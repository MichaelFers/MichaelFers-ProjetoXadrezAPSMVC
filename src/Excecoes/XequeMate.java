package Excecoes;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *class XequeMate � um tipo de exce��o que ser� disparada
 *pela classe respons�vel, caso ocorra a condi��o de XequeMate pelo jogador.
 */
public class XequeMate extends Exception{

	public XequeMate(String nome) {
		super(nome+": Xeque-Mate");
	}
}
