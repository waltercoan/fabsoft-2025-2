package br.univille.fabsoft_backend.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.fabsoft_backend.entity.Cliente;
import br.univille.fabsoft_backend.service.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes(){
        
        var listaClientes = service.getAll();

        return new ResponseEntity<List<Cliente>>(listaClientes,
            HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Cliente> save(@Valid @RequestBody Cliente cliente, BindingResult result){
        if(cliente == null){
            return ResponseEntity.badRequest().build();
        }
        if (result.hasErrors()) {
            HttpHeaders headers = new HttpHeaders();
            String errorMessages = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.joining(" "));
            headers.add("Erro", errorMessages);
            return new ResponseEntity<Cliente>(cliente,headers,HttpStatus.BAD_REQUEST);
        }
        if(cliente.getId() == 0){
            cliente = service.save(cliente);
            return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> 
                getClienteById(@PathVariable long id){
        
        var cliente = service.getById(id);
        if(cliente == null)
            return ResponseEntity.noContent().build();
            
        return new 
            ResponseEntity<Cliente>(cliente, HttpStatus.OK);

    }   

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> 
        update(@RequestBody Cliente cliente,
            @PathVariable long id){

        if(id <= 0 || cliente == null){
            return ResponseEntity.badRequest().build();
        }

        try {
            cliente = service.update(id, cliente);
            return new ResponseEntity<Cliente>(cliente,
                    HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> 
        update(@PathVariable long id){

        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }

        try {
            var cliente = service.delete(id);
            return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }


    }

}
