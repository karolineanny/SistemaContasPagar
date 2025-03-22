package model;

public class TelefoneFornecedor {

    private String numeroTelefone;

    private String numeroDDD;

    private String numeroDDI;

    private Integer idFornecedor;

    public TelefoneFornecedor() {
    }

    public TelefoneFornecedor(String numeroTelefone, String numeroDDD, String numeroDDI, Integer idFornecedor) {
        this.numeroTelefone = numeroTelefone;
        this.numeroDDD = numeroDDD;
        this.numeroDDI = numeroDDI;
        this.idFornecedor = idFornecedor;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getNumeroDDD() {
        return numeroDDD;
    }

    public void setNumeroDDD(String numeroDDD) {
        this.numeroDDD = numeroDDD;
    }

    public String getNumeroDDI() {
        return numeroDDI;
    }

    public void setNumeroDDI(String numeroDDI) {
        this.numeroDDI = numeroDDI;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    @Override
    public String toString() {
        return "TelefoneFornecedor{" +
                "numeroTelefone='" + numeroTelefone + '\'' +
                ", numeroDDD='" + numeroDDD + '\'' +
                ", numeroDDI='" + numeroDDI + '\'' +
                ", idFornecedor=" + idFornecedor +
                '}';
    }
}