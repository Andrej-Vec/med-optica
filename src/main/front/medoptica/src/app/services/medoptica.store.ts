import {Injectable} from '@angular/core';
import {ProductCard} from '../models/product-card';

@Injectable({
  providedIn: 'root'
})
export class MedopticaStore {
  selectedLikeProductCards: ProductCard[] = [];
  selectedBasketProducts: ProductCard[] = [];
}
