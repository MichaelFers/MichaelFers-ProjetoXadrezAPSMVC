package MovimentoPeca;

import Enum.Cor;
import Pecas.Peca;
import Pecas.PecaVazia;
/**
 * Classe que representa o movimento da pe�a PE�O no jogo implementando a interface Movimento e assim possibilitando
 * a implementa��o do padr�o strategy
 * O pe�o s� se movimenta para frente, sendo a �nica 
 * pe�a que n�o se move para tr�s. No primeiro lance 
 * de cada pe�o ele pode avan�ar 1 ou 2 casas. � partir 
 * do segundo lance de cada pe�o ele ir� movimenta-se apenas 1 casa.
 * Cada cor possui 8 pe�es.
 * 
 * @author Michael Fernandes
 * @author Silvana Silva
 * @author Jamile Felismina
 * @author Raul Louiz
 * @author Anderson Coutinho
 */
public class MovePeao implements Movimento{
	/**
	  * M�todo recebe o tabuleiro de pe�a, a posi��o atual da pe�a e posi��o de destino.
	  * Compara o �ndece das posi��es para saber se � poss�vel realizar o movimento ou n�o,
	  * e tem seu retorno boleano. 
	  */
	@Override
	public boolean mover(Peca[][] t, int x, int y, int xPara, int yPara) {
		if(t[x][y].getCor().equals(Cor.BRANCO)){


			if(x==6 && x-2==xPara && y==yPara && t[x-1][y] instanceof PecaVazia){
				if(t[xPara][yPara] instanceof PecaVazia){

					return true;
				}
				else{
					return false;
				}
			}
			if(x-1==xPara && y==yPara){
				if(t[xPara][yPara] instanceof PecaVazia){
					return true;
				}else{
					return false;
				}
			}
			if((x-1==xPara && y+1==yPara) || (x-1==xPara && y-1==yPara) ){

				if((!t[xPara][yPara].getCor().equals(t[x][y].getCor()))){

					return true;
				}

				else{
					return false;
				}
			}
			else{

				return false;
			}
		}
		if(t[x][y].getCor().equals(Cor.PRETO)){

			if(x==1 && x+2==xPara && y==yPara && t[x+1][y] instanceof PecaVazia){
				if(t[xPara][yPara] instanceof PecaVazia){
					return true;
				}
				else{
					return false;
				}
			}
			if(x+1==xPara && y==yPara){
				if(t[xPara][yPara] instanceof PecaVazia){
					return true;
				}else{
					return false;
				}
			}
			if((x+1==xPara && y+1==yPara) || (x+1==xPara && y-1==yPara) ){

				if((!t[xPara][yPara].getCor().equals(t[x][y].getCor()))){

					return true;
				}

				else{
					return false;
				}
			}
			else{

				return false;
			}
		}else{

			return false;
		}
	}
}
