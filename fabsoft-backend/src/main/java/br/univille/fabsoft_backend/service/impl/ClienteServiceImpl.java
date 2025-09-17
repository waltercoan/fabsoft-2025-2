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

        var clienteAntigo = repository.getById(id);
        if(clienteAntigo == null){
            throw new Exception("Cliente inexistente");
        }

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
        var clienteAntigo = repository.getById(id);
        if(clienteAntigo == null){
            throw new Exception("Cliente inexistente");
        }

        repository.delete(clienteAntigo);
        return clienteAntigo;
    }

}
