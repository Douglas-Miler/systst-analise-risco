import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatGridListModule } from '@angular/material/grid-list';

import { GridComponent } from './grid/grid.component';
import { TableModule } from './../table/table.module';
import { FormModule } from './../form/form.module';

@NgModule({
  declarations: [GridComponent],
  imports: [
    CommonModule,
    MatGridListModule,
    TableModule,
    FormModule
  ],
  exports: [
    GridComponent
  ]
})
export class GridModule { }
