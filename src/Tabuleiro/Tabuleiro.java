package Tabuleiro;

import java.util.List;

import Enum.Cor;
import Jogador.Jogador;
import Pecas.Peca;
import Pecas.PecaVazia;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *Classe responsável pela criação de um array bidimencional que representará o tabuleiro de xadrez
 *8 linhas, 8 colunas, com o atributo sendo static para a instancia da classe sem perda das posições
 *das peças
 */
public class Tabuleiro {
	private static Peca[][] tabuleiro = new Peca[8][8];
	/**
	 * métdo no qual retorna o atributo da classe  que representa o tabuleiro de xadrez
	 * @return
	 */
	public Peca[][] getTabuleiro() {
		return tabuleiro;
	}
	/**
	 * métdo no qual retorna o a peça com a posição x e y do array bidimencional
	 * @return
	 */
	public Peca getPeca(int x, int y) {
		return tabuleiro[x][y];
	}
	/**
	 * métdo no qual cria novamente o array bidimencional, esse método é usado para classe Model
	 */
	public void resetaTabuleiro() {
		this.tabuleiro = new Peca[8][8];
	}
}
