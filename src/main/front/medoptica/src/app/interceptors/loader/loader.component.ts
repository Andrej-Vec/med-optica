import {Component, inject, OnInit} from '@angular/core';
import {LoaderService} from '../../shared/services/loader.service';

@Component({
  selector: 'app-loader',
  imports: [],
  templateUrl: './loader.component.html',
  styleUrl: './loader.component.scss',
  standalone: true
})
export class LoaderComponent implements OnInit {
  private loaderService = inject(LoaderService);

  public show: boolean = false;

  ngOnInit() {
    this.loaderService.isLoading$.subscribe(state => {
      this.show = state;
    });
  }
}
