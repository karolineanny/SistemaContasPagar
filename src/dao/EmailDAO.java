package dao;

import model.EmailFornecedor;
import model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmailDAO {

    public static List<EmailFornecedor> selectTodosEmailPorIdFornecedor(Integer idFornecedor, Connection conexao) throws Exception {
        List<EmailFornecedor> emails = new ArrayList<>();
        String sql = "SELECT emailFornecedor, idFornecedor FROM emailfornecedor WHERE idFornecedor = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idFornecedor);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    EmailFornecedor emailFornecedor = new EmailFornecedor();
                    emailFornecedor.setEmailFornecedor(rs.getString("emailFornecedor"));

                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
                    emailFornecedor.setFornecedor(fornecedor);

                    emails.add(emailFornecedor);
                }
            }
        } catch (Exception e) {
            throw new Exception("Erro ao buscar emails do fornecedor pelo ID: " + idFornecedor, e);
        }

        return emails;
    }

    public static void insertEmailsFornecedor(Fornecedor fornecedor, List<EmailFornecedor> emails, Connection conexao) throws Exception {
        String sql = "INSERT INTO emailfornecedor (emailFornecedor, idFornecedor) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            for (EmailFornecedor email : emails) {
                stmt.setString(1, email.getEmailFornecedor());
                stmt.setInt(2, fornecedor.getIdFornecedor());
                stmt.addBatch();
            }
            stmt.executeBatch();
        } catch (Exception e) {
            throw new Exception("Erro ao inserir emails para o fornecedor com ID: " + fornecedor.getIdFornecedor(), e);
        }
    }

    public static EmailFornecedor selecionarEmailFornecedorPorEmail(String email, Connection conexao) throws Exception {
        String sql = "SELECT emailFornecedor, idFornecedor FROM emailfornecedor WHERE emailFornecedor = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    EmailFornecedor emailFornecedor = new EmailFornecedor();
                    emailFornecedor.setEmailFornecedor(rs.getString("emailFornecedor"));

                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
                    emailFornecedor.setFornecedor(fornecedor);

                    return emailFornecedor;
                }
            }
        } catch (Exception e) {
            throw new Exception("Erro ao buscar email do fornecedor: " + email, e);
        }
        return null;
    }
}