package model;

public class Cidade {

    private Integer idCidade;
    private String nome;
    private UnidadeFederativa unidadeFederativa;

    public Cidade() {
    }

    public Cidade(String nome, UnidadeFederativa unidadeFederativa) {
        this.nome = nome;
        this.unidadeFederativa = unidadeFederativa;
    }

    public Integer getIdCidade() { return idCidade; }

    public void setIdCidade(Integer idCidade) { this.idCidade = idCidade; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public UnidadeFederativa getUnidadeFederativa() { return unidadeFederativa; }

    public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) { this.unidadeFederativa = unidadeFederativa; }

    @Override
    public String toString() {
        return "Cidade{" +
                "idCidade=" + idCidade +
                ", nome='" + nome + '\'' +
                ", unidadeFederativa=" + unidadeFederativa +
                '}';
    }
}