package dao;

import model.TelefoneFornecedor;
import model.DDD;
import model.DDI;
import model.Fornecedor;
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

                    DDD ddd = new DDD();
                    ddd.setNumeroDDD(resultSet.getString("numeroDDD"));
                    telefone.setDdd(ddd);

                    DDI ddi = new DDI();
                    ddi.setNumeroDDI(resultSet.getString("numeroDDI"));
                    telefone.setDdi(ddi);

                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setIdFornecedor(resultSet.getInt("idFornecedor"));
                    telefone.setFornecedor(fornecedor);

                    return telefone;
                }
            }
        }
        return null;
    }

    public void inserirTelefonesFornecedor(Fornecedor fornecedor, List<TelefoneFornecedor> telefones, Connection conexao) throws Exception {
        String sql = "INSERT INTO telefonefornecedor (numeroTelefone, numeroDDD, numeroDDI, idFornecedor) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            for (TelefoneFornecedor telefone : telefones) {
                preparedStatement.setString(1, telefone.getNumeroTelefone());
                preparedStatement.setString(2, telefone.getDdd().getNumeroDDD());
                preparedStatement.setString(3, telefone.getDdi().getNumeroDDI());
                preparedStatement.setInt(4, fornecedor.getIdFornecedor());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }
    }

    public List<TelefoneFornecedor> selecionarTelefonesFornecedor(Fornecedor fornecedor, Connection conexao) throws Exception {
        String sql = "SELECT numeroTelefone, numeroDDD, numeroDDI, idFornecedor " +
                "FROM telefonefornecedor " +
                "WHERE idFornecedor = ?";
        List<TelefoneFornecedor> telefones = new ArrayList<>();
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, fornecedor.getIdFornecedor());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    TelefoneFornecedor telefone = new TelefoneFornecedor();
                    telefone.setNumeroTelefone(resultSet.getString("numeroTelefone"));

                    DDD ddd = new DDD();
                    ddd.setNumeroDDD(resultSet.getString("numeroDDD"));
                    telefone.setDdd(ddd);

                    DDI ddi = new DDI();
                    ddi.setNumeroDDI(resultSet.getString("numeroDDI"));
                    telefone.setDdi(ddi);

                    telefone.setFornecedor(fornecedor);
                    telefones.add(telefone);
                }
            }
        }
        return telefones;
    }
}