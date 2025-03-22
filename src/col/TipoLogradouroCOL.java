package col;

import model.TipoLogradouro;

public class TipoLogradouroCOL {

    public static boolean siglaValida(String sigla) {
        return sigla != null && !sigla.trim().isEmpty();
    }

    public static boolean tipoLogradouroValido(TipoLogradouro tipoLogradouro) {
        return tipoLogradouro != null &&
                siglaValida(tipoLogradouro.getSiglaTipoLogradouro()) &&
                tipoLogradouro.getNomeTipoLogradouro() != null &&
                !tipoLogradouro.getNomeTipoLogradouro().trim().isEmpty();
    }
}