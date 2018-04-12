
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Chamado;
import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Linha;
import br.edu.ifsul.modelo.Onibus;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
import java.util.TimeZone;
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
public class TestePersistirChamado {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirChamado() {
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
          
            Chamado c = new Chamado();
            c.setData_hora_recebimento(Calendar.getInstance());
            c.setData_ocorrencia(Calendar.getInstance());
            c.setHora_ocorrencia(Calendar.getInstance(TimeZone.getDefault()));
            c.setDescricao("Onibus não parou, mesmo eu acenando com a mão. O cobrador fez sinal com os braços para o motorista e mesmo assim ele não parou.");
            c.setLocal("Comercial");
            c.setRetorno(1);
            c.setSentido("Ptrópolis - Boqueirão");
            c.setStatus(1);
            c.setTipo(1);
            c.setLinha(em.find(Linha.class, 1));
            c.setOnibus(em.find(Onibus.class, 2));
            c.setUsuario(em.find(Usuario.class, 7));
                    
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        //vou verificar se o resultado é o esperado
        Assert.assertEquals(false, exception);
    }
    
}
