/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroHelpDesk.dao;

import cadastroHelpDesk.modelo.TipoChamado;
import java.util.List;

/**
 *
 * @author sala302b
 */
public class TipoChamadoDAO extends AppDao<TipoChamado>{
    
    public TipoChamadoDAO() {
        super(TipoChamado.class);
    }

    public void salvarLista(List<TipoChamado> ListaTipoChamado) {
        for (TipoChamado tipoChamado : ListaTipoChamado) {
            System.out.print("tipoChamado: " + tipoChamado.getNome());

            if (tipoChamado.getNome() == null || tipoChamado.getNome().isEmpty()) {
                //descartar               
                System.out.print("Descartou");
                continue;
            } if (tipoChamado.getId() != null && tipoChamado.getId() > 0) {
                //atualizar
                System.out.print("Atualizou");
                super.atualizar(tipoChamado);
            } else {
                //salvar
                System.out.print("Inseriu");
                super.inserir(tipoChamado);
            }

        }
    }

    public void salvarLista(TipoChamado tipoChamado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
    

