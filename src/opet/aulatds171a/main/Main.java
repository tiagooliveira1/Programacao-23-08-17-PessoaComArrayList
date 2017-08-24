package opet.aulatds171a.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Vector;

import opet.aulatds171a.pessoa.Pessoa;
import opet.aulatds171a.utilitario.Leitor;

public class Main {
	
	private static final int LIMITE_PESSOAS = 2000000;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Informa aqui quantos objetos Pessoa deseja criar
		
		
		ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		int opcao_menu = -1;
		while(opcao_menu != 9) {
			System.out.println("1) Cadastrar");
			System.out.println("2) Listar");
			System.out.println("9) Sair");
			opcao_menu = Leitor.readInt("Digite a opção desejada:");
			
			if(opcao_menu == 1) {
				listaPessoas.add(
						new Pessoa(
								Leitor.readString("Informe o nome:"),
								Leitor.readString("Informe o sexo:"),
								new Date(Leitor.readString("Informe a data de nascimento:"))
						)
				);
			}
			else if(opcao_menu == 2) {
				// imprime cabeçalho
				preencherComZeros("Nome", 30);
				preencherComZeros("Sexo", 10);
				preencherComZeros("Data Nascimento", 50);
				for (Pessoa pessoa : listaPessoas) {
					System.out.print(preencherComZeros(pessoa.getNome(), 30) );
					System.out.print(preencherComZeros(pessoa.getSexo(), 10) );
					System.out.print(pessoa.getDataNascimento());
					System.out.println("");
				}
			}
		}
		
		System.out.println("Até mais!");
		
	}
	
	/**
	 * 
	 */
	static Pessoa montarPessoa()
	{
		String nome = Leitor.readString("Entre com o nome:");
		String sexo = Leitor.readString("Entre com o sexo:");
		String dataNascimento = Leitor.readString("Entre com oa data de nascimento:");
		
		Pessoa novaPessoa = new Pessoa(nome, sexo,
				new Date(dataNascimento) );
		
		return novaPessoa;
	}
	
	/**
	 * Função para preencher uma string com zeros a direita
	 * @param str
	 * @param tamanho
	 * @return
	 */
	static String preencherComZeros(String str, int tamanho)
	{
		for(int i=str.length();i<tamanho;i++) {
			str = str + " ";
		}
		return str;
	}

}
