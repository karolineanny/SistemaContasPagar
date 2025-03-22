package dao;

import model.TelefoneFornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TelefoneDAO {

    public TelefoneFornecedor selecionarTelefoneFornecedorPorNumero(String numero, Connection conexao) throws Exception {
        String sql = "SELECT numeroTelefone, numeroDDD, numeroDDI, idFornecedor " +
                "FROM telefonefornecedor " +
                "WHERE numeroTelefone = ?";

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, numero);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    TelefoneFornecedor telefone = new TelefoneFornecedor();
                    telefone.setNumeroTelefone(resultSet.getString("numeroTelefone"));
                    telefone.setNumeroDDD(resultSet.getString("numeroDDD"));
                    telefone.setNumeroDDI(resultSet.getString("numeroDDI"));
                    telefone.setIdFornecedor(resultSet.getInt("idFornecedor"));
                    return telefone;
                }
            }
        }
        return null;
    }

    public void inserirTelefonesFornecedor(Integer idFornecedor, List<TelefoneFornecedor> telefones, Connection conexao) throws Exception {
        String sql = "INSERT INTO telefonefornecedor (numeroTelefone, numeroDDD, numeroDDI, idFornecedor) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            for (TelefoneFornecedor telefone : telefones) {
                preparedStatement.setString(1, telefone.getNumeroTelefone());
                preparedStatement.setString(2, telefone.getNumeroDDD());
                preparedStatement.setString(3, telefone.getNumeroDDI());
                preparedStatement.setInt(4, idFornecedor);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }
    }

    public List<TelefoneFornecedor> selecionarTelefonesFornecedor(Integer idFornecedor, Connection conexao) throws Exception {
        String sql = "SELECT numeroTelefone, numeroDDD, numeroDDI, idFornecedor " +
                "FROM telefonefornecedor " +
                "WHERE idFornecedor = ?";
        List<TelefoneFornecedor> telefones = new ArrayList<>();

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, idFornecedor);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    TelefoneFornecedor telefone = new TelefoneFornecedor();
                    telefone.setNumeroTelefone(resultSet.getString("numeroTelefone"));
                    telefone.setNumeroDDD(resultSet.getString("numeroDDD"));
                    telefone.setNumeroDDI(resultSet.getString("numeroDDI"));
                    telefone.setIdFornecedor(resultSet.getInt("idFornecedor"));
                    telefones.add(telefone);
                }
            }
        }
        return telefones;
    }
}