package model;

import javax.persistence.*;

@Entity
@Table(name = "ddi")
public class DDI {

    @Id
    @Column(name = "numeroDDI", length = 5, nullable = false)
    private String numeroDDI;

    public DDI() {
    }

    public DDI(String numeroDDI) {
        this.numeroDDI = numeroDDI;
    }

    public String getNumeroDDI() {
        return numeroDDI;
    }

    public void setNumeroDDI(String numeroDDI) {
        this.numeroDDI = numeroDDI;
    }

    @Override
    public String toString() {
        return "Ddi{" +
                "numeroDDI='" + numeroDDI + '\'' +
                '}';
    }
}