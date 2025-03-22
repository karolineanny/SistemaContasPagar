package dao;

import model.Logradouro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogradouroDAO {

    public Logradouro selecionarLogradouroPorId(Integer id, Connection conexao) throws SQLException {
        String sql = """
            SELECT l.idLogradouro, l.nome AS logradouro_nome, l.siglaTipoLogradouro
            FROM logradouro l
            WHERE l.idLogradouro = ?;
        """;

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Logradouro logradouro = new Logradouro();
                    logradouro.setIdLogradouro(resultSet.getInt("idLogradouro"));
                    logradouro.setNome(resultSet.getString("logradouroNome"));
                    logradouro.setSiglaTipoLogradouro(resultSet.getString("siglaTipoLogradouro"));
                    return logradouro;
                }
            }
        }
        return null;
    }

    public List<Logradouro> selecionarTodosLogradouros(Connection conexao) throws SQLException {
        String sql = """
            SELECT l.idLogradouro, l.nome AS logradouro_nome, l.siglaTipoLogradouro
            FROM logradouro l
            ORDER BY l.nome;
        """;

        List<Logradouro> logradouros = new ArrayList<>();

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Logradouro logradouro = new Logradouro();
                logradouro.setIdLogradouro(resultSet.getInt("idLogradouro"));
                logradouro.setNome(resultSet.getString("logradouroNome"));
                logradouro.setSiglaTipoLogradouro(resultSet.getString("siglaTipoLogradouro"));
                logradouros.add(logradouro);
            }
        }

        return logradouros;
    }
}