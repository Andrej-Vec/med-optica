import {Component, inject, OnInit} from '@angular/core';
import {NovaPoshtaService} from '../../../../shared/services/nova-poshta.service';
import {MethodProperties, NovaPoshtaRequest} from '../../../../models/nova-poshta.request';
import {MatFormField, MatInput} from '@angular/material/input';
import {MatOption, MatSelect} from '@angular/material/select';
import {map, Observable, startWith} from 'rxjs';
import {Area} from '../../../../models/area';
import {AsyncPipe} from '@angular/common';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MedopticaStore} from '../../../../services/medoptica.store';
import {City} from '../../../../models/city';
import {MatAutocomplete, MatAutocompleteTrigger} from '@angular/material/autocomplete';
import {FormControl, ReactiveFormsModule} from '@angular/forms';
import {Warehouse} from '../../../../models/warehouse';

@Component({
  selector: 'checkout-page',
  imports: [
    MatFormField,
    MatSelect,
    MatOption,
    AsyncPipe,
    MatFormFieldModule,
    MatAutocomplete,
    MatAutocompleteTrigger,
    ReactiveFormsModule,
    MatInput
  ],
  templateUrl: './checkout.component.html',
  styleUrl: './checkout.component.scss',
  standalone: true
})
export class CheckoutComponent implements OnInit {
  public readonly medopticaStore = inject(MedopticaStore);
  private readonly novaPoshtaService = inject(NovaPoshtaService);

  myControl = new FormControl<string | City>('');
  areas$: Observable<Area[]> | undefined;
  warehouse$: Observable<Warehouse[]> | undefined;
  filteredCities$: Observable<City[]> | undefined;
  allCities: City[] = [];


  ngOnInit() {
    this.areas$ = this.novaPoshtaService.getAreas(new NovaPoshtaRequest("139ef94b20fa0b2f436ed7c8fed46363", "AddressGeneral", "getSettlementAreas", null));
  }

  displayFn(user: City): string {
    return user && user.Description ? user.Description : '';
  }

  public onAreaChange(selectedRef: string): void {
    this.myControl.reset();

    this.novaPoshtaService.getCities(new NovaPoshtaRequest(
      "139ef94b20fa0b2f436ed7c8fed46363",
      "AddressGeneral",
      "getSettlements",
      new MethodProperties(selectedRef, "1", "2", "150", null)
    )).subscribe(cities => {
      this.allCities = cities;

      this.filteredCities$ = this.myControl.valueChanges.pipe(
        startWith(''),
        map(value => {
          const filterValue = typeof value === 'string' ? value.toLowerCase() : value?.Description.toLowerCase() ?? '';
          return this.allCities.filter(city =>
            city.Description.toLowerCase().includes(filterValue)
          );
        })
      );
    });
  }

  public getWarehouses(refCity: string): void {
    this.warehouse$ = this.novaPoshtaService.getWarehouses(new NovaPoshtaRequest(
      "139ef94b20fa0b2f436ed7c8fed46363",
      "AddressGeneral",
      "getWarehouses",
      new MethodProperties(null, null, null, null, refCity)
    ))
  }
}
