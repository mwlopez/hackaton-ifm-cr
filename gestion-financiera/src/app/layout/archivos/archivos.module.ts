import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ArchivosRoutingModule } from './archivos-routing.module';
import { ArchivosComponent } from './archivos.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, ArchivosRoutingModule, PageHeaderModule],
    declarations: [ArchivosComponent],
})
export class ArchivosModule {}
