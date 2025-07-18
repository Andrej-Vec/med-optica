package com.medoptica.medoptica.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NovaPoshtaRequest {
    private String apiKey;
    private String modelName;
    private String calledMethod;
}
