package com.trybe.acc.java.datacenter.service;

import com.trybe.acc.java.datacenter.entity.Datacenter;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DatacenterService implements ServiceInterface<Datacenter, Long> {

  @Override
  public void save(Datacenter s) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(s);
    em.getTransaction().commit();
    em.close();

  }

  @Override
  public void update(Datacenter s) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(s);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public void delete(Long id) {
    EntityManager em = emf.createEntityManager();

    Datacenter data = em.find(Datacenter.class, id);

    em.getTransaction().begin();
    em.remove(data);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public List<Datacenter> list() {
    EntityManager em = emf.createEntityManager();

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Datacenter> cq = cb.createQuery(Datacenter.class);
    Root<Datacenter> rootEntry = cq.from(Datacenter.class);
    CriteriaQuery<Datacenter> all = cq.select(rootEntry);

    TypedQuery<Datacenter> query = em.createQuery(all);
    return query.getResultList();
  }

  @Override
  public Datacenter findById(Long id) {
    EntityManager em = emf.createEntityManager();
    return em.find(Datacenter.class, id);
  }

}
