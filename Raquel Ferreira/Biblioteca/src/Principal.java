import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import objetos.Livro;
import objetos.Pessoa;

public class Principal {

	static Scanner entrada = new Scanner(System.in);

	static List<Livro> livros = new ArrayList<Livro>();
	static List<Pessoa> leitores = new ArrayList<Pessoa>();

	public static void main(String[] args) {

		carregarDados();

		System.out.println("Biblioteca iniciada!");

		exibirMenu();
	}

	private static void carregarDados() {

		leitores.add(new Pessoa("Ana"));
		leitores.add(new Pessoa("Lucas"));
		leitores.add(new Pessoa("Mariana"));
		leitores.add(new Pessoa("Rafael"));
		leitores.add(new Pessoa("Beatriz"));
		leitores.add(new Pessoa("Felipe"));
		leitores.add(new Pessoa("Julia"));

		livros.add(new Livro("O Diário de Anne Frank", "Anne Frank"));
		livros.add(new Livro("Percy Jackson", "Rick Riordan"));
		livros.add(new Livro("Crepúsculo", "Stephenie Meyer"));
		livros.add(new Livro("Coraline", "Neil Gaiman"));
		livros.add(new Livro("Extraordinário", "R. J. Palacio"));
		livros.add(new Livro("A Menina que Roubava Livros", "Markus Zusak"));
		livros.add(new Livro("O Código Da Vinci", "Dan Brown"));
		livros.add(new Livro("A Metamorfose", "Franz Kafka"));
		livros.add(new Livro("Orgulho e Preconceito", "Jane Austen"));
		livros.add(new Livro("O Diário de um Banana", "Jeff Kinney"));
	}

	public static void exibirMenu() {

		int opcao;

		do {
			System.out.println("\n------ BIBLIOTECA ------");
			System.out.println("1 - Mostrar livros");
			System.out.println("2 - Adicionar livro");
			System.out.println("3 - Remover livro");
			System.out.println("4 - Fazer empréstimo");
			System.out.println("5 - Fazer devolução");
			System.out.println("6 - Adicionar leitor");
			System.out.println("7 - Mostrar leitores");
			System.out.println("0 - Sair");
			System.out.print("Digite uma opção: ");

			opcao = entrada.nextInt();
			entrada.nextLine();

			verificarOpcao(opcao);

		} while (opcao != 0);
	}

	public static void verificarOpcao(int opcao) {

		switch (opcao) {

		case 0:
			System.out.println("Sistema encerrado. Até mais!");
			break;

		case 1:
			mostrarLivros();
			break;

		case 2:
			adicionarLivro();
			break;

		case 3:
			removerLivro();
			break;

		case 4:
			fazerEmprestimo();
			break;

		case 5:
			fazerDevolucao();
			break;

		case 6:
			adicionarLeitor();
			break;

		case 7:
			mostrarLeitores();
			break;

		default:
			System.out.println("Digite uma opção válida!");
		}
	}

	private static void mostrarLivros() {

		System.out.println("\n-------- LIVROS CADASTRADOS --------");

		if (livros.isEmpty()) {
			System.out.println("Não existem livros cadastrados!");
			return;
		}

		for (int indice = 0; indice < livros.size(); indice++) {

			Livro obra = livros.get(indice);

			System.out.printf("%d) %s - %s - %s\n", indice + 1,
					obra.getTitulo(), obra.getAutor(),
					obra.verificarDisponibilidade());
		}

		System.out.println();
	}

	private static void adicionarLivro() {

		Livro obra = new Livro(null, null);

		System.out.print("Digite o título do livro: ");
		obra.setTitulo(entrada.nextLine());

		System.out.print("Digite o autor do livro: ");
		obra.setAutor(entrada.nextLine());

		livros.add(obra);

		System.out.println("Livro adicionado com sucesso!");
	}

	private static void removerLivro() {

		if (livros.isEmpty()) {
			System.out.println("Não existem livros para remover!");
			return;
		}

		mostrarLivros();

		System.out.print("Digite o número do livro que deseja remover: ");
		int indice = entrada.nextInt() - 1;
		entrada.nextLine();

		if (indice < 0 || indice >= livros.size()) {
			System.out.println("Número inválido!");
			return;
		}

		if (livros.get(indice).getDataEmprestimo() != null) {
			System.out.println("O livro está emprestado e não pode ser removido!");
			return;
		}

		livros.remove(indice);

		System.out.println("Livro removido com sucesso!");
	}

	private static void fazerEmprestimo() {

		if (leitores.isEmpty()) {
			System.out.println("Não existem leitores cadastrados!");
			return;
		}

		if (livros.isEmpty()) {
			System.out.println("Não existem livros cadastrados!");
			return;
		}

		mostrarLeitores();

		System.out.print("Digite o número do leitor: ");
		int indiceLeitor = entrada.nextInt() - 1;
		entrada.nextLine();

		if (indiceLeitor < 0 || indiceLeitor >= leitores.size()) {
			System.out.println("Leitor inválido!");
			return;
		}

		if (leitores.get(indiceLeitor).getLivrosEmprestados().size() >= 2) {
			System.out.println("O leitor já possui dois livros emprestados!");
			return;
		}

		mostrarLivros();

		System.out.print("Digite o número do livro que deseja emprestar: ");
		int indiceLivro = entrada.nextInt() - 1;
		entrada.nextLine();

		if (indiceLivro < 0 || indiceLivro >= livros.size()) {
			System.out.println("Livro inválido!");
			return;
		}

		if (livros.get(indiceLivro).getDataEmprestimo() != null) {
			System.out.println("Este livro já está emprestado!");
			return;
		}

		leitores.get(indiceLeitor).getLivrosEmprestados().add(livros.get(indiceLivro));

		livros.get(indiceLivro).setDataEmprestimo(new Date());

		System.out.println("Empréstimo realizado com sucesso!");
	}

	private static void fazerDevolucao() {

		if (leitores.isEmpty()) {
			System.out.println("Não existem leitores cadastrados!");
			return;
		}

		mostrarLeitores();

		System.out.print("Digite o número do leitor que vai devolver o livro: ");
		int indiceLeitor = entrada.nextInt() - 1;
		entrada.nextLine();

		if (indiceLeitor < 0 || indiceLeitor >= leitores.size()) {
			System.out.println("Leitor inválido!");
			return;
		}

		if (leitores.get(indiceLeitor).getLivrosEmprestados().isEmpty()) {
			System.out.println("Este leitor não possui livros emprestados!");
			return;
		}

		System.out.println("\nLivros emprestados por este leitor:");

		List<Livro> emprestimos = leitores.get(indiceLeitor).getLivrosEmprestados();

		for (int indice = 0; indice < emprestimos.size(); indice++) {
			System.out.printf("%d) %s\n", indice + 1,
					emprestimos.get(indice).getTitulo());
		}

		System.out.print("Digite o número do livro que será devolvido: ");
		int indiceLivro = entrada.nextInt() - 1;
		entrada.nextLine();

		if (indiceLivro < 0 || indiceLivro >= emprestimos.size()) {
			System.out.println("Número de livro inválido!");
			return;
		}

		emprestimos.get(indiceLivro).setDataEmprestimo(null);
		emprestimos.remove(indiceLivro);

		System.out.println("Devolução realizada com sucesso!");
	}

	private static void adicionarLeitor() {

		Pessoa pessoa = new Pessoa(null);

		System.out.print("Digite o nome do leitor: ");
		pessoa.setNome(entrada.nextLine());

		leitores.add(pessoa);

		System.out.println("Leitor adicionado com sucesso!");
	}

	private static void mostrarLeitores() {

		System.out.println("\n-------- LEITORES CADASTRADOS --------");

		if (leitores.isEmpty()) {
			System.out.println("Não existem leitores cadastrados!");
			return;
		}

		for (int indice = 0; indice < leitores.size(); indice++) {

			Pessoa pessoa = leitores.get(indice);

			System.out.printf("%d) %s\n", indice + 1, pessoa.getNome());

			if (!pessoa.getLivrosEmprestados().isEmpty()) {

				System.out.println("   Livros emprestados:");

				for (int posicao = 0; posicao < pessoa.getLivrosEmprestados().size(); posicao++) {

					Livro obra = pessoa.getLivrosEmprestados().get(posicao);

					System.out.printf("   - %s\n", obra.getTitulo());
				}
			}
		}

		System.out.println();
	}
}