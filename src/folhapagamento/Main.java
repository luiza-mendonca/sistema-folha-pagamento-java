package folhapagamento;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Colaborador> colaboradores = new ArrayList<>();

        int option;
        do {
            System.out.println("Digite a opção desejada: " +
                    "\n1 - Cadastrar um Colaborador Padrão" +
                    "\n2 - Cadastrar um Colaborador Comissionado" +
                    "\n3 - Cadastrar um Colaborador de Produção" +
                    "\n4 - Gerar Folha de Pagamento" +
                    "\n5 - Exibir Resumo de Folha" +
                    "\n0 - Sair ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1: {
                    System.out.println("Cadastro de Colaborador Padrão");

                    String nome = validarNome(scanner);
                    colaboradores.add(new ColaboradorPadrao(nome));

                    break;
                }

                case 2: {
                    System.out.println("Cadastro de Colaborador Comissionado");

                    String nome = validarNome(scanner);

                    double valorVendas;

                    do {
                        System.out.println("Digite o Valor de Vendas: ");

                        valorVendas = scanner.nextDouble();
                        if (valorVendas < 0) {
                            System.out.println("O valor não pode ser negativo.");
                        }

                    } while (valorVendas < 0);

                    scanner.nextLine();
                    double percentualComissao;

                    do {
                        System.out.println("Digite o Percentual de Comissão do Colaborador: ");
                        percentualComissao = scanner.nextDouble();

                        if (percentualComissao < 0 || percentualComissao > 100) {
                            System.out.println("O Percentual não pode ser negativo nem maior que 100%.");
                        }

                    } while (percentualComissao < 0 || percentualComissao > 100);
                    scanner.nextLine();

                    colaboradores.add(new ColaboradorComissionado(nome, valorVendas, percentualComissao));
                    break;
                }
                case 3: {
                    System.out.println("Cadastro de Colaborador de Produção");

                    String nome = validarNome(scanner);
                    int qttPecas;

                    do {
                        System.out.println("Digite a Quantidade de Peças: ");
                        qttPecas = scanner.nextInt();

                        if (qttPecas < 0) {
                            System.out.println("A quantidade não pode ser negativa.");
                        }

                    } while (qttPecas < 0);
                    scanner.nextLine();

                    double valorPeca;

                    do {
                        System.out.println("Digite o Valor por Peça: ");
                        valorPeca = scanner.nextDouble();

                        if (valorPeca < 0) {
                            System.out.println("O valor não pode ser negativo.");
                        }

                    } while (valorPeca < 0);

                    scanner.nextLine();

                    colaboradores.add(new ColaboradorProducao(nome, qttPecas, valorPeca));
                    break;
                }
                case 4:
                    System.out.println("Folha de Pagamento: ");

                    if (colaboradores.size() > 0) {

                        for (int i = 0; i < colaboradores.size(); i++) {
                            System.out.println(colaboradores.get(i).exibirDados());
                            System.out.println("---------------");
                        }
                    } else {
                        System.out.println("Nenhum colaborador cadastrado.");

                    }
                    break;

                case 5:
                    if (colaboradores.size() > 0) {
                        double totalFolha = 0;
                        for (int i = 0; i < colaboradores.size(); i++) {
                            totalFolha += colaboradores.get(i).calcularSalarioFinal();
                        }
                        double mediaSalarial = totalFolha / colaboradores.size();
                        System.out.println("Resumo da Folha de Pagamento: ");
                        System.out.println("Total de Colaboradores: " + colaboradores.size());
                        System.out.println("Soma Total Salarial dos colaboradores: " + totalFolha);
                        System.out.println("Média Salarial dos colaboradores: " + mediaSalarial);
                    } else {
                        System.out.println("Nenhum colaborador cadastrado.");
                    }

                    break;
                case 0:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
                    break;
            }

        } while (option != 0);

        scanner.close();
    }

    public static String validarNome(Scanner scanner) {
        String nome;
        do {
            System.out.println("Digite o nome do Colaborador: ");
            nome = scanner.nextLine().trim();

            if (nome.isBlank()) {
                System.out.println("O nome não pode estar vazio.");
            }

        } while (nome.isBlank());

        return nome;
    }

}
