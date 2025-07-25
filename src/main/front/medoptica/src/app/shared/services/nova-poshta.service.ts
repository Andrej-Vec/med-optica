import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Area} from '../../models/area';
import {NovaPoshtaRequest} from '../../models/nova-poshta.request';

@Injectable({providedIn: 'root'})
export class NovaPoshtaService {

  private readonly http = inject(HttpClient);

  getAreas(novaPoshtaRequest: NovaPoshtaRequest): Observable<Area[]> {
    return this.http.post<Area[]>("http://localhost:8080/api/nova-poshta/get-areas", novaPoshtaRequest)
  }
}
