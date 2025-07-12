package com.medoptica.medoptica.contollers;

import com.medoptica.medoptica.components.ProductCardComponent;
import com.medoptica.medoptica.models.ProductCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductCardController {
    @Autowired
    ProductCardComponent productCardComponent;

    @GetMapping("get-all-products")
    public List<ProductCard> getAllProducts() {
        return productCardComponent.getAllProducts();
    }
}
