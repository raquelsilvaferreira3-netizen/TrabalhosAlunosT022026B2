class Time {
    String nome;
    int vitorias;
    int empates;
    int derrotas;
    int pontos;

    Time(String nome) {
        this.nome = nome;
        vitorias = 0;
        empates = 0;
        derrotas = 0;
        pontos = 0;
    }

    void registrarVitoria() {
        vitorias++;
        pontos += 3;
    }

    void registrarEmpate() {
        empates++;
        pontos += 1;
    }

    void registrarDerrota() {
        derrotas++;
    }

    void exibirEstatisticas() {
        System.out.println("Time: " + nome);
        System.out.println("Vitórias: " + vitorias);
        System.out.println("Empates: " + empates);
        System.out.println("Derrotas: " + derrotas);
        System.out.println("Pontos: " + pontos);
        System.out.println();
    }
    
    public class Main {
        public static void main(String[] args) {
            Time time1 = new Time("Flamengo");
            Time time2 = new Time("Palmeiras");

            time1.registrarVitoria();
            time1.registrarVitoria();
            time1.registrarEmpate();
            time1.registrarDerrota();

            time2.registrarVitoria();
            time2.registrarEmpate();
            time2.registrarEmpate();
            time2.registrarDerrota();

            time1.exibirEstatisticas();
            time2.exibirEstatisticas();

            if (time1.pontos > time2.pontos) {
                System.out.println(time1.nome + " possui mais pontos!");
            } else if (time2.pontos > time1.pontos) {
                System.out.println(time2.nome + " possui mais pontos!");
            } else {
                System.out.println("Houve empate na classificação!");
            }
        }
    }
}