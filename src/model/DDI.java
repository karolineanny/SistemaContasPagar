package model;

import javax.persistence.*;

public class DDI {

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