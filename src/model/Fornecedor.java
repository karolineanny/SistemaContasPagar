package model;

import java.math.BigDecimal;

public class Fornecedor {

    private Integer idFornecedor;
    private String nomeFornecedor;
    private String cnpjFornecedor;
    private Endereco endereco;
    private BigDecimal saldoPagar;

    public Fornecedor() {
    }

    public Fornecedor(String nomeFornecedor, String cnpjFornecedor, Endereco endereco, BigDecimal saldoPagar) {
        this.nomeFornecedor = nomeFornecedor;
        this.cnpjFornecedor = cnpjFornecedor;
        this.endereco = endereco;
        this.saldoPagar = saldoPagar;
    }

    public Integer getIdFornecedor() { return idFornecedor; }

    public void setIdFornecedor(Integer idFornecedor) { this.idFornecedor = idFornecedor; }

    public String getNomeFornecedor() { return nomeFornecedor; }

    public void setNomeFornecedor(String nomeFornecedor) { this.nomeFornecedor = nomeFornecedor; }

    public String getCnpjFornecedor() {  return cnpjFornecedor; }

    public void setCnpjFornecedor(String cnpjFornecedor) { this.cnpjFornecedor = cnpjFornecedor; }

    public Endereco getEndereco() { return endereco; }

    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public BigDecimal getSaldoPagar() { return saldoPagar; }

    public void setSaldoPagar(BigDecimal saldoPagar) { this.saldoPagar = saldoPagar; }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "idFornecedor=" + idFornecedor +
                ", nomeFornecedor='" + nomeFornecedor + '\'' +
                ", cnpjFornecedor='" + cnpjFornecedor + '\'' +
                ", endereco=" + endereco +
                ", saldoPagar=" + saldoPagar +
                '}';
    }
}