package MovimentoPeca;

import Pecas.Peca;
import Pecas.PecaVazia;
/**
 * Classe que representa o movimento da pe�a CAVALO no jogoimplementando a interface Movimento e assim possibilitando
 * a implementa��o do padr�o strategy
 * O cavalo tem um movimento especial que parece a letra L. 
 * O cavalo se movimenta 2 casas para frente ou para tr�s e
 * em seguida 1 casa para a direita ou para a esquerda, ou 2
 * casas para a direita ou para a esquerda e em seguida 1 casa 
 * para frente ou para tr�s. O cavalo � a �nica pe�a do xadrez 
 * que pode pular outras pe�as. Cada cor possui 2 Cavalos
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
	  * M�todo recebe o tabuleiro de pe�a, a posi��o atual da pe�a e posi��o de destino.
	  * Compara o �ndece das posi��es para saber se � poss�vel realizar o movimento ou n�o,
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
