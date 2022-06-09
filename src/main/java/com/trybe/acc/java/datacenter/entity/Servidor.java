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
import javax.persistence.Table;

@Entity
@Table(name = "tabela_servidor")
public class Servidor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;

  /** VARIOS servidores pode ter UM datacenter. */
  @ManyToOne
  @JoinColumn(name = "datacenter_id")
  private Datacenter datacenter;

  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "relacionamento_servidor_aplicacao", joinColumns = {
      @JoinColumn(name = "datacenter_id") }, inverseJoinColumns = {
          @JoinColumn(name = "servidor_id") })
  private Set<Aplicacao> aplicacoes;

  public Servidor() {
    super();
    this.aplicacoes = new HashSet<Aplicacao>();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Datacenter getDatacenter() {
    return datacenter;
  }

  public void setDatacenter(Datacenter datacenter) {
    this.datacenter = datacenter;
  }

  public Set<Aplicacao> getAplicacoes() {
    return aplicacoes;
  }

  public void setAplicacoes(Set<Aplicacao> aplicacoes) {
    this.aplicacoes = aplicacoes;
  }

  public void addAplicacao(Aplicacao aplicac) {
    this.aplicacoes.add(aplicac);
  }

}
