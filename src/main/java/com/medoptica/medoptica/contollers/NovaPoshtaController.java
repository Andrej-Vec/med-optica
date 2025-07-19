package com.medoptica.medoptica.contollers;

import com.medoptica.medoptica.components.NovaPoshtaComponent;
import com.medoptica.medoptica.models.Area;
import com.medoptica.medoptica.models.NovaPoshtaRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nova-poshta")
public class NovaPoshtaController {
    private final NovaPoshtaComponent novaPoshtaComponent;

    public NovaPoshtaController(NovaPoshtaComponent novaPoshtaComponent) {
        this.novaPoshtaComponent = novaPoshtaComponent;
    }

    @GetMapping("get-areas")
    public List<Area> getAreas(@RequestBody NovaPoshtaRequest novaPoshtaRequest) {
        return novaPoshtaComponent.getAreas(novaPoshtaRequest);
    }
}
