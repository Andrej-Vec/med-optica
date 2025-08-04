package com.medoptica.medoptica.service;

import com.medoptica.medoptica.models.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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

        ResponseEntity<NovaPoshtaResponse<Area>> response = restTemplate.exchange(
                host,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<NovaPoshtaResponse<Area>>() {
                }
        );

        NovaPoshtaResponse<Area> body = response.getBody();

        if (body != null && body.isSuccess()) {
            return body.getData();
        }

        return Collections.emptyList();
    }

    public List<City> getCities(NovaPoshtaRequest request) {
        HttpEntity<NovaPoshtaRequest> requestEntity = new HttpEntity<>(request, new HttpHeaders());

        ResponseEntity<NovaPoshtaResponse<City>> response = restTemplate.exchange(
                host,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }
        );

        NovaPoshtaResponse<City> body = response.getBody();

        if (body != null && body.isSuccess()) {
            return body.getData();
        }

        return Collections.emptyList();
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
