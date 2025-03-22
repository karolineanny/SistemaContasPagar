package model;

public class Endereco {
    private Integer idEndereco;

    private String cep;

    private Integer idCidade;

    private Integer idLogradouro;

    private Integer idBairro;

    public Endereco() {
    }

    public Endereco(String cep, Integer idCidade, Integer idLogradouro, Integer idBairro) {
        this.cep = cep;
        this.idCidade = idCidade;
        this.idLogradouro = idLogradouro;
        this.idBairro = idBairro;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public Integer getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(Integer idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public Integer getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(Integer idBairro) {
        this.idBairro = idBairro;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "idEndereco=" + idEndereco +
                ", cep='" + cep + '\'' +
                ", idCidade=" + idCidade +
                ", idLogradouro=" + idLogradouro +
                ", idBairro=" + idBairro +
                '}';
    }
}