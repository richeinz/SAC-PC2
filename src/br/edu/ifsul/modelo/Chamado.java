package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "chamado")
public class Chamado implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_chamado", sequenceName = "seq_chamado_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_chamado", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora_recebimento")
    private Calendar data_hora_recebimento;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_ocorrencia")
    private Calendar data_ocorrencia;

    @Column(name = "hora_ocorrencia", columnDefinition = "time")
    private Calendar hora_ocorrencia;

    @Column(name = "retorno")
    private Integer retorno;//2 => sem retorno   1 => com retono

    @Column(name = "local", length = 50)
    private String local;

    @Column(name = "sentido")
    private String sentido;

    @NotNull(message = "A descrição deve ser informada")
    @NotBlank(message = "A descrição não pode ser em branco")
    @Column(name = "descricao", nullable = false, columnDefinition = "text")
    private String descricao;

    @Column(name = "status")
    private Integer status;//1-aberto 2-setor 3-funcionario 4-fechado

    @Column(name = "tipo")
    private Integer tipo;//1-reclamação 2-elogio 3-sugestão 4-denuncia

    @ManyToOne
    @JoinColumn(name = "reclamacao", referencedColumnName = "id")
    @ForeignKey(name = "fk_reclamacao_id")
    private Reclamacao reclamacao;

    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ForeignKey(name = "fK_usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "linha", referencedColumnName = "id")
    @ForeignKey(name = "fk_linha_id")
    private Linha linha;

    @ManyToOne
    @JoinColumn(name = "onibus", referencedColumnName = "id")
    @ForeignKey(name = "fk_onibus_id")
    private Onibus onibus;

    @ManyToOne
    @JoinColumn(name = "motorista", referencedColumnName = "id")
    @ForeignKey(name = "fk_funcionario_id")
    private Funcionario motorista;

    @ManyToOne
    @JoinColumn(name = "cobrador", referencedColumnName = "id")
    @ForeignKey(name = "fk_funcionario_id")
    private Funcionario cobrador;

    @OneToMany(mappedBy = "chamado", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Movimento> movimentos = new ArrayList<>();
    
    

    public Chamado() {
        this.data_hora_recebimento = Calendar.getInstance();
        this.status = 1;
    }

    public void adicionarMovimento(Movimento obj) {
        obj.setChamado(this);
        this.movimentos.add(obj);
        System.out.println(obj);
    }

//Getters e Setter
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData_hora_recebimento() {
        return data_hora_recebimento;
    }

    public void setData_hora_recebimento(Calendar data_hora_recebimento) {
        this.data_hora_recebimento = Calendar.getInstance();
    }

    public Calendar getData_ocorrencia() {
        return data_ocorrencia;
    }

    public void setData_ocorrencia(Calendar data_ocorrencia) {
        this.data_ocorrencia = data_ocorrencia;
    }

    public Calendar getHora_ocorrencia() {
        return hora_ocorrencia;
    }

    public void setHora_ocorrencia(Calendar hora_ocorrencia) {
        this.hora_ocorrencia = hora_ocorrencia;
    }

    public Integer getRetorno() {
        return retorno;
    }

    public void setRetorno(Integer retorno) {
        this.retorno = retorno;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getSentido() {
        return sentido;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Linha getLinha() {
        return linha;
    }

    public void setLinha(Linha linha) {
        this.linha = linha;
    }

    public Onibus getOnibus() {
        return onibus;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }

    public Reclamacao getReclamacao() {
        return reclamacao;
    }

    public void setReclamacao(Reclamacao reclamacao) {
        this.reclamacao = reclamacao;
    }

    public List<Movimento> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(List<Movimento> movimentos) {
        this.movimentos = movimentos;
    }

    public Funcionario getMotorista() {
        return motorista;
    }

    public void setMotorista(Funcionario motorista) {
        this.motorista = motorista;
    }

    public Funcionario getCobrador() {
        return cobrador;
    }

    public void setCobrador(Funcionario cobrador) {
        this.cobrador = cobrador;
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
        final Chamado other = (Chamado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
