import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ProductCard} from '../../models/product-card';

@Injectable({providedIn: 'root'})
export class ProductCardService {

  private readonly http = inject(HttpClient);

  getAllProducts(): Observable<ProductCard[]> {
    return this.http.get<ProductCard[]>("http://localhost:8080/api/products/get-all-products");
  }
}
