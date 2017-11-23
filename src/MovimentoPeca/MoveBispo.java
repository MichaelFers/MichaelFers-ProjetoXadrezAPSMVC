package MovimentoPeca;

import Pecas.Peca;
import Pecas.PecaVazia;
/**
 * Classe que representa o movimento da peça BISPO no jogo implementando a interface Movimento e assim possibilitando
 * a implementação do padrão strategy
 * O bispo se movimenta na diagonal mantendo-se sempre nas casas 
 * de mesma cor que se encontrava no início do jogo, podendo ir 
 * para frente e para trás, quantas casas quiser, mas não pode 
 * pular nenhuma outra peça. Cada cor possui 2 Bispos
 *  
 * @author Michael Fernandes
 * @author Silvana Silva
 * @author Jamile Felismina
 * @author Raul Louiz
 * @author Anderson Coutinho
 *
 */
public class MoveBispo implements Movimento{
	/**
	  * Método recebe o tabuleiro de peça, a posição atual da peça e posição de destino.
	  * Compara o índece das posições para saber se é possível realizar o movimento, caso
	  * não seja possível a realização do movimento é chamada uma exceção informando que
	  * o movimento é inválido
	  */
	@Override
	public boolean mover(Peca[][] t, int xAtual, int yAtual, int xPara, int yPara) {
		int x = 0;
		int y = 0;
		try {

		if((xAtual<xPara && yAtual<yPara)){
			x = xAtual;
			y = yAtual;
			while(true){
				y++;
				x++;
				if(t[x][y] instanceof PecaVazia){
					if(y==yPara && x==xPara){

						return true;
					}else{
						continue;
					}
				}else{
					if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()) && (y==yPara && x==xPara))){

						return true;
					}

					return false;
				}
			}
		}
		else if(xAtual>xPara && yAtual>yPara ){
			x = xAtual;
			y = yAtual;

			while(true){
				y--;
				x--;
				
				if(t[x][y] instanceof PecaVazia){
					if(y==yPara && x==xPara){

						return true;
					}else{
						continue;
					}
				}else{
					if(((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor())) && (y==yPara && x==xPara))){

						return true;
					}else{

						return false;
					}
				}
			}
		}
		else if(xAtual<xPara && yAtual>yPara){
			x = xAtual;
			y = yAtual;
			while(true){
				y--;
				x++;

				if(y>=0 && t[x][y] instanceof PecaVazia){
					if(y==yPara && x==xPara){

						return true;
					}else{
						continue;
					}
				}else{
					if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()) && (y==yPara && x==xPara))){

						return true;
					}

					return false;
				}
			}
		}
		else if(xAtual>xPara && yAtual<yPara ){
			x = xAtual;
			y = yAtual;
			while(true){
				y++;
				x--;

				if(t[x][y] instanceof PecaVazia){
					if(y==yPara && x==xPara){

						return true;
					}else{
						continue;
					}
				}else {
					if((!t[xAtual][yAtual].getCor().equals(t[xPara][yPara].getCor()) && y==yPara && x==xPara)){

						return true;
					}else{

						return false;
					}

				}
				
			}
		}
		return false;
		}catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}
}



