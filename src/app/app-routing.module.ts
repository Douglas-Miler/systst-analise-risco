import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { VeiculoResolver } from './table/search-service/veiculo-resolver';
import { GridComponent } from './grid/grid/grid.component';

const routes: Routes = [
  {
    path: '',
    component: GridComponent,
    resolve: {
      response: VeiculoResolver
    }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
