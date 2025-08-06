package com.medoptica.medoptica.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NovaPoshtaResponseArea<T> extends NovaPoshtaBaseResponse {
    private List<T> data;
}
