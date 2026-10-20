class Cofrinho {
    String dono;
    double saldo;
    double metaEconomia;

    Cofrinho(String dono, double metaEconomia) {
        this.dono = dono;
        this.metaEconomia = metaEconomia;
        saldo = 0;
    }

    void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito realizado com sucesso!");
        } else {
            System.out.println("O valor do deposito deve ser positivo.");
        }
    }

    void retirar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Retirada realizada com sucesso!");
        } else {
            System.out.println("Nao foi possivel realizar a retirada. Saldo insuficiente ou valor invalido.");
        }
    }

    void verificarMeta() {
        if (saldo >= metaEconomia) {
            System.out.println("Parabens, " + dono + "! Voce atingiu sua meta de economia!");
        } else {
            double falta = metaEconomia - saldo;
            System.out.printf("Faltam R$ %.2f para atingir sua meta.%n", falta);
        }
    }

    void exibirSaldo() {
        System.out.println("Dono: " + dono);
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        System.out.printf("Meta de economia: R$ %.2f%n", metaEconomia);
    }
    
    public class Main {
        public static void main(String[] args) {
            Cofrinho cofrinho = new Cofrinho("Patrick", 500.00);

            cofrinho.depositar(200.00);
            cofrinho.depositar(150.00);
            cofrinho.depositar(100.00);

            cofrinho.retirar(600.00);

            cofrinho.exibirSaldo();
            cofrinho.verificarMeta();
        }
    }
}