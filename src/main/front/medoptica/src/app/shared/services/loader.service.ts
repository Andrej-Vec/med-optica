import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class LoaderService {
  private _isLoading = new BehaviorSubject<boolean>(false);
  public readonly isLoading$ = this._isLoading.asObservable();
  private requestCounter = 0;

  public show(): void {
    this.requestCounter++;
    this._isLoading.next(true)
  }

  public hide(): void {
    if (this.requestCounter > 0) this.requestCounter--;
    if (this.requestCounter === 0) this._isLoading.next(false);
  }
}
