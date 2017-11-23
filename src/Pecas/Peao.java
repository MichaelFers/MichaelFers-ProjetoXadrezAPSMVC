package Pecas;

import javax.swing.ImageIcon;

import Enum.Cor;
import MovimentoPeca.MoveBispo;
import MovimentoPeca.MovePeao;
import MovimentoPeca.MoveTorre;
/**
 * Classe que representa a peça Peão no jogo e herdando da classe Peca.
 * Inicialmente o Peão fica localizado a frente das Torres,
 * Bispos, Cavalos, Rei e Rainha. Cada cor possui 8 peões
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
	 * Contrutor da classe que recebe posições iniciais e cor a ser localizados pelo tabuleiro fazendo uso
	 * do contrutor da super classe e adicionando ao arrayList um movimento respesctivo da peça
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
	 * Método inicial para apresentar as imagens da peça conforme 
	 * sua cor, sobrescrevendo o método da classe Peca.
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
	 * Método para verificar se o peão atravessou todo tabuleiro
	 * e utiliza o padrão Strategy para transforma-ló em uma Rainha limpando o movimento antigo
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
