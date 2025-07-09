import {Component, inject, OnInit} from '@angular/core';
import {HeaderComponent} from './components/header/header.component';
import {FooterComponent} from './components/footer/footer.component';
import {HelloService} from './shared/services/hello.service';
import {LoaderComponent} from './interceptors/loader/loader.component';
import {RouterOutlet} from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [HeaderComponent, FooterComponent, LoaderComponent, RouterOutlet],
  templateUrl: './app.html',
  standalone: true,
  styleUrl: './app.scss'
})
export class App implements OnInit {
  protected title = 'medoptica';
  private readonly helloService = inject(HelloService);

  ngOnInit() {
    this.helloService.getMessage().subscribe(resp => {
      console.log("resp", resp);
    })
  }
}
