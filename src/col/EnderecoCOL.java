package col;

import model.Endereco;

public class EnderecoCOL {

    public static boolean idValido(Integer id) {
        return id != null && id > 0;
    }

    public static boolean cepValido(String cep) {
        return cep != null && cep.matches("\\d{8}");
    }

    public static boolean enderecoValido(Endereco endereco) {
        return endereco != null &&
                cepValido(endereco.getCep()) &&
                endereco.getCidade() != null &&
                idValido(endereco.getCidade().getIdCidade()) &&
                endereco.getLogradouro() != null &&
                idValido(endereco.getLogradouro().getIdLogradouro()) &&
                endereco.getBairro() != null &&
                idValido(endereco.getBairro().getIdBairro());
    }
}