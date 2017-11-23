package Model;

import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import Enum.Cor;
import Excecoes.CorDaPecaNaoExiste;
import Excecoes.MovimentoNaoPermitido;
import Excecoes.TempoExpiradoException;
import Excecoes.Xeque;
import Excecoes.XequeMate;
import Gravador.GravadorDePartida;
import Jogador.Jogador;
import Padroes.FactoryMethod;
import Pecas.Peca;
import Pecas.PecaVazia;
import Tabuleiro.Tabuleiro;
import Threads.Contador;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *classe Model, a principal classe do programa, pois nela � armazenada todo o modelo do Jogo de xadrez.
 *A principal fun��o da classe � verificar as condi��o de movimento de pe�as e solicita��es pelo controller,
 *realiza mudan�as em seus atributos e outras classes, conforme o padr�o MVC.
 */

public class Model {
	private static Jogador um, dois;
	private Contador c;
	private Tabuleiro t = new Tabuleiro();
	private GravadorDePartida gravador;

	/**
	 * construtor, instanciando objeto do tipo GravadorDePartida() ultilizado para a grava��o de arquivos .txt
	 */
	public Model() {
		try {
			gravador = new GravadorDePartida();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * m�todo para a verifica��o de movimento de uma pe�a, possibilitando tal pe�a realizar movimento ou n�o
	 * @param xAtual recebe a posi��o da coluna atual da pe�a representada no tabuleiro
	 * @param yAtual recebe a posi��o da linha atual da pe�a representada no tabuleiro
	 * @param xPara recebe a posi��o da coluna para a qual a pe�a deseja ir no tabuleiro
	 * @param yPara recebe a posi��o da linha para a qual a pe�a deseja ir no tabuleiro
	 * @return	retorna a condi��o de movimento permitido da pe�a
	 * @throws MovimentoNaoPermitido
	 * @throws Xeque
	 * @throws XequeMate
	 * @throws TempoExpiradoException
	 */
	public boolean permicaoMoverPeca(int xAtual, int yAtual, int xPara, int yPara) throws MovimentoNaoPermitido, Xeque, XequeMate, TempoExpiradoException {
		if(c.getContador()!=0) {
			if(verificaSeExistePecaEMovimento(um,xAtual, yAtual,xPara, yPara)) {
				return true;
			}else if(verificaSeExistePecaEMovimento(dois,xAtual, yAtual,xPara, yPara)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * m�todo privado de uso interno da pr�pria classe, faz a verifica��o de movimento de uma pe�a, possibilitando tal pe�a realizar movimento ou n�o
	 * e alterando a posi��o da pe�a que ser� atualizada para a altera��o da mesma no tabuleiro
	 * @param j recebe um objeto do tipo jogador para chamar o metodo .getPecas() que representa todas as pe�as do jogador
	 * @param xAtual recebe a posi��o da coluna atual da pe�a representada no tabuleiro
	 * @param yAtual recebe a posi��o da linha atual da pe�a representada no tabuleiro
	 * @param xPara recebe a posi��o da coluna para a qual a pe�a deseja ir no tabuleiro
	 * @param yPara recebe a posi��o da linha para a qual a pe�a deseja ir no tabuleiro
	 * @return retorna a condi��o de movimento permitido da pe�a
	 * @throws MovimentoNaoPermitido
	 * @throws Xeque
	 * @throws XequeMate
	 */
	private boolean verificaSeExistePecaEMovimento(Jogador j,int xAtual, int yAtual, int xPara, int yPara) throws MovimentoNaoPermitido, Xeque, XequeMate {

		for(Peca p: j.getPecas()) {

			if(j.getNome().equals(um.getNome()) && um.getNome().equals(vezJogador()) && (p.getX()==xAtual && p.getY() == yAtual) && p.moverPeca(xAtual, yAtual, xPara, yPara)) {
				if((!(t.getTabuleiro()[xPara][yPara] instanceof PecaVazia)) && p.getCor() != t.getTabuleiro()[xPara][yPara].getCor()){
					removerPeca(dois,xPara, yPara);
				}

				p.setPosicao(xPara, yPara);
				t.getTabuleiro()[xAtual][yAtual] = null;
				passaAVez();

				c.resetaTempo();

				verificaXequeMate();

				return true;

			}if(j.getNome().equals(dois.getNome()) && dois.getNome().equals(vezJogador())&& (p.getX()==xAtual && p.getY() == yAtual) && p.moverPeca(xAtual, yAtual, xPara, yPara)){

				if((!(t.getTabuleiro()[xPara][yPara] instanceof PecaVazia)) && p.getCor() != t.getTabuleiro()[xPara][yPara].getCor()){
					removerPeca(um,xPara, yPara);
				}
				p.setPosicao(xPara, yPara);
				t.getTabuleiro()[xAtual][yAtual] = null;
				passaAVez();
				c.resetaTempo();
				verificaXequeMate();
				return true;
			}
		}
		return false;
	}
	/**
	 * m�todo para a verifica��o da vez do jogador
	 */
	public void passaAVez() {
		if(um.getVez()) {
			um.passaVez();
		}else {
			dois.passaVez();
			um.passaVez();
		}
	}
	/**
	 * m�todo para iniciar a Thread contador, que serve para contar o tempo, permitindo um jogador realizar
	 * ou n�o uma jogada
	 * @param tempo recebe um objeto do tipo JLabel para atualizar o contador no tabuleiro
	 */
	public void iniciarThread(JLabel tempo) {

		c = new Contador(tempo);
		c.start();
	}
	/**
	 * Este m�todo � repons�vel pela cria��o dos jogadores com seus nomes e cores.
	 * @param nomeUm recebe o nome do jogador um
	 * @param cor recebe cor do jogador um
	 * @param nomeDois recebe nome do jogador dois
	 * @throws CorDaPecaNaoExiste exce��o disporada caso a cor informada n�o seja branco ou preto
	 */
	public void criacaoJogador(String nomeUm, String cor,String nomeDois)throws CorDaPecaNaoExiste {
		if(cor.toLowerCase().equals("branco")) {
			um = new Jogador(nomeUm, Cor.BRANCO);
			dois = new Jogador(nomeDois,Cor.PRETO);
		}else if(cor.toLowerCase().equals("preto")){
			um = new Jogador(nomeUm, Cor.PRETO);
			dois = new Jogador(nomeDois,Cor.BRANCO);
		}else {
			throw new CorDaPecaNaoExiste();
		}
	}
	/**
	 * m�todo usado para a retornar o contador 
	 * @return retorna a representa��o do tempo 
	 * @throws TempoExpiradoException exce��o disparada caso o contador chegue a 0
	 */
	public int getContador() throws  TempoExpiradoException{
		if(c.getContador()==0) {
			throw new TempoExpiradoException();
		}else {
			return c.getContador();
		}
	}
	/**
	 * M�todo no qual retorna a o objeto jogadorUm usado pelo controller para a atualiza��o da viwe
	 * @return
	 */
	public Jogador getJogadorUm() {
		return um;
	}
	/**
	 * M�todo no qual retorna a o objeto jogadorDois usado pelo controller para a atualiza��o da viwe
	 * @return
	 */
	public Jogador getJogadorDois() {
		return dois;
	}
	/**
	 * m�todo para remover pe�a do jogador
	 * @param j recebe o objeto do tipo jogador para ser usado o m�todo getPecas() do mesmo e assim realizar condi��o
	 * @param x posi��o x da pe�a no tabuleiro
	 * @param y posi��o y da pe�a no tabuleiro
	 */
	public void removerPeca(Jogador j, int x, int y) {
		for(Peca p: j.getPecas()) {
			if(p.getX()==x && p.getY()==y) {
				j.removePeca(x, y);
				break;
			}
		}
	}
	/**
	 * m�todo para verificar o xeque-mate do jogador caso o outro jogador perca a pe�a rei e xeque, caso alguma
	 * pe�a do jogador consiga fazer um movimento at� a pe�a rei do outro jogador
	 * @throws XequeMate
	 * @throws MovimentoNaoPermitido
	 * @throws Xeque
	 */
	public void verificaXequeMate() throws XequeMate, MovimentoNaoPermitido, Xeque{
		Peca reiDois = dois.getRei();
		Peca reiUm = um.getRei();
		if(reiDois != null) {
			for(Peca p: um.getPecas()){
				if(p.moverPeca(p.getX(), p.getY(), reiDois.getX(), reiDois.getY())){
					throw new Xeque(um.getNome());
				}
			}
		}if(reiUm != null) {
			for(Peca p: dois.getPecas()){
				if(p.moverPeca(p.getX(), p.getY(), reiUm.getX(), reiUm.getY())){
					throw new Xeque(dois.getNome());
				}
			}
		}
		if(reiDois == null){
			gravarPartidaEmArquivo(um,dois);
			c.setXequeMate();
			throw new XequeMate(um.getNome());
		}if(reiUm == null){
			gravarPartidaEmArquivo(dois,um);
			c.setXequeMate();
			throw new XequeMate(dois.getNome());
		}
	}
/**
 * m�todo que faz um da classe respons�vel para a cria��o e leitura de arquivo, esse m�todo � usado
 * quando � realizado um xeque-Mate
 * @param um
 * @param dois
 */
	public void gravarPartidaEmArquivo(Jogador um, Jogador dois) {
		try {
			gravador.gravar("Vencedor: "+um.getNome()+", xeque-Mate em "+dois.getNome() );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * M�todo para retornar o jogador da vez
	 * @return nome do jogador da vez
	 */
	public String vezJogador(){

		if(um.getVez()){
			return um.getNome();
		}
		else{
			return dois.getNome();
		}		
	}
	/**
	 * M�todo no qual atualiza o tabuleiro, preenchendo com pe�as vazia o tabuleiro fazendo uso do padr�o
	 * Factory Method e do m�todo addPecas, adicionando as pe�as dos jogadores em suas posi��es iniciais
	 * ou na posi��o da qual as pe�as est�o posicionadas no tabuleiro
	 */
	public void atualizaTabuleiro() {
		FactoryMethod factory = new FactoryMethod();
		addPecas(um.getPecas());
		addPecas(dois.getPecas());
		for (int x = 0; x < t.getTabuleiro().length; x++) {
			int d = (x + 1) % 2;
			for (int y = 0; y < t.getTabuleiro()[x].length; y++) {

				if (t.getTabuleiro()[x][y] == null) {
					int q = (y + 1) % 2;
					if (d == 1) {
						if (q == 0) {
							t.getTabuleiro()[x][y] = factory.getPeca(null,x, y, Cor.BRANCO);
						} else {
							t.getTabuleiro()[x][y] = factory.getPeca(null,x, y, Cor.PRETO);
						}
					} else {
						if (q == 0) {
							t.getTabuleiro()[x][y] = factory.getPeca(null,x, y, Cor.PRETO);
						} else {
							t.getTabuleiro()[x][y] = factory.getPeca(null,x, y, Cor.BRANCO);

						}
					}
				}
			}
		}
	}
	/**
	 * M�todo usado para resetar o tabuleiro quando o jogador quiser jogar novamente outra partida sem 
	 * sair do programa
	 */
	public void resetaTabuleiro() {
		t.resetaTabuleiro();
	}
	/**
	 * adiciona pe�as com suas posi��es ao tabuleiro
	 * @param pe lista de pe�as do jogador
	 */
	public void addPecas(List<Peca> pe) {
		for (Peca p : pe) {
			t.getTabuleiro()[p.getX()][p.getY()] = p;
		}
	}
	/**
	 * Atualiza as imagens dos bot�es com as imagens das pe�as respectivas.
	 * @param botoes
	 */
	public void attImg(JButton[][] botoes) {
		for(int x=0; x< botoes.length;x++ ) {
			for(int y=0; y<botoes[x].length; y++) {
				botoes[x][y].setIcon(t.getTabuleiro()[x][y].getImg());
			}
		}
	}
	/**
	 * M�todo no qual retorna o nome do jogadorUm usado pelo controller para a atualiza��o da viwe
	 * @return
	 */
	public String nomeJogadorUm() {
		return um.getNome();
	}
	/**
	 * M�todo no qual retorna o nome do jogadorDois usado pelo controller para a atualiza��o da viwe
	 * @return
	 */
	public String nomeJogadorDois() {
		return dois.getNome();
	}
	/**
	 * M�todo no qual retorna a cor do jogadorUm usado pelo controller para a atualiza��o da viwe
	 * @return
	 */
	public String corJogadorUm() {
		return um.getCor().toString();
	}
	/**
	 * M�todo no qual retorna a cor do jogadorDois usado pelo controller para a atualiza��o da viwe
	 * @return
	 */
	public String corJogadorDois() {
		return dois.getCor().toString();
	}
	/**
	 * M�todo no qual retorna o tabuleiro que � representado com um array bidimencional, 8 linhas e 8 colunas.
	 * @return
	 */
	public Peca[][] getTabuleiro(){
		return t.getTabuleiro();
	}
	/**
	 * Este m�todo faz uso da classe gravador, instanciada em seu contrutor para a leitura de arquivos
	 * @return retorna o conte�do encontrado no arquivo
	 */
	public String mostrarPartidasAntiga() {
		try {
			return gravador.ler();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
