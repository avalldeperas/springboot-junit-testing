package com.avalldeperas.springbootjunittesting.unittesting.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull private Integer id;

    @Column(name = "name")
    @NonNull private String name;

    @Column(name = "price")
    @NonNull private Integer price;

    @Column(name = "quantity")
    @NonNull private Integer quantity;

    @Transient
    private int value;

}
