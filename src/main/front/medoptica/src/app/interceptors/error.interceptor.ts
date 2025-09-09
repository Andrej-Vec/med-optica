import { inject } from '@angular/core';
import { HttpInterceptorFn, HttpErrorResponse } from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';
import { catchError, throwError } from 'rxjs';

export const errorInterceptor: HttpInterceptorFn = (req, next) => {
  const snackBar = inject(MatSnackBar);

  return next(req).pipe(
    catchError((error: HttpErrorResponse) => {
      const message =
        error?.error?.message ||
        (error.status === 0
          ? 'Немає з’єднання з сервером.'
          : 'Щось пішло не так. Спробуйте пізніше.');

      snackBar.open(message, 'Закрити', {
        horizontalPosition: 'center',
        verticalPosition: 'top'
      });

      return throwError(() => error);
    })
  );
};
