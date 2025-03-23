package model;

public class Endereco {
    private Integer idEndereco;
    private String cep;
    private Cidade cidade;
    private Logradouro logradouro;
    private Bairro bairro;

    public Endereco() {
    }

    public Endereco(String cep, Cidade cidade, Logradouro logradouro, Bairro bairro) {
        this.cep = cep;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.bairro = bairro;
    }

    public Integer getIdEndereco() { return idEndereco; }

    public void setIdEndereco(Integer idEndereco) { this.idEndereco = idEndereco; }

    public String getCep() { return cep; }

    public void setCep(String cep) { this.cep = cep; }

    public Cidade getCidade() { return cidade; }

    public void setCidade(Cidade cidade) { this.cidade = cidade; }

    public Logradouro getLogradouro() { return logradouro; }

    public void setLogradouro(Logradouro logradouro) { this.logradouro = logradouro; }

    public Bairro getBairro() { return bairro; }

    public void setBairro(Bairro bairro) { this.bairro = bairro; }

    @Override
    public String toString() {
        return "Endereco{" +
                "idEndereco=" + idEndereco +
                ", cep='" + cep + '\'' +
                ", cidade=" + cidade +
                ", logradouro=" + logradouro +
                ", bairro=" + bairro +
                '}';
    }
}