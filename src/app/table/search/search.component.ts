import { SearchService } from './../search-service/search.service';
import { Veiculo } from './../search-service/veiculo';
import { Component, OnInit, ViewChild, ElementRef, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  veiculos: Veiculo[] = [];
  dropdownOptions = [{id: 1, description: 'Alto'}, {id: 2, description: 'Médio'}, {id: 3, description: 'Baixo'}]
  searchForm: FormGroup;
  @ViewChild('select') select: ElementRef<HTMLSelectElement>;
  @Output() onSubmit = new EventEmitter<any>();

  constructor(private searchService: SearchService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.searchForm = this.formBuilder.group({
      select:['', Validators.required]
    });
  }

  search(selectValue: any){
    this.searchService.findVehicleByRiskId(selectValue.id).subscribe(response => this.handleResponse(response));
  }

  handleResponse(response: any){
    this.veiculos = response.content;
    if(this.veiculos.length == 0)
      window.alert('Não há resultados');
    else {
      this.onSubmit.emit({response});
    }
  }
}

