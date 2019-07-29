import {Injectable } from '@angular/core';
import {CanActivate, CanActivateChild, Router, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs';
import {EncryptSessionStorage} from '../util/secure-session-storage';



@Injectable()
export class ActivateInterceptor implements CanActivate, CanActivateChild {
  constructor(
    private router: Router
  ) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    const ctx = EncryptSessionStorage.getContexto();
    if (ctx === null || ctx === undefined) {
      this.router.navigate(['/login'], {});
      return false;
    }
    return true;
  }

  canActivateChild() {
    return true;
  }

}
