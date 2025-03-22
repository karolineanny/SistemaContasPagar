package dao;

import model.DDD;
import apoio.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DDDDao {

    public static DDD selectDDDPorNumero(String numero) throws Exception { // agora é String
        String sql = "SELECT numero_ddd FROM ddd WHERE numero_ddd = ?";

        try (Connection conn = new ConexaoBD().getConexaoComBD();
             PreparedStatement cmd = conn.prepareStatement(sql)) {

            cmd.setString(1, numero);
            try (ResultSet result = cmd.executeQuery()) {
                if (result.next()) {
                    return new DDD(result.getString("numero_ddd"));
                }
            }

        } catch (Exception e) {
            throw new Exception("Erro ao buscar DDD pelo número: " + numero, e);
        }

        return null;
    }

    public static List<DDD> selecionarTodosDDD() throws Exception {
        List<DDD> dddList = new ArrayList<>();
        String sql = "SELECT * FROM ddd;";

        try (Connection conn = new ConexaoBD().getConexaoComBD();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                DDD ddd = new DDD(rs.getString("numero_ddd")); // utilizar getString
                dddList.add(ddd);
            }

        } catch (Exception e) {
            throw new Exception("Erro ao buscar DDDs", e);
        }

        return dddList;
    }
}