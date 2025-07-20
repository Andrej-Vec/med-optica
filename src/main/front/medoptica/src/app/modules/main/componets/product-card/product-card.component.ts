import {Component, inject, Input} from '@angular/core';
import {ProductCard} from '../../../../models/product-card';
import {MedopticaStore} from '../../../../services/medoptica.store';

@Component({
  selector: 'app-product-card',
  imports: [],
  templateUrl: './product-card.component.html',
  styleUrl: './product-card.component.scss',
  standalone: true
})
export class ProductCardComponent {
  @Input({ required: true }) productCard: ProductCard | null = null;

  private readonly medopticaStore = inject(MedopticaStore);

  public addProductToCart(productCard: ProductCard | null): void {
    if (productCard) {
      this.medopticaStore.selectedProductCards.push(productCard);
    }
  }
}
