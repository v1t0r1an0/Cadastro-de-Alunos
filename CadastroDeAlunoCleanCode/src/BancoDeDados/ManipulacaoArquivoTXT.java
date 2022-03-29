package BancoDeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import Modelos.Alunos;
import Util.ListaDeAlunos;

public class ManipulacaoArquivoTXT {
	
	private static String nomeDoArquivo = "CadastroDeAluno.txt";

	public static void SalvarArquivoTXT() throws IOException {
		
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(nomeDoArquivo));
				PrintWriter pw = new PrintWriter(buffer)) {
			for (Alunos a : ListaDeAlunos.getInstance())
				pw.println(a);
		}
		
	}
	
	public static void LerArquivoTXT() throws IOException {
		
		String line;
		
		try (FileWriter arq = new FileWriter(nomeDoArquivo,true)){};//Verifica se já existe um arquivo .txt criado

		try (BufferedReader reader = new BufferedReader(new FileReader(nomeDoArquivo))) {

			while ((line = reader.readLine()) != null && !"".equals(line)) {
					Alunos aluno = new Alunos(line);
					ListaDeAlunos.getInstance().add(aluno);
			}
		} 
		
	}
	
}
