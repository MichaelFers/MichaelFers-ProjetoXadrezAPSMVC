package Excecoes;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *class TempoExpiradoException � um tipo de exce��o que ser� disparada
 *pela classe respons�vel, caso o tempo permitido esteja expirado.
 */
public class TempoExpiradoException extends Exception{
	
	public TempoExpiradoException() {
		super("O tempo Acabou, recomece o jogo.");
	}

}
