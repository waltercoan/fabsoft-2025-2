package br.univille.fabsoft_backend.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemRevisao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantidade;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private Peca peca;

    
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public Peca getPeca() {
        return peca;
    }
    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    
    
}
