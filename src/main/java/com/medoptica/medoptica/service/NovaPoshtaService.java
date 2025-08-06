package com.medoptica.medoptica.service;

import com.medoptica.medoptica.models.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NovaPoshtaService {
    private final String host;
    private final RestTemplate restTemplate;

    public NovaPoshtaService(String host, RestTemplate restTemplate) {
        this.host = host;
        this.restTemplate = restTemplate;
    }

    public List<Area> getAreas(NovaPoshtaRequest request) {
        HttpEntity<NovaPoshtaRequest> requestEntity = new HttpEntity<>(request, new HttpHeaders());

        ResponseEntity<NovaPoshtaResponseArea<Area>> response = restTemplate.exchange(
                host,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<NovaPoshtaResponseArea<Area>>() {
                }
        );

        NovaPoshtaResponseArea<Area> body = response.getBody();

        if (body != null && body.isSuccess()) {
            return body.getData();
        }

        return Collections.emptyList();
    }

    public List<City> getAllCities(NovaPoshtaRequest baseRequest) {
        int page = 1;
        int limit = 150;
        List<City> allCities = new ArrayList<>();

        while (true) {
            // Клонируем request, чтобы не мутировать оригинальный
            NovaPoshtaRequest request = deepCopyRequest(baseRequest);

            // Устанавливаем limit и текущую страницу
            request.getMethodProperties().setLimit(String.valueOf(limit));
            request.getMethodProperties().setPage(String.valueOf(page));

            // Выполняем запрос
            HttpEntity<NovaPoshtaRequest> requestEntity = new HttpEntity<>(request, new HttpHeaders());

            ResponseEntity<NovaPoshtaResponse<City>> response = restTemplate.exchange(
                    host,
                    HttpMethod.POST,
                    requestEntity,
                    new ParameterizedTypeReference<>() {}
            );

            NovaPoshtaResponse<City> body = response.getBody();

            if (body == null || !body.isSuccess()) {
                break;
            }

            List<City> pageData = body.getData();
            if (pageData != null) {
                allCities.addAll(pageData);
            }

            // Проверка на окончание
            int totalCount = body.getInfo() != null ? body.getInfo().getTotalCount() : 0;
            if (allCities.size() >= totalCount) {
                break;
            }

            page++; // Следующая страница
        }

        return allCities;
    }

    private NovaPoshtaRequest deepCopyRequest(NovaPoshtaRequest original) {
        NovaPoshtaRequest copy = new NovaPoshtaRequest();
        copy.setApiKey(original.getApiKey());
        copy.setModelName(original.getModelName());
        copy.setCalledMethod(original.getCalledMethod());

        // Копируем methodProperties вручную
        MethodProperties originalProps = original.getMethodProperties();
        MethodProperties copiedProps = new MethodProperties();
        copiedProps.setAreaRef(originalProps.getAreaRef());
        copiedProps.setWarehouse(originalProps.getWarehouse());
        copiedProps.setSettlementRef(originalProps.getSettlementRef());
        // Page и limit установим отдельно в основном методе
        copy.setMethodProperties(copiedProps);

        return copy;
    }

    public List<Warehouse> getWarehouses(NovaPoshtaRequest request) {
        HttpEntity<NovaPoshtaRequest> requestEntity = new HttpEntity<>(request, new HttpHeaders());

        ResponseEntity<NovaPoshtaResponse<com.medoptica.medoptica.models.Warehouse>> response = restTemplate.exchange(
                host,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }
        );

        NovaPoshtaResponse<com.medoptica.medoptica.models.Warehouse> body = response.getBody();

        if (body != null && body.isSuccess()) {
            return body.getData();
        }

        return Collections.emptyList();
    }
}
