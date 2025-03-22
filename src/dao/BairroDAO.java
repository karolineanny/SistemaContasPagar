package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Bairro;

public class BairroDAO {

    public Bairro selecionarBairroPorId(Long id, Connection conexao) throws SQLException {
        String sql = "SELECT id_bairro, nome FROM bairro WHERE id_bairro = ?;";

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {

                    Bairro bairro = new Bairro();
                    bairro.setIdBairro((int)resultSet.getLong("id_bairro"));
                    bairro.setNome(resultSet.getString("nome"));

                    return bairro;
                }
            }
        }
        return null;
    }

    public List<Bairro> selecionarTodosBairros(Connection conexao) throws SQLException {
        String sql = """
        SELECT b.id_bairro, b.nome AS bairro_nome
        FROM bairro b
        ORDER BY b.nome;
    """;

        List<Bairro> bairros = new ArrayList<>();

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Bairro bairro = new Bairro();
                bairro.setIdBairro((int)resultSet.getLong("id_bairro"));
                bairro.setNome(resultSet.getString("bairro_nome"));

                bairros.add(bairro);
            }
        }

        return bairros;
    }

}