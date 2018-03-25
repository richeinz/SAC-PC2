
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Setor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo
 */
public class TestePersistirSetor {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirSetor() {
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
             Setor s = new Setor();
             s.setDescricao("Trafego");
                               
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        //vou verificar se o resultado é o esperado
        Assert.assertEquals(false, exception);
    }

}
