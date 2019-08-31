/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroHelpDesk.bean;

import cadastroHelpDesk.dao.EquipamentoDAO;
import cadastroHelpDesk.dao.FabricanteDao;
import cadastroHelpDesk.dao.LocalDao;
import cadastroHelpDesk.dao.ModeloDao;
import cadastroHelpDesk.dao.TipoEquipamentoDao;
import cadastroHelpDesk.modelo.Equipamento;
import cadastroHelpDesk.modelo.Fabricante;
import cadastroHelpDesk.modelo.Local;
import cadastroHelpDesk.modelo.Modelo;
import cadastroHelpDesk.modelo.TipoEquipamento;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sala302b
 */
@Named(value = "equipametoMB")
@SessionScoped
public class EquipamentoMB extends AppMB implements Serializable {
    private Equipamento equipamento = new Equipamento();
    

 
    private List<Equipamento> listaEquipamento;
    private Boolean addNovo = false;
    private List<TipoEquipamento> listaTipoEquipamento;
    private List<Modelo> listaModelo;
    private List<Fabricante> listaFabricante;
    private List<Local> listaLocal;

  public EquipamentoMB(){
  equipamento = new Equipamento();
  }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
    
    
    


    
    
    
    public String excluir(Equipamento equipamento) {
        EquipamentoDAO dao = new EquipamentoDAO();
        dao.excluir(equipamento);
        return null;
    }
    
   public String gravar(){
       EquipamentoDAO dao = new EquipamentoDAO();
       if(equipamento.getId()!= null && equipamento.getId()>0){
       dao.atualizar(equipamento);
       }else{
       dao.inserir(equipamento);
       }
       return "listar";
    }
    public String editar(Equipamento equipamento){
        this.equipamento = equipamento;
        return "editar";
    }
 
    public String novoEquipamento() {
        this.equipamento = new Equipamento();
        return "editar";
    }
    
    
    
    
    
    

    public Boolean getAddNovo() {
        return addNovo;
    }

    public void setAddNovo(Boolean addNovo) {
        this.addNovo = addNovo;
    }

    public List<TipoEquipamento> getListaTipoEquipamento() {
        TipoEquipamentoDao dao = new TipoEquipamentoDao();
        return dao.buscarTodos();
    }

    public void setListaTipoEquipamento(List<TipoEquipamento> listaTipoEquipamento) {
        this.listaTipoEquipamento = listaTipoEquipamento;
    }

    public List<Modelo> getListaModelo() {
        ModeloDao dao = new ModeloDao();
        return dao.buscarTodos();
    }

    public void setListaModelo(List<Modelo> listaModelo) {
        this.listaModelo = listaModelo;
    }

    public List<Fabricante> getListaFabricante() {
        FabricanteDao dao = new FabricanteDao();
        return dao.buscarTodos();
    }

    public void setListaFabricante(List<Fabricante> listaFabricante) {
        this.listaFabricante = listaFabricante;
    }

    public List<Equipamento> getListaEquipamento() {
        EquipamentoDAO dao = new EquipamentoDAO();
        return dao.buscarTodos();
    }

    public void setListaEquipamento(List<Equipamento> listaEquipamento) {
        this.listaEquipamento = listaEquipamento;
    }

    public List<Local> getListaLocal() {
        LocalDao dao = new LocalDao();
        return dao.buscarTodos();
    }

    public void setListaLocal(List<Local> listaLocal) {
        this.listaLocal = listaLocal;
    }

  

}
