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

    constructor(private resultadossvc: ResultadosService) {}

    ngOnInit() {
        this.resultados();
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
