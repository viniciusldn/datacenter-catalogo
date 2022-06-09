package com.trybe.acc.java.datacenter.service;

import com.trybe.acc.java.datacenter.entity.Aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class AplicacaoService implements ServiceInterface<Aplicacao, Long> {

  /**
   * Salva uma aplicação no banco de dados.
   *
   * @param app a aplicação app ser salva
   */

  public void save(Aplicacao app) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(app);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Atualiza uma aplicação no banco de dados.
   *
   * @param app a aplicação app ser atualizada
   */

  public void update(Aplicacao app) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(app);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Remove uma aplicação do banco de dados.
   *
   * @param id o identificador único da aplicação a ser removida
   */

  public void delete(Long id) {
    EntityManager em = emf.createEntityManager();

    Aplicacao app = em.find(Aplicacao.class, id);

    em.getTransaction().begin();
    em.remove(app);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Retorna todas as aplicações do banco de dados.
   *
   * @return List
   */

  public List<Aplicacao> list() {
    EntityManager em = emf.createEntityManager();

    TypedQuery<Aplicacao> query = em.createQuery("from Aplicacao", Aplicacao.class);
    List<Aplicacao> lstApp = query.getResultList();
    return lstApp;
  }

  /**
   * findById.
   *
   * @param id da aplicação a ser encontrada
   *
   * @return Aplicacao
   */

  public Aplicacao findById(Long id) {
    EntityManager em = emf.createEntityManager();
    return em.find(Aplicacao.class, id);
  }
}
