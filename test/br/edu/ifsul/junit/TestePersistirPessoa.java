package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Pessoa;
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
public class TestePersistirPessoa {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPessoa() {
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
            Pessoa p = new Pessoa();
            p.setCpf("540.762.180-00");
            p.setEmail("ricardo.heinz@hotmail.com");
            p.setEndereco("Rua Dr. Loureiro da Silva, 186 - São Cristóvão - Passo Fundo - RS");
            p.setNome("Ricardo Heinz");
            p.setTelefone("(54)999876543");
                    
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        //vou verificar se o resultado é o esperado
        Assert.assertEquals(false, exception);
    }
}
