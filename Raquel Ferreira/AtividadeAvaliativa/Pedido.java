class Pedido {
    String nomeCliente;
    int quantidadeLanches;
    double precoLanche;
    double taxaEntrega;
    String status;

    Pedido(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        quantidadeLanches = 0;
        precoLanche = 18.00;
        taxaEntrega = 7.00;
        status = "Aberto";
    }

    void adicionarLanches(int quantidade) {
        if (status.equals("Aberto") && quantidade > 0) {
            quantidadeLanches += quantidade;
            System.out.println("Lanches adicionados com sucesso!");
        } else {
            System.out.println("Nao foi possivel adicionar lanches. O pedido esta finalizado ou a quantidade e invalida.");
        }
    }

    double calcularTotal() {
        double total = quantidadeLanches * precoLanche;

        if (quantidadeLanches >= 3) {
            total = total - (total * 0.10);
        }

        total += taxaEntrega;
        return total;
    }

    void finalizarPedido() {
        status = "Finalizado";
        System.out.println("Pedido finalizado!");
    }

    void exibirPedido() {
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Quantidade de lanches: " + quantidadeLanches);
        System.out.println("Status: " + status);
        System.out.printf("Total do pedido: R$ %.2f%n", calcularTotal());
    }
    
    public class Main {
        public static void main(String[] args) {
            Pedido pedido = new Pedido("Patrick");

            pedido.adicionarLanches(2);
            pedido.adicionarLanches(1);

            pedido.exibirPedido();

            pedido.finalizarPedido();

            pedido.adicionarLanches(1);

            pedido.exibirPedido();
        }
    }
}