
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import objetos.Jogos;

public class Principal {

	static Scanner scan = new Scanner(System.in);
	static List<Jogos> listaJogos = new ArrayList<Jogos>();

	public static void main(String[] args) {

		preencherTabela();

		
		System.out.println("Sistema iniciado!");

		verMenu();

	}

	private static void preencherTabela() {

		listaJogos.add(new Jogos(1, "Minecraft", "Aventura"));
		listaJogos.add(new Jogos(2, "The Sims 4", "Simulação"));
		listaJogos.add(new Jogos(3, "GTA V", "Ação"));
		listaJogos.add(new Jogos(4, "FIFA 25", "Esporte"));
		listaJogos.add(new Jogos(5, "Resident Evil", "Terror"));
		listaJogos.add(new Jogos(6, "Mario Kart", "Corrida"));

	}

	public static void verMenu() {

		int opcaoUsuario = 0;

		do {

			System.out.println("========== SISTEMA DE GERENCIAMENTO ==========");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar todos");
			System.out.println("3 - Buscar por ID");
			System.out.println("4 - Atualizar");
			System.out.println("5 - Excluir");
			System.out.println("0 - Sair");

			opcaoUsuario = scan.nextInt();
			scan.nextLine();

			confirmarEscolha(opcaoUsuario);

		} while (opcaoUsuario != 0);

	}

	public static void confirmarEscolha(int opcaoUsuario) {

		switch (opcaoUsuario) {

		case 0: {
			System.out.println("Você finalizou o programa. Até a próxima!");
			break;
		}

		case 1: {
			cadastrar();
			break;
		}

		case 2: {
			listar();
			break;
		}

		case 3: {
			buscar();
			break;
		}

		case 4: {
			atualizar();
			break;
		}

		case 5: {
			excluir();
			break;
		}

		default:
			System.out.println("Insira um número válido!");

		}

	}

	private static void cadastrar() {

		System.out.println("Informe o ID do jogo: ");
		int id = scan.nextInt();
		scan.nextLine();

		if (buscarPorId(id) != null) {
			System.out.println("Esse ID já está cadastrado!");
			return;
		}

		System.out.println("Informe o nome do jogo: ");
		String nome = scan.nextLine();

		System.out.println("Informe o gênero do jogo: ");
		String genero = scan.nextLine();

		Jogos jogos = new Jogos(id, nome, genero);

		listaJogos.add(jogos);

		System.out.println("Jogo cadastrado com sucesso!");

	}

	private static void listar() {

		if (listaJogos.size() == 0) {
			System.out.println("Não existem jogos cadastrados!");
			return;
		}

		System.out.println("============== LISTA DE JOGOS ==============");

		for (int i = 0; i < listaJogos.size(); i++) {

			System.out.printf("ID: %d - %s / %s\n", listaJogos.get(i).getId(), listaJogos.get(i).getNome(),
					listaJogos.get(i).getGenero());

		}

	}

	private static void buscar() {

		System.out.println("Informe o ID do jogo que deseja buscar: ");
		int id = scan.nextInt();
		scan.nextLine();

		Jogos jogo = buscarPorId(id);

		if (jogo == null) {
			System.out.println("Jogo não encontrado!");
			return;
		}

		System.out.println("============== JOGO ENCONTRADO ==============");
		System.out.println("ID: " + jogo.getId());
		System.out.println("Nome: " + jogo.getNome());
		System.out.println("Gênero: " + jogo.getGenero());

	}

	private static void atualizar() {

		System.out.println("Informe o ID do jogo que deseja atualizar: ");
		int id = scan.nextInt();
		scan.nextLine();

		Jogos jogo = buscarPorId(id);

		if (jogo == null) {
			System.out.println("Jogo não encontrado!");
			return;
		}

		System.out.println("Informe o novo nome do jogo: ");
		jogo.setNome(scan.nextLine());

		System.out.println("Informe o novo gênero do jogo: ");
		jogo.setGenero(scan.nextLine());

		System.out.println("Jogo atualizado com sucesso!");

	}

	private static void excluir() {

		if (listaJogos.size() == 0) {
			System.out.println("Não existem jogos para excluir!");
			return;
		}

		listar();

		System.out.println("Informe o ID do jogo que deseja excluir: ");
		int id = scan.nextInt();
		scan.nextLine();

		Jogos jogo = buscarPorId(id);

		if (jogo == null) {
			System.out.println("Jogo não encontrado!");
			return;
		}

		listaJogos.remove(jogo);

		System.out.println("Jogo removido com sucesso!");

	}

	private static Jogos buscarPorId(int id) {

		for (int i = 0; i < listaJogos.size(); i++) {

			if (listaJogos.get(i).getId() == id) {
				return listaJogos.get(i);
			}

		}

		return null;

	}

}
