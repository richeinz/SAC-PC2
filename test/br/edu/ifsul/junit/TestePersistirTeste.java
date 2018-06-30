/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Chamado;
import br.edu.ifsul.modelo.Linha;
import br.edu.ifsul.modelo.Movimento;
import java.util.List;
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
public class TestePersistirTeste {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirTeste() {
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
        List<Movimento> lista = em.createQuery("from Movimento order by id").getResultList();
//        for(Chamado c : lista){
//            System.out.println(c.getId());
//        }
    }

}
