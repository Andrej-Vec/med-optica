package com.medoptica.medoptica.components;

import com.medoptica.medoptica.models.OrderRequest;
import com.medoptica.medoptica.service.OrderEmailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderComponent {

    private final OrderEmailService orderEmailService;

    public void placeOrder(OrderRequest order) {
        try {
            orderEmailService.sendOrderEmail(order);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при отправке письма", e);
        }
    }
}
