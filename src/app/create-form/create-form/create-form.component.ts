import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { VehicleService } from './../../general/vehicle.service';
import { Vehicle } from '../../general/vehicle';

@Component({
  selector: 'app-create-form',
  templateUrl: './create-form.component.html',
  styleUrls: ['./create-form.component.scss']
})
export class CreateFormComponent implements OnInit {

  createForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private vehicleService: VehicleService) { }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group({
      marca: ['', Validators.required],
      modelo: ['', Validators.required],
      ano: ['', [Validators.required,
                  Validators.pattern(/(188[6-9]|19[0-9][0-9]|20[0-2][0-9]|2030)/),
                  Validators.maxLength(4)
                ]
      ],
      valor: ['', Validators.required]
    });
  }

  create(){
    let veiculo: Vehicle = this.createForm.value;
    this.vehicleService.saveVehicle(veiculo).subscribe(
      () => {
        alert('Veículo cadastrado com sucesso');
      }, 
      err => {
        alert('Erro! Consulte o console para mais informações')
        console.log(err);
      }
    );
  }
}
