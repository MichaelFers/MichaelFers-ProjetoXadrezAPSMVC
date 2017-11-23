package Pecas;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import Enum.Cor;
import Excecoes.MovimentoNaoPermitido;
import MovimentoPeca.Movimento;
import Tabuleiro.Tabuleiro;
/**
 * Esta classe abstrata representa uma peca abstrata a ser herdade por pe�as espec�ficas
 * assim, facilitando o uso dos padr�es strategy e Factory Method
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
	 * Contrutor da classe que recebe posi��es iniciais e cor a ser localizados pelo tabuleiro.
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
	 * M�todo no qual verifica se tal movimento da pe�a pode ser realizado, fazendo uso de posi��o
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
	 * M�todo a ser implementado pelas classes que est�o herdando da mesma.
	 */
	public abstract void iniciaImg();
	/**
	 * M�todo que retorna a posi��o x da pe�a no tabuleiro
	 * 
	 * @return
	 */
	public  int getX() {
		return x;
	}
	/**
	 * M�todo que retorna a posi��o y da pe�a no tabuleiro
	 * 
	 * @return
	 */
	public int getY() {
		return y;
	}
	/**
	 * M�todo que retorna a cor da pe�a.
	 * 
	 * @return
	 */
	public Cor getCor() {
		return cor;
	}
	/**
	 * M�todo que retorna a imagem que representa a pe�a
	 * 
	 * @return
	 */
	public ImageIcon getImg() {
		iniciaImg();
		return img;
	}
	/**
	 * M�todo que altera a posi��o da pe�a no tabuleiro
	 * 
	 * @return
	 */
	public void setPosicao(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
