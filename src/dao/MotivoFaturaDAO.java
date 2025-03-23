package dao;

import model.MotivoFatura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotivoFaturaDAO {

    public MotivoFatura inserirMotivoFatura(MotivoFatura motivoFatura, Connection conexao) throws SQLException {
        String sql = "INSERT INTO motivo_fatura (descricao_motivo) VALUES (?) RETURNING id_motivo_fatura";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, motivoFatura.getDescricaoMotivo());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    motivoFatura.setIdMotivoFatura(rs.getInt("id_motivo_fatura"));
                    return motivoFatura;
                }
            }
        }
        return null;
    }

    public MotivoFatura selecionarMotivoFaturaPorId(Integer id, Connection conexao) throws SQLException {
        String sql = "SELECT id_motivo_fatura, descricao_motivo FROM motivo_fatura WHERE id_motivo_fatura = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    MotivoFatura motivoFatura = new MotivoFatura();
                    motivoFatura.setIdMotivoFatura(rs.getInt("id_motivo_fatura"));
                    motivoFatura.setDescricaoMotivo(rs.getString("descricao_motivo"));
                    return motivoFatura;
                }
            }
        }
        return null;
    }

    public List<MotivoFatura> selecionarTodosMotivosFatura(Connection conexao) throws SQLException {
        String sql = "SELECT id_motivo_fatura, descricao_motivo FROM motivo_fatura ORDER BY descricao_motivo";
        List<MotivoFatura> motivos = new ArrayList<>();
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                MotivoFatura motivoFatura = new MotivoFatura();
                motivoFatura.setIdMotivoFatura(rs.getInt("id_motivo_fatura"));
                motivoFatura.setDescricaoMotivo(rs.getString("descricao_motivo"));
                motivos.add(motivoFatura);
            }
        }
        return motivos;
    }
}