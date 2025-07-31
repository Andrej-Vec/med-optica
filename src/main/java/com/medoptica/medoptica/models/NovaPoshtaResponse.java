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
public class NovaPoshtaResponse<T> {
    private boolean success;
    private List<T> data;
    private List<String> errors;
    private List<String> warnings;
    //private List<Integer> info;
    private List<String> messageCodes;
    private List<String> errorCodes;
    private List<String> warningCodes;
    private List<String> infoCodes;
}