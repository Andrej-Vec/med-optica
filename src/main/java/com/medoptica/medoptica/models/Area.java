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
public class Area {
    @JsonProperty("Ref")
    private String Ref;
    @JsonProperty("AreasCenter")
    private String AreasCenter;
    @JsonProperty("DescriptionRu")
    private String DescriptionRu;
    @JsonProperty("Description")
    private String Description;
}
