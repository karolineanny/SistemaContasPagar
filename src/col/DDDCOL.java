package col;

import model.DDD;
import dao.DDDDao;

public class DDDCOL {

    public static boolean dddValido(DDD ddd) {
        return ddd != null &&
                ddd.getNumeroDDD() != null &&
                !ddd.getNumeroDDD().trim().isEmpty();
    }

    public static boolean dddExiste(DDD ddd) throws Exception {
        return dddValido(ddd) && DDDDao.selectDDDPorNumero(ddd.getNumeroDDD()) != null;
    }
}