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
  AreaRef: string;
  Warehouse: string;
  Page: string;
  limit: string;

  constructor(AreaRef: string, Warehouse: string, Page: string, limit: string) {
    this.AreaRef = AreaRef;
    this.Warehouse = Warehouse;
    this.Page = Page;
    this.limit = limit;
  }
}
