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
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {Warehouse} from '../../../../models/warehouse';
import {CartItem} from '../../../../pop-up/shopping-cart/shopping-cart.component';
import {MatIcon} from '@angular/material/icon';
import {MatRadioButton, MatRadioGroup} from '@angular/material/radio';
import {MatButton} from "@angular/material/button";
import {MatDialogClose} from "@angular/material/dialog";
import {RouterLink} from '@angular/router';
import {OrderService} from '../../../../shared/services/order.service';
import {OrderRequest} from '../../../../shared/models/order.request';
import {ProductCardDto} from '../../../../shared/models/product-card-dto';

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
    MatInput,
    MatIcon,
    MatRadioGroup,
    MatRadioButton,
    MatButton,
    MatDialogClose,
    RouterLink
  ],
  templateUrl: './checkout.component.html',
  styleUrl: './checkout.component.scss',
  standalone: true
})
export class CheckoutComponent implements OnInit {

  public readonly medopticaStore = inject(MedopticaStore);
  private readonly fb = inject(FormBuilder);
  private readonly orderService = inject(OrderService);
  private readonly novaPoshtaService = inject(NovaPoshtaService);

  formCheckout: FormGroup =  new FormGroup({});
  areas$: Observable<Area[]> | undefined;
  warehouse$: Observable<Warehouse[]> | undefined;
  filteredCities$: Observable<City[]> | undefined;
  allCities: City[] = [];
  public total: number = 0;
  public groupedItems: CartItem[] = [];

  ngOnInit() {
    this.initForm();
    this.groupItems();
    this.calculateTotal();
    this.areas$ = this.novaPoshtaService.getAreas(new NovaPoshtaRequest("139ef94b20fa0b2f436ed7c8fed46363", "AddressGeneral", "getSettlementAreas", null));
  }

  private initForm(): void {
    this.formCheckout = this.fb.group({
      fullName: ['', Validators.required],
      phone: ['', Validators.required],
      region: ['', Validators.required],
      city: ['', Validators.required],
      branch: ['', Validators.required],
      paymentMethod: ['', Validators.required],
    })
  }

  displayFn(user: City): string {
    return user && user.Description ? user.Description : '';
  }

  public onAreaChange(selectedRef: any): void {
    this.formCheckout.get('city')?.reset('');

    this.novaPoshtaService.getCities(new NovaPoshtaRequest(
      "139ef94b20fa0b2f436ed7c8fed46363",
      "AddressGeneral",
      "getSettlements",
      new MethodProperties(selectedRef.Ref, "1", "2", "150", null)
    )).subscribe(cities => {
      this.allCities = cities;

      this.filteredCities$ = this.formCheckout.get('city')!.valueChanges.pipe(
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

  private groupItems(): void {
    const map = new Map<string, CartItem>();

    this.medopticaStore.selectedLikeProductCards.forEach(item => {
      const key = item.title; // уникальный идентификатор товара
      if (map.has(key)) {
        map.get(key)!.quantity += 1;
      } else {
        map.set(key, { productCard: item, quantity: 1 });
      }
    });

    this.groupedItems = Array.from(map.values());
  }

  public increase(item: CartItem): void {
    item.quantity += 1;
    this.calculateTotal();
  }

  public decrease(item: CartItem): void {
    if (item.quantity > 1) {
      item.quantity -= 1;
    } else {
      this.groupedItems = this.groupedItems.filter(i => i !== item);
    }
    this.calculateTotal();
  }

  public deleteGroupitem(item: CartItem): void {
    this.groupedItems = this.groupedItems.filter(i => i !== item);
    this.calculateTotal();
  }

  private calculateTotal(): void {
    this.total = this.groupedItems
      .reduce((sum, i) => sum + parseFloat(i.productCard.priceCurrent) * i.quantity, 0);
  }

  public sendOrderEmail() {
    const {fullName, phone, region, city, branch, paymentMethod} = this.formCheckout.value;

    const products: ProductCardDto[] = this.groupedItems.map(
      item => new ProductCardDto(item.productCard.title, Number(item.productCard.priceCurrent), item.quantity)
    );

    this.orderService.placeOrder(new OrderRequest(fullName, phone, region.Description, city.Description, branch.Description, paymentMethod, products)).subscribe()
  }

  compareAreas(a: any, b: any): boolean {
    return a && b && a.Ref === b.Ref;
  }

  compareWarehouse(a: any, b: any): boolean {
    return a && b && a.Ref === b.Ref;
  }
}
