package br.univille.fabsoft_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.fabsoft_backend.entity.Revisao;

@Repository
public interface RevisaoRepository 
    extends JpaRepository<Revisao,Long>{

}
