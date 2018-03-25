/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Usuario;
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
public class TestePersistirUsuario {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirUsuario() {
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
          
            Usuario u = new Usuario();
            u.setCpf("542.230.789-00");
            u.setEmail("usuario1@gmail.com");
            u.setEndereco("Rua usuario1, 1 - Bairro centro - Carazinho - RS");
            u.setNome("Usuario1");
            u.setTelefone("(54)33145678");
                    
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        //vou verificar se o resultado é o esperado
        Assert.assertEquals(false, exception);
    }
    
}
