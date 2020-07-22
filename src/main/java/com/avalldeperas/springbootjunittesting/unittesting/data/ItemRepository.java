package com.avalldeperas.springbootjunittesting.unittesting.data;

import com.avalldeperas.springbootjunittesting.unittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
