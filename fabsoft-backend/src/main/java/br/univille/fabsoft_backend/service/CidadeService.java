package br.univille.fabsoft_backend.service;

import java.util.List;

import br.univille.fabsoft_backend.entity.Cidade;

public interface CidadeService {
    List<Cidade> getAll();
    Cidade save(Cidade cidade);
    Cidade update(long id,Cidade cidade) throws Exception;
    Cidade delete(long id) throws Exception;
    Cidade getById(long id);
}
