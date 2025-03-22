package col;

import model.Fornecedor;

public class FornecedorCOL {

    public static boolean idValido(Integer id) {
        return id != null && id > 0;
    }

    public static boolean fornecedorValido(Fornecedor fornecedor) {
        return fornecedor != null &&
                fornecedor.getNomeFornecedor() != null && !fornecedor.getNomeFornecedor().trim().isEmpty() &&
                fornecedor.getCnpjFornecedor() != null && !fornecedor.getCnpjFornecedor().trim().isEmpty() &&
                fornecedor.getIdEndereco() != null;
    }
}