import { BaseService } from './base.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class BeneficiosService extends BaseService {
    private servicio = 'api/beneficiario';

    constructor(private http: HttpClient) {
        super();
    }

    getBeneficiario(request: any): Observable<any> {
        return this.post(this.http, this.servicio, request);
    }
}
