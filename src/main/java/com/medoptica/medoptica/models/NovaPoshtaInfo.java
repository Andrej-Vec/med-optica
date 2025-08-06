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
public class NovaPoshtaInfo {
    @JsonProperty("totalCount")
    private Integer totalCount;
}
