package com.avalldeperas.springbootjunittesting.unittesting.business;

import com.avalldeperas.springbootjunittesting.unittesting.data.SomeDataService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class SomeBusinessImpl {

    @Setter
    private SomeDataService someDataService;

    public int calculateSum(int[] data) {
        int sum = 0;
        for(int value: data) {
            sum += value;
        }
        return sum;
    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for(int value: data) {
            sum += value;
        }
        return sum;
    }
}
