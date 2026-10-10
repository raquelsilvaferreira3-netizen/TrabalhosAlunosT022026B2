import java.util.Scanner;

public class SomaDosImpares {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int inicio = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int fim = scanner.nextInt();

        int soma = 0;

        for (int i = inicio; i <= fim; i++) {

            if (i % 2 != 0) {
                soma = soma + i;
            }
        }

        System.out.println("A soma dos números ímpares é: " + soma);

        scanner.close();
    }
}