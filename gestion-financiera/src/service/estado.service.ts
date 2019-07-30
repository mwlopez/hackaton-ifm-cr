import { BaseService } from './base.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class EstadoService extends BaseService {
    private servicio = 'api/proceso';

    constructor(private http: HttpClient) {
        super();
    }

    getProceso(): Observable<any> {
        return this.get(this.http, this.servicio, {});
    }
}
