package br.univille.fabsoft_backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

import br.univille.fabsoft_backend.entity.Cidade;
import br.univille.fabsoft_backend.service.CidadeService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/cidades")
public class CidadeController {
    @Autowired
    private CidadeService service;

    @GetMapping
    public ResponseEntity<List<Cidade>> getCidades(){
        
        var listaCidades = service.getAll();

        return new ResponseEntity<List<Cidade>>(listaCidades,
            HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Cidade> save(@Valid @RequestBody Cidade Cidade, BindingResult result){
        if(Cidade == null){
            return ResponseEntity.badRequest().build();
        }
        if (result.hasErrors()) {
            HttpHeaders headers = new HttpHeaders();
            String errorMessages = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.joining(" "));
            headers.add("Erro", errorMessages);
            return new ResponseEntity<Cidade>(Cidade,headers,HttpStatus.BAD_REQUEST);
        }
        if(Cidade.getId() == 0){
            Cidade = service.save(Cidade);
            return new ResponseEntity<Cidade>(Cidade,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> 
                getCidadeById(@PathVariable long id){
        
        var Cidade = service.getById(id);
        if(Cidade == null)
            return ResponseEntity.noContent().build();
            
        return new 
            ResponseEntity<Cidade>(Cidade, HttpStatus.OK);

    }   

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> 
        update(@RequestBody Cidade Cidade,
            @PathVariable long id){

        if(id <= 0 || Cidade == null){
            return ResponseEntity.badRequest().build();
        }

        try {
            Cidade = service.update(id, Cidade);
            return new ResponseEntity<Cidade>(Cidade,
                    HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Cidade> 
        update(@PathVariable long id){

        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }

        try {
            var Cidade = service.delete(id);
            return new ResponseEntity<Cidade>(Cidade,HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }


    }
}
