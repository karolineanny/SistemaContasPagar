package col;

import model.DDI;
import dao.DDIDao;

public class DDICOL {

    public static boolean ddiValido(DDI ddi) {
        return ddi != null &&
                ddi.getNumeroDDI() != null &&
                !ddi.getNumeroDDI().trim().isEmpty();
    }

    public static boolean ddiExiste(DDI ddi) throws Exception {
        return ddiValido(ddi) && DDIDao.selectDDIPorNumero(ddi.getNumeroDDI()) != null;
    }
}