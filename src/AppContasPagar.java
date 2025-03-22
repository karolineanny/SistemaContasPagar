import service.UCContasPagarServicos;
import model.Fatura;
import model.Fornecedor;
import model.MotivoFatura;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AppContasPagar {

    public static void main(String[] args) {
        UCContasPagarServicos service = new UCContasPagarServicos();
        Scanner scanner = new Scanner(System.in);

        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== SISTEMA DE CONTAS A PAGAR ===");
            System.out.println("1. Consultar faturas de um fornecedor");
            System.out.println("2. Lançar nova fatura para um fornecedor");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opc = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opc) {
                    case 1:
                        telaConsultarFaturasFornecedor(service, scanner);
                        break;
                    case 2:
                        telaLancarFatura(service, scanner);
                        break;
                    case 0:
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.err.println("Ocorreu um erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        scanner.close();
    }

    private static void telaConsultarFaturasFornecedor(UCContasPagarServicos service, Scanner scanner) throws Exception {
        System.out.print("Digite o ID do Fornecedor: ");
        int idFornecedor = scanner.nextInt();
        scanner.nextLine();

        Fornecedor fornecedor = service.consultarFornecedorPorId(idFornecedor);
        if (fornecedor == null) {
            System.out.println("Fornecedor inexistente para o ID informado.");
            return;
        }

        List<Fatura> faturas = service.consultarFaturasPorFornecedor(idFornecedor);

        BigDecimal saldoTotal = BigDecimal.ZERO;
        for (Fatura f : faturas) {
            if (f.getSaldo() != null) {
                saldoTotal = saldoTotal.add(f.getSaldo());
            }
        }

        System.out.println("\n=== Consulta das Faturas a Pagar de um Fornecedor ===");
        System.out.println("Fornecedor: " + fornecedor.getNomeFornecedor());
        System.out.println("CNPJ: " + fornecedor.getCnpjFornecedor());
        System.out.println("Saldo a Pagar (somatório das faturas): R$ " + saldoTotal);

        if (faturas.isEmpty()) {
            System.out.println("Nenhuma fatura encontrada para esse fornecedor.");
        } else {
            System.out.println("\nNro. Fatura            | Motivo                   | Vencimento           | Valor           | Saldo        |");
            System.out.println("-----------------------------------------------------------------------------------------------------------");

            for (Fatura f : faturas) {
                MotivoFatura motivo = service.consultarMotivoFaturaPorId(f.getIdMotivoFatura());
                String descMotivo = (motivo != null ? motivo.getDescricaoMotivo() : ("ID=" + f.getIdMotivoFatura()));

                System.out.printf("%-22d | %-24s | %-20s | R$ %-12.2f | R$ %-12.2f\n",
                        f.getNumeroFatura(),
                        descMotivo,
                        f.getDataVencimento(),
                        f.getValorTotal(),
                        f.getSaldo()
                );
            }
        }
    }

    private static void telaLancarFatura(UCContasPagarServicos service, Scanner scanner) throws Exception {
        System.out.println("\n=== Lançar Nova Fatura ===");

        System.out.print("ID do Fornecedor: ");
        int idFornecedor = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID do Motivo da Fatura: ");
        int idMotivo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Data de Lançamento (yyyy-mm-dd): ");
        String dataLctoStr = scanner.nextLine();
        LocalDate dataLancamento = LocalDate.parse(dataLctoStr);

        System.out.print("Data de Vencimento (yyyy-mm-dd): ");
        String dataVencStr = scanner.nextLine();
        LocalDate dataVencimento = LocalDate.parse(dataVencStr);

        System.out.print("Valor Total: ");
        BigDecimal valorTotal = scanner.nextBigDecimal();
        scanner.nextLine();

        BigDecimal saldo = valorTotal;

        Fatura fatura = new Fatura();
        fatura.setNumeroFatura(null);
        fatura.setDataLancamento(dataLancamento);
        fatura.setDataVencimento(dataVencimento);
        fatura.setIdFornecedor(idFornecedor);
        fatura.setIdMotivoFatura(idMotivo);
        fatura.setValorTotal(valorTotal);
        fatura.setSaldo(saldo);

        Fatura faturaCriada = service.cadastrarFatura(fatura);
        if (faturaCriada != null) {
            System.out.println("Fatura cadastrada com sucesso! Nº gerado: " + faturaCriada.getNumeroFatura());
        } else {
            System.out.println("Erro ao lançar fatura.");
        }
    }
}