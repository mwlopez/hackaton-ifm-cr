import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EstadoComponent } from './estado-proceso.component';

const routes: Routes = [
    {
        path: '',
        component: EstadoComponent,
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class EstadoRoutingModule {}
