/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ricardo
 */

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @NotNull(message = "O nome deve ser informado")
    @NotBlank(message = "O nome não pode ser em branco")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Length(max = 100, message = "O endereço não pode ter mais que {max} caracteres")
    @NotNull(message = "O endereço deve ser informado")
    @NotBlank(message = "O endereço não pode ser em branco")
    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;
    
    @Email(message = "O email deve ser válido")
    @Length(max = 50, message = "O email não pode ter mais que {max} caracteres")
    @NotNull(message = "O email deve ser informado")
    @NotBlank(message = "O email não pode ser em branco")
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    
    @Length(max = 14, message = "O CPF não pode ter mais que {max} caracteres")
    @NotNull(message = "O CPF deve ser informado")
    @NotBlank(message = "O CPF não pode ser em branco")
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;
    
   @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Telefone> telefones = new ArrayList<>();
    
    public Pessoa(){
        
    }
    
    public void adicionarTelefone(Telefone obj){
        obj.setPessoa(this);
        this.telefones.add(obj);
    }
    
    public void removerTelefone (int index){
        this.telefones.remove(index);
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }


    
    
    
}
