import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { EstadoService } from '../../../service/estado.service';

@Component({
    selector: 'app-estado-proceso',
    templateUrl: './estado-proceso.component.html',
    styleUrls: ['./estado-proceso.component.scss'],
    animations: [routerTransition()],
})
export class EstadoComponent implements OnInit {
    estados: any;

    constructor(private estadosvc: EstadoService) {}

    ngOnInit() {
        this.proceso();
    }

    proceso() {
        this.estadosvc
            .getProceso()
            .toPromise()
            .then(r => {
                this.estados = r;
            })
            .catch(er => {
                this.estados = undefined;
                console.log(er);
            });

        //this.router.navigate(['/dashboard']);
    }
}
