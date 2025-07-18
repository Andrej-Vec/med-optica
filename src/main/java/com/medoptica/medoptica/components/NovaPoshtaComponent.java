package com.medoptica.medoptica.components;

import com.medoptica.medoptica.models.Area;
import com.medoptica.medoptica.models.NovaPoshtaRequest;
import com.medoptica.medoptica.service.NovaPoshtaService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NovaPoshtaComponent {
    private static NovaPoshtaService novaPoshtaService = null;

    public NovaPoshtaComponent(NovaPoshtaService novaPoshtaService) {
        NovaPoshtaComponent.novaPoshtaService = novaPoshtaService;
    }

    public static List<Area> getAreas(NovaPoshtaRequest novaPoshtaRequest) {
        return novaPoshtaService.getAreas(novaPoshtaRequest);
    }
}
