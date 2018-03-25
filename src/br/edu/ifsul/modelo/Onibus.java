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

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "onibus")
public class Onibus implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_onibus", sequenceName = "seq_onibus_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_onibus", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Length(max = 10, message = "O prefixo não pode ter mais que {max} caracteres")
    @NotNull(message = "O prefixo deve ser informado")
    @Column(name = "prefixo", length = 10, nullable = false)
    private String prefixo;

    public Onibus() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Onibus other = (Onibus) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
