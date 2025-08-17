import {Component, inject, OnInit} from '@angular/core';
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from '@angular/material/dialog';
import {RouterLink} from '@angular/router';
import {MedopticaStore} from '../../services/medoptica.store';
import {MatButton} from '@angular/material/button';
import {DecimalPipe} from '@angular/common';

@Component({
  selector: 'app-modal-content',
  imports: [
    MatDialogContent,
    MatDialogActions,
    RouterLink,
    MatButton,
    MatDialogTitle,
    DecimalPipe
  ],
  templateUrl: './shopping-cart.component.html',
  styleUrl: './shopping-cart.component.scss',
  standalone: true
})
export class ShoppingCartComponent implements OnInit {
  public readonly medopticaStore = inject(MedopticaStore);
  private readonly dialogRef = inject(MatDialogRef<ShoppingCartComponent>)
  private readonly data = inject(MAT_DIALOG_DATA);

  public total: number = 0;

  public ngOnInit(): void {
    this.total = this.medopticaStore.selectedLikeProductCards
      .reduce((sum, item) => sum + parseFloat(item.priceCurrent), 0);
  }

  public close(): void {
    this.dialogRef.close();
  }
}
