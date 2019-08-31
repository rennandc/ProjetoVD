/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroHelpDesk.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sala302b
 */
@Entity
public class Chamado implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")    
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuarioAbertura;
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario tecnicoResponsavel;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataAbertura", nullable = false)
    private Date dataAbertura;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "limiteAtendimento", nullable = false)
    private Date limiteAtendimento;
    private String decricao;
    private Status status;
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoChamado tipoChamado;
    @ManyToOne(fetch = FetchType.EAGER)
    private Equipamento equipamento;
    private String solucao;

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public Usuario getUsuarioAbertura() {
        return usuarioAbertura;
    }

    public void setUsuarioAbertura(Usuario usuarioAbertura) {
        this.usuarioAbertura = usuarioAbertura;
    }

    public Usuario getTecnicoResponsavel() {
        return tecnicoResponsavel;
    }

    public void setTecnicoResponsavel(Usuario tecnicoResponsavel) {
        this.tecnicoResponsavel = tecnicoResponsavel;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getLimiteAtendimento() {
        return limiteAtendimento;
    }

    public void setLimiteAtendimento(Date limiteAtendimento) {
        this.limiteAtendimento = limiteAtendimento;
    }

    public String getDecricao() {
        return decricao;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TipoChamado getTipoChamado() {
        return tipoChamado;
    }

    public void setTipoChamado(TipoChamado tipoChamado) {
        this.tipoChamado = tipoChamado;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.usuarioAbertura);
        hash = 67 * hash + Objects.hashCode(this.tecnicoResponsavel);
        hash = 67 * hash + Objects.hashCode(this.dataAbertura);
        hash = 67 * hash + Objects.hashCode(this.limiteAtendimento);
        hash = 67 * hash + Objects.hashCode(this.decricao);
        hash = 67 * hash + Objects.hashCode(this.status);
        hash = 67 * hash + Objects.hashCode(this.tipoChamado);
        hash = 67 * hash + Objects.hashCode(this.equipamento);
        hash = 67 * hash + Objects.hashCode(this.solucao);
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
        final Chamado other = (Chamado) obj;
        if (!Objects.equals(this.decricao, other.decricao)) {
            return false;
        }
        if (!Objects.equals(this.solucao, other.solucao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.usuarioAbertura, other.usuarioAbertura)) {
            return false;
        }
        if (!Objects.equals(this.tecnicoResponsavel, other.tecnicoResponsavel)) {
            return false;
        }
        if (!Objects.equals(this.dataAbertura, other.dataAbertura)) {
            return false;
        }
        if (!Objects.equals(this.limiteAtendimento, other.limiteAtendimento)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.tipoChamado, other.tipoChamado)) {
            return false;
        }
        if (!Objects.equals(this.equipamento, other.equipamento)) {
            return false;
        }
        return true;
    }

 
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
   
}
