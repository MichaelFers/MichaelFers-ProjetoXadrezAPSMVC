package Pecas;

import javax.swing.ImageIcon;

import Enum.Cor;
import MovimentoPeca.MoveRei;
/**
 * Classe que representa a pe�a Rei no jogo e herdando da classe Peca.
 * Inicialmente o cavalo fica localizado entre
 * a Rainha e o Bispo. Cada cor possui 1 Rei
 * 
 * @author Michael Fernandes
 * @author Silvana Silva
 * @author Jamile Felismina
 * @author Raul Louiz
 * @author Anderson Coutinho
 */
public class Rei extends Peca{
	
	/**
	 * Contrutor da classe que recebe posi��es iniciais e cor a ser localizados pelo tabuleiro fazendo uso
	 * do contrutor da super classe e adicionando ao arrayList um movimento respesctivo da pe�a
	 * 
	 * @param x
	 * @param y
	 * @param cor
	 */
	public Rei(int x, int y, Cor cor) {
		super(x, y, cor);
		super.movimento.add(new MoveRei());
	}
	/**
	 * M�todo inicial para apresentar as imagens da pe�a conforme 
	 * sua cor, sobrescrevendo o m�todo da classe Peca.
	 */
	@Override
	public void iniciaImg() {
		if(cor.BRANCO == cor) {
			img = new ImageIcon("img/Brancas/Rei.jpg");
		}else {
			img = new ImageIcon("img/Escuras/Rei.jpg");
		}
		
	}

}
