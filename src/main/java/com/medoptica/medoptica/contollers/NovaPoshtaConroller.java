package com.medoptica.medoptica.contollers;

import com.medoptica.medoptica.components.NovaPoshtaComponent;
import com.medoptica.medoptica.models.Area;
import com.medoptica.medoptica.models.NovaPoshtaRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nova-poshta")
public class NovaPoshtaConroller {
    private final NovaPoshtaComponent novaPoshtaComponent;

    public NovaPoshtaConroller(NovaPoshtaComponent novaPoshtaComponent) {
        this.novaPoshtaComponent = novaPoshtaComponent;
    }


    @GetMapping("get-areas")
    public List<Area> getAreas(@RequestBody NovaPoshtaRequest novaPoshtaRequest) {
        return NovaPoshtaComponent.getAreas(novaPoshtaRequest);
    }
}
