package Excecoes;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *class MovimentoNaoPermitido � um tipo de exce��o que ser� disparada
 *pela classe respons�vel, caso o movimento de uma pe�a n�o esteja dispon�vel.
 */
public class MovimentoNaoPermitido extends Exception{
	public MovimentoNaoPermitido() {
		super("Movimento n�o Permitido.");
	}

}
