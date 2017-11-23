package Gravador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *class GravadorDePartida ultilizada para a criação de arquivos .txt
 *quando uma partida chegar ao fim, e o armazenamento de vencedor e perdedor.
 *Contendo uma constante(final) para representar o nome da criação e leitura
 *do arquivo no HD.
 */
public class GravadorDePartida {
	
	private final String nomeArquivo = "historico Partida.txt";

	public GravadorDePartida() throws IOException {
		
	}
	/**
	 * esse método tem como motivo a criação de arquivo
	 * @param o parâmetro recebe uma string no qual setrá gravada em arquivo
	 * @throws IOException
	 */
	public void gravar(String text) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo));
		text += ler();
		bw.write(text);
		bw.close();
	}
	/**
	 * esse método tem como motivo a leitura de conteúdo de um arquivo.
	 * @return retorna a string com as informação lidas no arquivo encontrado.
	 * @throws IOException caso não ache o arquivo.
	 */
	public String ler() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
		String recebido = "";
		String rec = "";
		
		do{
			recebido = br. readLine();
			if(recebido != null) {
				rec += recebido+"\n";
			}
		}while(recebido != null);
		br.close();
		return rec;
	}
}
