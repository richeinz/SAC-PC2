
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Reclamacao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Ricardo
 */
public class TestePersistirReclamacao {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirReclamacao() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("SAC-PC2");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void testar(){
        boolean exception = false;
        try {
            Reclamacao r = new Reclamacao();
            r.setDescricao("O motorista não parou na parada");
            
                               
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        //vou verificar se o resultado é o esperado
        Assert.assertEquals(false, exception);
    }

}
