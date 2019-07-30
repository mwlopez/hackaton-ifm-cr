import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ReglasComponent } from './reglas.component';

const routes: Routes = [
    {
        path: '',
        component: ReglasComponent,
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class ReglasRoutingModule {}
