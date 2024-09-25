package cadastropoo;
import model.*;
import java.util.Scanner;

public class CadastroPOO {

   public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo ID");
            System.out.println("5 - Exibir Todos");
            System.out.println("0 - Finalizar Programa");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Escolha o tipo (1-Fisica, 2-Juridica): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    if (tipo == 1) {
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        repoFisica.inserir(new PessoaFisica(id, nome, cpf, idade));
                    } else if (tipo == 2) {
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CNPJ: ");
                        String cnpj = scanner.nextLine();
                        repoJuridica.inserir(new PessoaJuridica(id, nome, cnpj));
                    }
                    break;

                case 2:
                    System.out.print("Escolha o tipo (1-Fisica, 2-Juridica): ");
                    tipo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID: ");
                    int idAlterar = scanner.nextInt();
                    scanner.nextLine();
                    if (tipo == 1) {
                        PessoaFisica pessoaFisica = repoFisica.obter(idAlterar);
                        if (pessoaFisica != null) {
                            System.out.println("Dados atuais:");
                            pessoaFisica.exibir();
                            System.out.print("Novo Nome: ");
                            String novoNome = scanner.nextLine();
                            System.out.print("Novo CPF: ");
                            String novoCpf = scanner.nextLine();
                            System.out.print("Nova Idade: ");
                            int novaIdade = scanner.nextInt();
                            repoFisica.alterar(idAlterar, new PessoaFisica(idAlterar, novoNome, novoCpf, novaIdade));
                        } else {
                            System.out.println("Pessoa nao encontrada.");
                        }
                    } else if (tipo == 2) {
                        
                    }
                    break;

                case 3:
                    System.out.print("Escolha o tipo (1-Fisica, 2-Juridica): ");
                    tipo = scanner.nextInt();
                    System.out.print("ID: ");
                    int idExcluir = scanner.nextInt();
                    if (tipo == 1) {
                        repoFisica.excluir(idExcluir);
                    } else if (tipo == 2) {
                        
                    }
                    break;

                case 4:
                    System.out.print("Escolha o tipo (1-Fisica, 2-Juridica): ");
                    tipo = scanner.nextInt();
                    System.out.print("ID: ");
                    int idObter = scanner.nextInt();
                    if (tipo == 1) {
                        PessoaFisica pessoa = repoFisica.obter(idObter);
                        if (pessoa != null) {
                            pessoa.exibir();
                        } else {
                            System.out.println("Pessoa nao encontrada.");
                        }
                    } else if (tipo == 2) {
                        
                    }
                    break;

                case 5:
                    System.out.print("Escolha o tipo (1-Fisica, 2-Juridica): ");
                    tipo = scanner.nextInt();
                    if (tipo == 1) {
                        for (PessoaFisica p : repoFisica.obterTodos()) {
                            p.exibir();
                        }
                    } else if (tipo == 2) {
                        
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}   