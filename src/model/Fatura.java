package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Fatura {

    private Integer numeroFatura;
    private LocalDate dataLancamento;
    private LocalDate dataVencimento;
    private Fornecedor fornecedor;
    private MotivoFatura motivoFatura;
    private BigDecimal valorTotal;
    private BigDecimal saldo;

    public Fatura() {
    }

    public Fatura(Integer numeroFatura, LocalDate dataLancamento, LocalDate dataVencimento,
                  Fornecedor fornecedor, MotivoFatura motivoFatura, BigDecimal valorTotal, BigDecimal saldo) {
        this.numeroFatura = numeroFatura;
        this.dataLancamento = dataLancamento;
        this.dataVencimento = dataVencimento;
        this.fornecedor = fornecedor;
        this.motivoFatura = motivoFatura;
        this.valorTotal = valorTotal;
        this.saldo = saldo;
    }

    public Integer getNumeroFatura() { return numeroFatura; }

    public void setNumeroFatura(Integer numeroFatura) { this.numeroFatura = numeroFatura; }

    public LocalDate getDataLancamento() { return dataLancamento; }

    public void setDataLancamento(LocalDate dataLancamento) { this.dataLancamento = dataLancamento; }

    public LocalDate getDataVencimento() { return dataVencimento; }

    public void setDataVencimento(LocalDate dataVencimento) { this.dataVencimento = dataVencimento; }

    public Fornecedor getFornecedor() { return fornecedor; }

    public void setFornecedor(Fornecedor fornecedor) { this.fornecedor = fornecedor; }

    public MotivoFatura getMotivoFatura() { return motivoFatura; }

    public void setMotivoFatura(MotivoFatura motivoFatura) { this.motivoFatura = motivoFatura; }

    public BigDecimal getValorTotal() { return valorTotal; }

    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    public BigDecimal getSaldo() { return saldo; }

    public void setSaldo(BigDecimal saldo) { this.saldo = saldo; }

    @Override
    public String toString() {
        return "Fatura{" +
                "numeroFatura=" + numeroFatura +
                ", dataLancamento=" + dataLancamento +
                ", dataVencimento=" + dataVencimento +
                ", fornecedor=" + fornecedor +
                ", motivoFatura=" + motivoFatura +
                ", valorTotal=" + valorTotal +
                ", saldo=" + saldo +
                '}';
    }
}