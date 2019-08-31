/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroHelpDesk.dao;

import cadastroHelpDesk.modelo.Fabricante;
import java.util.List;

/**
 *
 * @author sala302b
 */
public class FabricanteDao extends AppDao<Fabricante>{
     public FabricanteDao(){
        super(Fabricante.class);
     } 
  
    public void salvarLista(List<Fabricante> listaFabricante) {
        for (Fabricante fabricante : listaFabricante) {
            System.out.print("fabricante: " + fabricante.getNome());
            
            if (fabricante.getNome() == null || fabricante.getNome().isEmpty()){
                //descartar               
                System.out.print("Descartou");
                continue;
            }
            if (fabricante.getId() != null && fabricante.getId() >0){
            //atualizar
            System.out.print("Atualizou");
            super.atualizar(fabricante);            
            } else{
                //salvar
                System.out.print("Inseriu");
            super.inserir(fabricante);}
                
        }
    }

    public void atualizar(List<Fabricante> listaFabricante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
