package dao;

import model.EmailFornecedor;
import model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmailDAO {

    public static List<EmailFornecedor> selectTodosEmailPorFornecedor(Fornecedor fornecedor, Connection conexao) throws Exception {
        List<EmailFornecedor> emails = new ArrayList<>();
        String sql = "SELECT email_fornecedor, id_fornecedor FROM email_fornecedor WHERE id_fornecedor = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, fornecedor.getIdFornecedor());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    EmailFornecedor emailFornecedor = new EmailFornecedor();
                    emailFornecedor.setEmailFornecedor(rs.getString("email_fornecedor"));
                    emailFornecedor.setFornecedor(fornecedor);
                    emails.add(emailFornecedor);
                }
            }
        } catch (Exception e) {
            throw new Exception("Erro ao buscar emails do fornecedor com ID: " + fornecedor.getIdFornecedor(), e);
        }

        return emails;
    }

    public static void insertEmailsFornecedor(Fornecedor fornecedor, List<EmailFornecedor> emails, Connection conexao) throws Exception {
        String sql = "INSERT INTO email_fornecedor (email_fornecedor, id_fornecedor) VALUES (?, ?)";
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
        String sql = "SELECT email_fornecedor, id_fornecedor FROM email_fornecedor WHERE email_fornecedor = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    EmailFornecedor emailFornecedor = new EmailFornecedor();
                    emailFornecedor.setEmailFornecedor(rs.getString("email_fornecedor"));
                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
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