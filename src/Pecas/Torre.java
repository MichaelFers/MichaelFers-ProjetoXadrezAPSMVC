package Pecas;

import javax.swing.ImageIcon;

import Enum.Cor;
import MovimentoPeca.MoveTorre;
/**
 * Classe que representa a pe�a Torre no jogo e herdando da classe Peca.
 * Inicialmente o Torre fica localizado ao lado
 * do Cavalo. Cada cor possui 2 Torres
 * 
 * @author Michael Fernandes
 * @author Silvana Silva
 * @author Jamile Felismina
 * @author Raul Louiz
 * @author Anderson Coutinho
 */
public class Torre extends Peca{
	/**
	 * Contrutor da classe que recebe posi��es iniciais e cor a ser localizados pelo tabuleiro fazendo uso
	 * do contrutor da super classe e adicionando ao arrayList um movimento respesctivo da pe�a
	 * 
	 * @param x
	 * @param y
	 * @param cor
	 */
	public Torre(int x, int y, Cor cor) {
		super(x, y, cor);
		super.movimento.add(new MoveTorre());
	}
	/**
	 * M�todo inicial para apresentar as imagens da pe�a conforme 
	 * sua cor, sobrescrevendo o m�todo da classe Peca.
	 */
	@Override
	public void iniciaImg() {
		if(cor.BRANCO == cor) {
			img = new ImageIcon("img/Brancas/Torre.jpg");
		}else {
			img = new ImageIcon("img/Escuras/Torre.jpg");
		}
		
	}

}
