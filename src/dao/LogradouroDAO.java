package dao;

import model.Logradouro;
import model.TipoLogradouro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogradouroDAO {

    public Logradouro selecionarLogradouroPorId(Integer id, Connection conexao) throws SQLException {
        String sql = """
            SELECT l.id_logradouro, l.nome AS logradouro_nome, l.sigla_tipo_logradouro
            FROM logradouro l
            WHERE l.id_logradouro = ?;
        """;

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Logradouro logradouro = new Logradouro();
                    logradouro.setIdLogradouro(resultSet.getInt("id_logradouro"));
                    logradouro.setNome(resultSet.getString("logradouro_nome"));

                    TipoLogradouro tipo = new TipoLogradouro();
                    tipo.setSiglaTipoLogradouro(resultSet.getString("sigla_tipo_logradouro"));
                    logradouro.setTipoLogradouro(tipo);

                    return logradouro;
                }
            }
        }
        return null;
    }

    public List<Logradouro> selecionarTodosLogradouros(Connection conexao) throws SQLException {
        String sql = """
            SELECT l.id_logradouro, l.nome, l.sigla_tipo_logradouro
            FROM logradouro l
            ORDER BY l.nome;
        """;

        List<Logradouro> logradouros = new ArrayList<>();

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Logradouro logradouro = new Logradouro();
                logradouro.setIdLogradouro(resultSet.getInt("id_logradouro"));
                logradouro.setNome(resultSet.getString("logradouro_nome"));

                TipoLogradouro tipo = new TipoLogradouro();
                tipo.setSiglaTipoLogradouro(resultSet.getString("sigla_tipo_logradouro"));
                logradouro.setTipoLogradouro(tipo);

                logradouros.add(logradouro);
            }
        }

        return logradouros;
    }
}