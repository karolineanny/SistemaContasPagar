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
            SELECT c.id_cidade        AS cidade_id,
                   c.nome             AS cidade_nome,
                   c.sigla_uf         AS uf_sigla
            FROM cidade c
            WHERE c.id_cidade = ?;
        """;

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cidade cidade = new Cidade();
                    // A model Cidade tem idCidade como Integer
                    cidade.setIdCidade(rs.getInt("cidade_id"));
                    cidade.setNome(rs.getString("cidade_nome"));
                    cidade.setSiglaUF(rs.getString("uf_sigla"));
                    return cidade;
                }
            }
        }
        return null;
    }

    public List<Cidade> selecionarTodasCidades(Connection conexao) throws SQLException {
        String sql = """
            SELECT c.id_cidade,
                   c.nome       AS cidade_nome,
                   c.sigla_uf   AS uf_sigla
            FROM cidade c
            ORDER BY c.nome;
        """;

        List<Cidade> cidades = new ArrayList<>();

        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setIdCidade(rs.getInt("id_cidade"));
                cidade.setNome(rs.getString("cidade_nome"));
                cidade.setSiglaUF(rs.getString("uf_sigla"));
                cidades.add(cidade);
            }
        }

        return cidades;
    }
}