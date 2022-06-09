package com.trybe.acc.java.datacenter.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

// TODO: Auto-generated Javadoc
/**
 * The Class Aplicacao.
 */
@Entity
public class Aplicacao {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  /** The nome. */
  private String nome;

  /** The descricao. */
  private String descricao;

  /** The servidores. */
  @ManyToMany(mappedBy = "aplicacoes")
  private Set<Servidor> servidores;

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
   * Gets the servidores.
   *
   * @return the servidores
   */
  public Set<Servidor> getServidores() {
    return servidores;
  }

  /**
   * Sets the servidores.
   *
   * @param servidores the new servidores
   */
  public void setServidores(Set<Servidor> servidores) {
    this.servidores = servidores;
  }

  /**
   * Gets the descricao.
   *
   * @return the descricao
   */
  public String getDescricao() {
    return descricao;
  }

  /**
   * Sets the descricao.
   *
   * @param descricao the new descricao
   */
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

}
