package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Chamado;
import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Movimento;
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
             m.setFuncionario(em.find(Funcionario.class, 13));
             m.setInformação("Identificado os funcionários envolvidos: Motorista Fulano, Cobrador Ciclano");
             
                               
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        //vou verificar se o resultado é o esperado
        Assert.assertEquals(false, exception);
    }

}
