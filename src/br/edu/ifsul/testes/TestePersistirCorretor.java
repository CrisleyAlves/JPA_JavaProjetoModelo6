package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;

/**
 *
 * @author crisley
 */
public class TestePersistirCorretor {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Corretor c = new Corretor();
        
        c.setCpf("407.890.488-25");
        c.setEmail("crisley@hotmail.com");
        c.setNome("Crisley Alves");
        c.setRg("437198807");
        c.setTelefone("(43) 2321-1232");
        c.setNomeUsuario("Nome do usuário");
        c.setPassword("senha");
        c.setPercentualComissao(3.2);
        
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        
        
    }
    
}
