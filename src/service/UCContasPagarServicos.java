package service;

import col.FaturaCOL;
import col.FornecedorCOL;
import col.MotivoFaturaCOL;
import dao.EmailDAO;
import dao.FaturaDAO;
import dao.FornecedorDAO;
import dao.MotivoFaturaDAO;
import dao.TelefoneDAO;
import apoio.ConexaoBD;
import model.EmailFornecedor;
import model.Fatura;
import model.Fornecedor;
import model.MotivoFatura;
import model.ResumoDespesa;
import model.TelefoneFornecedor;

import java.sql.Connection;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class UCContasPagarServicos {

    private FaturaCOL faturaCOL;
    private FornecedorCOL fornecedorCOL;
    private MotivoFaturaCOL motivoFaturaCOL;

    private FaturaDAO faturaDAO;
    private FornecedorDAO fornecedorDAO;
    private MotivoFaturaDAO motivoFaturaDAO;
    private EmailDAO emailDAO;
    private TelefoneDAO telefoneDAO;

    public UCContasPagarServicos() {
        this.faturaCOL = new FaturaCOL();
        this.fornecedorCOL = new FornecedorCOL();
        this.motivoFaturaCOL = new MotivoFaturaCOL();

        this.faturaDAO = new FaturaDAO();
        this.fornecedorDAO = new FornecedorDAO();
        this.motivoFaturaDAO = new MotivoFaturaDAO();
        this.emailDAO = new EmailDAO();
        this.telefoneDAO = new TelefoneDAO();
    }

    public Fatura cadastrarFatura(Fatura fatura) throws Exception {
        if (!FaturaCOL.faturaValida(fatura)) {
            throw new Exception("Fatura inválida!");
        }

        try (Connection conn = new ConexaoBD().getConexaoComBD()) {
            conn.setAutoCommit(false);
            try {
                Fornecedor fornecedor = fornecedorDAO.selecionarFornecedorPorId(fatura.getFornecedor().getIdFornecedor(), conn);
                if (fornecedor == null) {
                    throw new Exception("Fornecedor inexistente com id " + fatura.getFornecedor().getIdFornecedor());
                }

                MotivoFatura motivo = motivoFaturaDAO.selecionarMotivoFaturaPorId(fatura.getMotivoFatura().getIdMotivoFatura(), conn);
                if (motivo == null) {
                    throw new Exception("Motivo de Fatura inexistente com id " + fatura.getMotivoFatura().getIdMotivoFatura());
                }

                fatura.setFornecedor(fornecedor);
                fatura.setMotivoFatura(motivo);

                Fatura faturaCriada = faturaDAO.inserirFatura(fatura, conn);
                conn.commit();
                return faturaCriada;
            } catch (Exception e) {
                conn.rollback();
                throw new Exception("Erro ao cadastrar fatura: " + e.getMessage(), e);
            }
        }
    }

    public Fatura consultarFaturaPorNumero(Integer numeroFatura) throws Exception {
        if (numeroFatura == null || numeroFatura <= 0) {
            throw new Exception("Número da fatura inválido!");
        }
        try (Connection conn = new ConexaoBD().getConexaoComBD()) {
            conn.setAutoCommit(false);
            try {
                Fatura fatura = faturaDAO.selecionarFaturaPorNumero(numeroFatura, conn);
                conn.commit();
                return fatura;
            } catch (Exception e) {
                conn.rollback();
                throw new Exception("Erro ao consultar fatura Nº " + numeroFatura, e);
            }
        }
    }

    public List<Fatura> obterListaDeFaturas() throws Exception {
        try (Connection conn = new ConexaoBD().getConexaoComBD()) {
            conn.setAutoCommit(false);
            try {
                List<Fatura> lista = faturaDAO.selecionarTodasFaturas(conn);
                conn.commit();
                return lista;
            } catch (Exception e) {
                conn.rollback();
                throw new Exception("Erro ao listar faturas.", e);
            }
        }
    }

    public List<Fatura> consultarFaturasPorFornecedor(Integer idFornecedor) throws Exception {
        if (idFornecedor == null || idFornecedor <= 0) {
            throw new Exception("ID de Fornecedor inválido!");
        }
        try (Connection conn = new ConexaoBD().getConexaoComBD()) {
            conn.setAutoCommit(false);
            try {
                Fornecedor fornecedor = fornecedorDAO.selecionarFornecedorPorId(idFornecedor, conn);
                if (fornecedor == null) {
                    throw new Exception("Fornecedor inexistente com ID: " + idFornecedor);
                }
                List<Fatura> faturas = faturaDAO.selecionarFaturasPorFornecedor(fornecedor, conn);
                conn.commit();
                return faturas;
            } catch (Exception e) {
                conn.rollback();
                throw new Exception("Erro ao consultar faturas do fornecedor ID: " + idFornecedor, e);
            }
        }
    }

    public Fornecedor consultarFornecedorPorId(Integer idFornecedor) throws Exception {
        if (idFornecedor == null || idFornecedor <= 0) {
            throw new Exception("ID de Fornecedor inválido!");
        }
        try (Connection conn = new ConexaoBD().getConexaoComBD()) {
            conn.setAutoCommit(false);
            try {
                Fornecedor fornecedor = fornecedorDAO.selecionarFornecedorPorId(idFornecedor, conn);
                conn.commit();
                return fornecedor;
            } catch (Exception e) {
                conn.rollback();
                throw new Exception("Erro ao consultar fornecedor ID: " + idFornecedor, e);
            }
        }
    }

    public MotivoFatura consultarMotivoFaturaPorId(Integer idMotivo) throws Exception {
        if (idMotivo == null || idMotivo <= 0) {
            throw new Exception("ID de MotivoFatura inválido!");
        }
        try (Connection conn = new ConexaoBD().getConexaoComBD()) {
            conn.setAutoCommit(false);
            try {
                MotivoFatura mf = motivoFaturaDAO.selecionarMotivoFaturaPorId(idMotivo, conn);
                conn.commit();
                return mf;
            } catch (Exception e) {
                conn.rollback();
                throw new Exception("Erro ao consultar motivo fatura ID: " + idMotivo, e);
            }
        }
    }

    public List<EmailFornecedor> consultarEmailsFornecedor(Integer idFornecedor) throws Exception {
        if (idFornecedor == null || idFornecedor <= 0) {
            throw new Exception("ID de Fornecedor inválido para emails!");
        }
        try (Connection conn = new ConexaoBD().getConexaoComBD()) {
            conn.setAutoCommit(false);
            try {
                Fornecedor fornecedor = fornecedorDAO.selecionarFornecedorPorId(idFornecedor, conn);
                if (fornecedor == null) {
                    throw new Exception("Fornecedor inexistente com ID " + idFornecedor);
                }
                List<EmailFornecedor> emails = emailDAO.selectTodosEmailPorFornecedor(fornecedor, conn);
                conn.commit();
                return emails;
            } catch (Exception e) {
                conn.rollback();
                throw new Exception("Erro ao consultar emails para o fornecedor ID: " + idFornecedor, e);
            }
        }
    }

    public List<TelefoneFornecedor> consultarTelefonesFornecedor(Integer idFornecedor) throws Exception {
        if (idFornecedor == null || idFornecedor <= 0) {
            throw new Exception("ID de Fornecedor inválido para telefones!");
        }
        try (Connection conn = new ConexaoBD().getConexaoComBD()) {
            conn.setAutoCommit(false);
            try {
                Fornecedor fornecedor = fornecedorDAO.selecionarFornecedorPorId(idFornecedor, conn);
                if (fornecedor == null) {
                    throw new Exception("Fornecedor inexistente com ID " + idFornecedor);
                }
                List<TelefoneFornecedor> tels = telefoneDAO.selecionarTelefonesFornecedor(fornecedor, conn);
                conn.commit();
                return tels;
            } catch (Exception e) {
                conn.rollback();
                throw new Exception("Erro ao consultar telefones para o fornecedor ID: " + idFornecedor, e);
            }
        }
    }

    public List<ResumoDespesa> consultarTotaisPorTipoDespesa(LocalDate dataInicio, LocalDate dataFim) throws Exception {
        if (dataInicio == null || dataFim == null || dataFim.isBefore(dataInicio)) {
            throw new Exception("Período inválido!");
        }
        try (Connection conn = new ConexaoBD().getConexaoComBD()) {
            conn.setAutoCommit(false);
            try {
                List<ResumoDespesa> lista = faturaDAO.listarTotaisPorMotivoFatura(dataInicio, dataFim, conn);
                conn.commit();
                return lista;
            } catch (Exception e) {
                conn.rollback();
                throw new Exception("Erro ao consultar totais por tipo de despesa no período.", e);
            }
        }
    }

    public static void main(String[] args) {
        UCContasPagarServicos service = new UCContasPagarServicos();
        try {
            Fatura novaFatura = new Fatura();
            novaFatura.setNumeroFatura(null);
            novaFatura.setDataLancamento(LocalDate.now());
            novaFatura.setDataVencimento(LocalDate.now().plusDays(10));

            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setIdFornecedor(1);
            novaFatura.setFornecedor(fornecedor);

            MotivoFatura motivo = new MotivoFatura();
            motivo.setIdMotivoFatura(1);
            novaFatura.setMotivoFatura(motivo);

            novaFatura.setValorTotal(new BigDecimal("1500.00"));
            novaFatura.setSaldo(new BigDecimal("1500.00"));

            Fatura faturaCadastrada = service.cadastrarFatura(novaFatura);
            if (faturaCadastrada != null) {
                System.out.println("Fatura cadastrada! Nº gerado: " + faturaCadastrada.getNumeroFatura());
            }

            Fatura faturaBuscada = service.consultarFaturaPorNumero(faturaCadastrada.getNumeroFatura());
            if (faturaBuscada != null) {
                System.out.println("Fatura encontrada: " + faturaBuscada);
            }

            List<Fatura> todasFaturas = service.obterListaDeFaturas();
            System.out.println("Lista de faturas: " + todasFaturas);

            List<Fatura> faturasFornecedor = service.consultarFaturasPorFornecedor(1);
            System.out.println("Faturas do fornecedor 1: " + faturasFornecedor);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<TelefoneFornecedor> consultarFornecedorComTipoTelefoneCompleto(Integer idFornecedor) throws Exception {
        if (idFornecedor == null || idFornecedor <= 0) {
            throw new Exception("ID de Fornecedor inválido!");
        }

        try (Connection conn = new ConexaoBD().getConexaoComBD()) {
            conn.setAutoCommit(false);
            try {
                List<TelefoneFornecedor> telefoneFornecedorList = telefoneDAO.selecionarFornecedorPorIdComTelefoneCompleto(idFornecedor, conn);
                conn.commit();
                return telefoneFornecedorList;
            } catch (Exception e) {
                conn.rollback();
                throw new Exception("Erro ao consultar telefones completos do fornecedor " + idFornecedor, e);
            }
        }
    }

    public void adicionarTelefoneCompletoFornecedor(int idFornecedor, String numero, String ddd, String ddi) throws Exception {
        if (numero == null || numero.isBlank() || ddd == null || ddi == null) {
            throw new Exception("Dados do telefone inválidos.");
        }

        try (Connection conn = new ConexaoBD().getConexaoComBD()) {
            conn.setAutoCommit(false);
            try {
                fornecedorDAO.inserirTelefoneCompleto(idFornecedor, numero, ddd, ddi, conn);
                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                throw new Exception("Erro ao inserir telefone completo.", e);
            }
        }
    }

    public boolean removerFatura(int numeroFatura) throws Exception {
        if (numeroFatura <= 0) {
            throw new Exception("Número de fatura inválido.");
        }

        try (Connection conn = new ConexaoBD().getConexaoComBD()) {
            conn.setAutoCommit(false);
            try {
                boolean removido = faturaDAO.removerPorNumero(numeroFatura, conn);
                conn.commit();
                return removido;
            } catch (Exception e) {
                conn.rollback();
                throw new Exception("Erro ao remover fatura: " + numeroFatura, e);
            }
        }
    }

}