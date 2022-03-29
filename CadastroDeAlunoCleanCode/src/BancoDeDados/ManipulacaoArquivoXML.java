package BancoDeDados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.w3c.dom.DOMException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import Handler.XMLHandlerAlunos;
import Modelos.Alunos;
import Util.ListaDeAlunos;

public class ManipulacaoArquivoXML {
	
	private static String nomeDoArquivo = "CadastroDeAluno.xml";

	public static void SalvarXML() throws ParserConfigurationException, UnsupportedEncodingException, FileNotFoundException, IOException, TransformerException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();//Cria uma "Fábrica de Construtores de Documentos" que possibilita a criação do DocumentoBuilder que por sua vez possibilita manejo de documentos
		
		DocumentBuilder db = dbf.newDocumentBuilder();//
		
		Document doc = db.newDocument();
		
		Element alunostag = doc.createElement("Alunos");
		doc.appendChild(alunostag);
		
		for(Alunos a : ListaDeAlunos.getInstance()) {
			Element alunotag = doc.createElement("Aluno");
			alunotag.setAttribute("id", "1");
			alunostag.appendChild(alunotag);
			
			Element nometag = doc.createElement("Nome");
			nometag.setTextContent(a.getNome());
			alunostag.appendChild(nometag);
			
			Element cpfTag = doc.createElement("CPF");
			cpfTag.setTextContent(String.valueOf(a.getCpf()));
			alunostag.appendChild(cpfTag);
			
			Element cursoTag = doc.createElement("Curso");
			cursoTag.setTextContent(String.valueOf(a.getCurso()));
			alunostag.appendChild(cursoTag);
			
			Element enderecoTag = doc.createElement("Endereco");
			alunotag.appendChild(enderecoTag);
			
			Element ruaTag = doc.createElement("Rua");
			ruaTag.setTextContent(a.getEndereco().getRua());
			enderecoTag.appendChild(ruaTag);
			
			Element numTag = doc.createElement("Numero");
			numTag.setTextContent(String.valueOf(a.getEndereco().getNumero()));
			enderecoTag.appendChild(numTag);
			
			Element bairroTag = doc.createElement("Bairro");
			bairroTag.setTextContent(a.getEndereco().getBairro());
			enderecoTag.appendChild(bairroTag);
			
			Element cidadeTag = doc.createElement("Cidade");
			cidadeTag.setTextContent(a.getEndereco().getCidade());
			enderecoTag.appendChild(cidadeTag);
			
			Element cepTag = doc.createElement("CEP");
			cepTag.setTextContent(String.valueOf(a.getEndereco().getCep()));
			enderecoTag.appendChild(cepTag);
		}
		
		TransformerFactory tf = TransformerFactory.newInstance();//Lê o documento, pega o objeto e isere o mesmo dentro do padrão
		
		Transformer trans = tf.newTransformer();
		
		trans.setOutputProperty(OutputKeys.INDENT, "yes");//Declaro que eu quero a identação
		trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");//Qual a identação que deve ser seguida
		
		DOMSource source = new DOMSource(doc);
		
		try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(nomeDoArquivo),"ISO-8859-1")){
			
			StreamResult result = new StreamResult(osw);
			
			trans.transform(source, result);
			
		}
		
	}
	
	public static void LerArquivoXML () throws ParserConfigurationException, SAXException, UnsupportedEncodingException, FileNotFoundException, IOException {
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser parser = spf.newSAXParser();
	
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeDoArquivo), "ISO-8859-1")){
			
			InputSource source = new InputSource(isr);
			
			XMLHandlerAlunos handler = new XMLHandlerAlunos();
		
			parser.parse(source, handler);
			
		}
		
	}
	
}