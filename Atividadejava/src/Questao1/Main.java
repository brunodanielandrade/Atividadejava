import java.util.Scanner;

    public static void Main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();

        System.out.print("Digite a terceira nota: ");
        double nota3 = scanner.nextDouble();

        double media = (nota1 + nota2 + nota3) / 3;

        System.out.println("\nAluno: " + nome);
        System.out.println("Média: " + media);

        if (media >= 70) {
            System.out.println("Situação: Aprovado");
        } else if (media < 40) {
            System.out.println("Situação: Reprovado");
        } else {
            System.out.println("Situação: Final");
        }

        scanner.close();
    }
