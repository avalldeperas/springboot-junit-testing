package com.avalldeperas.springbootjunittesting.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * AssertJ is even better than Hamcrest Matchers, as we now start defining a number of conditions
 * in the same line (chaining).
 */
public class AssertJTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12,15,45);

//        assertThat(numbers, hasSize(3));
//        assertThat(numbers, hasItems(12,45));
//        assertThat(numbers, everyItem(greaterThan(10)));
//        assertThat(numbers, everyItem(lessThan(100)));

        assertThat(numbers).hasSize(3)
                .contains(12,15)
                .allMatch(x -> x > 10)
                .allMatch(x -> x < 100)
                .noneMatch(x -> x < 0);

//        assertThat("", emptyString()); // isEmptyString is deprecated
        assertThat("").isEmpty();

//        assertThat("ABCDE", containsString("BCD"));
//        assertThat("ABCDE", startsWith("ABC"));
//        assertThat("ABCDE", endsWith("CDE"));
        assertThat("ABCDE").contains("BCD")
                .startsWith("ABC")
                .endsWith("CDE");
    }
}
