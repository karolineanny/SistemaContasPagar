package model;

import java.math.BigDecimal;

public class Fornecedor {

    private Integer idFornecedor;

    private String nomeFornecedor;

    private String cnpjFornecedor;

    private Integer idEndereco;

    private String complementoEndereco;

    private String numeroEndereco;

    private BigDecimal saldoPagar;

    public Fornecedor() {
    }

    public Fornecedor(String nomeFornecedor, String cnpjFornecedor, Integer idEndereco,
                      String complementoEndereco, String numeroEndereco, BigDecimal saldoPagar) {
        this.nomeFornecedor = nomeFornecedor;
        this.cnpjFornecedor = cnpjFornecedor;
        this.idEndereco = idEndereco;
        this.complementoEndereco = complementoEndereco;
        this.numeroEndereco = numeroEndereco;
        this.saldoPagar = saldoPagar;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getCnpjFornecedor() {
        return cnpjFornecedor;
    }

    public void setCnpjFornecedor(String cnpjFornecedor) {
        this.cnpjFornecedor = cnpjFornecedor;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public BigDecimal getSaldoPagar() {
        return saldoPagar;
    }

    public void setSaldoPagar(BigDecimal saldoPagar) {
        this.saldoPagar = saldoPagar;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "idFornecedor=" + idFornecedor +
                ", nomeFornecedor='" + nomeFornecedor + '\'' +
                ", cnpjFornecedor='" + cnpjFornecedor + '\'' +
                ", idEndereco=" + idEndereco +
                ", complementoEndereco='" + complementoEndereco + '\'' +
                ", numeroEndereco='" + numeroEndereco + '\'' +
                ", saldoPagar=" + saldoPagar +
                '}';
    }
}