
package br.edu.ifsul.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ricardo
 */
public class EntityManagerUtil {
    
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;
    
    public static EntityManager getEntityManager(){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory("SAC-PC2");
        }
        if(em == null){
            em = factory.createEntityManager();
        }
        return em;
    }
}
