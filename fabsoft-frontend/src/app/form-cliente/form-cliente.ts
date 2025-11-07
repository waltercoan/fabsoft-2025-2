import { Component } from '@angular/core'
import { Cliente } from '../model/cliente'
import { Cidade } from '../model/cidade'
import { ClienteService } from '../service/cliente.service'
import { CidadeService } from '../service/cidade.service'
import { HttpClientModule } from '@angular/common/http'
import { CommonModule } from '@angular/common'
import { FormsModule } from '@angular/forms'
import { Router, ActivatedRoute, ParamMap } from '@angular/router'


@Component({
  selector: 'app-form-cliente',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-cliente.html',
  styleUrl: './form-cliente.css',
  providers: [ClienteService, Router, CidadeService]

})
export class FormCliente {
    cliente: Cliente = new Cliente();

    listaCidades:Cidade[] = [];

    constructor(
      private clienteService:ClienteService,
      private cidadeService:CidadeService,
      private router:Router,
      private activeRouter: ActivatedRoute
      
    ){
        let id = this.activeRouter.snapshot.paramMap.get('id')

        this.cidadeService.getCidades().subscribe(listaCidades =>{
          this.listaCidades = listaCidades
        })
        

        if(id) {
          this.clienteService.getClienteById(id)
            .subscribe( res => {
                this.cliente = res
            })
        }
    }

    salvar(){
      this.clienteService.saveCliente(this.cliente)
        .subscribe(resultado => {
            this.router.navigate(['clientes'])
        })
    }

    comparaCidades(obj1: Cidade, obj2: Cidade): boolean{
      return obj1 && obj2 ? obj1.id === obj2.id : obj1 === obj2
    }
}
