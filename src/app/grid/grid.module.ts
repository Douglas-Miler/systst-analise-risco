import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatGridListModule } from '@angular/material/grid-list';

import { GridComponent } from './grid/grid.component';
import { TableModule } from './../table/table.module';
import { CreateFormModule } from '../create-form/create-form.module';

@NgModule({
  declarations: [GridComponent],
  imports: [
    CommonModule,
    MatGridListModule,
    TableModule,
    CreateFormModule
  ],
  exports: [
    GridComponent
  ]
})
export class GridModule { }
