package com.avalldeperas.springbootjunittesting.unittesting.business;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@Slf4j
public class ListMockTest {

    private List<String> mock = mock(List.class);

    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("firstString");
        assertEquals("firstString", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("firstString");
        assertEquals("firstString", mock.get(0));
        assertEquals("firstString", mock.get(1));
    }

    @Test
    public void verificationBasics() {
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        // verification that get has been called
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing() {
        mock.add("SomeString");

        // verification of which argument has been passed
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        mock.add("SomeString1");
        mock.add("SomeString2");

        // verification of which argument has been passed
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();

        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

    /**
     * A mock does not retain behaviour (code) of the original class.
     * However, a spy retains behaviour of the original class by default.
     */
    @Test
    public void spying() {
        // mock
        ArrayList arrayListMock = mock(ArrayList.class);
        log.info("array get(0) = " + arrayListMock.get(0)); // no error bc mock
        log.info("array size = " + arrayListMock.size());
        arrayListMock.add("String");
        log.info("array size = "+arrayListMock.size());

        // spy
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        log.info("array get(0) = " + arrayListSpy.get(0));
        log.info("array size = "+arrayListSpy.size());
        arrayListSpy.add("String");
        log.info("array size = "+arrayListSpy.size());

        // mocking a spy - from now on, size is always 5
        when(arrayListSpy.size()).thenReturn(5);
        log.info("array size = " + arrayListSpy.size());

        arrayListSpy.add("Test4");
        log.info("array size = " + arrayListSpy.size()); // 5 anyway

        boolean hasAddedTest4 = verify(arrayListSpy).add("Test4");
        log.info("have we added Test4 string? " + hasAddedTest4);
    }

}
