package model;

import javax.persistence.*;

@Entity
@Table(name = "bairro")
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBairro")
    private Integer idBairro;

    @Column(name = "nome", length = 100, nullable = true)
    private String nome;

    public Bairro() {
    }

    public Bairro(String nome) {
        this.nome = nome;
    }

    public Integer getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(Integer idBairro) {
        this.idBairro = idBairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Bairro{" +
                "idBairro=" + idBairro +
                ", nome='" + nome + '\'' +
                '}';
    }
}