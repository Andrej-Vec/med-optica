import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HeaderComponent} from './components/header/header.component';
import {SliderComponent} from './components/slider/slider.component';
import {ProductsComponent} from './components/products/products.component';

@Component({
  selector: 'app-root',
  imports: [HeaderComponent, SliderComponent, ProductsComponent],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected title = 'medoptica';
}
