package col;

import model.TelefoneFornecedor;
import model.DDD;
import model.DDI;
import model.Fornecedor;

public class TelefoneCOL {

    public static boolean telefoneValido(TelefoneFornecedor telefone) {
        if (telefone == null) {
            return false;
        }
        boolean numeroValido = telefone.getNumeroTelefone() != null && !telefone.getNumeroTelefone().trim().isEmpty();

        boolean dddValido = false;
        DDD ddd = telefone.getDdd();
        if (ddd != null && ddd.getNumeroDDD() != null) {
            dddValido = !ddd.getNumeroDDD().trim().isEmpty();
        }

        boolean ddiValido = false;
        DDI ddi = telefone.getDdi();
        if (ddi != null && ddi.getNumeroDDI() != null) {
            ddiValido = !ddi.getNumeroDDI().trim().isEmpty();
        }

        boolean fornecedorValido = telefone.getFornecedor() != null &&
                telefone.getFornecedor().getIdFornecedor() != null &&
                telefone.getFornecedor().getIdFornecedor() > 0;

        return numeroValido && dddValido && ddiValido && fornecedorValido;
    }
}