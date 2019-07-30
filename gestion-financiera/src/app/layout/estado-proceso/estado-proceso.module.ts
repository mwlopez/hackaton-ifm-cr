import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EstadoRoutingModule } from './estado-proceso-routing.module';
import { EstadoComponent } from './estado-proceso.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, EstadoRoutingModule, PageHeaderModule],
    declarations: [EstadoComponent],
})
export class EstadoModule {}
