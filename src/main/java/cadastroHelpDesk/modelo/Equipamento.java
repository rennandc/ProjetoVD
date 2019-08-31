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
public class Equipamento implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;
    private String numeroPratrimonio; 
    @Temporal(TemporalType.DATE)
    @Column(name = "dtFimGarantia", nullable=false)
    private Date dtFimGarantia;
    private Boolean ativo;
    private String dadosComplementares;
    private String observacao;
    @ManyToOne(fetch = FetchType.EAGER)
    private Local localInstalacao;
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoEquipamento tipoEquipamento;
    @ManyToOne(fetch = FetchType.EAGER)
    private Modelo modelo;
    @ManyToOne(fetch = FetchType.EAGER)
    private Fabricante fabricante;

    public String getNumeroPratrimonio() {
        return numeroPratrimonio;
    }

    public void setNumeroPratrimonio(String numeroPratrimonio) {
        this.numeroPratrimonio = numeroPratrimonio;
    }

    public Date getDtFimGarantia() {
        return dtFimGarantia;
    }

    public void setDtFimGarantia(Date dtFimGarantia) {
        this.dtFimGarantia = dtFimGarantia;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getDadosComplementares() {
        return dadosComplementares;
    }

    public void setDadosComplementares(String dadosComplementares) {
        this.dadosComplementares = dadosComplementares;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Local getLocalInstalacao() {
        return localInstalacao;
    }

    public void setLocalInstalacao(Local localInstalacao) {
        this.localInstalacao = localInstalacao;
    }

    public TipoEquipamento getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.numeroPratrimonio);
        hash = 59 * hash + Objects.hashCode(this.dtFimGarantia);
        hash = 59 * hash + Objects.hashCode(this.ativo);
        hash = 59 * hash + Objects.hashCode(this.dadosComplementares);
        hash = 59 * hash + Objects.hashCode(this.observacao);
        hash = 59 * hash + Objects.hashCode(this.localInstalacao);
        hash = 59 * hash + Objects.hashCode(this.tipoEquipamento);
        hash = 59 * hash + Objects.hashCode(this.modelo);
        hash = 59 * hash + Objects.hashCode(this.fabricante);
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
        final Equipamento other = (Equipamento) obj;
        if (!Objects.equals(this.numeroPratrimonio, other.numeroPratrimonio)) {
            return false;
        }
        if (!Objects.equals(this.dadosComplementares, other.dadosComplementares)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dtFimGarantia, other.dtFimGarantia)) {
            return false;
        }
        if (!Objects.equals(this.ativo, other.ativo)) {
            return false;
        }
        if (!Objects.equals(this.localInstalacao, other.localInstalacao)) {
            return false;
        }
        if (!Objects.equals(this.tipoEquipamento, other.tipoEquipamento)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.fabricante, other.fabricante)) {
            return false;
        }
        return true;
    }

   
    
    
}
