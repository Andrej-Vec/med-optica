export interface Warehouse {
  SiteKey: string;
  Description: string;
  DescriptionRu: string;
  ShortAddress: string;
  ShortAddressRu: string;
  Phone: string;
  TypeOfWarehouse: string;
  Ref: string;
  Number: string;
  CityRef: string;
  CityDescription: string;
  CityDescriptionRu: string;
  SettlementRef: string;
  SettlementDescription: string;
  SettlementAreaDescription: string;
  SettlementRegionsDescription: string;
  SettlementTypeDescription: string;
  SettlementTypeDescriptionRu: string;
  Longitude: string;
  Latitude: string;
  PostFinance: string;
  BicycleParking: string;
  PaymentAccess: string;
  POSTerminal: string;
  InternationalShipping: string;
  SelfServiceWorkplacesCount: string;
  TotalMaxWeightAllowed: string;
  PlaceMaxWeightAllowed: string;
  SendingLimitationsOnDimensions: Dimensions;
  ReceivingLimitationsOnDimensions: Dimensions;
  Reception: Schedule;
  Delivery: Schedule;
  Schedule: Schedule;
  DistrictCode: string;
  WarehouseStatus: string;
  WarehouseStatusDate: string;
  CategoryOfWarehouse: string;
  RegionCity: string;
  WarehouseForAgent: string;
  MaxDeclaredCost: string;
  DenyToSelect: string;
  PostMachineType: string;
  PostalCodeUA: string;
  OnlyReceivingParcel: string;
  WarehouseIndex: string;
}

export interface Dimensions {
  Width: number;
  Height: number;
  Length: number;
}

export interface Schedule {
  Monday?: string;
  Tuesday?: string;
  Wednesday?: string;
  Thursday?: string;
  Friday?: string;
  Saturday?: string;
  Sunday?: string;
}
