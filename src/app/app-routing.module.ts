import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { VehicleResolver } from './general/vehicle-resolver';
import { GridComponent } from './grid/grid/grid.component';

const routes: Routes = [
  {
    path: '',
    component: GridComponent,
    resolve: {
      response: VehicleResolver
    }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
