package com.medoptica.medoptica.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCard {
    private String title;
    private String describe;
    private String ratingValue;
    private String ratingInfo;
    private String priceCurrent;
    private String pricePrevious;
    private String priceDifference;
    private String priceAktsiya;
    private String price;
    private boolean isNew;
    private boolean isBestseller;
    private String imageUrl;
}
