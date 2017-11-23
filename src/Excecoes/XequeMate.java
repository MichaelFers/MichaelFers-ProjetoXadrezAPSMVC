package Excecoes;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *class XequeMate é um tipo de exceção que será disparada
 *pela classe responsável, caso ocorra a condição de XequeMate pelo jogador.
 */
public class XequeMate extends Exception{

	public XequeMate(String nome) {
		super(nome+": Xeque-Mate");
	}
}
