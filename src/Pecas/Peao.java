package Pecas;

import javax.swing.ImageIcon;

import Enum.Cor;
import MovimentoPeca.MoveBispo;
import MovimentoPeca.MovePeao;
import MovimentoPeca.MoveTorre;
/**
 * Classe que representa a pe�a Pe�o no jogo e herdando da classe Peca.
 * Inicialmente o Pe�o fica localizado a frente das Torres,
 * Bispos, Cavalos, Rei e Rainha. Cada cor possui 8 pe�es
 * 
 * @author Michael Fernandes
 * @author Silvana Silva
 * @author Jamile Felismina
 * @author Raul Louiz
 * @author Anderson Coutinho
 */
public class Peao extends Peca{
	boolean virouRainha = false;
	/**
	 * Contrutor da classe que recebe posi��es iniciais e cor a ser localizados pelo tabuleiro fazendo uso
	 * do contrutor da super classe e adicionando ao arrayList um movimento respesctivo da pe�a
	 * 
	 * @param x
	 * @param y
	 * @param cor
	 */
	public Peao(int x, int y, Cor cor) {
		super(x, y, cor);
		super.movimento.add(new MovePeao());

	}
	/**
	 * M�todo inicial para apresentar as imagens da pe�a conforme 
	 * sua cor, sobrescrevendo o m�todo da classe Peca.
	 */
	@Override
	public void  iniciaImg() {
		verificaPeaoVirouRainha();
		if(virouRainha== false) {
			if(cor.BRANCO == cor) {
				img = new ImageIcon("img/Brancas/Peao.jpg");
			}else {
				img = new ImageIcon("img/Escuras/Peao.jpg");
			}
		}else {
			if(cor.BRANCO == cor) {
				img = new ImageIcon("img/Brancas/Rainha.jpg");
			}else {
				img = new ImageIcon("img/Escuras/Rainha.jpg");
			}
		}
	}
	/**
	 * M�todo para verificar se o pe�o atravessou todo tabuleiro
	 * e utiliza o padr�o Strategy para transforma-l� em uma Rainha limpando o movimento antigo
	 * e instanciando movimento para representar o movimento da rainha. 
	 */
	public void verificaPeaoVirouRainha(){

		if((super.getCor()==Cor.BRANCO && super.getX()==0) || (super.getCor() ==Cor.PRETO && super.getX()==7)){
			this.virouRainha = true;
			this.movimento.clear();
			this.movimento.add(new MoveTorre());
			this.movimento.add(new MoveBispo());
		}
	}

}
