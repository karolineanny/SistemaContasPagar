package model;

import javax.persistence.*;

@Entity
@Table(name = "unidadefederativa")
public class UnidadeFederativa {

    @Id
    @Column(name = "siglaUF", length = 2, nullable = false)
    private String siglaUF;

    @Column(name = "nomeUF", length = 100)
    private String nomeUF;

    public UnidadeFederativa() {
    }

    public UnidadeFederativa(String siglaUF, String nomeUF) {
        this.siglaUF = siglaUF;
        this.nomeUF = nomeUF;
    }

    public String getSiglaUF() {
        return siglaUF;
    }

    public void setSiglaUF(String siglaUF) {
        this.siglaUF = siglaUF;
    }

    public String getNomeUF() {
        return nomeUF;
    }

    public void setNomeUF(String nomeUF) {
        this.nomeUF = nomeUF;
    }

    @Override
    public String toString() {
        return "UnidadeFederativa{" +
                "siglaUF='" + siglaUF + '\'' +
                ", nomeUF='" + nomeUF + '\'' +
                '}';
    }
}