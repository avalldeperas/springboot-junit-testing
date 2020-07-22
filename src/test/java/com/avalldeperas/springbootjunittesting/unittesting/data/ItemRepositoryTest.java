package com.avalldeperas.springbootjunittesting.unittesting.data;

import com.avalldeperas.springbootjunittesting.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This class would have much more sense if we had our own repository implementation (f/ex: hibernate).
 * Extending JpaRepository there is no real need to test it, as we haven't made any logic in it.
 */
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    public void testFindAll() {
        List<Item> items = repository.findAll();
        assertEquals(3, items.size());
    }

    @Test
    public void testFindById() {
        Optional<Item> item = repository.findById(10001);

        assertNotNull(item.get());
        assertEquals(10001, item.get().getId());
        // ....
    }
}
