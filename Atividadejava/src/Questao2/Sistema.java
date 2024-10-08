package Questao2;

import java.util.Scanner;
public class Sistema {
    public static void main(String[] args) {
        Loja loja = new Loja();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1 - Cadastrar produto");
            System.out.println("2 - Vender produto");
            System.out.println("3 - Exibir estoque");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    loja.cadastrarProduto();
                    break;
                case 2:
                    loja.venderProduto();
                    break;
                case 3:
                    loja.exibirEstoque();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}