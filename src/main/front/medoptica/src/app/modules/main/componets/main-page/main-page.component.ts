import {Component} from '@angular/core';
import {SliderComponent} from '../slider/slider.component';
import {ProductsComponent} from '../products/products.component';
import {ProductSaleComponent} from '../product-sale/product-sale.component';
import {NewsProductComponent} from '../news-product/news-product.component';

@Component({
  selector: 'main-page',
  imports: [
    SliderComponent,
    ProductsComponent,
    ProductSaleComponent,
    NewsProductComponent
  ],
  templateUrl: './main-page.component.html',
  styleUrl: './main-page.component.scss',
  standalone: true
})
export class MainPageComponent {

}
