/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroHelpDesk.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author sala302b
 */
    @Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id") //informa como deve ser chamado o campo na tabela
    private Long id; //ID DA PESSOA
    
    private String nome;
    @Column(name = "cpf", unique = true, //manda criar uma chave exclusiva
                          nullable=false) //informa que não deve aceitar nulo no campo
    private String cpf;
 
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    private String telefone;
    
    @Enumerated(EnumType.STRING)
    private Perfil Perfil;
    
    @ManyToOne(fetch = FetchType.EAGER)//informa como deve ser recuperado a entidade (atributo)
    private Local setortrabalho;
    
    

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

  

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Perfil getPerfil() {
        return Perfil;
    }

    public void setPerfil(Perfil Perfil) {
        this.Perfil = Perfil;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.nome);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Local getSetortrabalho() {
        return setortrabalho;
    }

    public void setSetortrabalho(Local setortrabalho) {
        this.setortrabalho = setortrabalho;
    }
    
    
    
}
