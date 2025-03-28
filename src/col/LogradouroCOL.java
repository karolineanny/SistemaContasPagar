package col;

import model.Logradouro;

public class LogradouroCOL {

    public static boolean idValido(Integer id) {
        return id != null && id > 0;
    }

    public static boolean logradouroValido(Logradouro logradouro) {
        return logradouro != null &&
                idValido(logradouro.getIdLogradouro()) &&
                logradouro.getNome() != null &&
                !logradouro.getNome().trim().isEmpty() &&
                logradouro.getTipoLogradouro() != null &&
                logradouro.getTipoLogradouro().getSiglaTipoLogradouro() != null &&
                !logradouro.getTipoLogradouro().getSiglaTipoLogradouro().trim().isEmpty();
    }
}