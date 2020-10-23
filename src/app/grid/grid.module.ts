import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatGridListModule } from '@angular/material/grid-list';
import { HttpClientModule } from '@angular/common/http';

import { GridComponent } from './grid/grid.component';
import { TableModule } from './../table/table.module';
import { CreateFormModule } from '../create-form/create-form.module';

@NgModule({
  declarations: [GridComponent],
  imports: [
    CommonModule,
    MatGridListModule,
    TableModule,
    CreateFormModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  exports: [
    GridComponent
  ]
})
export class GridModule { }
