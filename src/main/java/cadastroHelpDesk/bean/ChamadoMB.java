/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroHelpDesk.bean;

import cadastroHelpDesk.dao.ChamadoDAO;
import cadastroHelpDesk.dao.EquipamentoDAO;
import cadastroHelpDesk.dao.TipoChamadoDAO;
import cadastroHelpDesk.dao.UsuarioDao;
import cadastroHelpDesk.modelo.Chamado;
import cadastroHelpDesk.modelo.Equipamento;
import cadastroHelpDesk.modelo.Status;
import cadastroHelpDesk.modelo.TipoChamado;
import cadastroHelpDesk.modelo.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author sala302b
 */
@Named(value = "chamadoMB")
@SessionScoped
public class ChamadoMB extends AppMB implements Serializable {

    private Chamado chamado = new Chamado();

    private List<TipoChamado> listaTipoChamado;
    private List<Equipamento> listaEquipamento;
    private List<Usuario> listaUsuario;
    private Status[] status;
    private List<Chamado> listaChamadoAberto;
    private List<Chamado> listaChamadoFechado;

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public String excluir(Chamado chamado) {
        ChamadoDAO dao = new ChamadoDAO();
        dao.excluir(chamado);
        return null;
    }

    public String gravar() {
        ChamadoDAO dao = new ChamadoDAO();
        if (chamado.getId() != null && chamado.getId() > 0) {
            dao.atualizar(chamado);
            addMessageInfo("chamdo atualizada com sucesso");
        } else {
            try {
                chamado.setUsuarioAbertura(getUsuarioLogado());

                chamado.setStatus(Status.ABERTO);

                chamado.setDataAbertura(new Date());
                chamado.setLimiteAtendimento(addHora(new Date(), chamado.getTipoChamado().getTempoAtendimento()));
                dao.inserir(chamado);
                addMessageInfo("Chamado inserido com sucesso!!");
                return "listar?faces-redirect=true";

            } catch (Exception e) {
                addMessageErro(e.getMessage());
                return null;
            }

        }
        return "listar?faces-redirect=true";
    }

    public String editar(Chamado chamado) {
        this.chamado = chamado;
        return "editar?faces-redirect=true";
    }

    public String atender(Chamado chamado) {
        this.chamado = chamado;

        //insere o técnico responsável quando o usuario clicar em atender
        this.chamado.setTecnicoResponsavel(getUsuarioLogado());

        //Coloca o status do chamado como em atendimento
        this.chamado.setStatus(Status.ATENDIMENTO);

        return "editar?faces-redirect=true";
    }

    public String solucao(Chamado chamado) {

        this.chamado = chamado;
        return "solucao?faces-redirect=true";
    }

    public String encerrar() {
        //Coloca o status do chamado como fechado
        chamado.setStatus(Status.FECHADO);

        //chama o gravar
        gravar();

        //envia email
        return "listar?faces-redirect=true";
    }

    public String novoChamado() {
        this.chamado = new Chamado();
        return "editar";
    }

    public List<TipoChamado> getListaTipoChamado() {
        TipoChamadoDAO dao = new TipoChamadoDAO();
        return dao.buscarTodos();
    }

    public void setListaTipoChamado(List<TipoChamado> listaTipoChamado) {
        this.listaTipoChamado = listaTipoChamado;
    }

    public List<Equipamento> getListaEquipamento() {
        EquipamentoDAO dao = new EquipamentoDAO();
        return dao.buscarTodos();
    }

    public void setListaEquipamento(List<Equipamento> listaEquipamento) {
        this.listaEquipamento = listaEquipamento;
    }

    public Date addHora(Date data, int horasAdicionais) {
        int umaHora = 60 * 60 * 1000; //1h = 60min * 60seg * 1000miliseg
        data.setTime(data.getTime() + horasAdicionais * umaHora);
        return data;
    }

    public List<Usuario> getListaUsuario() {
        UsuarioDao dao = new UsuarioDao();
        return dao.buscarTodos();
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public Status[] getStatus() {

        return Status.values();
    }

    public void setStatus(Status[] status) {
        this.status = status;
    }

    public List<Chamado> getListaChamadoFechado() {
        ChamadoDAO dao = new ChamadoDAO();
        return dao.getListaChamadosEncerrados();
    }

    public void setListaChamadoFechado(List<Chamado> listaChamadoFechado) {
        this.listaChamadoFechado = listaChamadoFechado;
    }

    public List<Chamado> getListaChamadoAberto() {
        ChamadoDAO dao = new ChamadoDAO();
        return dao.getListaChamadosAbertos();
    }

    public void setListaChamadoAberto(List<Chamado> listaChamadoAberto) {
        this.listaChamadoAberto = listaChamadoAberto;
    }

}
