export class ProductCardDto {
  title: string;
  price: number;
  quantity: number;

  constructor(title: string, price: number, quantity: number) {
    this.title = title;
    this.price = price;
    this.quantity = quantity;
  }
}
