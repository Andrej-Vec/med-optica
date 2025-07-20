export class NovaPoshtaRequest {
  apiKey: string;
  modelName: string;
  calledMethod: string;

  constructor(apiKey: string, modelName: string, calledMethod: string) {
    this.apiKey = apiKey;
    this.modelName = modelName;
    this.calledMethod = calledMethod;
  }
}
