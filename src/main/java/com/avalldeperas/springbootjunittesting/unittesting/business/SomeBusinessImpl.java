package com.avalldeperas.springbootjunittesting.unittesting.business;

import com.avalldeperas.springbootjunittesting.unittesting.data.SomeDataService;
import lombok.Setter;

import java.util.Arrays;

public class SomeBusinessImpl {

    @Setter
    private SomeDataService someDataService;

    public int calculateSum(int[] data) {
        return Arrays.stream(data)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public int calculateSumUsingDataService() {
        return Arrays.stream(someDataService.retrieveAllData())
                .reduce(Integer::sum)
                .orElse(0);
    }
}
