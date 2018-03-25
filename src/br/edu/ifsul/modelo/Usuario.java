
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "usuario")
public class Usuario extends Pessoa implements Serializable{
    
    public Usuario(){
        
    }
}
