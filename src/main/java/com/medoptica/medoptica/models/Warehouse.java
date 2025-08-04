package com.medoptica.medoptica.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {

    @JsonProperty("SiteKey")
    private String siteKey;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("DescriptionRu")
    private String descriptionRu;

    @JsonProperty("ShortAddress")
    private String shortAddress;

    @JsonProperty("ShortAddressRu")
    private String shortAddressRu;

    @JsonProperty("Phone")
    private String phone;

    @JsonProperty("TypeOfWarehouse")
    private String typeOfWarehouse;

    @JsonProperty("Ref")
    private String ref;

    @JsonProperty("Number")
    private String number;

    @JsonProperty("CityRef")
    private String cityRef;

    @JsonProperty("CityDescription")
    private String cityDescription;

    @JsonProperty("CityDescriptionRu")
    private String cityDescriptionRu;

    @JsonProperty("SettlementRef")
    private String settlementRef;

    @JsonProperty("SettlementDescription")
    private String settlementDescription;

    @JsonProperty("SettlementAreaDescription")
    private String settlementAreaDescription;

    @JsonProperty("SettlementRegionsDescription")
    private String settlementRegionsDescription;

    @JsonProperty("SettlementTypeDescription")
    private String settlementTypeDescription;

    @JsonProperty("SettlementTypeDescriptionRu")
    private String settlementTypeDescriptionRu;

    @JsonProperty("Longitude")
    private String longitude;

    @JsonProperty("Latitude")
    private String latitude;

    @JsonProperty("PostFinance")
    private String postFinance;

    @JsonProperty("BicycleParking")
    private String bicycleParking;

    @JsonProperty("PaymentAccess")
    private String paymentAccess;

    @JsonProperty("POSTerminal")
    private String posTerminal;

    @JsonProperty("InternationalShipping")
    private String internationalShipping;

    @JsonProperty("SelfServiceWorkplacesCount")
    private String selfServiceWorkplacesCount;

    @JsonProperty("TotalMaxWeightAllowed")
    private String totalMaxWeightAllowed;

    @JsonProperty("PlaceMaxWeightAllowed")
    private String placeMaxWeightAllowed;

    @JsonProperty("SendingLimitationsOnDimensions")
    private Dimension sendingLimitationsOnDimensions;

    @JsonProperty("ReceivingLimitationsOnDimensions")
    private Dimension receivingLimitationsOnDimensions;

    @JsonProperty("Reception")
    private Map<String, String> reception;

    @JsonProperty("Delivery")
    private Map<String, String> delivery;

    @JsonProperty("Schedule")
    private Map<String, String> schedule;

    @JsonProperty("DistrictCode")
    private String districtCode;

    @JsonProperty("WarehouseStatus")
    private String warehouseStatus;

    @JsonProperty("WarehouseStatusDate")
    private String warehouseStatusDate;

    @JsonProperty("CategoryOfWarehouse")
    private String categoryOfWarehouse;

    @JsonProperty("RegionCity")
    private String regionCity;

    @JsonProperty("WarehouseForAgent")
    private String warehouseForAgent;

    @JsonProperty("MaxDeclaredCost")
    private String maxDeclaredCost;

    @JsonProperty("DenyToSelect")
    private String denyToSelect;

    @JsonProperty("PostMachineType")
    private String postMachineType;

    @JsonProperty("PostalCodeUA")
    private String postalCodeUA;

    @JsonProperty("OnlyReceivingParcel")
    private String onlyReceivingParcel;

    @JsonProperty("WarehouseIndex")
    private String warehouseIndex;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Dimension {
        @JsonProperty("Width")
        private Integer width;

        @JsonProperty("Height")
        private Integer height;

        @JsonProperty("Length")
        private Integer length;
    }
}