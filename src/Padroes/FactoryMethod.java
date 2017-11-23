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
 *Esta classe representa o padrão Factory Method para a criação de objetos conforme a descrição
 *do padrão
 *a viwe que representa a tela inicial do jogo
 */
public class FactoryMethod {
	/**
	 * método no qual faz uso do atributo nome, posição x e y, cor da peça para retornar a instancia
	 * de um objeto do tipo específico conforme a descrição do padrão.
	 * @param nome nome da peça a ser criado
	 * @param x posição x da peça
	 * @param y posição y da peça
	 * @param cor a cor que a peça terá
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
