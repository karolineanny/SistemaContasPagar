package col;

import model.DDD;
import dao.DDDDao;
import java.sql.Connection;

public class DDDCOL {

    public static boolean dddValido(DDD ddd) {
        return ddd != null &&
                ddd.getNumeroDDD() != null &&
                !ddd.getNumeroDDD().trim().isEmpty();
    }

    public static boolean dddExiste(DDD ddd, Connection conexao) throws Exception {
        return dddValido(ddd) && DDDDao.selectDDDPorNumero(ddd.getNumeroDDD(), conexao) != null;
    }
}