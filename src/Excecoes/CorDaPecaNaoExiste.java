package Excecoes;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *class CorDaPecaNaoExiste � um tipo de exce��o que ser� disparada
 *caso a cor da peca n�o exista pela classe respons�vel.
 */
public class CorDaPecaNaoExiste extends Exception{

	public CorDaPecaNaoExiste() {
		super("Cor da pe�a n�o existe: Apenas permitido Branco ou Preto");
	}
}
