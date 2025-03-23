package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cidade;
import model.UnidadeFederativa;

public class CidadeDAO {

    public Cidade selecionarCidadePorId(Long id, Connection conexao) throws SQLException {
        String sql = """
            SELECT c.id_cidade,
                   c.nome,
                   c.siglaUf
            FROM cidade c
            WHERE c.id_cidade = ?;
        """;

        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cidade cidade = new Cidade();
                    cidade.setIdCidade(rs.getInt("id_cidade"));
                    cidade.setNome(rs.getString("nome"));

                    UnidadeFederativa uf = new UnidadeFederativa();
                    uf.setSiglaUF(rs.getString("sigla_uf"));
                    cidade.setUnidadeFederativa(uf);

                    return cidade;
                }
            }
        }
        return null;
    }

    public List<Cidade> selecionarTodasCidades(Connection conexao) throws SQLException {
        String sql = """
            SELECT c.id_cidade,
                   c.nome,
                   c.sigla_uf,
            FROM cidade c
            ORDER BY c.nome;
        """;

        List<Cidade> cidades = new ArrayList<>();

        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setIdCidade(rs.getInt("id_cidade"));
                cidade.setNome(rs.getString("nome"));

                UnidadeFederativa uf = new UnidadeFederativa();
                uf.setSiglaUF(rs.getString("sigla_uf"));
                cidade.setUnidadeFederativa(uf);

                cidades.add(cidade);
            }
        }
        return cidades;
    }
}