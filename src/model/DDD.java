package model;

import javax.persistence.*;

@Entity
@Table(name = "ddd")
public class DDD {

    @Id
    @Column(name = "numeroDDD", length = 5, nullable = false)
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