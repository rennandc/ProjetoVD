/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.laa.cadastrojsfjpa.bean;

import cadastroHelpDesk.dao.TipoChamadoDAO;
import static cadastroHelpDesk.modelo.Chamado_.tipoChamado;
import cadastroHelpDesk.modelo.TipoChamado;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sala302b
 */
@FacesConverter (forClass = TipoChamadoConverter.class, value = "tipochamadoConverter")
public class TipoChamadoConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            System.out.println("Nulooooo");
            return null;
        } else {
            try {
                Long id = Long.parseLong(value);
                System.out.println("Buscar: " + id);
                TipoChamado tipoChamado = new TipoChamadoDAO().buscar(id);
                System.out.println("Converteu: " + tipoChamado.getNome());
                return tipoChamado;
            } catch (Exception e) {
                return null;
            }

        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("Converteu2: " + value);
        try {
            TipoChamado TipoChamado = (TipoChamado) value;
            if (tipoChamado != null) {
                return String.valueOf(TipoChamado.getId());
            } else {
                System.out.println("Nulooooo2");
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
}
