package MovimentoPeca;

import Pecas.Peca;
import Pecas.PecaVazia;
/**
 * Classe que representa o movimento da peça CAVALO no jogoimplementando a interface Movimento e assim possibilitando
 * a implementação do padrão strategy
 * O cavalo tem um movimento especial que parece a letra L. 
 * O cavalo se movimenta 2 casas para frente ou para trás e
 * em seguida 1 casa para a direita ou para a esquerda, ou 2
 * casas para a direita ou para a esquerda e em seguida 1 casa 
 * para frente ou para trás. O cavalo é a única peça do xadrez 
 * que pode pular outras peças. Cada cor possui 2 Cavalos
 * 
 * 
 * @author Michael Fernandes
 * @author Silvana Silva
 * @author Jamile Felismina
 * @author Raul Louiz
 * @author Anderson Coutinho
 *
 */
public class MoveCavalo implements Movimento{
	 /**
	  * Método recebe o tabuleiro de peça, a posição atual da peça e posição de destino.
	  * Compara o índece das posições para saber se é possível realizar o movimento ou não,
	  * e tem seu retorno boleano. 
	  */
	@Override
	public boolean mover(Peca[][] t, int xAtual, int yAtual, int xPara, int yPara) {
		int x = xAtual;
		int y = yAtual;
		if(x+2==xPara && y-1==yPara){
			if(t[xPara][yPara] instanceof PecaVazia){
				return true;
			}
			if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

				return true;
			}else{

				return false;
			}
		}	
		if(x+2==xPara && y+1==yPara){
			if(t[xPara][yPara] instanceof PecaVazia){

				return true;
			}
			if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

				return true;
			}else{

				return false;
			}
		}
		if(x-2==xPara && y+1==yPara){
			if(t[xPara][yPara] instanceof PecaVazia){

				return true;
			}
			if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

				return true;
			}else{

				return false;
			}
		}
		if(x-2==xPara && y-1==yPara){
			if(t[xPara][yPara] instanceof PecaVazia){

				return true;
			}
			if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

				return true;
			}else{

				return false;
			}
		}
		if(x+1==xPara && y+2==yPara){
			if(t[xPara][yPara] instanceof PecaVazia){

				return true;
			}
			if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

				return true;
			}else{

				return false;
			}
		}	
		if(x-1==xPara && y+2==yPara){
			if(t[xPara][yPara] instanceof PecaVazia){

				return true;
			}
			if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

				return true;
			}else{

				return false;
			}
		}
		if(x-1==xPara && y-2==yPara){
			if(t[xPara][yPara] instanceof PecaVazia){

				return true;
			}
			if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

				return true;
			}else{

				return false;
			}
		}
		if(x+1==xPara && y-2==yPara){
			if(t[xPara][yPara] instanceof PecaVazia){

				return true;
			}
			if((!t[x][y].getCor().equals(t[xPara][yPara].getCor()))){

				return true;
			}else{

				return false;
			}
		}else{

			return false;
		}
	}
}
