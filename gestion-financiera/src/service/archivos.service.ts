import { BaseService } from './base.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class ArchivosService extends BaseService {
    private servicio = 'api/cargaarchivo';

    constructor(private http: HttpClient) {
        super();
    }

    subirArchivo(rq): Observable<any> {
        return this.post(this.http, this.servicio, rq);
    }
}
