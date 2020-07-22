package com.avalldeperas.springbootjunittesting.unittesting.controller;

import com.avalldeperas.springbootjunittesting.unittesting.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * simple controller to perform unit testing.
 */
@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100);
    }

}
