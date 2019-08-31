/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroHelpDesk.bean;



import cadastroHelpDesk.dao.TipoChamadoDAO;
import cadastroHelpDesk.modelo.TipoChamado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sala302b
 */
@Named(value = "tipoChamadoMB")
@SessionScoped
public class TipoChamadoMB extends AppMB implements Serializable{
    private List<TipoChamado> listaTipoChamado;
    private Boolean addNovo = false;

    public List<TipoChamado> getListaTipoChamado() {
        TipoChamadoDAO dao = new TipoChamadoDAO();
        if (listaTipoChamado == null) {
            listaTipoChamado = dao.buscarTodos();
        }
        if (listaTipoChamado == null) {
            listaTipoChamado = new ArrayList<>();
        }
        if (listaTipoChamado.isEmpty() || addNovo) {
            listaTipoChamado.add(new TipoChamado());
            addNovo = false;
        }
        return listaTipoChamado;

    }
    public void setListaEquipamento(List<TipoChamado> listaTipoChamado) {
        this.listaTipoChamado = listaTipoChamado;
    }
    
    public String excluir(TipoChamado tipoChamado) {
        TipoChamadoDAO dao = new TipoChamadoDAO();
        dao.excluir(tipoChamado);
        listaTipoChamado.remove(tipoChamado);
        return null;
        
    }

    public String salvar() {
        TipoChamadoDAO dao = new TipoChamadoDAO();
        dao.salvarLista(this.listaTipoChamado);
        return null;
    }

    public String novo() {
        addNovo = true;
        return null;
    }
    
    }

    
    

