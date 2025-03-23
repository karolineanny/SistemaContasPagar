package col;

import model.Fatura;
import model.Fornecedor;
import model.MotivoFatura;
import java.math.BigDecimal;
import java.time.LocalDate;

public class FaturaCOL {

    public static boolean idValido(Integer id) {
        return id != null && id > 0;
    }

    public static boolean faturaValida(Fatura fatura) {
        if (fatura == null) {
            return false;
        }

        boolean numeroValido = (fatura.getNumeroFatura() == null) || (fatura.getNumeroFatura() > 0);

        boolean dataLancamentoValida = fatura.getDataLancamento() != null;
        boolean dataVencimentoValida = fatura.getDataVencimento() != null;
        boolean datasValidas = dataLancamentoValida && dataVencimentoValida &&
                (fatura.getDataVencimento().isAfter(fatura.getDataLancamento()) ||
                        fatura.getDataVencimento().isEqual(fatura.getDataLancamento()));

        boolean valorValido = fatura.getValorTotal() != null &&
                fatura.getValorTotal().compareTo(BigDecimal.ZERO) > 0;

        boolean motivoValido = fatura.getMotivoFatura() != null &&
                fatura.getMotivoFatura().getIdMotivoFatura() != null &&
                fatura.getMotivoFatura().getIdMotivoFatura() > 0;

        boolean fornecedorValido = fatura.getFornecedor() != null &&
                fatura.getFornecedor().getIdFornecedor() != null &&
                fatura.getFornecedor().getIdFornecedor() > 0;

        return numeroValido && datasValidas && valorValido && motivoValido && fornecedorValido;
    }
}