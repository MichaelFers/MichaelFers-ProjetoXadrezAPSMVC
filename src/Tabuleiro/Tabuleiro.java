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
 *Classe respons�vel pela cria��o de um array bidimencional que representar� o tabuleiro de xadrez
 *8 linhas, 8 colunas, com o atributo sendo static para a instancia da classe sem perda das posi��es
 *das pe�as
 */
public class Tabuleiro {
	private static Peca[][] tabuleiro = new Peca[8][8];
	/**
	 * m�tdo no qual retorna o atributo da classe  que representa o tabuleiro de xadrez
	 * @return
	 */
	public Peca[][] getTabuleiro() {
		return tabuleiro;
	}
	/**
	 * m�tdo no qual retorna o a pe�a com a posi��o x e y do array bidimencional
	 * @return
	 */
	public Peca getPeca(int x, int y) {
		return tabuleiro[x][y];
	}
	/**
	 * m�tdo no qual cria novamente o array bidimencional, esse m�todo � usado para classe Model
	 */
	public void resetaTabuleiro() {
		this.tabuleiro = new Peca[8][8];
	}
}
