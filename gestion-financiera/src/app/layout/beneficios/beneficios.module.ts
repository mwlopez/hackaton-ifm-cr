import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BeneficiosRoutingModule } from './beneficios-routing.module';
import { BeneficiosComponent } from './beneficios.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, BeneficiosRoutingModule, PageHeaderModule],
    declarations: [BeneficiosComponent],
})
export class BeneficiosModule {}
