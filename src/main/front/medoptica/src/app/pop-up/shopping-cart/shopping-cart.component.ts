import {Component, inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogActions, MatDialogContent, MatDialogRef} from '@angular/material/dialog';
import {RouterLink} from '@angular/router';
import {MedopticaStore} from '../../services/medoptica.store';

@Component({
  selector: 'app-modal-content',
  imports: [
    MatDialogContent,
    MatDialogActions,
    RouterLink
  ],
  templateUrl: './shopping-cart.component.html',
  styleUrl: './shopping-cart.component.scss',
  standalone: true
})
export class ShoppingCartComponent {
  public readonly medopticaStore = inject(MedopticaStore);
  private readonly dialogRef = inject(MatDialogRef<ShoppingCartComponent>)
  private readonly data = inject(MAT_DIALOG_DATA);

  public close(): void {
    this.dialogRef.close();
  }
}
