package model;

import javax.persistence.*;

@Entity
@Table(name = "cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCidade")
    private Integer idCidade;

    @Column(name = "nome", length = 100, nullable = true)
    private String nome;

    @Column(name = "siglaUF", length = 2, nullable = true)
    private String siglaUF;

    public Cidade() {
    }

    public Cidade(String nome, String siglaUF) {
        this.nome = nome;
        this.siglaUF = siglaUF;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiglaUF() {
        return siglaUF;
    }

    public void setSiglaUF(String siglaUF) {
        this.siglaUF = siglaUF;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "idCidade=" + idCidade +
                ", nome='" + nome + '\'' +
                ", siglaUF='" + siglaUF + '\'' +
                '}';
    }
}