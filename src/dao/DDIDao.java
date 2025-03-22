package dao;

import model.DDI;
import apoio.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DDIDao {
    public static DDI selectDDIPorNumero(String numero) throws Exception {
        String sql = "SELECT numeroDDI FROM ddi WHERE numeroDDI = ?";

        try (Connection conn = new ConexaoBD().getConexaoComBD();
             PreparedStatement cmd = conn.prepareStatement(sql)) {

            cmd.setString(1, numero);
            try (ResultSet result = cmd.executeQuery()) {
                if (result.next()) {
                    return new DDI(result.getString("numeroDDI"));
                }
            }

        } catch (Exception e) {
            throw new Exception("Erro ao buscar DDI pelo número: " + numero, e);
        }

        return null;
    }

    public static List<DDI> selecionarTodosDDI() throws Exception {
        List<DDI> ddiList = new ArrayList<>();
        String sql = "SELECT * FROM ddi;";

        try (Connection conn = new ConexaoBD().getConexaoComBD();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    DDI ddi = new DDI(rs.getString("numeroDDI"));
                    ddiList.add(ddi);
                }
            }

        } catch (Exception e) {
            throw new Exception("Erro ao buscar DDIs", e);
        }

        return ddiList;
    }
}