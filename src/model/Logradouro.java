package model;

public class Logradouro {

    private Integer idLogradouro;

    private String nome;

    private String siglaTipoLogradouro;

    public Logradouro() {
    }

    public Logradouro(String nome, String siglaTipoLogradouro) {
        this.nome = nome;
        this.siglaTipoLogradouro = siglaTipoLogradouro;
    }

    public Integer getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(Integer idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiglaTipoLogradouro() {
        return siglaTipoLogradouro;
    }

    public void setSiglaTipoLogradouro(String siglaTipoLogradouro) {
        this.siglaTipoLogradouro = siglaTipoLogradouro;
    }

    @Override
    public String toString() {
        return "Logradouro{" +
                "idLogradouro=" + idLogradouro +
                ", nome='" + nome + '\'' +
                ", siglaTipoLogradouro='" + siglaTipoLogradouro + '\'' +
                '}';
    }
}