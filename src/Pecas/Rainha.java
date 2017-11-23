package Pecas;

import javax.swing.ImageIcon;

import Enum.Cor;
import MovimentoPeca.MoveBispo;
import MovimentoPeca.MoveTorre;
/**
 * Classe que representa a peça Rainha no jogo e herdando da classe Peca.
 * Inicialmente o Rainha fica localizado entre
 * o Rei e o Bispo. Cada cor possui 1 Rainha
 * 
 * @author Michael Fernandes
 * @author Silvana Silva
 * @author Jamile Felismina
 * @author Raul Louiz
 * @author Anderson Coutinho
 */
public class Rainha extends Peca{

	/**
	 * Contrutor da classe que recebe posições iniciais e cor a ser localizados pelo tabuleiro fazendo uso
	 * do contrutor da super classe e adicionando ao arrayList movimentos respesctivo da peça
	 * 
	 * @param x
	 * @param y
	 * @param cor
	 */
	public Rainha(int x, int y, Cor cor) {
		super(x, y, cor);
		super.movimento.add(new MoveBispo());
		super.movimento.add(new MoveTorre());
		
	}
	/**
	 * Método inicial para apresentar as imagens da peça conforme 
	 * sua cor, sobrescrevendo o método da classe Peca.
	 */
	@Override
	public void iniciaImg() {
		if(cor.BRANCO == cor) {
			img = new ImageIcon("img/Brancas/Rainha.jpg");
		}else {
			img = new ImageIcon("img/Escuras/Rainha.jpg");
		}
		
	}

}
