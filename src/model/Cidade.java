package model;

public class Cidade {

    private Integer idCidade;

    private String nome;

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