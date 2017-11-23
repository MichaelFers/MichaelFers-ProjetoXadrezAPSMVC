package Excecoes;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *class CorDaPecaNaoExiste é um tipo de exceção que será disparada
 *caso a cor da peca não exista pela classe responsável.
 */
public class CorDaPecaNaoExiste extends Exception{

	public CorDaPecaNaoExiste() {
		super("Cor da peça não existe: Apenas permitido Branco ou Preto");
	}
}
