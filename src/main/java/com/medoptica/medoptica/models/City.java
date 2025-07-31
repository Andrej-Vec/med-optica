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
public class City {
    @JsonProperty("Ref")
    private String ref;

    @JsonProperty("SettlementType")
    private String settlementType;

    @JsonProperty("Latitude")
    private String latitude;

    @JsonProperty("Longitude")
    private String longitude;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("DescriptionRu")
    private String descriptionRu;

    @JsonProperty("DescriptionTranslit")
    private String descriptionTranslit;

    @JsonProperty("SettlementTypeDescription")
    private String settlementTypeDescription;

    @JsonProperty("SettlementTypeDescriptionRu")
    private String settlementTypeDescriptionRu;

    @JsonProperty("SettlementTypeDescriptionTranslit")
    private String settlementTypeDescriptionTranslit;

    @JsonProperty("Region")
    private String region;

    @JsonProperty("RegionsDescription")
    private String regionsDescription;

    @JsonProperty("RegionsDescriptionRu")
    private String regionsDescriptionRu;

    @JsonProperty("RegionsDescriptionTranslit")
    private String regionsDescriptionTranslit;

    @JsonProperty("Area")
    private String area;

    @JsonProperty("AreaDescription")
    private String areaDescription;

    @JsonProperty("AreaDescriptionRu")
    private String areaDescriptionRu;

    @JsonProperty("AreaDescriptionTranslit")
    private String areaDescriptionTranslit;

    @JsonProperty("Index1")
    private String index1;

    @JsonProperty("Index2")
    private String index2;

    @JsonProperty("IndexCOATSU1")
    private String indexCOATSU1;

    @JsonProperty("Delivery1")
    private String delivery1;

    @JsonProperty("Delivery2")
    private String delivery2;

    @JsonProperty("Delivery3")
    private String delivery3;

    @JsonProperty("Delivery4")
    private String delivery4;

    @JsonProperty("Delivery5")
    private String delivery5;

    @JsonProperty("Delivery6")
    private String delivery6;

    @JsonProperty("Delivery7")
    private String delivery7;

    @JsonProperty("SpecialCashCheck")
    private int specialCashCheck;

    @JsonProperty("RadiusHomeDelivery")
    private String radiusHomeDelivery;

    @JsonProperty("RadiusExpressPickUp")
    private String radiusExpressPickUp;

    @JsonProperty("RadiusDrop")
    private String radiusDrop;

    @JsonProperty("Warehouse")
    private String warehouse;

    @JsonProperty("AddressDeliveryAllowed")
    private boolean addressDeliveryAllowed;
}
