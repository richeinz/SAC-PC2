
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ricardo
 */

@Entity
@Table(name = "funcionario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario extends Pessoa implements Serializable{
    
    @Length(max = 30, message = "O nomeUsuario não pode ter mais que {max} caracteres")
    @NotNull(message = "O nomeUsuario deve ser informado")
    @NotBlank(message = "O nomeUsuario não pode ser em branco")
    @Column(name = "nomeUsuario", length = 30, nullable = false)
    private String nomeUsuario;
    
    @Length(max = 10, message = "A senha não pode ter mais que {max} caracteres")
    @NotNull(message = "A senha deve ser informado")
    @NotBlank(message = "A senha não pode ser em branco")
    @Column(name = "senha", length = 50, nullable = false)
    private String senha;
    
    @Length(max = 30, message = "O cargo não pode ter mais que {max} caracteres")
    @NotNull(message = "O cargo deve ser informado")
    @NotBlank(message = "O cargo não pode ser em branco")
    @Column(name = "cargo", length = 30, nullable = false)
    private String cargo;
    
    @ManyToOne
    @NotNull(message = "O setor deve ser informado")
    @JoinColumn(name = "setor", referencedColumnName = "id",  nullable = false)
    @ForeignKey(name = "fK_setor_id")
    private Setor setor;
    
    public Funcionario(){
        
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
    
    
    
}
