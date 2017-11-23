package Padroes;

import Enum.Cor;
import Pecas.*;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *Esta classe representa o padr�o Factory Method para a cria��o de objetos conforme a descri��o
 *do padr�o
 *a viwe que representa a tela inicial do jogo
 */
public class FactoryMethod {
	/**
	 * m�todo no qual faz uso do atributo nome, posi��o x e y, cor da pe�a para retornar a instancia
	 * de um objeto do tipo espec�fico conforme a descri��o do padr�o.
	 * @param nome nome da pe�a a ser criado
	 * @param x posi��o x da pe�a
	 * @param y posi��o y da pe�a
	 * @param cor a cor que a pe�a ter�
	 * @return retorno do objeto solicitado
	 */
	public Peca getPeca(String nome, int x, int y, Cor cor) {
		if(nome==null){
			return new PecaVazia(x,y,cor);
		}if(nome.toLowerCase().equals("peao")) {
			return new Peao(x,y,cor);
		}if(nome.toLowerCase().equals("bispo")) {
			return new Bispo(x,y,cor);
		}if(nome.toLowerCase().equals("cavalo")) {
			return new Cavalo(x,y,cor);
		}if(nome.toLowerCase().equals("rei")) {
			return new Rei(x,y,cor);
		}if(nome.toLowerCase().equals("rainha")) {
			return new Rainha(x,y,cor);
		}if(nome.toLowerCase().equals("torre")) {
			return new Torre(x,y,cor);
		}
		return null;
	}
}
