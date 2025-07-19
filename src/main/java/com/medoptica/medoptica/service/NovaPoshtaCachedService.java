package com.medoptica.medoptica.service;

import com.medoptica.medoptica.models.Area;
import com.medoptica.medoptica.models.NovaPoshtaRequest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NovaPoshtaCachedService {

    private final NovaPoshtaService novaPoshtaService;

    public NovaPoshtaCachedService(NovaPoshtaService novaPoshtaService) {
        this.novaPoshtaService = novaPoshtaService;
    }

    @Cacheable(value = "areasCache", key = "#request.apiKey")
    public List<Area> getAreas(NovaPoshtaRequest request) {
        return novaPoshtaService.getAreas(request);
    }
}
