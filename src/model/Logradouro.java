package model;

import javax.persistence.*;

@Entity
@Table(name = "logradouro")
public class Logradouro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLogradouro")
    private Integer idLogradouro;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "siglaTipoLogradouro", length = 10)
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