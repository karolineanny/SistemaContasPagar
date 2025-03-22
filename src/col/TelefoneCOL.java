package col;

import java.sql.Connection;
import java.util.List;
import model.TelefoneFornecedor;
import model.DDD;
import model.DDI;

public class TelefoneCOL {

    private static boolean numeroValido(String numero) {
        return numero != null && !numero.trim().isEmpty() && numero.length() <= 15;
    }

    public static boolean telefonesValidos(List<TelefoneFornecedor> telefones, Connection conexao) throws Exception {
        for (TelefoneFornecedor telefone : telefones) {
            if (!telefoneValido(telefone, conexao)) {
                return false;
            }
        }
        return true;
    }

    private static boolean telefoneValido(TelefoneFornecedor telefone, Connection conexao) throws Exception {
        return telefone != null &&
                numeroValido(telefone.getNumeroTelefone()) &&
                DDDCOL.dddValido(new DDD(telefone.getNumeroDDD())) &&
                DDDCOL.dddExiste(new DDD(telefone.getNumeroDDD()), conexao) &&
                DDICOL.ddiValido(new DDI(telefone.getNumeroDDI())) &&
                DDICOL.ddiExiste(new DDI(telefone.getNumeroDDI()), conexao);
    }
}