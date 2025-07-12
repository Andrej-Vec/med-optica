import {Component} from '@angular/core';
import {ProductCardComponent} from '../product-card/product-card.component';
import {ProductCard} from '../../models/product-card';

@Component({
  selector: 'app-products',
  imports: [
    ProductCardComponent
  ],
  templateUrl: './products.component.html',
  styleUrl: './products.component.scss',
  standalone: true
})
export class ProductsComponent {
  productCards: ProductCard[] = [
    {
      title: "title",
      describe: "describe",
      ratingValue: "3",
      ratingInfo: "12",
      priceCurrent: "3000",
      pricePrevious: "3400",
      priceDifference: "400",
      priceAktsiya: "4%",
      isNew: true,
      isBestseller: true
    },
    {
      title: "title",
      describe: "describe",
      ratingValue: "3",
      ratingInfo: "12",
      priceCurrent: "3200",
      pricePrevious: "3400",
      priceDifference: "400",
      priceAktsiya: "3%",
      isNew: false,
      isBestseller: true
    },
    {
      title: "title",
      describe: "describe",
      ratingValue: "3",
      ratingInfo: "12",
      priceCurrent: "3000",
      pricePrevious: "3400",
      priceDifference: "400",
      priceAktsiya: "4%",
      isNew: false,
      isBestseller: false
    },
    {
      title: "title",
      describe: "describe",
      ratingValue: "2",
      ratingInfo: "16",
      priceCurrent: "5000",
      pricePrevious: "2400",
      priceDifference: "400",
      priceAktsiya: "4%",
      isNew: true,
      isBestseller: false
    }
  ]
}
