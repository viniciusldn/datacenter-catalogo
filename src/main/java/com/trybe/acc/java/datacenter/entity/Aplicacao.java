package com.trybe.acc.java.datacenter.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Aplicacao {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nome;
  private String descricao;

  @ManyToMany(mappedBy = "Aplicacao")
  private Set<Servidor> servidores;

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

  public Set<Servidor> getServidores() {
    return servidores;
  }

  public void setServidores(Set<Servidor> servidores) {
    this.servidores = servidores;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

}
