import { BaseService } from './base.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class ResultadosService extends BaseService {
    private servicio = 'api/beneficiario';

    constructor(private http: HttpClient) {
        super();
    }

    getResultados(): Observable<any> {
        return this.get(this.http, this.servicio, {});
    }
}
