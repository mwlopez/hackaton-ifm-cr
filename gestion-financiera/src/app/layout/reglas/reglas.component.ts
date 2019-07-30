import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { ReglasService } from '../../../service/reglas.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-reglas',
    templateUrl: './reglas.component.html',
    styleUrls: ['./reglas.component.scss'],
    animations: [routerTransition()],
})
export class ReglasComponent implements OnInit {
    reglas: any;

    constructor(public router: Router, private reglassvc: ReglasService) {}

    ngOnInit() {
        this.cargarReglas();
    }

    eliminarRegla(objRegla) {
        this.reglassvc
            .deleteRegla(objRegla)
            .toPromise()
            .then(r => {
                this.cargarReglas();
            })
            .catch(er => {
                console.log(er);
            });
    }

    agregarRegla() {
        var elNombre = <HTMLInputElement>document.getElementById('txtNombre');
        var elCampo = <HTMLSelectElement>document.getElementById('selCampo');
        var elTipo = <HTMLSelectElement>document.getElementById('selTipo');
        var elValor = <HTMLInputElement>document.getElementById('txtValor');
        var elIgualdad = <HTMLSelectElement>(
            document.getElementById('selIgualdad')
        );

        var objRegla = {
            nombre: elNombre.value,
            campo: elCampo.options[elCampo.selectedIndex].text,
            tipo: elTipo.options[elTipo.selectedIndex].text,
            valor: elValor.value,
            igualdad: elIgualdad.options[elIgualdad.selectedIndex].text,
        };

        this.reglassvc
            .addRegla(objRegla)
            .toPromise()
            .then(r => {
                this.cargarReglas();
                elNombre.value = '';
                elValor.value = '';
            })
            .catch(er => {
                console.log(er);
            });
    }

    cargarReglas() {
        this.reglassvc
            .getReglas()
            .toPromise()
            .then(r => {
                this.reglas = r;
            })
            .catch(er => {
                this.reglas = undefined;
                console.log(er);
            });

        //this.router.navigate(['/dashboard']);
    }
}
