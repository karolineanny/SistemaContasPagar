package dao;

import model.TipoLogradouro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoLogradouroDAO {

    public List<TipoLogradouro> selecionarTodosTiposLogradouro(Connection conexao) throws SQLException {
        String sql = """
            SELECT tl.sigla_tipo_logradouro, tl.nome_tipo_logradouro
            FROM tipo_logradouro tl
            ORDER BY tl.nome_tipo_logradouro;
        """;

        List<TipoLogradouro> tiposLogradouro = new ArrayList<>();

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                TipoLogradouro tipoLogradouro = new TipoLogradouro();
                tipoLogradouro.setSiglaTipoLogradouro(resultSet.getString("sigla_tipo_logradouro"));
                tipoLogradouro.setNomeTipoLogradouro(resultSet.getString("nome_tipo_logradouro"));
                tiposLogradouro.add(tipoLogradouro);
            }
        }

        return tiposLogradouro;
    }
}