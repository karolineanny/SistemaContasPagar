package model;

import javax.persistence.*;

@Entity
@Table(name = "emailfornecedor")
public class EmailFornecedor {

    @Id
    @Column(name = "emailFornecedor", length = 100, nullable = false)
    private String emailFornecedor;

    @Column(name = "idFornecedor")
    private Integer idFornecedor;

    public EmailFornecedor() {
    }

    public EmailFornecedor(String emailFornecedor, Integer idFornecedor) {
        this.emailFornecedor = emailFornecedor;
        this.idFornecedor = idFornecedor;
    }

    public String getEmailFornecedor() {
        return emailFornecedor;
    }

    public void setEmailFornecedor(String emailFornecedor) {
        this.emailFornecedor = emailFornecedor;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    @Override
    public String toString() {
        return "EmailFornecedor{" +
                "emailFornecedor='" + emailFornecedor + '\'' +
                ", idFornecedor=" + idFornecedor +
                '}';
    }
}