package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;

/**
 *
 * @author crisley
 */
public class TestePersistirPessoa {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Pessoa p = new Pessoa();
        
        p.setCpf("407.890.488-25");
        p.setEmail("crisley@hotmail.com");
        p.setNome("Crisley Alves");
        p.setRg("437198807");
        p.setTelefone("(43) 2321-1232");
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
        
    }
    
}
