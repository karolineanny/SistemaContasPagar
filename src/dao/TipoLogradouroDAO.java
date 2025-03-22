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
            SELECT tl.siglaTipoLogradouro, tl.nomeTipoLogradouro
            FROM tipologradouro tl
            ORDER BY tl.nomeTipoLogradouro;
        """;

        List<TipoLogradouro> tiposLogradouro = new ArrayList<>();

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                TipoLogradouro tipoLogradouro = new TipoLogradouro();
                tipoLogradouro.setSiglaTipoLogradouro(resultSet.getString("siglaTipoLogradouro"));
                tipoLogradouro.setNomeTipoLogradouro(resultSet.getString("nomeTipoLogradouro"));
                tiposLogradouro.add(tipoLogradouro);
            }
        }

        return tiposLogradouro;
    }
}