import { BaseService } from './base.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class ReglasService extends BaseService {
    private servicio = 'api/regla';

    constructor(private http: HttpClient) {
        super();
    }

    getReglas(): Observable<any> {
        return this.get(this.http, this.servicio, {});
    }

    addRegla(obj): Observable<any> {
        return this.post(this.http, this.servicio, obj);
    }

    deleteRegla(obj): Observable<any> {
        return this.post(this.http, 'api/elimina/regla', obj);
    }
}
