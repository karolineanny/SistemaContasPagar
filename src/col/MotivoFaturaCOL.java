package col;

import model.MotivoFatura;

public class MotivoFaturaCOL {

    public static boolean idValido(Integer id) {
        return id != null && id > 0;
    }

    public static boolean motivoFaturaValido(MotivoFatura motivoFatura) {
        if (motivoFatura == null) {
            return false;
        }
        boolean descricaoValida = motivoFatura.getDescricaoMotivo() != null &&
                !motivoFatura.getDescricaoMotivo().trim().isEmpty();
        return descricaoValida;
    }
}