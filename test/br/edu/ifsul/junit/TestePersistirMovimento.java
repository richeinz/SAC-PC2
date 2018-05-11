package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Chamado;
import br.edu.ifsul.modelo.Movimento;
import br.edu.ifsul.modelo.Pessoa;
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
public class TestePersistirMovimento {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirMovimento() {
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
             Movimento m = new Movimento();
             m.setChamado(em.find(Chamado.class, 19));
             m.setpessoa(em.find(Pessoa.class, 13));
             m.setInformacao("Realizado abertura de chamado");
             
             Movimento m1 = new Movimento();
             m1.setChamado(em.find(Chamado.class, 25));
             m1.setpessoa(em.find(Pessoa.class, 14));
             m1.setInformacao("Realizado abertura de chamado");
             
                               
            em.getTransaction().begin();
            em.persist(m);
            em.persist(m1);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        //vou verificar se o resultado é o esperado
        Assert.assertEquals(false, exception);
    }

}
