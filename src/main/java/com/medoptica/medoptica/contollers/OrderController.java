package com.medoptica.medoptica.contollers;

import com.medoptica.medoptica.components.OrderComponent;
import com.medoptica.medoptica.models.OrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderComponent orderComponent;

    @PostMapping("/send-order-email")
    public String placeOrder(@RequestBody OrderRequest order) {
        orderComponent.placeOrder(order);
        return "Ваше замовлення прийнято!";
    }
}