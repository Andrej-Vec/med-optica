import {Component, inject, Input} from '@angular/core';
import {ProductCard} from '../../../../models/product-card';
import {MedopticaStore} from '../../../../services/medoptica.store';
import {Router} from '@angular/router';

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
  private readonly router = inject(Router);

  public addProductToLikes(productCard: ProductCard | null): void {
    if (productCard) {
      this.medopticaStore.selectedLikeProductCards.push(productCard);
    }
  }

  public addProductToBasket(productCard: ProductCard | null): void {
    if (productCard) {
      this.medopticaStore.selectedBasketProducts.push(productCard);
    }
    this.router.navigate(['/checkout']);
  }
}
