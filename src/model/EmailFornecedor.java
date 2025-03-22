package model;

public class EmailFornecedor {

    private String emailFornecedor;
    private Fornecedor fornecedor;

    public EmailFornecedor() {
    }

    public EmailFornecedor(String emailFornecedor, Fornecedor fornecedor) {
        this.emailFornecedor = emailFornecedor;
        this.fornecedor = fornecedor;
    }

    public String getEmailFornecedor() { return emailFornecedor; }

    public void setEmailFornecedor(String emailFornecedor) { this.emailFornecedor = emailFornecedor; }

    public Fornecedor getFornecedor() { return fornecedor; }

    public void setFornecedor(Fornecedor fornecedor) { this.fornecedor = fornecedor; }

    @Override
    public String toString() {
        return "EmailFornecedor{" +
                "emailFornecedor='" + emailFornecedor + '\'' +
                ", fornecedor=" + (fornecedor != null ? fornecedor.getIdFornecedor() : null) +
                '}';
    }
}