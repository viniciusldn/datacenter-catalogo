package com.trybe.acc.java.datacenter.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DataCenter")
public class Datacenter {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String nome;

  private String localidade;

  @OneToMany(mappedBy = "dataCenter", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Servidor> servidores;

  public Datacenter() {
    this.servidores = new ArrayList<Servidor>();
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

  public String getLocalidade() {
    return localidade;
  }

  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }

  public void addServidor(Servidor servidor) {
    this.servidores.add(servidor);
  }
}
