package model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFornecedor")
    private Integer idFornecedor;

    @Column(name = "nomeFornecedor", length = 100)
    private String nomeFornecedor;

    @Column(name = "cnpjFornecedor", length = 20)
    private String cnpjFornecedor;

    @Column(name = "idEndereco")
    private Integer idEndereco;

    @Column(name = "complementoEndereco", length = 100)
    private String complementoEndereco;

    @Column(name = "numeroEndereco", length = 10)
    private String numeroEndereco;

    @Column(name = "saldoPagar", precision = 10, scale = 2)
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