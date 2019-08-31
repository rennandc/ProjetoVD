/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroHelpDesk.bean;

import cadastroHelpDesk.dao.LocalDao;
import cadastroHelpDesk.modelo.Local;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sala302b
 */
@Named(value = "localMB")//nome que será visto na tela
@SessionScoped
public class LocalMB extends AppMB implements Serializable {

    //Objeto local que será preenchido na tela
    private Local local = new Local();

    private List<Local> listaLocal;

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    //construtor do Manegedbean
    public LocalMB() {
        //estanciando o objeto local
        local = new Local();
    }

    public String gravar() {
        LocalDao dao = new LocalDao();
        if (local.getId() != null && local.getId() > 0) {
            dao.atualizar(local);
        } else {
            dao.inserir(local);
        }
        return "listar";
    }

    public List<Local> getListaLocal() {
        LocalDao dao = new LocalDao();
        return dao.buscarTodos();
    }

    public void setListaLocal(List<Local> listaLocal) {
        this.listaLocal = listaLocal;
    }

    public String editar(Local local) {
        this.local = local;
        return "editar";
    }

    public String excluir(Local local) {
        LocalDao dao = new LocalDao();
        dao.excluir(local);
        return null;
    }

    public String novoLocal() {
        this.local = new Local();
        return "editar";
    }

}
