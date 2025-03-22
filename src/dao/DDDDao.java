package dao;

import model.DDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DDDDao {

    public static DDD selectDDDPorNumero(String numero, Connection conexao) throws Exception {
        String sql = "SELECT numeroDdd FROM ddd WHERE numeroDdd = ?";

        try (PreparedStatement cmd = conexao.prepareStatement(sql)) {
            cmd.setString(1, numero);
            try (ResultSet result = cmd.executeQuery()) {
                if (result.next()) {
                    return new DDD(result.getString("numeroDdd"));
                }
            }
        } catch (Exception e) {
            throw new Exception("Erro ao buscar DDD pelo número: " + numero, e);
        }

        return null;
    }

    public static List<DDD> selecionarTodosDDD(Connection conexao) throws Exception {
        List<DDD> dddList = new ArrayList<>();
        String sql = "SELECT * FROM ddd;";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                DDD ddd = new DDD(rs.getString("numeroDdd"));
                dddList.add(ddd);
            }
        } catch (Exception e) {
            throw new Exception("Erro ao buscar DDDs", e);
        }

        return dddList;
    }
}