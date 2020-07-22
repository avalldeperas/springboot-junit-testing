package com.avalldeperas.springbootjunittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    private String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";


    @Test
    public void jsonAssert_strictTrue_exactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    /**
     * Removed quantity from expectedResponse with strict to false.
     * @throws JSONException
     */
    @Test
    public void jsonAssert_strictFalse_exactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    /**
     * Much more easier and readable test method than the above two.
     * @throws JSONException
     */
    @Test
    public void jsonAssert_withoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id:1,name:Ball,price:10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

}
