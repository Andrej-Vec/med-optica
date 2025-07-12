package com.medoptica.medoptica.components;

import com.medoptica.medoptica.models.ProductCard;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductCardComponent {

    public List<ProductCard> getAllProducts() {
        List<ProductCard> products = new ArrayList<>();

        ProductCard p1 = new ProductCard();
        p1.setTitle("Окуляри");
        p1.setDescribe("Захисні окуляри для зору");
        p1.setRatingValue("4.5");
        p1.setRatingInfo("200 відгуків");
        p1.setPrice("2300");
        p1.setPriceAktsiya("200");
        p1.setPriceCurrent("900");
        p1.setPricePrevious("1000");
        p1.setPriceDifference("-100");
        p1.setNew(true);
        p1.setBestseller(false);

        ProductCard p2 = new ProductCard();
        p2.setTitle("Контактні лінзи");
        p2.setDescribe("Щоденні лінзи для комфорту");
        p2.setRatingValue("4.8");
        p2.setRatingInfo("320 відгуків");
        p2.setPrice("2300");
        p2.setPriceAktsiya("200");
        p2.setPriceCurrent("600");
        p2.setPricePrevious("750");
        p2.setPriceDifference("-150");
        p2.setNew(false);
        p2.setBestseller(true);

        ProductCard p3 = new ProductCard();
        p3.setTitle("Розчин для лінз");
        p3.setDescribe("Універсальний розчин 360мл");
        p3.setRatingValue("4.3");
        p3.setRatingInfo("120 відгуків");
        p2.setPrice("2300");
        p3.setPriceAktsiya("200");
        p3.setPriceCurrent("250");
        p3.setPricePrevious(null);
        p3.setPriceDifference(null);
        p3.setNew(false);
        p3.setBestseller(false);

        ProductCard p4 = new ProductCard();
        p4.setTitle("Сонцезахисні окуляри");
        p4.setDescribe("Поляризаційні окуляри з UV-захистом");
        p4.setRatingValue("4.9");
        p4.setRatingInfo("540 відгуків");
        p4.setPrice("2300");
        p4.setPriceAktsiya("200");
        p4.setPriceCurrent("1200");
        p4.setPricePrevious("1500");
        p4.setPriceDifference("-300");
        p4.setNew(true);
        p4.setBestseller(true);

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);

        return products;
    }
}
