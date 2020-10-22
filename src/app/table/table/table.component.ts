import { ActivatedRoute } from '@angular/router';
import { Component, OnInit, AfterViewInit, ViewChild, Input, OnChanges, SimpleChanges, ChangeDetectorRef } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

import { Veiculo } from './../search-service/veiculo';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss']
})
export class TableComponent implements OnInit, AfterViewInit {

  displayedColumns = ['id', 'marca', 'modelo', 'ano', 'valor', 'risco'];
  @Input() dataSource: MatTableDataSource<Veiculo[]>;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private activatedRoute: ActivatedRoute, private changeDetector: ChangeDetectorRef) { }

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit(): void {
    this.dataSource = new MatTableDataSource<Veiculo[]>(this.activatedRoute.snapshot.data['response'].content);
  }

  formatDate(ano: number[]){
    let date = new Date(ano[0], ano[1], ano[2]);
    return date.getFullYear();
  }

  formatValueAsCurrency(valor: number){
    return new Intl.NumberFormat('pt-BR', {style: 'currency', currency: 'BRL'}).format(valor);
  }

  setDataSource(veiculos: any){
    this.dataSource = new MatTableDataSource<Veiculo[]>(veiculos);
    this.dataSource.paginator = this.paginator;
  }
}
