import {Component, inject, OnInit} from '@angular/core';
import {HeaderComponent} from './components/header/header.component';
import {SliderComponent} from './components/slider/slider.component';
import {ProductsComponent} from './components/products/products.component';
import {NewsProductComponent} from './components/news-product/news-product.component';
import {ProductSaleComponent} from './components/product-sale/product-sale.component';
import {FooterComponent} from './components/footer/footer.component';
import {HelloService} from './shared/services/hello.service';
import {LoaderComponent} from './interceptors/loader/loader.component';

@Component({
  selector: 'app-root',
  imports: [HeaderComponent, SliderComponent, ProductsComponent, NewsProductComponent, ProductSaleComponent, FooterComponent, LoaderComponent],
  templateUrl: './app.html',
  standalone: true,
  styleUrl: './app.scss'
})
export class App implements OnInit {
  protected title = 'medoptica';
  private readonly helloService = inject(HelloService);

  ngOnInit() {
    this.helloService.getMessage().subscribe(resp => {
      console.log("resp", resp);
    })
  }
}
