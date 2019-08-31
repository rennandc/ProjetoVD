/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.laa.cadastrojsfjpa.bean;

import cadastroHelpDesk.dao.ModeloDao;
import cadastroHelpDesk.modelo.Modelo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sala302b
 */
@FacesConverter (forClass = Modelo.class, value = "ModeloConverter")
public class ModeloConverter implements Converter{
    
     @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            System.out.println("Nulooooo");
            return null;
        } else {
            try {
                Long id = Long.parseLong(value);
                System.out.println("Buscar: " + id);
                Modelo modelo = new ModeloDao().buscar(id);
                System.out.println("Converteu: " +modelo.getNome());
                return modelo;
            } catch (Exception e) {
                return null;
            }

        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
   System.out.println("Converteu2: " + value);
        try {
            Modelo modelo = (Modelo) value;
            if (modelo != null) {
                return String.valueOf(modelo.getId());
            } else {
                System.out.println("Nulooooo2");
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    
}
