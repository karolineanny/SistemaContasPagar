package model;

public class Bairro {

    private Integer idBairro;
    private String nome;

    public Bairro() {
    }

    public Bairro(String nome) { this.nome = nome; }

    public Integer getIdBairro() { return idBairro; }

    public void setIdBairro(Integer idBairro) { this.idBairro = idBairro; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    @Override
    public String toString() {
        return "Bairro{" +
                "idBairro=" + idBairro +
                ", nome='" + nome + '\'' +
                '}';
    }
}