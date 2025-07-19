package com.medoptica.medoptica.components;

import com.medoptica.medoptica.models.Area;
import com.medoptica.medoptica.models.NovaPoshtaRequest;
import com.medoptica.medoptica.service.NovaPoshtaCachedService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NovaPoshtaComponent {
    private final NovaPoshtaCachedService cachedService;

    public NovaPoshtaComponent(NovaPoshtaCachedService cachedService) {
        this.cachedService = cachedService;
    }

    public List<Area> getAreas(NovaPoshtaRequest request) {
        return cachedService.getAreas(request);
    }
}