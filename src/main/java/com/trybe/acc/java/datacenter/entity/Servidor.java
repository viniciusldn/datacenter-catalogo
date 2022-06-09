package com.trybe.acc.java.datacenter.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Servidor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String nome;

  @ManyToOne
  @JoinColumn(name = "datacenter_id")
  private Datacenter dataCenter;

  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "AplicacoesServidores", joinColumns = {
      @JoinColumn(name = "servidor_id") }, inverseJoinColumns = {
          @JoinColumn(name = "aplicacao_id") })
  private Set<Aplicacao> aplicacoes;

  public Servidor() {
    this.aplicacoes = new HashSet<Aplicacao>();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Datacenter getDatacenter() {
    return dataCenter;
  }

  public void setDatacenter(Datacenter dataCenter) {
    this.dataCenter = dataCenter;
  }

  public Set<Aplicacao> getAplicacoes() {
    return aplicacoes;
  }

  public void addAplicacao(Aplicacao aplicacao) {
    this.aplicacoes.add(aplicacao);
  }
}
