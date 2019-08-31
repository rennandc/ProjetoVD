/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroHelpDesk.bean;

import cadastroHelpDesk.dao.LocalDao;
import cadastroHelpDesk.dao.UsuarioDao;
import cadastroHelpDesk.modelo.Local;
import cadastroHelpDesk.modelo.Perfil;
import cadastroHelpDesk.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sala302b
 */
@Named(value = "usuarioMB")
@SessionScoped
public class UsuarioMB extends AppMB implements Serializable {

    private Usuario usuario = new Usuario();

    private List<Usuario> listaUsuario;

    private Perfil[] perfil;

    private List<Local> listaLocal;

    private Boolean addNovo = false;

    public List<Usuario> getListaUsuario() {
        UsuarioDao dao = new UsuarioDao();
        return dao.buscarTodos();
    }

    public void setListaUsuarios(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public String editar(Usuario usuario) {
        this.usuario = usuario;
        return "editar?faces-redicect=true";
    }

    public String excluir(Usuario usuario) {
        UsuarioDao dao = new UsuarioDao();
        dao.excluir(usuario);
               return "listar";
    }

    public String salvar() {
        UsuarioDao dao = new UsuarioDao();
        dao.inserir(usuario);
        return "listar";
    }

    public String novo() {
        this.usuario = new Usuario();
        return "editar?faces-redicect=true";
    }

    public UsuarioMB() {

    }

    public Usuario getUsuarios() {
        return usuario;
    }

    public void setUsuarios(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean getAddNovo() {
        return addNovo;
    }

    public void setAddNovo(Boolean addNovo) {
        this.addNovo = addNovo;
    }

    public String gravar() {
        UsuarioDao dao = new UsuarioDao();
        if (usuario.getId() != null && usuario.getId() > 0) {
            dao.atualizar(usuario);
        } else {
            dao.inserir(usuario);
        }
        return "listar?faces-redicect=true";
    }

    public Perfil[] getPerfil() {
        return Perfil.values();
    }

    public void setPerfil(Perfil[] perfil) {
        this.perfil = perfil;
    }

    public List<Local> getListaLocal() {
        LocalDao localDao = new LocalDao();
        return localDao.buscarTodos();
    }

    public void setListaLocal(List<Local> listaLocal) {
        this.listaLocal = listaLocal;
    }

}
