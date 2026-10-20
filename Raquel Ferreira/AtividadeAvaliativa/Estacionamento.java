public class Estacionamento {
	String placa;
	String modelo;
	int minutosEstacionado;
	Double valorPago;

	public Estacionamento(String placa, String modelo) {
		this.placa = placa;
		this.modelo = modelo;
		minutosEstacionado = 0;
		valorPago = 0.0;
	}
	
	public void adicionarTempo(int minutos) {
		if (minutos >= 0) {
			minutosEstacionado += minutos;
		} else {
			System.out.println("O tempo não pode ser negativo!");
		}
	}

	public void calcularValor() {
		if (minutosEstacionado <= 30) {
			valorPago = 5.00;
		} else {
			valorPago = 5.00 + (minutosEstacionado - 30) * 0.10;
		}
		if (valorPago > 30.00) {
			valorPago = 30.00;
		}
	}

	public void exibirResumo() {
		System.out.println("\n--- RESUMO DO ESTACIONAMENTO ---");
		System.out.println("Placa: " + placa);
		System.out.println("Modelo: " + modelo);
		System.out.println("Minutos estacionado: " + minutosEstacionado);
		System.out.printf("Valor a pagar: R$ %.2f%n", valorPago);
	}
	
	public class Main {
	    public static void main(String[] args) {

	        Estacionamento veiculo = new Estacionamento("ABC-1234", "Fiat Uno");

	        veiculo.adicionarTempo(60);

	        veiculo.calcularValor();

	        veiculo.exibirResumo();
	    }
	}
}