package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
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
@Table(name = "reclamacao")
public class Reclamacao implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_reclamacao", sequenceName = "seq_reclamacao_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_reclamacao", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Length(max = 50, message = "A descriçao não pode ter mais que {max} caracteres")
    @NotNull(message = "A descriçao deve ser informada")
    @NotBlank(message = "A descriçao não pode ser em branco")
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;
    

    public Reclamacao() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
        @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamacao other = (Reclamacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


}
