import {Component} from '@angular/core';
import {HeaderComponent} from './components/header/header.component';
import {SliderComponent} from './components/slider/slider.component';
import {ProductsComponent} from './components/products/products.component';
import {NewsProductComponent} from './components/news-product/news-product.component';
import {ProductSaleComponent} from './components/product-sale/product-sale.component';

@Component({
  selector: 'app-root',
  imports: [HeaderComponent, SliderComponent, ProductsComponent, NewsProductComponent, ProductSaleComponent],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected title = 'medoptica';
}
