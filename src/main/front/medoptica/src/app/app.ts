import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HeaderComponent} from './header/header.component';
import {SliderComponent} from './slider/slider.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HeaderComponent, SliderComponent],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected title = 'medoptica';
}
