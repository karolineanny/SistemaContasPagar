package dao;

import model.Fatura;
import model.Fornecedor;
import model.MotivoFatura;
import model.ResumoDespesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FaturaDAO {

    public Fatura inserirFatura(Fatura fatura, Connection conexao) throws SQLException {
        String sql = "INSERT INTO fatura (dataLancamento, dataVencimento, idFornecedor, idMotivoFatura, valorTotal, saldo) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setDate(1, Date.valueOf(fatura.getDataLancamento()));
            stmt.setDate(2, Date.valueOf(fatura.getDataVencimento()));
            stmt.setInt(3, fatura.getFornecedor().getIdFornecedor());
            stmt.setInt(4, fatura.getMotivoFatura().getIdMotivoFatura());
            stmt.setBigDecimal(5, fatura.getValorTotal());
            stmt.setBigDecimal(6, fatura.getSaldo());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Falha ao inserir fatura, nenhuma linha afetada.");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    fatura.setNumeroFatura(generatedKeys.getInt(1));
                    return fatura;
                } else {
                    throw new SQLException("Falha ao inserir fatura, nenhuma chave gerada.");
                }
            }
        }
    }

    public Fatura selecionarFaturaPorNumero(Integer numeroFatura, Connection conexao) throws SQLException {
        String sql = "SELECT numeroFatura, dataLancamento, dataVencimento, idFornecedor, idMotivoFatura, valorTotal, saldo " +
                "FROM fatura WHERE numeroFatura = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, numeroFatura);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Fatura fatura = new Fatura();
                    fatura.setNumeroFatura(rs.getInt("numeroFatura"));
                    fatura.setDataLancamento(rs.getDate("dataLancamento").toLocalDate());
                    fatura.setDataVencimento(rs.getDate("dataVencimento").toLocalDate());

                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
                    fatura.setFornecedor(fornecedor);

                    MotivoFatura motivo = new MotivoFatura();
                    motivo.setIdMotivoFatura(rs.getInt("idMotivoFatura"));
                    fatura.setMotivoFatura(motivo);

                    fatura.setValorTotal(rs.getBigDecimal("valorTotal"));
                    fatura.setSaldo(rs.getBigDecimal("saldo"));
                    return fatura;
                }
            }
        }
        return null;
    }

    public List<Fatura> selecionarTodasFaturas(Connection conexao) throws SQLException {
        String sql = "SELECT numeroFatura, dataLancamento, dataVencimento, idFornecedor, idMotivoFatura, valorTotal, saldo " +
                "FROM fatura ORDER BY dataLancamento";
        List<Fatura> faturas = new ArrayList<>();
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Fatura fatura = new Fatura();
                fatura.setNumeroFatura(rs.getInt("numeroFatura"));
                fatura.setDataLancamento(rs.getDate("dataLancamento").toLocalDate());
                fatura.setDataVencimento(rs.getDate("dataVencimento").toLocalDate());

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
                fatura.setFornecedor(fornecedor);

                MotivoFatura motivo = new MotivoFatura();
                motivo.setIdMotivoFatura(rs.getInt("idMotivoFatura"));
                fatura.setMotivoFatura(motivo);

                fatura.setValorTotal(rs.getBigDecimal("valorTotal"));
                fatura.setSaldo(rs.getBigDecimal("saldo"));
                faturas.add(fatura);
            }
        }
        return faturas;
    }

    public List<Fatura> selecionarFaturasPorFornecedor(Fornecedor fornecedor, Connection conexao) throws SQLException {
        String sql = "SELECT numeroFatura, dataLancamento, dataVencimento, idFornecedor, idMotivoFatura, valorTotal, saldo " +
                "FROM fatura WHERE idFornecedor = ? ORDER BY dataLancamento";
        List<Fatura> faturas = new ArrayList<>();
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, fornecedor.getIdFornecedor());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Fatura fatura = new Fatura();
                    fatura.setNumeroFatura(rs.getInt("numeroFatura"));
                    fatura.setDataLancamento(rs.getDate("dataLancamento").toLocalDate());
                    fatura.setDataVencimento(rs.getDate("dataVencimento").toLocalDate());
                    fatura.setFornecedor(fornecedor);

                    MotivoFatura motivo = new MotivoFatura();
                    motivo.setIdMotivoFatura(rs.getInt("idMotivoFatura"));
                    fatura.setMotivoFatura(motivo);

                    fatura.setValorTotal(rs.getBigDecimal("valorTotal"));
                    fatura.setSaldo(rs.getBigDecimal("saldo"));
                    faturas.add(fatura);
                }
            }
        }
        return faturas;
    }

    public List<ResumoDespesa> listarTotaisPorMotivoFatura(LocalDate dataInicio, LocalDate dataFim, Connection conexao) throws SQLException {
        String sql = """
            SELECT m.idMotivoFatura, m.descricaoMotivo, SUM(f.valorTotal) AS total
            FROM fatura f
            JOIN motivo_fatura m ON f.idMotivoFatura = m.idMotivoFatura
            WHERE f.dataLancamento >= ? AND f.dataLancamento <= ?
            GROUP BY m.idMotivoFatura, m.descricaoMotivo
            ORDER BY m.descricaoMotivo;
        """;
        List<ResumoDespesa> lista = new ArrayList<>();
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(dataInicio));
            ps.setDate(2, java.sql.Date.valueOf(dataFim));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    MotivoFatura motivo = new MotivoFatura();
                    motivo.setIdMotivoFatura(rs.getInt("idMotivoFatura"));
                    motivo.setDescricaoMotivo(rs.getString("descricaoMotivo"));
                    BigDecimal total = rs.getBigDecimal("total");
                    ResumoDespesa resumo = new ResumoDespesa(motivo, total);
                    lista.add(resumo);
                }
            }
        }
        return lista;
    }
}