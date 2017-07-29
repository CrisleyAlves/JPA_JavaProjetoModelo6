package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Cobertura;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Seguro;
import br.ifsul.edu.modelo.Sinistro;
import java.util.Calendar;
import javax.persistence.EntityManager;

/**
 *
 * @author crisley
 */
public class TestePersistirSinistro {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Sinistro s = new Sinistro();
        Seguro se = em.find(Seguro.class, 1);
        
        s.setCidade("Marau");
        s.setData(Calendar.getInstance());
        s.setEstado("Rio Grande do Sul");
        s.setNome("Nome Sinistro");
        s.setSeguro(se);
        
        se.adicionarSinistro(s);
        
        em.getTransaction().begin();
        em.persist(se);
        em.getTransaction().commit();
        
        
    }
    
}
