package com.medoptica.medoptica.service;

import com.medoptica.medoptica.models.Area;
import com.medoptica.medoptica.models.NovaPoshtaRequest;
import com.medoptica.medoptica.models.NovaPoshtaResponse;
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

}
