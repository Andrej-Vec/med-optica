package com.medoptica.medoptica.components;

import com.medoptica.medoptica.models.Area;
import com.medoptica.medoptica.models.City;
import com.medoptica.medoptica.models.NovaPoshtaRequest;
import com.medoptica.medoptica.models.Warehouse;
import com.medoptica.medoptica.service.NovaPoshtaCachedService;
import com.medoptica.medoptica.service.NovaPoshtaService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NovaPoshtaComponent {
    private final NovaPoshtaCachedService cachedService;
    private final NovaPoshtaService novaPoshtaService;

    public NovaPoshtaComponent(NovaPoshtaCachedService cachedService, NovaPoshtaService novaPoshtaService) {
        this.cachedService = cachedService;
        this.novaPoshtaService = novaPoshtaService;
    }

    public List<Area> getAreas(NovaPoshtaRequest request) {
        return cachedService.getAreas(request);
    }

    public List<City> getCities(NovaPoshtaRequest request) {
        return novaPoshtaService.getAllCities(request);
    }

    public List<Warehouse> getWarehouses(NovaPoshtaRequest request) {
        return novaPoshtaService.getAllWarehouses(request);
    }
}