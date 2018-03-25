
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Setor;
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
public class TestePersistirFuncionario {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirFuncionario() {
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
          
            Funcionario f = new Funcionario();
            f.setCpf("542.230.789-00");
            f.setEmail("funcionario1@gmail.com");
            f.setEndereco("Rua Funcionario1, 1 - Bairro centro - Carazinho - RS");
            f.setNome("Funcionario1");
            f.setTelefone("(54)33145678");
            f.setCargo("motorista");
            f.setNomeUsuario("funcionario1.funcionario");
            f.setSenha("123456");
            f.setSetor(em.find(Setor.class, 1));
                    
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        //vou verificar se o resultado é o esperado
        Assert.assertEquals(false, exception);
    }
    
}
