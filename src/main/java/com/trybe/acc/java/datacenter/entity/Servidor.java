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

// TODO: Auto-generated Javadoc
/**
 * The Class Servidor.
 */
@Entity
public class Servidor {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  /** The nome. */
  private String nome;

  /** The data center. */
  @ManyToOne
  @JoinColumn(name = "datacenter_id")
  private Datacenter dataCenter;

  /** The aplicacoes. */
  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "AplicacoesServidores", joinColumns = {
      @JoinColumn(name = "servidor_id") }, inverseJoinColumns = {
          @JoinColumn(name = "aplicacao_id") })
  private Set<Aplicacao> aplicacoes;

  /**
   * Instantiates a new servidor.
   */
  public Servidor() {
    this.aplicacoes = new HashSet<Aplicacao>();
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the nome.
   *
   * @return the nome
   */
  public String getNome() {
    return nome;
  }

  /**
   * Sets the nome.
   *
   * @param nome the new nome
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Gets the datacenter.
   *
   * @return the datacenter
   */
  public Datacenter getDatacenter() {
    return dataCenter;
  }

  /**
   * Sets the datacenter.
   *
   * @param dataCenter the new datacenter
   */
  public void setDatacenter(Datacenter dataCenter) {
    this.dataCenter = dataCenter;
  }

  /**
   * Gets the aplicacoes.
   *
   * @return the aplicacoes
   */
  public Set<Aplicacao> getAplicacoes() {
    return aplicacoes;
  }

  /**
   * Adds the aplicacao.
   *
   * @param aplicacao the aplicacao
   */
  public void addAplicacao(Aplicacao aplicacao) {
    this.aplicacoes.add(aplicacao);
  }
}
