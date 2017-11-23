package Excecoes;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *class Xeque é um tipo de exceção que será disparada
 *pela classe responsável, caso ocorra a condição de Xeque pelo jogador.
 */
public class Xeque extends Exception{
	public Xeque(String nome) {
		super(nome+": Xeque!");
	}

}
