package com.trybe.acc.java.datacenter.service;

import com.trybe.acc.java.datacenter.entity.Servidor;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * The Class ServidorService.
 */
public class ServidorService implements ServiceInterface<Servidor, Long> {

  @Override
  public void save(Servidor s) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(s);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public void update(Servidor s) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(s);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public void delete(Long id) {
    EntityManager em = emf.createEntityManager();

    Servidor data = em.find(Servidor.class, id);

    em.getTransaction().begin();
    em.remove(data);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public List<Servidor> list() {
    EntityManager em = emf.createEntityManager();

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Servidor> cq = cb.createQuery(Servidor.class);
    Root<Servidor> rootEntry = cq.from(Servidor.class);
    CriteriaQuery<Servidor> all = cq.select(rootEntry);

    TypedQuery<Servidor> query = em.createQuery(all);
    return query.getResultList();
  }

  @Override
  public Servidor findById(Long id) {
    EntityManager em = emf.createEntityManager();
    return em.find(Servidor.class, id);
  }

}
