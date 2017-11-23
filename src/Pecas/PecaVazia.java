package Pecas;

import javax.swing.ImageIcon;

import Enum.Cor;
/**
 * Classe que representa a peça vazia no jogo e herdando da classe Peca.
 * 
 * @author Michael Fernandes
 * @author Silvana Silva
 * @author Jamile Felismina
 * @author Raul Louiz
 * @author Anderson Coutinho
 */
public class PecaVazia extends Peca{
	/**
	 * Contrutor da classe que recebe posições iniciais e cor a ser localizados pelo tabuleiro fazendo uso
	 * do contrutor da super classe e adicionando ao arrayList um movimento respesctivo da peça
	 * 
	 * @param x
	 * @param y
	 * @param cor
	 */
	public PecaVazia(int x, int y, Cor cor) {
		super(x, y, cor);
		
	}
	/**
	 * Método inicial para apresentar as imagens da peça conforme 
	 * sua cor, sobrescrevendo o método da classe Peca.
	 */
	@Override
	public void iniciaImg() {
		if(cor.BRANCO == cor) {
			
			img = new ImageIcon("img/Brancas/fundo.jpg");
		}else {
			img = new ImageIcon("img/Escuras/fundo.jpg");
		}
		
	}

}
