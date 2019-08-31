
package br.com.laa.cadastrojsfjpa.bean;


import cadastroHelpDesk.dao.LocalDao;

import cadastroHelpDesk.modelo.Local;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter (forClass = Local.class, value = "LocalConverter")
public class LocalConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            System.out.println("Nulooooo");
            return null;
        } else {
            try {
                Long id = Long.parseLong(value);
                System.out.println("Buscar: " + id);
                Local local = new LocalDao().buscar(id);
                System.out.println("Converteu: " +local.getNome());
                return local;
            } catch (Exception e) {
                return null;
            }

        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
   System.out.println("Converteu2: " + value);
        try {
            Local local = (Local) value;
            if (local != null) {
                return String.valueOf(local.getId());
            } else {
                System.out.println("Nulooooo2");
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
}
