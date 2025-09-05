package br.univille.fabsoft_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.fabsoft_backend.entity.Carro;

@Repository
public interface CarroRepository 
        extends JpaRepository<Carro,Long>{
    List<Carro> findByMarcaAndModelo(String marca, String modelo);
}
