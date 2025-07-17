import { Routes } from '@angular/router';
import {MainPageComponent} from './modules/main/componets/main-page/main-page.component';
import {CheckoutComponent} from './modules/checkout/components/checkout/checkout.component';

export const routes: Routes = [
  {
    path: '',
    component: MainPageComponent
  },
  {
    path: 'checkout',
    component: CheckoutComponent
  },
  {
    path: '**',
    redirectTo: ''
  }
];
