import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewCadVeiculo {
    private static Scanner scanner = new Scanner(System.in);
    private static ServiceVeiculo serviceVeiculo = new ServiceVeiculo();

    static void limparTela() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) {
        int opcao;
        do {
            limparTela();
            System.out.println("SISTEMA DE GERENCIAMENTO DE FROTAS");
            System.out.println("Menu de Opções:");
            System.out.println("1 - Cadastrar Novo Veículo");
            System.out.println("2 - Listar todos Veículos cadastrados");
            System.out.println("3 - Pesquisar um Veículo por placa");
            System.out.println("4 - Remover um Veículo");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = lerInteiro();

            limparTela();
            switch (opcao) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    serviceVeiculo.listarVeiculos();
                    break;
                case 3:
                    pesquisarVeiculo();
                    break;
                case 4:
                    removerVeiculo();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println("Pressione Enter para voltar ao Menu Inicial...");
            scanner.nextLine();
            scanner.nextLine();

        } while (opcao != 0);
    }

    private static void cadastrarVeiculo() {
        try {
            System.out.println("Qual o tipo de veículo?");
            System.out.println("1 - Carro");
            System.out.println("2 - Moto");
            int tipoVeiculo = lerInteiro();

            System.out.print("Digite a marca: ");
            String marca = scanner.next();

            System.out.print("Digite o modelo: ");
            String modelo = scanner.next();

            System.out.print("Digite o ano: ");
            int ano = lerInteiro();

            System.out.print("Digite a placa: ");
            String placa = scanner.next();

            if (tipoVeiculo == 1) {
                System.out.print("Digite o número de portas: ");
                int numeroPortas = lerInteiro();
                serviceVeiculo.cadastrarVeiculo(new Carro(marca, modelo, ano, placa, numeroPortas));
            } else if (tipoVeiculo == 2) {
                System.out.print("A moto possui partida elétrica? (1 - Sim, 2 - Não): ");
                boolean partidaEletrica = lerInteiro() == 1;
                serviceVeiculo.cadastrarVeiculo(new Moto(marca, modelo, ano, placa, partidaEletrica));
            } else {
                System.out.println("Opção inválida.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, tente novamente.");
            scanner.next();
        } catch (Exception e) {
            System.out.println("NÃO FOI POSSÍVEL CADASTRAR O VEÍCULO!");
            System.out.println(e.getMessage());
        }
    }

    private static void pesquisarVeiculo() {
        System.out.print("Informe a placa que deseja pesquisar: ");
        String placa = scanner.next();
        Veiculo veiculo = serviceVeiculo.pesquisarPorPlaca(placa);
        if (veiculo != null) {
            System.out.println("Veículo encontrado: " + veiculo);
        } else {
            System.out.println("Veículo não encontrado com a placa informada!");
        }
    }

    private static void removerVeiculo() {
        try {
            System.out.print("Informe a placa do veículo que deseja remover: ");
            String placa = scanner.next();
            serviceVeiculo.removerVeiculo(placa);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int lerInteiro() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Digite um número válido: ");
                scanner.next();
            }
        }
    }
}
