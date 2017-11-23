package MovimentoPeca;

import Enum.Cor;
import Pecas.Peca;
import Pecas.PecaVazia;
/**
 * Classe que representa o movimento da peça PEÃO no jogo implementando a interface Movimento e assim possibilitando
 * a implementação do padrão strategy
 * O peão só se movimenta para frente, sendo a única 
 * peça que não se move para trás. No primeiro lance 
 * de cada peão ele pode avançar 1 ou 2 casas. À partir 
 * do segundo lance de cada peão ele irá movimenta-se apenas 1 casa.
 * Cada cor possui 8 peões.
 * 
 * @author Michael Fernandes
 * @author Silvana Silva
 * @author Jamile Felismina
 * @author Raul Louiz
 * @author Anderson Coutinho
 */
public class MovePeao implements Movimento{
	/**
	  * Método recebe o tabuleiro de peça, a posição atual da peça e posição de destino.
	  * Compara o índece das posições para saber se é possível realizar o movimento ou não,
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
