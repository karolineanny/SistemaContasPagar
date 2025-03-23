package dao;

import model.Endereco;
import model.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FornecedorDAO {

    public Fornecedor inserirFornecedor(Fornecedor fornecedor, Connection conexao) throws SQLException {
        String sql = "INSERT INTO fornecedor (cnpj_fornecedor, nome_fornecedor, id_endereco, saldo_pagar) " +
                "VALUES (?, ?, ?, ?) RETURNING idFornecedor";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, fornecedor.getCnpjFornecedor());
            preparedStatement.setString(2, fornecedor.getNomeFornecedor());
            preparedStatement.setInt(3, fornecedor.getEndereco().getIdEndereco());
            preparedStatement.setBigDecimal(4, fornecedor.getSaldoPagar());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    fornecedor.setIdFornecedor(resultSet.getInt("id_fornecedor"));
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
        String sql = "SELECT id_fornecedor, cnpj_fornecedor, nome_fornecedor, id_endereco, saldo_pagar " +
                "FROM fornecedor WHERE id_fornecedor = ?";
        Fornecedor fornecedor = null;
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    fornecedor = new Fornecedor();
                    fornecedor.setIdFornecedor(resultSet.getInt("id_fornecedor"));
                    fornecedor.setCnpjFornecedor(resultSet.getString("cnpj_fornecedor"));
                    fornecedor.setNomeFornecedor(resultSet.getString("nome_fornecedor"));

                    Endereco endereco = new Endereco();
                    endereco.setIdEndereco(resultSet.getInt("id_endereco"));
                    fornecedor.setEndereco(endereco);

                    fornecedor.setSaldoPagar(resultSet.getBigDecimal("saldo_pagar"));
                }
            }
        }
        return fornecedor;
    }

    public Fornecedor selecionarFornecedorPorCNPJ(String cnpj, Connection conexao) throws SQLException {
        String sql = "SELECT id_fornecedor, cnpj_fornecedor, nome_fornecedor, id_endereco, saldo_pagar " +
                "FROM fornecedor WHERE cnpj_fornecedor = ?";
        Fornecedor fornecedor = null;
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, cnpj);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    fornecedor = new Fornecedor();
                    fornecedor.setIdFornecedor(resultSet.getInt("id_fornecedor"));
                    fornecedor.setCnpjFornecedor(resultSet.getString("cnpj_fornecedor"));
                    fornecedor.setNomeFornecedor(resultSet.getString("nome_fornecedor"));

                    Endereco endereco = new Endereco();
                    endereco.setIdEndereco(resultSet.getInt("id_endereco"));
                    fornecedor.setEndereco(endereco);

                    fornecedor.setSaldoPagar(resultSet.getBigDecimal("saldo_pagar"));
                }
            }
        }
        return fornecedor;
    }

    public void inserirTelefoneCompleto(int idFornecedor, String numero, String ddd, String ddi, Connection conn) throws Exception {
        String sql = "INSERT INTO telefone_fornecedor_com_tipo (id_fornecedor, telefone) VALUES (?, ROW(?, ?, ?))";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFornecedor);
            ps.setString(2, numero);
            ps.setString(3, ddd);
            ps.setString(4, ddi);
            ps.executeUpdate();
        }
    }

    public void atualizarNomeFornecedor(int idFornecedor, String novoNome, Connection conexao) throws SQLException {
        String sql = "UPDATE fornecedor SET nome_fornecedor = ? WHERE id_fornecedor = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, novoNome);
            stmt.setInt(2, idFornecedor);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Nenhum fornecedor encontrado com o ID " + idFornecedor);
            }
        }
    }

}