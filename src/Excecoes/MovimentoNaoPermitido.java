package Excecoes;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *class MovimentoNaoPermitido é um tipo de exceção que será disparada
 *pela classe responsável, caso o movimento de uma peça não esteja disponível.
 */
public class MovimentoNaoPermitido extends Exception{
	public MovimentoNaoPermitido() {
		super("Movimento não Permitido.");
	}

}
