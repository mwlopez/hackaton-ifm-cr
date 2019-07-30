import { Injectable } from '@angular/core';
import {
    HttpErrorResponse,
    HttpEvent,
    HttpHandler,
    HttpInterceptor,
    HttpRequest,
    HttpResponse,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { EncryptSessionStorage } from '../util/secure-session-storage';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Router } from '@angular/router';
import * as SimpleBase from 'simple-base';
import { environment } from 'src/environments/environment';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
    constructor(private router: Router) {}

    intercept(
        req: HttpRequest<any>,
        next: HttpHandler
    ): Observable<HttpEvent<any>> {
        if (req.url.indexOf('assets/i18n') !== -1) {
            console.log('Traductor');
            return next.handle(req);
        }
        const ctx = EncryptSessionStorage.getContexto();
        console.log('contexto' + ctx);
        console.log(req);

        if (ctx) {
            /*const helper = new JwtHelperService();
      const isExpired = helper.isTokenExpired((<any>ctx).token);
      if (isExpired) {
        EncryptSessionStorage.clearStorage();
        this.router.navigate(['/login'], {});
        return Observable.create();
      }*/
            let clonedHeaders = req.clone({
                setHeaders: {
                    Authorization: 'Bearer ' + (<any>ctx).token,
                },
            });
            console.log(req);
            if (req.method === 'GET') {
                const data = req.url.split('?');
                if (data.length > 1) {
                    clonedHeaders = clonedHeaders.clone({
                        url:
                            data[0] +
                            '?data=' +
                            SimpleBase.base58.encode(
                                EncryptSessionStorage.encrypt(data[1])
                            ),
                    });
                }
            } else if (req.method === 'POST') {
                const e = JSON.stringify(req.body);
                if (!environment.localhost) {
                    clonedHeaders = clonedHeaders.clone({
                        body: {
                            data: SimpleBase.base58.encode(
                                EncryptSessionStorage.encrypt(e)
                            ),
                        },
                    });
                }
                // }
            }
            return next
                .handle(req)
                .do(e => {})
                .catch(response => {
                    // TODO: validar estatus de respuesta
                    console.log(response);
                    if (response instanceof HttpErrorResponse) {
                        if (response.status === 401) {
                            EncryptSessionStorage.clearStorage();
                            this.router.navigate(['/login']);
                        }
                    }
                    return next.handle(clonedHeaders);
                });
        } else {
            if (this.router.url === '/login') {
                const clonedHeaders = req.clone({
                    setHeaders: {
                        // 'X-Authorization-Type': 'plain',
                    },
                });
                return next
                    .handle(clonedHeaders)
                    .do(e => {})
                    .catch(response => {
                        return next.handle(clonedHeaders);
                    });
            } else {
                this.router.navigate(['/login'], {});
                return Observable.create();
                //return next.handle(req);
            }
        }
    }
}
