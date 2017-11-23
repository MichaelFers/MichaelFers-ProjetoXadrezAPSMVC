package MovimentoPeca;

import Pecas.Peca;
import Pecas.PecaVazia;
/**
 * Classe que representa o movimento da peça REI no jogo implementando a interface Movimento e assim possibilitando
 * a implementação do padrão strategy
 * O Rei movimenta-se apenas 1 casa em qualquer direção. 
 * O Rei nunca pode se movimentar para uma casa que esteja 
 * sob ataque ou capturar uma peça que esteja defendida por 
 * uma peça adversária. No diagrama o rei preto só pode ir 
 * para cima, pois indo para a esquerda ou em diagonal estará 
 * sob ataque da torre branca. Quando estudarmos os movimentos 
 * especiais veremos que existe uma situação em que o rei pode 
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
	  * Método recebe o tabuleiro de peça, a posição atual da peça e posição de destino.
	  * Compara o índece das posições para saber se é possível realizar o movimento ou não,
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
