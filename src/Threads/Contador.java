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
 *Classe Contador herdando de Thread para a cria��o de uma mesma. Esta classe tem como
 *objetivo  realizar um contador que ser� ultizada para a verifica��o e assim possibilitando
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
	 * m�todo run, sobrescrito da classe Thread no qual � decrementado 1 apos 1000 milisegundos, para isso
	 * � ultilizado o m�todo sleep herdado da classe Thread.
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
	 * reseta o tempo usada pela model apos um jogador realizar uma jogada, jogando alguma pe�a
	 */
	public void resetaTempo() {
		cont = 30;
	}
	/**
	 * m�todo no qual retorna o contador que representa os segundos que o jogador tem
	 * para realizar uma jogada
	 * @return
	 * @throws TempoExpiradoException caso o contador chegue a 0 � disparada a exce��o
	 */
	public int getContador() throws  TempoExpiradoException{	
		if(cont == 0) {
			throw new TempoExpiradoException();
		}
		return cont;
	}
	/**
	 * m�todo no qual retorna o xeequeMate, caso o jogador realiza o mesmo, assim, faz
	 * com que a Thread em seu tempo de execu��o seja interrompida.
	 * @return
	 */
	public boolean acabou() {
		return xequeMate;
	}
	/**
	 * m�todo altera o atributo xequeMate, para a condi��o que se encontra no m�todo run()
	 */
	public void setXequeMate() {
		xequeMate = true;
	}

}
