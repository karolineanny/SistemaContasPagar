package dao;

import model.UnidadeFederativa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnidadeFederativaDAO {

    public List<UnidadeFederativa> selecionarTodasUnidadesFederativas(Connection conexao) throws SQLException {
        String sql = """
            SELECT uf.siglaUF, uf.nomeUF
            FROM unidadefederativa uf
            ORDER BY uf.nomeUF;
        """;

        List<UnidadeFederativa> unidadesFederativas = new ArrayList<>();

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                UnidadeFederativa uf = new UnidadeFederativa();
                uf.setSiglaUF(resultSet.getString("siglaUF"));
                uf.setNomeUF(resultSet.getString("nomeUF"));
                unidadesFederativas.add(uf);
            }
        }

        return unidadesFederativas;
    }
}