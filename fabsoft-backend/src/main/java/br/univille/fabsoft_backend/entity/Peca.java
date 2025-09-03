package br.univille.fabsoft_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Peca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codigo;
    private float valorUnitario;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public float getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    
}
