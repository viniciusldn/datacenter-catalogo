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

// TODO: Auto-generated Javadoc
/**
 * The Class Datacenter.
 */
@Entity
@Table(name = "DataCenter")
public class Datacenter {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  /** The nome. */
  private String nome;

  /** The localidade. */
  private String localidade;

  /** The servidores. */
  @OneToMany(mappedBy = "dataCenter", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Servidor> servidores;

  /**
   * Instantiates a new datacenter.
   */
  public Datacenter() {
    this.servidores = new ArrayList<Servidor>();
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
   * Gets the localidade.
   *
   * @return the localidade
   */
  public String getLocalidade() {
    return localidade;
  }

  /**
   * Sets the localidade.
   *
   * @param localidade the new localidade
   */
  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }

  /**
   * Adds the servidor.
   *
   * @param servidor the servidor
   */
  public void addServidor(Servidor servidor) {
    this.servidores.add(servidor);
  }
}
