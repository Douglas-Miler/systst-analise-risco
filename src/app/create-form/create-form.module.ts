import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';

import { CurrencyMaskModule } from "ng2-currency-mask";

import { CreateFormComponent } from './create-form/create-form.component';

@NgModule({
  declarations: [
    CreateFormComponent
  ],
  imports: [
    CommonModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatDividerModule,
    CurrencyMaskModule
  ],
  exports: [
    CreateFormComponent
  ]
})
export class CreateFormModule { }
