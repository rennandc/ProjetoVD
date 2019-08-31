/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroHelpDesk.dao;

import cadastroHelpDesk.modelo.TipoEquipamento;
import java.util.List;

/**
 *
 * @author sala302b
 */
public class TipoEquipamentoDao extends AppDao<TipoEquipamento> {

    public TipoEquipamentoDao() {
        super(TipoEquipamento.class);
    }

    public void salvarLista(List<TipoEquipamento> listaTipoEquipamento) {
        for (TipoEquipamento tipoEquipamento : listaTipoEquipamento) {
            System.out.print("tipoEquipamento: " + tipoEquipamento.getNome());

            if (tipoEquipamento.getNome() == null || tipoEquipamento.getNome().isEmpty()) {
                //descartar               
                System.out.print("Descartou");
                continue;
            } if (tipoEquipamento.getId() != null && tipoEquipamento.getId() > 0) {
                //atualizar
                System.out.print("Atualizou");
                super.atualizar(tipoEquipamento);
            } else {
                //salvar
                System.out.print("Inseriu");
                super.inserir(tipoEquipamento);
            }

        }
    }

    public void salvarLista(TipoEquipamento tipoEquipamento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
