import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { BeneficiosService } from '../../../service/beneficios.service';

@Component({
    selector: 'app-beneficios',
    templateUrl: './beneficios.component.html',
    styleUrls: ['./beneficios.component.scss'],
    animations: [routerTransition()],
})
export class BeneficiosComponent implements OnInit {
    beneficiario: any;

    constructor(private beneficiossvc: BeneficiosService) {}

    ngOnInit() {}

    beneficios() {
        let inputValue = (<HTMLInputElement>document.getElementById('txtId'))
            .value;
        const u = {
            num_documento: inputValue,
        };

        this.beneficiossvc
            .getBeneficiario(u)
            .toPromise()
            .then(r => {
                this.beneficiario = r;
            })
            .catch(er => {
                this.beneficiario = undefined;
                console.log(er);
            });

        //this.router.navigate(['/dashboard']);
    }
}
