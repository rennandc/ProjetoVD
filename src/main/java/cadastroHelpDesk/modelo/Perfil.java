/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroHelpDesk.modelo;

/**
 *
 * @author sala302b
 */
public enum Perfil {
    USU("Usuario"),  
    TEC("Tecnico"),
    ADM("Administrador");
  
    private String valor;  
      
    private Perfil(String valor) {  
        this.valor = valor;  
    }  
 public String toString() {
        return valor;
}
 private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}