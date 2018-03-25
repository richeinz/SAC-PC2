
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ricardo
 */

@Entity
@Table(name = "linha")
public class Linha implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_linha", sequenceName = "seq_linha_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_linha", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @NotNull(message = "O nome deve ser informado")
    @NotBlank(message = "O nome não pode ser em branco")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Length(max = 5, message = "O prefixo não pode ter mais que {max} caracteres")
    @NotNull(message = "O prefixo deve ser informado")
    @Column(name = "prefixo", length = 5, nullable = false)
    private String prefixo;
    
    public Linha(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }
    
    
    
}
