import {Component, inject} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {ShoppingCartComponent} from '../../pop-up/shopping-cart/shopping-cart.component';
import {MedopticaStore} from '../../services/medoptica.store';

@Component({
  selector: 'app-header',
  imports: [],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss',
  standalone: true
})
export class HeaderComponent {
  public readonly medopticaStore = inject(MedopticaStore);
  private readonly dialog = inject(MatDialog);


  public openShoppingCart(): void {
    this.dialog.open(ShoppingCartComponent, {
      width: '300px',
      data: { name: 'Пользователь' }
    });
  }
}
