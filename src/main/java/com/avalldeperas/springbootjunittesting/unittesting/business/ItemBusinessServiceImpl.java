package com.avalldeperas.springbootjunittesting.unittesting.business;

import com.avalldeperas.springbootjunittesting.unittesting.data.ItemRepository;
import com.avalldeperas.springbootjunittesting.unittesting.model.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ItemBusinessServiceImpl implements ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }

    public List<Item> retrieveAllItems() {
        return itemRepository.findAll().stream()
                .peek(item -> item.setValue(item.getPrice() * item.getQuantity()))
                .collect(Collectors.toList());
    }

    public Item retrieveOneItem() {
        return itemRepository.getOne(10001);
    }
}
