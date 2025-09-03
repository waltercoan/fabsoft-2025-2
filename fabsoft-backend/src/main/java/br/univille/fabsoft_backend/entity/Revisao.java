package br.univille.fabsoft_backend.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Revisao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataAgendamento;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataRealizacao;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private Carro carro;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "revisao_id")
    private List<ItemRevisao> listaItens = new ArrayList<>();

    public List<ItemRevisao> getListaItens() {
        return listaItens;
    }
    public void setListaItens(List<ItemRevisao> listaItens) {
        this.listaItens = listaItens;
    }
    public Carro getCarro() {
        return carro;
    }
    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getDataAgendamento() {
        return dataAgendamento;
    }
    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }
    public Date getDataRealizacao() {
        return dataRealizacao;
    }
    public void setDataRealizacao(Date dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }
    
    
}
