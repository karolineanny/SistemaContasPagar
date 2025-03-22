package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "fatura")
public class Fatura {

    @Id
    @Column(name = "numeroFatura")
    private Integer numeroFatura;

    @Column(name = "dataLancamento")
    private LocalDate dataLancamento;

    @Column(name = "dataVencimento")
    private LocalDate dataVencimento;

    @Column(name = "idFornecedor")
    private Integer idFornecedor;

    @Column(name = "idMotivoFatura")
    private Integer idMotivoFatura;

    @Column(name = "valorTotal", precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "saldo", precision = 10, scale = 2)
    private BigDecimal saldo;

    public Fatura() {
    }

    public Fatura(Integer numeroFatura, LocalDate dataLancamento, LocalDate dataVencimento,
                  Integer idFornecedor, Integer idMotivoFatura, BigDecimal valorTotal, BigDecimal saldo) {
        this.numeroFatura = numeroFatura;
        this.dataLancamento = dataLancamento;
        this.dataVencimento = dataVencimento;
        this.idFornecedor = idFornecedor;
        this.idMotivoFatura = idMotivoFatura;
        this.valorTotal = valorTotal;
        this.saldo = saldo;
    }

    public Integer getNumeroFatura() {
        return numeroFatura;
    }

    public void setNumeroFatura(Integer numeroFatura) {
        this.numeroFatura = numeroFatura;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Integer getIdMotivoFatura() {
        return idMotivoFatura;
    }

    public void setIdMotivoFatura(Integer idMotivoFatura) {
        this.idMotivoFatura = idMotivoFatura;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Fatura{" +
                "numeroFatura=" + numeroFatura +
                ", dataLancamento=" + dataLancamento +
                ", dataVencimento=" + dataVencimento +
                ", idFornecedor=" + idFornecedor +
                ", idMotivoFatura=" + idMotivoFatura +
                ", valorTotal=" + valorTotal +
                ", saldo=" + saldo +
                '}';
    }
}