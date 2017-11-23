package Pecas;

import javax.swing.ImageIcon;

import Enum.Cor;
import MovimentoPeca.MoveBispo;
/**
 * Classe que representa a pe�a Bispo no jogo e herdando da classe Peca.
 * Inicialmente o Bispo fica localizado entre
 * o Cavalo e Rei. Cada cor possui 2 Bispos
 * 
 * @author Michael Fernandes
 * @author Silvana Silva
 * @author Jamile Felismina
 * @author Raul Louiz
 * @author Anderson Coutinho
 */
public class Bispo extends Peca {
	
	/**
	 * Contrutor da classe que recebe posi��es iniciais e cor a ser localizados pelo tabuleiro fazendo uso
	 * do contrutor da super classe e adicionando ao arrayList um movimento respesctivo da pe�a
	 * 
	 * @param x
	 * @param y
	 * @param cor
	 */
	public Bispo(int x, int y, Cor cor) {
		super(x, y, cor);
		super.movimento.add(new MoveBispo());
		
	}
	/**
	 * M�todo inicial para apresentar as imagens da pe�a conforme 
	 * sua cor sobrescrevendo o m�todo da classe Peca.
	 */
	@Override
	public void iniciaImg() {
		if(cor.BRANCO == cor) {
			img = new ImageIcon("img/Brancas/Bispo.jpg");
		}else {
			img = new ImageIcon("img/Escuras/Bispo.jpg");
		}
		
	}
}
