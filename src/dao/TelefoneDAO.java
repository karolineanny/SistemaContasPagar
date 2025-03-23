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
        String sql = "SELECT numero_telefone, numero_ddd, numero_ddi, id_fornecedor " +
                "FROM telefone_fornecedor " +
                "WHERE numero_telefone = ?";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, numero);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    TelefoneFornecedor telefone = new TelefoneFornecedor();
                    telefone.setNumeroTelefone(resultSet.getString("numero_telefone"));

                    DDD ddd = new DDD();
                    ddd.setNumeroDDD(resultSet.getString("numero_ddd"));
                    telefone.setDdd(ddd);

                    DDI ddi = new DDI();
                    ddi.setNumeroDDI(resultSet.getString("numero_ddi"));
                    telefone.setDdi(ddi);

                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setIdFornecedor(resultSet.getInt("id_fornecedor"));
                    telefone.setFornecedor(fornecedor);

                    return telefone;
                }
            }
        }
        return null;
    }

    public void inserirTelefonesFornecedor(Fornecedor fornecedor, List<TelefoneFornecedor> telefones, Connection conexao) throws Exception {
        String sql = "INSERT INTO telefone_fornecedor (numero_telefone, numero_ddd, numero_ddi, id_fornecedor) VALUES (?, ?, ?, ?)";
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
        String sql = "SELECT numero_telefone, numero_ddd, numero_ddi, id_fornecedor " +
                "FROM telefone_fornecedor " +
                "WHERE id_fornecedor = ?";
        List<TelefoneFornecedor> telefones = new ArrayList<>();
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, fornecedor.getIdFornecedor());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    TelefoneFornecedor telefone = new TelefoneFornecedor();
                    telefone.setNumeroTelefone(resultSet.getString("numero_telefone"));

                    DDD ddd = new DDD();
                    ddd.setNumeroDDD(resultSet.getString("numero_ddd"));
                    telefone.setDdd(ddd);

                    DDI ddi = new DDI();
                    ddi.setNumeroDDI(resultSet.getString("numero_ddi"));
                    telefone.setDdi(ddi);

                    telefone.setFornecedor(fornecedor);
                    telefones.add(telefone);
                }
            }
        }
        return telefones;
    }

    public List<TelefoneFornecedor> selecionarFornecedorPorIdComTelefoneCompleto(Integer idFornecedor, Connection conn) throws Exception {
        String sql = """
                    SELECT 
                        (tf.telefone).numero AS numero_telefone,
                        (tf.telefone).ddd AS ddd,
                        (tf.telefone).ddi AS ddi,
                        f.id_fornecedor,
                        f.nome_fornecedor,
                        f.cnpj_fornecedor,
                        f.saldo_pagar
                    FROM telefone_fornecedor_com_tipo tf
                    JOIN fornecedor f ON f.id_fornecedor = tf.id_fornecedor
                    WHERE f.id_fornecedor = ?
                """;

        List<TelefoneFornecedor> telefones = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFornecedor);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TelefoneFornecedor tel = new TelefoneFornecedor();
                tel.setNumeroTelefone(rs.getString("numero_telefone"));

                DDD ddd = new DDD();
                ddd.setNumeroDDD(rs.getString("ddd"));
                tel.setDdd(ddd);

                DDI ddi = new DDI();
                ddi.setNumeroDDI(rs.getString("ddi"));
                tel.setDdi(ddi);

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
                fornecedor.setNomeFornecedor(rs.getString("nome_fornecedor"));
                fornecedor.setCnpjFornecedor(rs.getString("cnpj_fornecedor"));
                fornecedor.setSaldoPagar(rs.getBigDecimal("saldo_pagar"));
                tel.setFornecedor(fornecedor);

                telefones.add(tel);
            }
        }

        return telefones;
    }
}