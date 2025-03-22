package model;

public class DDD {

    private String numeroDDD;

    public DDD() {
    }

    public DDD(String numeroDDD) {
        this.numeroDDD = numeroDDD;
    }

    public String getNumeroDDD() {
        return numeroDDD;
    }

    public void setNumeroDDD(String numeroDDD) {
        this.numeroDDD = numeroDDD;
    }

    @Override
    public String toString() {
        return "Ddd{" +
                "numeroDDD='" + numeroDDD + '\'' +
                '}';
    }
}