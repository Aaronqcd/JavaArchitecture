package com.ewangz.javaarchitecture.repository;

import com.ewangz.javaarchitecture.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by aaronqin on 16/3/18.
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Query("SELECT i FROM Item i WHERE i.checked=true")
    List<Item> findChecked();
}
