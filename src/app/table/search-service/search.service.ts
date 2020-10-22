import { Injectable } from '@angular/core';
import { HttpClient, HttpBackend } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class SearchService {

    private http: HttpClient;

    constructor(handler: HttpBackend){
        this.http = new HttpClient(handler);
    }

    findVehicleByRiskId(riskId: number){
        return this.http.get('http://localhost:8080/sin/systst-analise-risco/rest/veiculo/' + riskId);
    }

    getAllVehicles(){
        return this.http.get('http://localhost:8080/sin/systst-analise-risco/rest/veiculo');
    }

}