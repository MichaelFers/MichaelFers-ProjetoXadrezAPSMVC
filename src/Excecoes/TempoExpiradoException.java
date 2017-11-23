package Excecoes;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *class TempoExpiradoException é um tipo de exceção que será disparada
 *pela classe responsável, caso o tempo permitido esteja expirado.
 */
public class TempoExpiradoException extends Exception{
	
	public TempoExpiradoException() {
		super("O tempo Acabou, recomece o jogo.");
	}

}
