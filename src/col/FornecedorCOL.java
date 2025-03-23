package col;

import model.Fornecedor;
import model.Endereco;

public class FornecedorCOL {

    public static boolean idValido(Integer id) {
        return id != null && id > 0;
    }

    public static boolean fornecedorValido(Fornecedor fornecedor) {
        return fornecedor != null &&
                fornecedor.getNomeFornecedor() != null && !fornecedor.getNomeFornecedor().trim().isEmpty() &&
                fornecedor.getCnpjFornecedor() != null && !fornecedor.getCnpjFornecedor().trim().isEmpty() &&
                fornecedor.getEndereco() != null && enderecoValido(fornecedor.getEndereco());
    }

    public static boolean enderecoValido(Endereco endereco) {
        return endereco.getIdEndereco() != null && endereco.getIdEndereco() > 0;
    }
}