package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import Modelos.Alunos;
import Util.ListaDeAlunos;

public class ViewCRUDAlunos {

	public static int ViewMenuPrincipal(BufferedReader reader) throws NumberFormatException, IOException {
		
		System.out.println();
		System.out.println();
		System.out.println("||=o=o=o=o=o=o=o=o= MENU =o=o=o=o=o=o=o=o=o=||");
		System.out.println("||                                          ||");
		System.out.println("||     [1] - Cadastrar Alunos               ||");
		System.out.println("||     [2] - Listar Alunos                  ||");
		System.out.println("||     [3] - Deletar Alunos                 ||");
		System.out.println("||     [4] - Editar Alunos                  ||");
		System.out.println("||     [5] - SAIR                           ||");
		System.out.println("||                                          ||");
		System.out.println("||=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o||");

		return Integer.parseInt(reader.readLine());	
	}

	
	public static String[] ViewMenuSalvarAluno(BufferedReader reader) throws IOException {
		String[] menuAluno = {"Nome", "CPF", "Curso","Endereço \n Rua",
									"Numero","Bairro","Cidade", "Estado", "CEP"};
		String[] dadosAluno = {"","","","","","","","",""};
		
		for(int i=0; i < menuAluno.length; i++) {
			System.out.println(menuAluno[i]);
			dadosAluno[i] = reader.readLine();
		}
			
		return dadosAluno;
	}
	
	public static int ViewMenuEditarOuDeletarAluno(String editar_deletar,BufferedReader reader) throws NumberFormatException, IOException {		

		for (int i = 0; i < ListaDeAlunos.getInstance().size(); i++) {
			System.out.println(i + " - " + ListaDeAlunos.getInstance().get(i));
		}

		System.out.println();
		System.out.println("Dentre a lista acima, escolha o indice do aluno que deseja "+ editar_deletar);
						
		return Integer.parseInt(reader.readLine());
	}
	
	public static String[] viewOpcaoEdicao(BufferedReader reader) throws IOException{
		String[] dadosEditados = { " ", " "};
		System.out.println("escolha o Atributo que deseja editar:");
		System.out.println("||=o=o=o=o=o=o=o=o= EDITAR =o=o=o=o=o=o=o=o=o=||");
		System.out.println("||                                            ||");
		System.out.println("||     [1]  - Nome                            ||");
		System.out.println("||     [2]  - CPF                             ||"); 
		System.out.println("||     [3]  - Curso                           ||"); 
		System.out.println("||     [4]  - Endereço                        ||"); 
		System.out.println("||     [5]  - Rua                             ||"); 
		System.out.println("||     [6]  - Número                          ||"); 
		System.out.println("||     [7]  - Bairro                          ||");
		System.out.println("||     [8]  - Cidade                          ||"); 
		System.out.println("||     [9]  - Estado                          ||");
		System.out.println("||     [10] - CEP                             ||"); 
		System.out.println("||                                            ||");
		System.out.println("||=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o||");
	
		dadosEditados[0] = reader.readLine();    //receber informação string
		System.out.println("Escreva o novo valor do atributo");
		dadosEditados[1] = reader.readLine();
	
	return dadosEditados;
	
	}
	
	public static void ViewListaDeAlunosEditada() {
		
		
		
		for(Alunos a : ListaDeAlunos.getInstance()) {
			
			System.out.println();
			System.out.println();
			System.out.println("||=o=o=o=o=o=o=o=o= ALUNO =o=o=o=o=o=o=o=o=o=o||");
			System.out.println("||                                            ||");
			System.out.println("||   Nome: " + a.getNome());
			System.out.println("||   CPF: " + a.getCpf());
			System.out.println("||   Curso: " + a.getCurso());
			System.out.println("||                                            ||");
			System.out.println("||- - - - - - - -  Endereço - - - - - - - - - ||");
			System.out.println("||                                            ||");
			System.out.println("||   Rua: " + a.getEndereco().getRua());
			System.out.println("||   Número: " + a.getEndereco().getNumero());
			System.out.println("||   Bairro: " + a.getEndereco().getBairro());
			System.out.println("||   Cidade: " + a.getEndereco().getCidade());
			System.out.println("||   Estado: " + a.getEndereco().getEstado());
			System.out.println("||   CEP: " + a.getEndereco().getCep());
			System.out.println("||                                           ||");
			System.out.println("||- - - - - - - - - - - - - - - - - - - - - -||");
			System.out.println("||                                           ||");
			System.out.println("||=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=o=||");
			System.out.println();
			System.out.println();
			
		} 
		
	}
	
	public static void ViewMsgFinal(int op) {
		// TODO Auto-generated method stub
		
		String[] msgFinal = {"Aluno salvo com sucesso!",
							 "Aluno editado com sucesso!",
							 "Aluno deletado com sucesso!",
							 "Fim de Programa!"};
		
		System.out.println(msgFinal[op]);
		
	}
	
}
