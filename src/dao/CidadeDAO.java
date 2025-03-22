package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cidade;

public class CidadeDAO {

    public Cidade selecionarCidadePorId(Long id, Connection conexao) throws SQLException {
        String sql = """
            SELECT c.idCidade        AS cidade_id,
                   c.nome             AS cidade_nome,
                   c.siglaUf         AS uf_sigla
            FROM cidade c
            WHERE c.idCidade = ?;
        """;

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cidade cidade = new Cidade();
                    // A model Cidade tem idCidade como Integer
                    cidade.setIdCidade(rs.getInt("cidadeId"));
                    cidade.setNome(rs.getString("cidadeNome"));
                    cidade.setSiglaUF(rs.getString("ufSigla"));
                    return cidade;
                }
            }
        }
        return null;
    }

    public List<Cidade> selecionarTodasCidades(Connection conexao) throws SQLException {
        String sql = """
            SELECT c.idCidade,
                   c.nome       AS cidade_nome,
                   c.siglaUf   AS uf_sigla
            FROM cidade c
            ORDER BY c.nome;
        """;

        List<Cidade> cidades = new ArrayList<>();

        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setIdCidade(rs.getInt("idCidade"));
                cidade.setNome(rs.getString("cidadeNome"));
                cidade.setSiglaUF(rs.getString("ufSigla"));
                cidades.add(cidade);
            }
        }

        return cidades;
    }
}