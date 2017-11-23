package MovimentoPeca;

import Pecas.Peca;
import Pecas.PecaVazia;
/**
 * Classe que representa o movimento da pe�a REI no jogo implementando a interface Movimento e assim possibilitando
 * a implementa��o do padr�o strategy
 * O Rei movimenta-se apenas 1 casa em qualquer dire��o. 
 * O Rei nunca pode se movimentar para uma casa que esteja 
 * sob ataque ou capturar uma pe�a que esteja defendida por 
 * uma pe�a advers�ria. No diagrama o rei preto s� pode ir 
 * para cima, pois indo para a esquerda ou em diagonal estar� 
 * sob ataque da torre branca. Quando estudarmos os movimentos 
 * especiais veremos que existe uma situa��o em que o rei pode 
 * andar 2 casas. Cada cor possui 1 rei.
 * 
 * 
 * @author Michael Fernandes
 * @author Silvana Silva
 * @author Jamile Felismina
 * @author Raul Louiz
 * @author Anderson Coutinho
 */
public class MoveRei implements Movimento{


	/**
	  * M�todo recebe o tabuleiro de pe�a, a posi��o atual da pe�a e posi��o de destino.
	  * Compara o �ndece das posi��es para saber se � poss�vel realizar o movimento ou n�o,
	  * e tem seu retorno boleano. 
	  */
	@Override
	public boolean mover(Peca[][] t, int xAtual, int yAtual, int xPara, int yPara) {

		int x = xAtual;
		int y = yAtual;
		if(x-1==xPara && y-1==yPara){
			x--;
			y--;
			if(t[x][y] instanceof PecaVazia){

				return true;
			}else{
				if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()))){

					return true;
				}

				return false;
			}
		}
		if(x+1==xPara && y+1==yPara){
			x++;
			y++;
			if(t[x][y] instanceof PecaVazia){

				return true;
			}else{
				if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()) )){
					return true;
				}

				return false;
			}
		}
		if(x-1==xPara && y+1==yPara){
			x--;
			y++;
			if(t[x][y] instanceof PecaVazia){

				return true;
			}else{
				if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()))){

					return true;
				}

				return false;
			}
		}
		if(x+1==xPara && y-1==yPara){
			x++;
			y--;
			if(t[x][y] instanceof PecaVazia){

				return true;
			}else{
				if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()))){

					return true;
				}

				return false;
			}
		}
		if(x-1==xPara && y==yPara){
			x--;

			if(t[x][y] instanceof PecaVazia){

				return true;
			}else{
				if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()))){

					return true;
				}

				return false;
			}
		}
		if(x+1==xPara && y==yPara){
			x++;
			if(t[x][y] instanceof PecaVazia){

				return true;
			}else{
				if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()))){

					return true;
				}

				return false;
			}
		}
		if(x==xPara && y-1==yPara){
			y--;
			if(t[x][y] instanceof PecaVazia){

				return true;
			}else{
				if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()))){

					return true;
				}

				return false;
			}
		}
		if(x==xPara && y+1==yPara){
			y++;
			if(t[x][y] instanceof PecaVazia){

				return true;
			}else{
				if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()))){

					return true;
				}

				return false;
			}
		}
		else{

			return false;
		}
	}


}
