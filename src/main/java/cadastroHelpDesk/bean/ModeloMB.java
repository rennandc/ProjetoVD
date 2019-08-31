/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroHelpDesk.bean;

import cadastroHelpDesk.dao.FabricanteDao;
import cadastroHelpDesk.dao.ModeloDao;
import cadastroHelpDesk.modelo.Fabricante;
import cadastroHelpDesk.modelo.Modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sala302b
 */
@Named(value = "modeloMB")
@SessionScoped
public class ModeloMB extends AppMB implements Serializable {

    private List<Modelo> listaModelo;
    private List<Fabricante> listaFabricante;
    private Boolean addNovo = false;

    public List<Modelo> getListaModelo() {
        ModeloDao dao = new ModeloDao();
        if (listaModelo == null) {
            listaModelo = dao.buscarTodos();
        }
        if (listaModelo == null) {
            listaModelo = new ArrayList<>();
        }
        if (listaModelo.isEmpty() || addNovo) {
            listaModelo.add(new Modelo());
            addNovo = false;
        }
        return listaModelo;

    }

    public void setListaModelo(List<Modelo> listaModelo) {
        this.listaModelo = listaModelo;
    }

    public String excluir(Modelo modelo) {
        ModeloDao dao = new ModeloDao();
        dao.excluir(modelo);
        listaModelo.remove(modelo);
        return null;
    }

    public String salvar() {
        ModeloDao dao = new ModeloDao();
        dao.salvarLista(listaModelo);
        return null;
    }

    public String novo() {
        addNovo = true;
        return null;
    }

    public ModeloMB() {

    }


    public Boolean getAddNovo() {
        return addNovo;
    }

    public void setAddNovo(Boolean addNovo) {
        this.addNovo = addNovo;
    }

    public List<Fabricante> getListaFabricante() {
        FabricanteDao fabricanteDao = new FabricanteDao();
        return fabricanteDao.buscarTodos();
    }

    public void setListaFabricante(List<Fabricante> listaFabricante) {
        this.listaFabricante = listaFabricante;
    }

}
