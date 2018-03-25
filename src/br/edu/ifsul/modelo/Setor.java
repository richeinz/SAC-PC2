package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "setor")
public class Setor implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_setor", sequenceName = "seq_setor_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_setor", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Length(max = 50, message = "A descriçao não pode ter mais que {max} caracteres")
    @NotNull(message = "A descriçao deve ser informada")
    @NotBlank(message = "A descriçao não pode ser em branco")
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;
    
    @ManyToMany
    @JoinTable(name = "lista_funcionario",
            joinColumns = @JoinColumn(name = "setor", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "funcionario", referencedColumnName = "id", nullable = false))
    private List<Funcionario> listaFuncionario = new ArrayList<>();

    public Setor() {

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


    public List<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
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
        final Setor other = (Setor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


}
