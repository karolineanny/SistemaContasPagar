package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Endereco;

public class EnderecoDAO {

    public Endereco inserirEndereco(Endereco endereco, Connection conexao) {
        String sql = "INSERT INTO endereco (cep, idCidade, idLogradouro, idBairro) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, endereco.getCep());
            preparedStatement.setInt(2, endereco.getIdCidade());
            preparedStatement.setInt(3, endereco.getIdLogradouro());
            preparedStatement.setInt(4, endereco.getIdBairro());

            preparedStatement.executeUpdate();
            try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    endereco.setIdEndereco(rs.getInt(1));
                    return endereco;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Endereco: " + e.getMessage(), e);
        }
        return null;
    }

    public List<Endereco> selecionarEnderecosPorCep(String cep, Connection conexao) throws SQLException {
        String sql = "SELECT idEndereco, cep, idCidade, idLogradouro, idBairro FROM endereco WHERE cep = ?";
        List<Endereco> enderecos = new ArrayList<>();

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, cep);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Endereco endereco = new Endereco();
                    endereco.setIdEndereco(rs.getInt("idEndereco"));
                    endereco.setCep(rs.getString("cep"));
                    endereco.setIdCidade(rs.getInt("idCidade"));
                    endereco.setIdLogradouro(rs.getInt("idLogradouro"));
                    endereco.setIdBairro(rs.getInt("idBairro"));
                    enderecos.add(endereco);
                }
            }
        }
        return enderecos;
    }

    public Endereco selecionarEnderecoPorId(Long id, Connection conexao) throws SQLException {
        String sql = "SELECT idEndereco, cep, idCidade, idLogradouro, idBairro FROM endereco WHERE idEndereco = ?";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    Endereco endereco = new Endereco();
                    endereco.setIdEndereco(rs.getInt("idEndereco"));
                    endereco.setCep(rs.getString("cep"));
                    endereco.setIdCidade(rs.getInt("idCidade"));
                    endereco.setIdLogradouro(rs.getInt("idLogradouro"));
                    endereco.setIdBairro(rs.getInt("idBairro"));
                    return endereco;
                }
            }
        }
        return null;
    }

    public List<Endereco> selecionarTodosEnderecos(Connection conexao) throws SQLException {
        String sql = "SELECT idEndereco, cep, idCidade, idLogradouro, idBairro FROM endereco";
        List<Endereco> enderecos = new ArrayList<>();

        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setIdEndereco(rs.getInt("idEndereco"));
                endereco.setCep(rs.getString("cep"));
                endereco.setIdCidade(rs.getInt("idCidade"));
                endereco.setIdLogradouro(rs.getInt("idLogradouro"));
                endereco.setIdBairro(rs.getInt("idBairro"));
                enderecos.add(endereco);
            }
        }
        return enderecos;
    }
}