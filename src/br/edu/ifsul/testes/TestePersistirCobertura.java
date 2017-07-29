package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cobertura;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Seguro;
import javax.persistence.EntityManager;

/**
 *
 * @author crisley
 */
public class TestePersistirCobertura {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Cobertura c = new Cobertura();
        Seguro se = em.find(Seguro.class, 1);
        
        c.setDescricao("cobertura descrição");
        c.setSeguro(se);
        c.setValor(900.0);
        
        se.adicionarCobertura(c);
        
        em.getTransaction().begin();
        em.persist(se);
        em.getTransaction().commit();
        
        
    }
    
}
