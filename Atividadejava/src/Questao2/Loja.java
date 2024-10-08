package Questao2;

import java.util.Scanner;

class Loja {
    private Produto produto;
    private Scanner scanner = new Scanner(System.in);

    public void cadastrarProduto() {
        System.out.println("Cadastro de produto");
        System.out.print("Código: ");

        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Tamanho/Peso: ");
        String tamanhoPeso = scanner.nextLine();
        System.out.print("Cor: ");
        String cor = scanner.nextLine();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        System.out.print("Quantidade no estoque: ");
        int quantidadeEstoque = scanner.nextInt();
        produto = new Produto(codigo, nome, tamanhoPeso, cor, valor, quantidadeEstoque);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public Produto buscarProdutoPorCodigo(int codigo) {
        if (produto != null && produto.getCodigo() == codigo) {
            return produto;
        }
        return null;
    }

    public void venderProduto() {
        if (produto == null) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

        System.out.print("Digite o código do produto para venda: ");
        int codigo = scanner.nextInt();
        Produto produtoEncontrado = buscarProdutoPorCodigo(codigo);

        if (produtoEncontrado != null) {
            System.out.print("Quantidade a vender: ");
            int quantidade = scanner.nextInt();

            if (quantidade <= produto.getQuantidadeEstoque()) {
                double valorTotal = produto.getValor() * quantidade;
                System.out.println("Valor total: R$ " + valorTotal);

                System.out.println("Método de pagamento: ");
                System.out.println("1 - Pix");
                System.out.println("2 - Espécie");
                System.out.println("3 - Transferência");
                System.out.println("4 - Débito");
                System.out.println("5 - Crédito (parcelado em 3x)");
                int metodoPagamento = scanner.nextInt();

                switch (metodoPagamento) {
                    case 1:
                    case 3:
                    case 4: // Pix, Transferência, Débito
                        valorTotal *= 0.95;
                        System.out.println("Desconto aplicado. Novo valor: R$ " + valorTotal);
                        break;
                    case 2: // Espécie
                        valorTotal *= 0.95;
                        System.out.println("Desconto aplicado. Novo valor: R$ " + valorTotal);
                        System.out.print("Valor pago: R$ ");
                        double valorPago = scanner.nextDouble();
                        if (valorPago >= valorTotal) {
                            double troco = valorPago - valorTotal;
                            System.out.println("Troco: R$ " + troco);
                        } else {
                            System.out.println("Valor insuficiente!");
                            return;
                        }
                        break;
                    case 5: // Crédito
                        System.out.println("Parcelado em 3x de R$ " + (valorTotal / 3));
                        break;
                    default:
                        System.out.println("Método de pagamento inválido!");
                        return;
                }

                produto.reduzirEstoque(quantidade);
                System.out.println("Venda realizada com sucesso!");
            } else {
                System.out.println("Quantidade insuficiente no estoque!");
            }
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    public void exibirEstoque() {
        if (produto != null) {
            System.out.println("Estoque:");
            System.out.println(produto);
        } else {
            System.out.println("Nenhum produto cadastrado!");
        }
    }
}