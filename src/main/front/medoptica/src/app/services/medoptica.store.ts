import {Injectable} from '@angular/core';
import {ProductCard} from '../models/product-card';

@Injectable({
  providedIn: 'root'
})
export class MedopticaStore {
  selectedProductCards: ProductCard[] = [];
}
