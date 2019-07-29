import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.scss'],
    animations: [routerTransition()]
})
export class DashboardComponent implements OnInit {
    public alerts: Array<any> = [];
    public sliders: Array<any> = [];

    constructor() {
        this.sliders.push(
            {
                imagePath: 'assets/images/slider1.jpg',
                label: 'Prueba 1',
                text: 'Slider 1'
            },
            {
                imagePath: 'assets/images/slider2.jpg',
                label: 'Prueba 2',
                text: 'Slider 2'
            },
            {
                imagePath: 'assets/images/slider3.jpg',
                label: 'Prueba 3',
                text: 'Slider 4'
            }
        );

        this.alerts.push(
            {
                id: 1,
                type: 'success',
                message: `Mensaje de alerta`
            },
            {
                id: 2,
                type: 'warning',
                message: `Mensaje de alerta warning`
            }
        );
    }

    ngOnInit() {}

    public closeAlert(alert: any) {
        const index: number = this.alerts.indexOf(alert);
        this.alerts.splice(index, 1);
    }
}
