import {ProductCardDto} from './product-card-dto';

export class OrderRequest {
  fullName: string;
  phone: string;
  region: string;
  city: string;
  branch: string;
  paymentMethod: string;
  products: ProductCardDto[];

  constructor(fullName: string, phone: string, region: string, city: string, branch: string, paymentMethod: string, products: ProductCardDto[]) {
    this.fullName = fullName;
    this.phone = phone;
    this.region = region;
    this.city = city;
    this.branch = branch;
    this.paymentMethod = paymentMethod;
    this.products = products;
  }
}
