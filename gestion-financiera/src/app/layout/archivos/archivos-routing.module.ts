import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ArchivosComponent } from './archivos.component';

const routes: Routes = [
    {
        path: '',
        component: ArchivosComponent,
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class ArchivosRoutingModule {}
