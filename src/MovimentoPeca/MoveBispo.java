package MovimentoPeca;

import Pecas.Peca;
import Pecas.PecaVazia;
/**
 * Classe que representa o movimento da pe�a BISPO no jogo implementando a interface Movimento e assim possibilitando
 * a implementa��o do padr�o strategy
 * O bispo se movimenta na diagonal mantendo-se sempre nas casas 
 * de mesma cor que se encontrava no in�cio do jogo, podendo ir 
 * para frente e para tr�s, quantas casas quiser, mas n�o pode 
 * pular nenhuma outra pe�a. Cada cor possui 2 Bispos
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
	  * M�todo recebe o tabuleiro de pe�a, a posi��o atual da pe�a e posi��o de destino.
	  * Compara o �ndece das posi��es para saber se � poss�vel realizar o movimento, caso
	  * n�o seja poss�vel a realiza��o do movimento � chamada uma exce��o informando que
	  * o movimento � inv�lido
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



