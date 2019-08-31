package cadastroHelpDesk.modelo;

import cadastroHelpDesk.modelo.Local;
import cadastroHelpDesk.modelo.Perfil;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-26T12:32:02")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile SingularAttribute<Usuario, String> telefone;
    public static volatile SingularAttribute<Usuario, Perfil> Perfil;
    public static volatile SingularAttribute<Usuario, String> cpf;
    public static volatile SingularAttribute<Usuario, String> nome;
    public static volatile SingularAttribute<Usuario, Local> setortrabalho;
    public static volatile SingularAttribute<Usuario, Long> id;

}