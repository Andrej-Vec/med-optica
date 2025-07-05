import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({providedIn: 'root'})
export class HelloService {
    private readonly http = inject(HttpClient);

    getMessage() {
      return this.http.get("http://localhost:8080/hello");
    }
}
