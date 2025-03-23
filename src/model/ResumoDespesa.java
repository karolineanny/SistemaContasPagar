package model;

import java.math.BigDecimal;

public class ResumoDespesa {

    private MotivoFatura motivoFatura;
    private BigDecimal total;

    public ResumoDespesa() {
    }

    public ResumoDespesa(MotivoFatura motivoFatura, BigDecimal total) {
        this.motivoFatura = motivoFatura;
        this.total = total;
    }

    public MotivoFatura getMotivoFatura() { return motivoFatura; }

    public void setMotivoFatura(MotivoFatura motivoFatura) { this.motivoFatura = motivoFatura; }

    public BigDecimal getTotal() { return total; }

    public void setTotal(BigDecimal total) { this.total = total; }

    @Override
    public String toString() {
        return "ResumoDespesa{" +
                "motivoFatura=" + motivoFatura +
                ", total=" + total +
                '}';
    }
}