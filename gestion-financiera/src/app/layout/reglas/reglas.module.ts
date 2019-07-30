import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReglasRoutingModule } from './reglas-routing.module';
import { ReglasComponent } from './reglas.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, ReglasRoutingModule, PageHeaderModule],
    declarations: [ReglasComponent],
})
export class ReglasModule {}
