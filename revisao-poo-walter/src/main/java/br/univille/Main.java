package br.univille;

import br.univille.entity.Cidade;
import br.univille.entity.Cliente;
import br.univille.entity.Pokemon;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        var cliente = new Cliente();
        cliente.setNome("zezinho");
        cliente.setIdade(20);
        cliente.setPeso(70);

        Cidade cidade = new Cidade("joinville");

        cliente.setCidade(cidade);

        var jigglypuff = new Pokemon("jigglypuff");
        var pikachu = new Pokemon("pikachu");

        cliente.getListaPokemon().add(jigglypuff);
        cliente.getListaPokemon().add(pikachu);
        //cliente.getListaPokemon().add("porygon");
        //cliente.getListaPokemon().add("univille");
        //cliente.getListaPokemon().add(12345);
        //cliente.getListaPokemon().add(false);
        //cliente.getListaPokemon().add(12345.55);




        System.out.println();

    }
}