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
 *class GravadorDePartida ultilizada para a cria��o de arquivos .txt
 *quando uma partida chegar ao fim, e o armazenamento de vencedor e perdedor.
 *Contendo uma constante(final) para representar o nome da cria��o e leitura
 *do arquivo no HD.
 */
public class GravadorDePartida {
	
	private final String nomeArquivo = "historico Partida.txt";

	public GravadorDePartida() throws IOException {
		
	}
	/**
	 * esse m�todo tem como motivo a cria��o de arquivo
	 * @param o par�metro recebe uma string no qual setr� gravada em arquivo
	 * @throws IOException
	 */
	public void gravar(String text) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo));
		text += ler();
		bw.write(text);
		bw.close();
	}
	/**
	 * esse m�todo tem como motivo a leitura de conte�do de um arquivo.
	 * @return retorna a string com as informa��o lidas no arquivo encontrado.
	 * @throws IOException caso n�o ache o arquivo.
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
