package col;

import model.Cidade;

public class CidadeCOL {

    public boolean idValido(Integer id) {
        return id != null && id > 0;
    }

    public boolean cidadeValida(Cidade cidade) {
        return cidade != null &&
                idValido(cidade.getIdCidade()) &&
                cidade.getNome() != null &&
                !cidade.getNome().trim().isEmpty() &&
                cidade.getUnidadeFederativa() != null &&
                cidade.getUnidadeFederativa().getSiglaUF() != null &&
                !cidade.getUnidadeFederativa().getSiglaUF().trim().isEmpty();
    }
}