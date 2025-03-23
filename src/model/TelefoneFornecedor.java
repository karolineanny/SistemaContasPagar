package model;

public class TelefoneFornecedor {

    private String numeroTelefone;
    private DDD ddd;
    private DDI ddi;
    private Fornecedor fornecedor;

    public TelefoneFornecedor() {
    }

    public TelefoneFornecedor(String numeroTelefone, DDD ddd, DDI ddi, Fornecedor fornecedor) {
        this.numeroTelefone = numeroTelefone;
        this.ddd = ddd;
        this.ddi = ddi;
        this.fornecedor = fornecedor;
    }

    public String getNumeroTelefone() { return numeroTelefone; }

    public void setNumeroTelefone(String numeroTelefone) { this.numeroTelefone = numeroTelefone; }

    public DDD getDdd() { return ddd; }

    public void setDdd(DDD ddd) { this.ddd = ddd; }

    public DDI getDdi() { return ddi; }

    public void setDdi(DDI ddi) { this.ddi = ddi; }

    public Fornecedor getFornecedor() { return fornecedor; }

    public void setFornecedor(Fornecedor fornecedor) { this.fornecedor = fornecedor; }

    @Override
    public String toString() {
        return "TelefoneFornecedor{" +
                "numeroTelefone='" + numeroTelefone + '\'' +
                ", ddd=" + ddd +
                ", ddi=" + ddi +
                ", fornecedor=" + fornecedor +
                '}';
    }
}