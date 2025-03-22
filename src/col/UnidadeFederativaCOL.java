package col;

import model.UnidadeFederativa;

public class UnidadeFederativaCOL {

    public static boolean siglaValida(String sigla) {
        return sigla != null && sigla.matches("[A-Z]{2}");
    }

    public static boolean unidadeFederativaValida(UnidadeFederativa unidadeFederativa) {
        return unidadeFederativa != null &&
                siglaValida(unidadeFederativa.getSiglaUF()) &&
                unidadeFederativa.getNomeUF() != null &&
                !unidadeFederativa.getNomeUF().trim().isEmpty();
    }
}