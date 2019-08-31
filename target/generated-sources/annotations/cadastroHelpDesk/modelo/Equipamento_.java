package cadastroHelpDesk.modelo;

import cadastroHelpDesk.modelo.Fabricante;
import cadastroHelpDesk.modelo.Local;
import cadastroHelpDesk.modelo.Modelo;
import cadastroHelpDesk.modelo.TipoEquipamento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-26T12:32:02")
@StaticMetamodel(Equipamento.class)
public class Equipamento_ { 

    public static volatile SingularAttribute<Equipamento, Boolean> ativo;
    public static volatile SingularAttribute<Equipamento, String> observacao;
    public static volatile SingularAttribute<Equipamento, TipoEquipamento> tipoEquipamento;
    public static volatile SingularAttribute<Equipamento, String> dadosComplementares;
    public static volatile SingularAttribute<Equipamento, String> numeroPratrimonio;
    public static volatile SingularAttribute<Equipamento, Local> localInstalacao;
    public static volatile SingularAttribute<Equipamento, Long> id;
    public static volatile SingularAttribute<Equipamento, Fabricante> fabricante;
    public static volatile SingularAttribute<Equipamento, Date> dtFimGarantia;
    public static volatile SingularAttribute<Equipamento, Modelo> modelo;

}