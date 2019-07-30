import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ResultadosRoutingModule } from './resultado-proceso-routing.module';
import { ResultadosComponent } from './resultado-proceso.component';
import { PageHeaderModule, StatModule } from './../../shared';

@NgModule({
    imports: [
        CommonModule,
        ResultadosRoutingModule,
        PageHeaderModule,
        StatModule,
    ],
    declarations: [ResultadosComponent],
})
export class ResultadosModule {}
