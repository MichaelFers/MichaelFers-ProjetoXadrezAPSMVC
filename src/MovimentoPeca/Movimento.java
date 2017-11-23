package MovimentoPeca;

import Pecas.Peca;
/**
 * A interface será implementada pelos movimentos das peças
 */
public interface Movimento {

	public abstract boolean mover(Peca[][] t,int x, int y, int xPara, int yPara);
	
}
