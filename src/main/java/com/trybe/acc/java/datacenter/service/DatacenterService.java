package com.trybe.acc.java.datacenter.service;

import com.trybe.acc.java.datacenter.entity.Datacenter;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DatacenterService implements ServiceInterface<Datacenter, Long> {

  /**
   * Salva data.
   *
   * @param data a ser salva
   */

  public void save(Datacenter data) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(data);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Atualiza data.
   *
   * @param data a ser atualizada
   */

  public void update(Datacenter data) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(data);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Remove data.
   *
   * @param id a ser deletado
   */

  public void delete(Long id) {
    EntityManager em = emf.createEntityManager();

    Datacenter data = em.find(Datacenter.class, id);

    em.getTransaction().begin();
    em.remove(data);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Retorna lista de data.
   *
   * @return List
   */

  public List<Datacenter> list() {
    EntityManager em = emf.createEntityManager();

    TypedQuery<Datacenter> query = em.createQuery("from Aplicacao", Datacenter.class);
    List<Datacenter> lstData = query.getResultList();
    return lstData;
  }

  /**
   * findById.
   *
   * @param id
   *
   * @return Datacenter
   */

  public Datacenter findById(Long id) {
    EntityManager em = emf.createEntityManager();
    return em.find(Datacenter.class, id);
  }
}
