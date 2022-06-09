package com.trybe.acc.java.datacenter.service;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// TODO: Auto-generated Javadoc
/**
 * NÃO ALTERAR ESSA INTERFACE.
 *
 * @param <T> the generic type
 * @param <I> the generic type
 */
public interface ServiceInterface<T, I extends Serializable> {

  /** The emf. */
  EntityManagerFactory emf =
      Persistence.createEntityManagerFactory("com.trybe.acc.java.hibernate.datacenter");

  /**
   * Save.
   *
   * @param s the s
   */
  void save(T s);

  /**
   * Update.
   *
   * @param s the s
   */
  void update(T s);

  /**
   * Delete.
   *
   * @param id the id
   */
  void delete(I id);

  /**
   * List.
   *
   * @return the list
   */
  List<T> list();

  /**
   * Find by id.
   *
   * @param id the id
   * @return the t
   */
  T findById(I id);
}
