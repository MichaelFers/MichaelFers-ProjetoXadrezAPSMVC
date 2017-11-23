package MovimentoPeca;

import Pecas.Peca;
import Pecas.PecaVazia;
/**
 *
 * Classe que representa o movimento da peça TORRE no jogo implementando a interface Movimento e assim possibilitando
 * a implementação do padrão strategy
 * A torre se movimenta para frente e para trás,
 * para a direita e para a esquerda, quantas casas 
 * quiser, mas não pode pular nenhuma outra peça.
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
	 * Método recebe o tabuleiro de peça, a posição atual da peça e posição de destino.
	 * Compara o índece das posições para saber se é possível realizar o movimento ou não,
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
