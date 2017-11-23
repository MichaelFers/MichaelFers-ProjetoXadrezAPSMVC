package MovimentoPeca;

import Pecas.Peca;
import Pecas.PecaVazia;
/**
 *
 * Classe que representa o movimento da pe�a TORRE no jogo implementando a interface Movimento e assim possibilitando
 * a implementa��o do padr�o strategy
 * A torre se movimenta para frente e para tr�s,
 * para a direita e para a esquerda, quantas casas 
 * quiser, mas n�o pode pular nenhuma outra pe�a.
 * Cada cor possui 2 torres.
 * 
 * @author Michael Fernandes
 * @author Silvana Silva
 * @author Jamile Felismina
 * @author Raul Louiz
 * @author Anderson Coutinho
 */
public class MoveTorre implements Movimento{


	/**
	 * M�todo recebe o tabuleiro de pe�a, a posi��o atual da pe�a e posi��o de destino.
	 * Compara o �ndece das posi��es para saber se � poss�vel realizar o movimento ou n�o,
	 * e tem seu retorno boleano. 
	 */
	@Override
	public boolean mover(Peca[][] t, int xAtual, int yAtual, int xPara, int yPara) {

		int x = xAtual;
		int y = yAtual;

		if(x>xPara && y==yPara){

			while(true){
				x--;
				if(t[x][y] instanceof PecaVazia){
					if(y==yPara && x==xPara){
						return true;
					}else{
						continue;
					}
				}else{
					if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor())) && x==xPara){

						return true;
					}
					return false;
				}
			}
		}
		if(x<xPara && y==yPara){

			while(true){
				x++;
				if(t[x][y] instanceof PecaVazia){
					if(y==yPara && x==xPara){

						return true;
					}else{
						continue;
					}
				}else{
					if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()) && x==xPara)){

						return true;
					}

					return false;
				}
			}
		}
		if(y>yPara && x==xPara){
			while(true){
				y--;
				if(t[x][y] instanceof PecaVazia){
					if(y==yPara && x==xPara){

						return true;
					}else{
						continue;
					}
				}else{
					if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()) && y==yPara)){

						return true;
					}

					return false;
				}
			}
		}
		if(y<yPara && x==xPara){

			while(true){
				y++;
				if(t[x][y] instanceof PecaVazia){
					if(y==yPara && x==xPara){

						return true;
					}else{
						continue;
					}
				}else{
					if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()) && y==yPara)){

						return true;
					}

					return false;
				}
			}
		}else{

			return false;
		}
	}

}
