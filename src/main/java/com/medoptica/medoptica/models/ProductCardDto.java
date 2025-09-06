package com.medoptica.medoptica.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCardDto {
    private String id;
    private String title;
    private double price;
    private int quantity;
}
