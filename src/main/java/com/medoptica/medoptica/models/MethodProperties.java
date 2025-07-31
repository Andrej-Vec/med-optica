package com.medoptica.medoptica.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MethodProperties {
    @JsonProperty("AreaRef")
    private String AreaRef;
    @JsonProperty("Warehouse")
    private String Warehouse;
    @JsonProperty("Page")
    private String Page;
    @JsonProperty("limit")
    private String limit;
}
