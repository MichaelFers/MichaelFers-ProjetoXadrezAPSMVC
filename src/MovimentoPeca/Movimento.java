package MovimentoPeca;

import Pecas.Peca;
/**
 * A interface ser� implementada pelos movimentos das pe�as
 */
public interface Movimento {

	public abstract boolean mover(Peca[][] t,int x, int y, int xPara, int yPara);
	
}
