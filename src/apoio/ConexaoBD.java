package apoio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    // Outros usuários
    // usuario_admin, usuario_leitor, usuario_insercao

    private static final String URL = "jdbc:postgresql://localhost:5432/bd_contas";
    private static final String USER = "usuario_insercao";
    private static final String PASSWORD = "insercao";

    public Connection getConexaoComBD() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do Postgresql não encontrado.", e);
        }
    }
}