package col;

import model.DDI;
import dao.DDIDao;
import java.sql.Connection;

public class DDICOL {

    public static boolean ddiValido(DDI ddi) {
        return ddi != null &&
                ddi.getNumeroDDI() != null &&
                !ddi.getNumeroDDI().trim().isEmpty();
    }

    public static boolean ddiExiste(DDI ddi, Connection conexao) throws Exception {
        return ddiValido(ddi) && DDIDao.selectDDIPorNumero(ddi.getNumeroDDI(), conexao) != null;
    }
}