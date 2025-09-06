import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {OrderRequest} from '../models/order.request';

@Injectable({providedIn: 'root'})
export class OrderService {

  private readonly http = inject(HttpClient);

  public placeOrder(orderRequest: OrderRequest): Observable<string> {
    return this.http.post<string>("http://localhost:8080/api/order/send-order-email", orderRequest)
  }
}
