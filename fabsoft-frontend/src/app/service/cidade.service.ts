import { Injectable } from '@angular/core';
import { Cidade } from '../model/cidade';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CidadeService {
  apiURL = 'http://localhost:8080/api/v1/cidades'

  constructor(private http:HttpClient) {}

  getCidades(){
    return this.http.get<Cidade[]>(this.apiURL)
  }



}
