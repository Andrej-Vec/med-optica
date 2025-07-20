import {Component, inject, OnInit} from '@angular/core';
import {NovaPoshtaService} from '../../../../shared/services/nova-poshta.service';
import {NovaPoshtaRequest} from '../../../../models/nova-poshta.request';
import {MatFormField} from '@angular/material/input';
import {MatOption, MatSelect} from '@angular/material/select';
import {Observable} from 'rxjs';
import {Area} from '../../../../models/area';
import {AsyncPipe} from '@angular/common';
import {MatFormFieldModule} from '@angular/material/form-field';

@Component({
  selector: 'checkout-page',
  imports: [
    MatFormField,
    MatSelect,
    MatOption,
    AsyncPipe,
    MatFormFieldModule
  ],
  templateUrl: './checkout.component.html',
  styleUrl: './checkout.component.scss',
  standalone: true
})
export class CheckoutComponent implements OnInit {
  private readonly novaPoshtaService = inject(NovaPoshtaService);

  areas$: Observable<Area[]> | undefined;

  ngOnInit() {
    this.areas$ = this.novaPoshtaService.getAreas(new NovaPoshtaRequest("139ef94b20fa0b2f436ed7c8fed46363", "AddressGeneral", "getAreas"));
  }
}
