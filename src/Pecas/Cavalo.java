package Pecas;

import javax.swing.ImageIcon;

import Enum.Cor;
import MovimentoPeca.MoveCavalo;
/**
 * Classe que representa a peça Cavalo no jogo e herdando da classe Peca.
 * Inicialmente o cavalo fica localizado entre
 * o Torre e o Bispo. Cada cor possui 2 Cavalos
 * 
 * @author Michael Fernandes
 * @author Silvana Silva
 * @author Jamile Felismina
 * @author Raul Louiz
 * @author Anderson Coutinho
 */
public class Cavalo  extends Peca{
	/**
	 * Contrutor da classe que recebe posições iniciais e cor a ser localizados pelo tabuleiro fazendo uso
	 * do contrutor da super classe e adicionando ao arrayList um movimento respesctivo da peça
	 * 
	 * @param x
	 * @param y
	 * @param cor
	 */
	public Cavalo(int x, int y, Cor cor) {
		super(x, y, cor);
		super.movimento.add(new MoveCavalo());
	}
	/**
	 * Método inicial para apresentar as imagens da peça conforme 
	 * sua cor sobrescrevendo o método da classe Peca.
	 */
	@Override
	public void iniciaImg() {
		if(cor.BRANCO == cor) {
			img = new ImageIcon("img/Brancas/Cavalo.jpg");
		}else {
			img = new ImageIcon("img/Escuras/Cavalo.jpg");
		}
		
	}

}
