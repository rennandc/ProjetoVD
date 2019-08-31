/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroHelpDesk.bean;


import cadastroHelpDesk.dao.TipoEquipamentoDao;
import cadastroHelpDesk.modelo.TipoEquipamento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sala302b
 */
@Named(value = "tipoEquipamentoMB")
@SessionScoped
public class TipoEquipamentoMB extends AppMB implements Serializable{
    private List<TipoEquipamento> listaTipoEquipamento;
    private Boolean addNovo = false;

    public List<TipoEquipamento> getListaTipoEquipamento() {
        TipoEquipamentoDao dao = new TipoEquipamentoDao();
        if (listaTipoEquipamento == null) {
            listaTipoEquipamento = dao.buscarTodos();
        }
        if (listaTipoEquipamento == null) {
            listaTipoEquipamento = new ArrayList<>();
        }
        if (listaTipoEquipamento.isEmpty() || addNovo) {
            listaTipoEquipamento.add(new TipoEquipamento());
            addNovo = false;
        }
        return listaTipoEquipamento;

    }
    public void setListaEquipamento(List<TipoEquipamento> listaTipoEquipamento) {
        this.listaTipoEquipamento = listaTipoEquipamento;
    }
    
    public String excluir(TipoEquipamento tipoEquipamento) {
        TipoEquipamentoDao dao = new TipoEquipamentoDao();
        dao.excluir(tipoEquipamento);
        listaTipoEquipamento.remove(tipoEquipamento);
        return null;
    }

    public String salvar() {
        TipoEquipamentoDao dao = new TipoEquipamentoDao();
        dao.salvarLista(this.listaTipoEquipamento);
        return null;
    }

    public String novo() {
        addNovo = true;
        return null;
    }
    
    }

    
    

