package com.avalldeperas.springbootjunittesting.unittesting.business;

import com.avalldeperas.springbootjunittesting.unittesting.model.Item;

import java.util.List;

public interface ItemBusinessService {

    Item retrieveHardcodedItem();
    List<Item> retrieveAllItems();
}
