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
public class TestePersistirSeguro {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Seguro s = new Seguro();
        
        s.setCarro(em.find(Carro.class, 2));
        s.setCorretor(em.find(Corretor.class, 2));
        s.setData(Calendar.getInstance());
        s.setFimVigencia(Calendar.getInstance());
        s.setInicioVigencia(Calendar.getInstance());
        s.setValorFipe(900.3);
        s.setValorTotal(3000.0);
        
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        
        
    }
    
}
