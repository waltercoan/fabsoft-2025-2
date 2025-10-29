package br.univille.fabsoft_backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fabsoft_backend.entity.Cliente;
import br.univille.fabsoft_backend.repository.ClienteRepository;
import br.univille.fabsoft_backend.service.ClienteService;

@Service
public class ClienteServiceImpl 
    implements ClienteService{

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente update(long id, Cliente cliente) throws Exception{

        var optResp = repository.findById(id);
        if(!optResp.isPresent()){
            throw new Exception("Cliente inexistente");
        }
        var clienteAntigo = optResp.get();
        
        clienteAntigo.setNome(cliente.getNome());
        clienteAntigo.setDataNascimento(cliente.getDataNascimento());
        clienteAntigo.setEmail(cliente.getEmail());
        clienteAntigo.setEndereco(cliente.getEndereco());
        clienteAntigo.setTelefone(cliente.getTelefone());
        clienteAntigo.setCidade(cliente.getCidade());
        
        repository.save(clienteAntigo);

        return clienteAntigo;
    }

    @Override
    public Cliente delete(long id) throws Exception {
       var optResp = repository.findById(id);
        if(!optResp.isPresent()){
            throw new Exception("Cliente inexistente");
        }

        var clienteAntigo = optResp.get();
        
        repository.delete(clienteAntigo);
        return clienteAntigo;
    }

    @Override
    public Cliente getById(long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        
        return null;
    }

}
