package Pecas;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import Enum.Cor;
import Excecoes.MovimentoNaoPermitido;
import MovimentoPeca.Movimento;
import Tabuleiro.Tabuleiro;
/**
 * Esta classe abstrata representa uma peca abstrata a ser herdade por peças específicas
 * assim, facilitando o uso dos padrões strategy e Factory Method
 * 
 * @author Michael Fernandes
 * @author Silvana Silva
 * @author Jamile Felismina
 * @author Raul Louiz
 * @author Anderson Coutinho
 */
public abstract class Peca {
	
	private int x, y;
	protected Cor cor;
	protected ImageIcon img;
	protected List<Movimento> movimento;
	private Tabuleiro ta = new Tabuleiro();
	/**
	 * Contrutor da classe que recebe posições iniciais e cor a ser localizados pelo tabuleiro.
	 * 
	 * @param x
	 * @param y
	 * @param cor
	 */
	public Peca(int x, int y, Cor cor) {
		this.x = x;
		this.y = y;
		this.cor = cor;
		movimento = new ArrayList();
		iniciaImg();
	}
	
	
	/**
	 * Método no qual verifica se tal movimento da peça pode ser realizado, fazendo uso de posição
	 * atual e para onde deseja ir.
	 * 
	 * @param xAtual
	 * @param yAtual
	 * @param xNovo
	 * @param yNovo
	 * @return
	 * @throws MovimentoNaoPermitido
	 */
	public boolean moverPeca(int xAtual, int yAtual, int xNovo, int yNovo) throws MovimentoNaoPermitido{
		
		boolean permicao = false;
		
		for(Movimento m: movimento) {
			permicao = m.mover(ta.getTabuleiro() , xAtual, yAtual,  xNovo,  yNovo);
			if(permicao) {
				
				return true;
			}
		}
		
		return permicao;
		
	}
	/**
	 * Método a ser implementado pelas classes que estão herdando da mesma.
	 */
	public abstract void iniciaImg();
	/**
	 * Método que retorna a posição x da peça no tabuleiro
	 * 
	 * @return
	 */
	public  int getX() {
		return x;
	}
	/**
	 * Método que retorna a posição y da peça no tabuleiro
	 * 
	 * @return
	 */
	public int getY() {
		return y;
	}
	/**
	 * Método que retorna a cor da peça.
	 * 
	 * @return
	 */
	public Cor getCor() {
		return cor;
	}
	/**
	 * Método que retorna a imagem que representa a peça
	 * 
	 * @return
	 */
	public ImageIcon getImg() {
		iniciaImg();
		return img;
	}
	/**
	 * Método que altera a posição da peça no tabuleiro
	 * 
	 * @return
	 */
	public void setPosicao(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
