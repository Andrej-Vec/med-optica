export class NovaPoshtaRequest {
  apiKey: string;
  modelName: string;
  calledMethod: string;
  methodProperties: MethodProperties | null;

  constructor(apiKey: string, modelName: string, calledMethod: string, methodProperties: MethodProperties | null) {
    this.apiKey = apiKey;
    this.modelName = modelName;
    this.calledMethod = calledMethod;
    this.methodProperties = methodProperties;
  }
}

export class MethodProperties {
  AreaRef: string | null;
  Warehouse: string | null;
  Page: string | null;
  limit: string | null;
  SettlementRef: string | null;

  constructor(AreaRef: string | null, Warehouse: string | null, Page: string | null, limit: string | null, SettlementRef: string | null) {
    this.AreaRef = AreaRef;
    this.Warehouse = Warehouse;
    this.Page = Page;
    this.limit = limit;
    this.SettlementRef = SettlementRef;
  }
}
