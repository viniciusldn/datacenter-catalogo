import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.trybe.acc.java.datacenter.entity.Aplicacao;

public class AplicacaoService implements ServiceInterface<Aplicacao, Long> {

  public void save(Aplicacao app) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(app);
    em.getTransaction().commit();
    em.close();
  }

  public void update(Aplicacao app) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(app);
    em.getTransaction().commit();
    em.close();
  }

  public void delete(Long id) {
    EntityManager em = emf.createEntityManager();

    Aplicacao app = em.find(Aplicacao.class, id);

    em.getTransaction().begin();
    em.remove(app);
    em.getTransaction().commit();
    em.close();
  }

  public List<Aplicacao> list() {
    EntityManager em = emf.createEntityManager();

    TypedQuery<Aplicacao> query = em.createQuery("from Aplicacao", Aplicacao.class);
    List<Aplicacao> lstApp = query.getResultList();
    return lstApp;
  }

  public Aplicacao findById(Long id) {
    EntityManager em = emf.createEntityManager();
    return em.find(Aplicacao.class, id);
  }
}
