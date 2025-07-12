import {Component, inject} from '@angular/core';
import {ProductCardComponent} from '../product-card/product-card.component';
import {ProductCard} from '../../models/product-card';
import {ProductCardService} from '../../shared/services/product-card.service';
import {Observable} from 'rxjs';
import {AsyncPipe} from '@angular/common';

@Component({
  selector: 'app-products',
  imports: [
    ProductCardComponent,
    AsyncPipe
  ],
  templateUrl: './products.component.html',
  styleUrl: './products.component.scss',
  standalone: true
})
export class ProductsComponent {
  private readonly productCardService = inject(ProductCardService);

  allProducts$: Observable<ProductCard[]> = this.productCardService.getAllProducts();
}
