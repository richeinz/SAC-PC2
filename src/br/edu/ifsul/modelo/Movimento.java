package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "movimento")
public class Movimento implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_chamado", sequenceName = "seq_chamado_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_chamado", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora")
    private Calendar data_hora;
    
    @NotNull(message = "A informação deve ser preenchida")
    @NotBlank(message = "A informação não pode ser em branco")
    @Column(name = "informação", nullable = false, columnDefinition = "text")
    private String informação;
     
    @ManyToOne
    @JoinColumn(name = "funcionario", referencedColumnName = "id")
    @ForeignKey(name = "fK_funcionario_id")
    private Funcionario funcionario;
    
    @ManyToOne
    @JoinColumn(name = "chamado_id", referencedColumnName = "id", nullable = false)
    private Chamado chamado;

    public Movimento() {
        this.data_hora = Calendar.getInstance();
        //incluir fincionário através da seção
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData_hora() {
        return data_hora;
    }

    public void setData_hora(Calendar data_hora) {
        this.data_hora = data_hora;
    }

    public String getInformação() {
        return informação;
    }

    public void setInformação(String informação) {
        this.informação = informação;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Movimento other = (Movimento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
