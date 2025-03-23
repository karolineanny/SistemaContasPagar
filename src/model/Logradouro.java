package model;

public class Logradouro {

    private Integer idLogradouro;
    private String nome;
    private TipoLogradouro tipoLogradouro;

    public Logradouro() {
    }

    public Logradouro(String nome, TipoLogradouro tipoLogradouro) {
        this.nome = nome;
        this.tipoLogradouro = tipoLogradouro;
    }

    public Integer getIdLogradouro() { return idLogradouro; }

    public void setIdLogradouro(Integer idLogradouro) { this.idLogradouro = idLogradouro; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public TipoLogradouro getTipoLogradouro() { return tipoLogradouro; }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) { this.tipoLogradouro = tipoLogradouro; }

    @Override
    public String toString() {
        return "Logradouro{" +
                "idLogradouro=" + idLogradouro +
                ", nome='" + nome + '\'' +
                ", tipoLogradouro=" + tipoLogradouro +
                '}';
    }
}