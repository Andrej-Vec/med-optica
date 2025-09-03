import {Component} from '@angular/core';
import {MatDialogActions, MatDialogClose, MatDialogContent, MatDialogTitle} from '@angular/material/dialog';
import {MatButton} from '@angular/material/button';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-cart-notification',
  imports: [
    MatDialogTitle,
    MatButton,
    MatDialogActions,
    MatDialogClose,
    MatDialogContent,
    RouterLink
  ],
  templateUrl: './cart-notification.component.html',
  styleUrl: './cart-notification.component.scss',
  standalone: true
})
export class CartNotificationComponent {

}
