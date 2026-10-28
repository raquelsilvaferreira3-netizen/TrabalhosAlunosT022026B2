package objetos;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

	private String nome;
	private List<Livro> livrosEmprestados;

	public Pessoa(String nome) {
		this.nome = nome;
		this.livrosEmprestados = new ArrayList<Livro>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Livro> getLivrosEmprestados() {
		return livrosEmprestados;
	}

	public void setLivrosEmprestados(List<Livro> livrosEmprestados) {
		this.livrosEmprestados = livrosEmprestados;
	}

}