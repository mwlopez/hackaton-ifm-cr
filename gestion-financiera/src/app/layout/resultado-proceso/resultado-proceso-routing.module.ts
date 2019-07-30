import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ResultadosComponent } from './resultado-proceso.component';

const routes: Routes = [
    {
        path: '',
        component: ResultadosComponent,
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class ResultadosRoutingModule {}
