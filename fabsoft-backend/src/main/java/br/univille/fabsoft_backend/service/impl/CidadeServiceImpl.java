package br.univille.fabsoft_backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fabsoft_backend.entity.Cidade;
import br.univille.fabsoft_backend.repository.CidadeRepository;
import br.univille.fabsoft_backend.service.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService {
    @Autowired
    private CidadeRepository repository;

    @Override
    public List<Cidade> getAll() {
        return repository.findAll();
    }

    @Override
    public Cidade save(Cidade cidade) {
        return repository.save(cidade);
    }

    @Override
    public Cidade update(long id, Cidade cidade) throws Exception {
        var optResp = repository.findById(id);
        if(!optResp.isPresent()){
            throw new Exception("Cidade inexistente");
        }
        var cidadeAntigo = optResp.get();
        
        cidadeAntigo.setNome(cidade.getNome());
        
        repository.save(cidadeAntigo);

        return cidadeAntigo;
    }

    @Override
    public Cidade delete(long id) throws Exception {
        var optResp = repository.findById(id);
        if(!optResp.isPresent()){
            throw new Exception("Cidade inexistente");
        }

        var cidadeAntigo = optResp.get();
        
        repository.delete(cidadeAntigo);
        return cidadeAntigo;
    }

    @Override
    public Cidade getById(long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        
        return null;
    }
    
}
