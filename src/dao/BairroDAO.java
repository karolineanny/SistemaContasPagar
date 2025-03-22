package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Bairro;

public class BairroDAO {

    public Bairro selecionarBairroPorId(Integer id, Connection conexao) throws SQLException {
        String sql = "SELECT idBairro, nome FROM bairro WHERE idBairro = ?;";

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Bairro bairro = new Bairro();
                    bairro.setIdBairro(resultSet.getInt("idBairro"));
                    bairro.setNome(resultSet.getString("nome"));
                    return bairro;
                }
            }
        }
        return null;
    }

    public List<Bairro> selecionarTodosBairros(Connection conexao) throws SQLException {
        String sql = """
            SELECT b.idBairro, b.nome AS bairroNome
            FROM bairro b
            ORDER BY b.nome;
            """;

        List<Bairro> bairros = new ArrayList<>();

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Bairro bairro = new Bairro();
                bairro.setIdBairro(resultSet.getInt("idBairro"));
                bairro.setNome(resultSet.getString("bairroNome"));
                bairros.add(bairro);
            }
        }
        return bairros;
    }
}