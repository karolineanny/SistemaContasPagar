package col;

import model.Bairro;

public class BairroCOL {

    public static boolean idValido(Integer id) {
        return id != null && id > 0;
    }

    public static boolean bairroValido(Bairro bairro) {
        return bairro != null &&
                idValido(bairro.getIdBairro()) &&
                bairro.getNome() != null &&
                !bairro.getNome().trim().isEmpty();
    }
}