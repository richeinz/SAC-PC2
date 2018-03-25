/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Onibus;
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
public class TestePersistirOnibus {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirOnibus() {
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
             Onibus o = new Onibus();
             o.setPrefixo("200");
                               
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        //vou verificar se o resultado é o esperado
        Assert.assertEquals(false, exception);
    }

}
