import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { ResultadosService } from '../../../service/resultados.service';

@Component({
    selector: 'app-resultados',
    templateUrl: './resultado-proceso.component.html',
    styleUrls: ['./resultado-proceso.component.scss'],
    animations: [routerTransition()],
})
export class ResultadosComponent implements OnInit {
    resultado: any;
    resultadoProceso: any;

    constructor(private resultadossvc: ResultadosService) {}

    ngOnInit() {
        this.resultados();
        this.resultadosProceso();
    }

    resultadosProceso() {
        this.resultadossvc
            .getResultadoProceso()
            .toPromise()
            .then(r => {
                this.resultadoProceso = r;
            })
            .catch(er => {
                this.resultadoProceso = undefined;
                console.log(er);
            });

        //this.router.navigate(['/dashboard']);
    }

    resultados() {
        this.resultadossvc
            .getResultados()
            .toPromise()
            .then(r => {
                this.resultado = r;
            })
            .catch(er => {
                this.resultado = undefined;
                console.log(er);
            });

        //this.router.navigate(['/dashboard']);
    }
}
