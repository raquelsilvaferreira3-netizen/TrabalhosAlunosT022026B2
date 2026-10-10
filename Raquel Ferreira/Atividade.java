import java.util.Scanner;

public class Atividade {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int senhaPre = 1234;
        boolean senhaCorreta = false;
        int tentativa = 0;
        double saldo = 0;
        boolean sair = false;

        while (tentativa < 3 && !senhaCorreta) {
            System.out.printf("Insira a senha para acessar o caixa eletronico (maximo 3 tentativas): \n");
            int senha = sc.nextInt();

            if (senha == senhaPre) {
                senhaCorreta = true;
            } else {
                tentativa++;
                System.out.printf("Senha incorreta. Tentativas realizadas: %d\n", tentativa);
            }
        }

        if (senhaCorreta) {
            while (!sair) {
                System.out.printf("================Menu================\n");
                System.out.printf("1 - Consultar saldo\n");
                System.out.printf("2 - Realizar deposito\n");
                System.out.printf("3 - Realizar saque\n");
                System.out.printf("4 - Sair\n");
                System.out.printf("====================================\n");
                System.out.printf("Escolha uma opcao: \n");
                int opt = sc.nextInt();

                switch (opt) {
                    case 1:
                        System.out.printf("Saldo: R$ %.2f\n", consultar(saldo));
                        break;
                    case 2:
                        System.out.printf("Insira o valor do deposito: \n");
                        double deposito = sc.nextDouble();
                        saldo = depositar(saldo, deposito);
                        break;
                    case 3:
                        System.out.printf("Insira o valor do saque: \n");
                        double saque = sc.nextDouble();
                        saldo = sacar(saldo, saque);
                        break;
                    case 4:
                        sair = true;
                        break;
                    default:
                        System.out.printf("Opcao invalida!\n");
                }
            }
        } else {
            System.out.printf("Limite de tentativas excedido.\n");
        }
    }

    public static double consultar(double saldo) {
        return saldo;
    }

    public static double depositar(double saldo, double deposito) {
        if (deposito > 0) {
            return saldo + deposito;
        } else {
            System.out.printf("Valor invalido!\n");
            return saldo;
        }
    }

    public static double sacar(double saldo, double saque) {
        if (saque > 0 && saque <= saldo) {
            return saldo - saque;
        } else {
            System.out.printf("Valor invalido!\n");
            return saldo;
        }
    }
}

