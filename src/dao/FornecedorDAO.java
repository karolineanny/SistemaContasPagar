package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Fornecedor;

public class FornecedorDAO {

    public Fornecedor inserirFornecedor(Fornecedor fornecedor, Connection conexao) throws SQLException {
        String sql = "INSERT INTO fornecedor (cnpjFornecedor, nomeFornecedor, idEndereco, complementoEndereco, numeroEndereco, saldoPagar) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING idFornecedor";

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, fornecedor.getCnpjFornecedor());
            preparedStatement.setString(2, fornecedor.getNomeFornecedor());
            preparedStatement.setInt(3, fornecedor.getIdEndereco());
            preparedStatement.setString(4, fornecedor.getComplementoEndereco());
            preparedStatement.setString(5, fornecedor.getNumeroEndereco());
            preparedStatement.setBigDecimal(6, fornecedor.getSaldoPagar());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    fornecedor.setIdFornecedor(resultSet.getInt("idFornecedor"));
                    return fornecedor;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Fornecedor: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return null;
    }

    public Fornecedor selecionarFornecedorPorId(Integer id, Connection conexao) throws SQLException {
        String sql = "SELECT idFornecedor, cnpjFornecedor, nomeFornecedor, idEndereco, complementoEndereco, numeroEndereco, saldoPagar " +
                "FROM fornecedor WHERE idFornecedor = ?";

        Fornecedor fornecedor = null;
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    fornecedor = new Fornecedor();
                    fornecedor.setIdFornecedor(resultSet.getInt("idFornecedor"));
                    fornecedor.setCnpjFornecedor(resultSet.getString("cnpjFornecedor"));
                    fornecedor.setNomeFornecedor(resultSet.getString("nomeFornecedor"));
                    fornecedor.setIdEndereco(resultSet.getInt("idEndereco"));
                    fornecedor.setComplementoEndereco(resultSet.getString("complementoEndereco"));
                    fornecedor.setNumeroEndereco(resultSet.getString("numeroEndereco"));
                    fornecedor.setSaldoPagar(resultSet.getBigDecimal("saldoPagar"));
                }
            }
        }
        return fornecedor;
    }

    public Fornecedor selecionarFornecedorPorCNPJ(String cnpj, Connection conexao) throws SQLException {
        String sql = "SELECT idFornecedor, cnpjfornecedor, nomefornecedor, idEndereco, complementoEndereco, numeroEndereco, saldoPagar " +
                "FROM fornecedor WHERE cnpj_fornecedor = ?";

        Fornecedor fornecedor = null;
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, cnpj);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    fornecedor = new Fornecedor();
                    fornecedor.setIdFornecedor(resultSet.getInt("idFornecedor"));
                    fornecedor.setCnpjFornecedor(resultSet.getString("cnpjFornecedor"));
                    fornecedor.setNomeFornecedor(resultSet.getString("nomeFornecedor"));
                    fornecedor.setIdEndereco(resultSet.getInt("idEndereco"));
                    fornecedor.setComplementoEndereco(resultSet.getString("complementoEndereco"));
                    fornecedor.setNumeroEndereco(resultSet.getString("numeroEndereco"));
                    fornecedor.setSaldoPagar(resultSet.getBigDecimal("saldoPagar"));
                }
            }
        }
        return fornecedor;
    }
}