import { BaseService } from './base.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class UsuarioService extends BaseService {
  private servicio = 'api/login';

  constructor(private http: HttpClient) {
    super();
  }

  loginUser (request: any): Observable<any> {
    return this.post(this.http, this.servicio, request);
  }
}
