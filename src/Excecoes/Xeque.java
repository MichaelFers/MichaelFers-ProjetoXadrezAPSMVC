package Excecoes;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *class Xeque � um tipo de exce��o que ser� disparada
 *pela classe respons�vel, caso ocorra a condi��o de Xeque pelo jogador.
 */
public class Xeque extends Exception{
	public Xeque(String nome) {
		super(nome+": Xeque!");
	}

}
