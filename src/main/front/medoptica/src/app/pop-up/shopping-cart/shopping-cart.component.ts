import {Component, inject, OnInit} from '@angular/core';
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogClose,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from '@angular/material/dialog';
import {RouterLink} from '@angular/router';
import {MedopticaStore} from '../../services/medoptica.store';
import {MatButton} from '@angular/material/button';
import {DecimalPipe} from '@angular/common';
import {ProductCard} from '../../models/product-card';

interface CartItem {
  productCard: ProductCard;
  quantity: number;
}

@Component({
  selector: 'app-modal-content',
  imports: [
    MatDialogContent,
    MatDialogActions,
    RouterLink,
    MatButton,
    MatDialogTitle,
    DecimalPipe,
    MatDialogClose
  ],
  templateUrl: './shopping-cart.component.html',
  styleUrl: './shopping-cart.component.scss',
  standalone: true
})
export class ShoppingCartComponent implements OnInit {
  public readonly medopticaStore = inject(MedopticaStore);
  private readonly dialogRef = inject(MatDialogRef<ShoppingCartComponent>)
  private readonly data = inject(MAT_DIALOG_DATA);

  public groupedItems: CartItem[] = [];
  public total: number = 0;

  ngOnInit(): void {
    this.groupItems();
    this.calculateTotal();
  }

  private groupItems(): void {
    const map = new Map<string, CartItem>();

    this.medopticaStore.selectedLikeProductCards.forEach(item => {
      const key = item.title; // уникальный идентификатор товара
      if (map.has(key)) {
        map.get(key)!.quantity += 1;
      } else {
        map.set(key, { productCard: item, quantity: 1 });
      }
    });

    this.groupedItems = Array.from(map.values());
  }

  public increase(item: CartItem): void {
    item.quantity += 1;
    this.calculateTotal();
  }

  public decrease(item: CartItem): void {
    if (item.quantity > 1) {
      item.quantity -= 1;
    } else {
      this.groupedItems = this.groupedItems.filter(i => i !== item);
    }
    this.calculateTotal();
  }

  private calculateTotal(): void {
    this.total = this.groupedItems
      .reduce((sum, i) => sum + parseFloat(i.productCard.priceCurrent) * i.quantity, 0);
  }

  public close(): void {
    this.dialogRef.close();
  }
}
