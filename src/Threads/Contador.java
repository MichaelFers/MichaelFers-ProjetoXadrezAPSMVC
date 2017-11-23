package Threads;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Excecoes.TempoExpiradoException;
import Excecoes.Xeque;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *Classe Contador herdando de Thread para a criação de uma mesma. Esta classe tem como
 *objetivo  realizar um contador que será ultizada para a verificação e assim possibilitando
 *o encerramento de uma partida.
 */
public class Contador extends Thread{
	private int cont;
	private JLabel b;
	private boolean xequeMate;

	public Contador(JLabel b) {
		xequeMate = false;
		resetaTempo();
		this.b = b;
	}
	/**
	 * método run, sobrescrito da classe Thread no qual é decrementado 1 apos 1000 milisegundos, para isso
	 * é ultilizado o método sleep herdado da classe Thread.
	 */
	@Override
	public void run() {

		while(cont > 0) {

			b.setText(""+cont);
			System.out.println(cont);
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
			cont--;
			if(acabou()) {
				break;
			}
		}
	}
	/**
	 * reseta o tempo usada pela model apos um jogador realizar uma jogada, jogando alguma peça
	 */
	public void resetaTempo() {
		cont = 30;
	}
	/**
	 * método no qual retorna o contador que representa os segundos que o jogador tem
	 * para realizar uma jogada
	 * @return
	 * @throws TempoExpiradoException caso o contador chegue a 0 é disparada a exceção
	 */
	public int getContador() throws  TempoExpiradoException{	
		if(cont == 0) {
			throw new TempoExpiradoException();
		}
		return cont;
	}
	/**
	 * método no qual retorna o xeequeMate, caso o jogador realiza o mesmo, assim, faz
	 * com que a Thread em seu tempo de execução seja interrompida.
	 * @return
	 */
	public boolean acabou() {
		return xequeMate;
	}
	/**
	 * método altera o atributo xequeMate, para a condição que se encontra no método run()
	 */
	public void setXequeMate() {
		xequeMate = true;
	}

}
