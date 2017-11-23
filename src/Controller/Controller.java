package Controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import Excecoes.CorDaPecaNaoExiste;
import Excecoes.MovimentoNaoPermitido;
import Excecoes.TempoExpiradoException;
import Excecoes.Xeque;
import Excecoes.XequeMate;
import Jogador.Jogador;
import Model.Model;
import Pecas.Peca;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *Classe Controller, no qual faz uso do padrão MVC, esta classe
 *tem como objetivo solicitar valores ou alteração a classe Model
 *para ser ultilizado pelas View ao usuário. Os principais métodos fazem
 *chamada a classe responsável por armazenamento dos dados conforme
 *a regra do padrão MVC, tendo como seu atributo um objeto sendo instanciado
 *em seu contrutor do tipo Model.
 */
public class Controller {
	private Model model;

	public Controller() {
		model = new Model();
	}

	public void recebeEntradaNome(String nomeUm,String cor, String nomeDois) throws CorDaPecaNaoExiste {
		model.criacaoJogador(nomeUm,cor,nomeDois);
	}
	public boolean recebeEntradaMovimento(int xAtual, int yAtual, int xPara, int yPara) throws MovimentoNaoPermitido, Xeque, XequeMate, TempoExpiradoException{
		if(model.permicaoMoverPeca(xAtual, yAtual, xPara, yPara)) {

			return true;
		}else {
			throw new MovimentoNaoPermitido();
		}
	}
	public void comecou(JLabel tempo) {
		model.iniciarThread(tempo);
	}
	public String mostrarPartidasAntiga() {
		return model.mostrarPartidasAntiga();
	}
	public int getContador() throws  TempoExpiradoException{	
		return model.getContador();
	}
	public Jogador getJogadorUm() {
		return model.getJogadorUm();
	}
	public Jogador getJogadorDois() {
		return model.getJogadorDois();
	}
	public String vezJogador() {
		return model.vezJogador();
	}
	public void atualizarTabuleiro() {
		model.atualizaTabuleiro();
	}
	public void attImg(JButton[][] botoes) {
		model.attImg(botoes);
	}
	public String nomeJogadorUm() {
		return model.nomeJogadorUm();
	}
	public void resetaTabuleiro() {
		model.resetaTabuleiro();
	}
	public String nomeJogadorDois() {
		return model.nomeJogadorDois();
	}
	public String corJogadorUm() {
		return model.corJogadorUm();
	}
	public String corJogadorDois() {
		return model.corJogadorDois();
	}
	public Peca[][] getTabuleiro(){
		return model.getTabuleiro();
	}
	public void finaliza() {
		System.exit(0);
	}
}
