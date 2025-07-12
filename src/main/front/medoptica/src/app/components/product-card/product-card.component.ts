import {Component, Input} from '@angular/core';
import {ProductCard} from '../../models/product-card';

@Component({
  selector: 'app-product-card',
  imports: [],
  templateUrl: './product-card.component.html',
  styleUrl: './product-card.component.scss',
  standalone: true
})
export class ProductCardComponent {
  @Input({ required: true }) productCard: ProductCard | null = null;
}
