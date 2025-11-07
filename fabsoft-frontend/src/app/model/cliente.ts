import { Cidade } from "./cidade";

export class Cliente {
    id:number;
    nome:string;
    endereco:string;
    telefone:string;
    email:string;
    dataNascimento: Date;
    cidade: Cidade;

}
