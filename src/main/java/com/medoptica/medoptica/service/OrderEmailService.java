package com.medoptica.medoptica.service;

import com.medoptica.medoptica.models.OrderRequest;
import com.medoptica.medoptica.models.ProductCardDto;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderEmailService {

    private final JavaMailSender mailSender;

    public OrderEmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendOrderEmail(OrderRequest order) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            String html = buildHtml(order);
            helper.setText(html, true);
            helper.setTo("andrijvechirko2003@gmail.com");
            helper.setSubject("Нове замовлення від " + order.getFullName());
            helper.setFrom("no-reply@yourdomain.com");
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при отправке письма", e);
        }
    }

    private String buildHtml(OrderRequest o) {
        StringBuilder sb = new StringBuilder();
        sb.append("<h2>Нове замовлення</h2>");
        sb.append("<p><b>ПІБ:</b> ").append(escape(o.getFullName())).append("</p>");
        sb.append("<p><b>Телефон:</b> ").append(escape(o.getPhone())).append("</p>");
        sb.append("<p><b>Область:</b> ").append(escape(o.getRegion())).append("</p>");
        sb.append("<p><b>Місто:</b> ").append(escape(o.getCity())).append("</p>");
        sb.append("<p><b>Відділення:</b> ").append(escape(o.getBranch())).append("</p>");
        sb.append("<p><b>Оплата:</b> ").append(escape(o.getPaymentMethod())).append("</p>");

        sb.append("<h3>Товари</h3>");
        sb.append("<table border='1' cellpadding='6' cellspacing='0'>")
                .append("<tr><th>Назва</th><th>Кількість</th><th>Ціна</th><th>Сума</th></tr>");

        BigDecimal total = BigDecimal.ZERO;
        if (o.getProducts() != null) {
            for (ProductCardDto it : o.getProducts()) {
                BigDecimal itemTotal = BigDecimal.valueOf(it.getPrice())
                        .multiply(BigDecimal.valueOf(it.getQuantity()));

                total = total.add(itemTotal);
                sb.append("<tr>")
                        .append("<td>").append(escape(it.getTitle())).append("</td>")
                        .append("<td>").append("Кількість").append("</td>")
                        .append("<td>").append(it.getPrice()).append("</td>")
                        .append("<td>").append(itemTotal).append("</td>")
                        .append("</tr>");
            }
        }
        sb.append("<tr><td colspan='3'><b>Итого</b></td><td><b>").append(total).append("</b></td></tr>");
        sb.append("</table>");
        return sb.toString();
    }

    private String escape(String s) {
        return s == null ? "" : s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}
