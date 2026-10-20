public class MaquinaRefrigerante {
    int quantidadeEstoque;
    double preco;
    double dinheiroArrecadado;

    public MaquinaRefrigerante(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
        preco = 4.50;
        dinheiroArrecadado = 0;
    }

    public void comprar(int quantidade, double valorPago) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida!");
            return;
        }
        if (quantidade > quantidadeEstoque) {
            System.out.println("Erro: estoque insuficiente!");
            return;
        }
        double total = quantidade * preco;
        if (valorPago < total) {
            System.out.println("Erro: dinheiro insuficiente!");
            return;
        }

        quantidadeEstoque -= quantidade;
        dinheiroArrecadado += total;
        double troco = valorPago - total;

        System.out.println("Compra realizada com sucesso!");
        System.out.printf("Valor da compra: R$ %.2f%n", total);
        System.out.printf("Troco: R$ %.2f%n", troco);
    }

    public void reporEstoque(int quantidade) {
        if (quantidade > 0) {
            quantidadeEstoque += quantidade;
            System.out.println("Estoque atualizado!");
        } else {
            System.out.println("Quantidade para reposição inválida!");
        }
    }

    public void exibirEstado() {
        System.out.println("\n--- ESTADO DA MÁQUINA ---");
        System.out.println("Quantidade em estoque: " + quantidadeEstoque);
        System.out.printf("Preço por refrigerante: R$ %.2f%n", preco);
        System.out.printf("Dinheiro arrecadado: R$ %.2f%n", dinheiroArrecadado);
    }
    
    public class Main {
	    public static void main(String[] args) {
	    	MaquinaRefrigerante maquina = new MaquinaRefrigerante(10);
	    	maquina.comprar(3, 15.00);
	    	maquina.comprar(5, 12.00);
	    	maquina.reporEstoque(5);
	    	maquina.exibirEstado();
	    }
	}
}