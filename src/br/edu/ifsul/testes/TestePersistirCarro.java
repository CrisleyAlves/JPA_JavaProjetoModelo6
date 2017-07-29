package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Cobertura;
import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;

/**
 *
 * @author crisley
 */
public class TestePersistirCarro {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Carro c = new Carro();
        
        c.setAnoFabricao(2007);
        c.setAnoModelo(2006);
        c.setFabricante("Fabricante");
        c.setModelo("Modelo");
        c.setPessoa(em.find(Pessoa.class, 2));
        c.setPlaca("placa");
        c.setRenavam("renavam");
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        
        
    }
    
}
