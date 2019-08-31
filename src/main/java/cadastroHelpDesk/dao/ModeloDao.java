/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroHelpDesk.dao;

import cadastroHelpDesk.modelo.Modelo;
import java.util.List;

/**
 *
 * @author sala302b
 */
public class ModeloDao extends AppDao<Modelo> {

    public ModeloDao() {
        super(Modelo.class);
    }

    public void salvarLista(List<Modelo> listaModelo) {
        for (Modelo modelo : listaModelo) {
            System.out.print("modelo: " + modelo.getNome());

            if (modelo.getNome() == null || modelo.getNome().isEmpty()) {
                //descartar               
                System.out.print("Descartou");
                continue;
            }
            if (modelo.getId() != null && modelo.getId() > 0) {
                //atualizar
                System.out.print("Atualizou");
                super.atualizar(modelo);
            } else {
                //salvar
                System.out.print("Inseriu");
                super.inserir(modelo);
            }

        }
    }

    public void salvarLista(Modelo modelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
