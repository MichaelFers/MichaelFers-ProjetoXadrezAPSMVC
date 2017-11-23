package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.Controller;
import Excecoes.MovimentoNaoPermitido;
import Excecoes.TempoExpiradoException;
import Excecoes.Xeque;
import Excecoes.XequeMate;
import Pecas.Peca;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *Esta classe representa uma tela, sendo a tela principal para a exibição do jogo de xadrez, herdando de JFrame para a exibição de seus componentes
 *e fazendo uso de ações ao clique do botões e/ou de objetos que é representado como peças do jogo de xadrez
 *fazendo uso do objeto controller e solicitando pelo mesmo a realização de mobimentos e condições, conforme padrãp MVC
 *em seu contrutor se encontra as instancias necessárias para a exibição dos elementos na tela
 *em seus atributos de encontram as principais ferramentas para a sua execução.
 */
public class TelaTabuleiro extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton[][] botoes = new JButton[8][8];
	private int x = -1, y = -1;
	private JLabel tempo;
	private JLabel nomeJogadorDaVez;

	private Controller controle;

	public TelaTabuleiro() throws IOException {
		this.controle = new Controller();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				int i = JOptionPane.showConfirmDialog(null ,"Deseja sair?", "Sair",JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					repaint();
				}
			}
		});
		setBounds(400, 50, 773, 577);
		setTitle("Jogo Xadrez");
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		controle.atualizarTabuleiro();
		criarLabels();
		criarBotoes();
		controle.comecou(tempo);
	}

	/**
	 * método no qual realiza a criação de botões e suas posição na tela, para representar um jogo de xadrez
	 * o metodo faz uso do controlle para solicitar o tabuleiro que contém as peças, pegando suas imagens e alterando
	 * a mesmo em sua imagem dos botões.
	 */
	public void criarBotoes() {

		Peca[][] p = controle.getTabuleiro();

		for(int x=0; x< botoes.length;x++ ) {

			for(int y=0; y<botoes[x].length; y++) {
				botoes[x][y] = new JButton(p[x][y].getImg());

				if(x==0 && y==0) {
					botoes[x][y].setBounds(30, 34, 64, 63);
				}if(x==0 && y==1) {
					botoes[x][y].setBounds(92, 34, 64, 63);
				}if(x==0 && y==2) {
					botoes[x][y].setBounds(155, 34, 64, 63);
				}if(x==0 && y==3) {
					botoes[x][y].setBounds(218, 34, 64, 63);
				}if(x==0 && y==4) {
					botoes[x][y].setBounds(281, 34, 64, 63);
				}if(x==0 && y==5) {
					botoes[x][y].setBounds(344, 34, 64, 63);
				}if(x==0 && y==6) {
					botoes[x][y].setBounds(408, 34, 64, 63);
				}if(x==0 && y==7) {
					botoes[x][y].setBounds(471, 34, 64, 63);
				}if(x==1 && y==0) {
					botoes[x][y].setBounds(30, 95, 64, 63);
				}if(x==1 && y==1) {
					botoes[x][y].setBounds(92, 95, 64, 63);
				}if(x==1 && y==2) {
					botoes[x][y].setBounds(155, 95, 64, 63);
				}if(x==1 && y==3) {
					botoes[x][y].setBounds(218, 95, 64, 63);
				}if(x==1 && y==4) {
					botoes[x][y].setBounds(281, 95, 64, 63);
				}if(x==1 && y==5) {
					botoes[x][y].setBounds(344, 95, 64, 63);
				}if(x==1 && y==6) {
					botoes[x][y].setBounds(408, 95, 64, 63);
				}if(x==1 && y==7) {
					botoes[x][y].setBounds(471, 95, 64, 63);
				}if(x==2 && y==0) {
					botoes[x][y].setBounds(30, 157, 64, 63);
				}if(x==2 && y==1) {
					botoes[x][y].setBounds(92, 157, 64, 63);
				}if(x==2 && y==2) {
					botoes[x][y].setBounds(155, 157, 64, 63);
				}if(x==2 && y==3) {
					botoes[x][y].setBounds(218, 157, 64, 63);
				}if(x==2 && y==4) {
					botoes[x][y].setBounds(281, 157, 64, 63);
				}if(x==2 && y==5) {
					botoes[x][y].setBounds(344, 157, 64, 63);
				}if(x==2 && y==6) {
					botoes[x][y].setBounds(408, 157, 64, 63);
				}if(x==2 && y==7) {
					botoes[x][y].setBounds(471, 157, 64, 63);
				}if(x==3 && y==0) {
					botoes[x][y].setBounds(30, 218, 64, 63);
				}if(x==3 && y==1) {
					botoes[x][y].setBounds(92, 218, 64, 63);
				}if(x==3 && y==2) {
					botoes[x][y].setBounds(155, 218, 64, 63);
				}if(x==3 && y==3) {
					botoes[x][y].setBounds(218, 218, 64, 63);
				}if(x==3 && y==4) {
					botoes[x][y].setBounds(281, 218, 64, 63);
				}if(x==3 && y==5) {
					botoes[x][y].setBounds(344, 218, 64, 63);
				}if(x==3 && y==6) {
					botoes[x][y].setBounds(408, 218, 64, 63);
				}if(x==3 && y==7) {
					botoes[x][y].setBounds(471, 218, 64, 63);
				}if(x==4 && y==0) {
					botoes[x][y].setBounds(30, 281, 64, 63);
				}if(x==4 && y==1) {
					botoes[x][y].setBounds(92, 281, 64, 63);
				}if(x==4 && y==2) {
					botoes[x][y].setBounds(155, 281, 64, 63);
				}if(x==4 && y==3) {
					botoes[x][y].setBounds(218, 281, 64, 63);
				}if(x==4 && y==4) {
					botoes[x][y].setBounds(281, 281, 64, 63);
				}if(x==4 && y==5) {
					botoes[x][y].setBounds(344, 281, 64, 63);
				}if(x==4 && y==6) {
					botoes[x][y].setBounds(408, 281, 64, 63);
				}if(x==4 && y==7) {
					botoes[x][y].setBounds(471, 281, 64, 63);
				}if(x==5 && y==0) {
					botoes[x][y].setBounds(30, 342, 64, 63);
				}if(x==5 && y==1) {
					botoes[x][y].setBounds(92, 342, 64, 63);
				}if(x==5 && y == 2) {
					botoes[x][y].setBounds(155, 342, 64, 63);
				}if(x==5 && y == 3) {
					botoes[x][y].setBounds(218, 342, 64, 63);
				}if(x==5 && y == 4) {
					botoes[x][y].setBounds(281, 342, 64, 63);
				}if(x==5 && y == 5) {
					botoes[x][y].setBounds(344, 342, 64, 63);
				}if(x==5 && y == 6) {
					botoes[x][y].setBounds(408, 342, 64, 63);
				}if(x==5 && y == 7) {
					botoes[x][y].setBounds(471, 342, 64, 63);
				}if(x==6 && y == 0) {
					botoes[x][y].setBounds(30, 403, 64, 63);
				}if(x==6 && y == 1) {
					botoes[x][y].setBounds(92, 403, 64, 63);
				}if(x==6 && y == 2) {
					botoes[x][y].setBounds(155, 403, 64, 63);
				}if(x==6 && y == 3) {
					botoes[x][y].setBounds(218, 403, 64, 63);
				}if(x==6 && y == 4) {
					botoes[x][y].setBounds(281, 403, 64, 63);
				}if(x==6 && y == 5) {
					botoes[x][y].setBounds(344, 403, 64, 63);
				}if(x==6 && y == 6) {
					botoes[x][y].setBounds(408, 403, 64, 63);
				}if(x==6 && y == 7) {
					botoes[x][y].setBounds(471, 403, 64, 63);
				}if(x==7 && y == 0) {
					botoes[x][y].setBounds(30, 464, 64, 63);
				}if(x==7 && y == 1) {
					botoes[x][y].setBounds(92, 464, 64, 63);
				}if(x==7 && y == 2) {
					botoes[x][y].setBounds(155, 464, 64, 63);
				}if(x==7 && y == 3) {
					botoes[x][y].setBounds(218, 464, 64, 63);
				}if(x==7 && y == 4) {
					botoes[x][y].setBounds(281, 464, 64, 63);
				}if(x==7 && y == 5) {
					botoes[x][y].setBounds(344, 464, 64, 63);
				}if(x==7 && y == 6) {
					botoes[x][y].setBounds(408, 464, 64, 63);
				}if(x==7 && y == 7) {
					botoes[x][y].setBounds(471, 464, 64, 63);
				}
				contentPane.add(botoes[x][y]);
				botoes[x][y].addActionListener(this);
			}
		}
	}

	/**
	 * método no qual é realizado a ação do clique nos botões, pegando os valores da peça atual na sua primeira condição
	 * e na segunda, verificando pelo controller se a peça pode fazer tal movimento, apos o movimento realizado ou
	 * disporada a exceção, é resetado os valores de x e y, assim podendo realizar a condição para saber do primeiro clique
	 * que representa a peça atual e o segundo clique, reprensentando assim para onde tal peça deseja ir,
	 * alterando assim, o jogador da vez pelo controller e atualizando o tabuleiro com a nova imagem
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if(x == -1 && y == -1) {
			for(int x=0; x< botoes.length;x++ ) {

				for(int y=0; y<botoes[x].length; y++) {
					if(e.getSource() == botoes[x][y]) {
						this.x = x;
						this.y = y;
					}
				}
			}
		}else {
			for(int x=0; x< botoes.length;x++ ) {

				for(int y=0; y<botoes[x].length; y++) {
					if(e.getSource() == botoes[x][y]) {

						try {

							if(controle.recebeEntradaMovimento(this.x, this.y, x, y)) {

								nomeJogadorDaVez.setText(controle.vezJogador());
								controle.atualizarTabuleiro();
								controle.attImg(botoes);
								zerarXY();
							}
						} catch (MovimentoNaoPermitido | Xeque | XequeMate | TempoExpiradoException e1) {
							if(e1 instanceof XequeMate) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
								controle.atualizarTabuleiro();
								controle.attImg(botoes);
								int i = JOptionPane.showConfirmDialog(null ,"Jogar outra partida?", "Sair",JOptionPane.YES_NO_OPTION);
								if (i == JOptionPane.YES_OPTION) {
									TelaInicial t = new TelaInicial();
									t.setVisible(true);

									controle.resetaTabuleiro();
									dispose();
									break;
								} else {

									controle.finaliza();
								}

							}if(e1 instanceof Xeque) {
								JOptionPane.showMessageDialog(null, e1.getMessage());

								zerarXY();

								nomeJogadorDaVez.setText(controle.vezJogador());
								controle.atualizarTabuleiro();
								controle.attImg(botoes);
								continue;
							}if(e1 instanceof TempoExpiradoException) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
								System.exit(0);
							}
							JOptionPane.showMessageDialog(null, e1.getMessage());
							zerarXY();
							continue;
						}
					}

				}
			}
		}
	}
	/**
	 * método no qual instancia os jlabels e adiciona ao seu conteiner com seus títulos e posição
	 */
	public void criarLabels() {
		JLabel lblNomeJogador = new JLabel("Nome jogador:");
		lblNomeJogador.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeJogador.setBounds(560, 125, 86, 14);
		contentPane.add(lblNomeJogador);

		JLabel lbJogador = new JLabel(controle.nomeJogadorUm());
		lbJogador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbJogador.setBounds(656, 125, 91, 14);
		contentPane.add(lbJogador);

		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblX.setBounds(625, 170, 15, 14);
		contentPane.add(lblX);

		JLabel lblNewLabel = new JLabel("Nome Jogador:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(560, 196, 86, 14);
		contentPane.add(lblNewLabel);

		JLabel lbJogador2 = new JLabel(controle.nomeJogadorDois());
		lbJogador2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbJogador2.setBounds(656, 196, 91, 14);
		contentPane.add(lbJogador2);

		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCor.setBounds(560, 150, 46, 14);
		contentPane.add(lblCor);

		JLabel lbCorJ1 = new JLabel(controle.corJogadorUm());
		lbCorJ1.setBounds(656, 150, 66, 14);
		contentPane.add(lbCorJ1);

		JLabel lblCor_1 = new JLabel("Cor:");
		lblCor_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCor_1.setBounds(560, 221, 46, 14);
		contentPane.add(lblCor_1);

		JLabel lbCorJ2 = new JLabel(controle.corJogadorDois());
		lbCorJ2.setBounds(656, 221, 66, 14);
		contentPane.add(lbCorJ2);

		JLabel jogadorDaVez = new JLabel("Nome do Jogador da vez");
		jogadorDaVez.setFont(new Font("Tahoma", Font.BOLD, 11));
		jogadorDaVez.setBounds(560, 281, 162, 14);
		contentPane.add(jogadorDaVez);

		nomeJogadorDaVez = new JLabel(controle.vezJogador());
		nomeJogadorDaVez.setBounds(606, 318, 116, 14);
		contentPane.add(nomeJogadorDaVez);

		JLabel msgTempo = new JLabel("Tempo");
		msgTempo.setFont(new Font("Tahoma", Font.BOLD, 11));
		msgTempo.setBounds(606, 354, 66, 14);
		contentPane.add(msgTempo);

		tempo = new JLabel("");
		tempo.setBounds(623, 379, 46, 14);
		contentPane.add(tempo);
	}
	/**
	 * método no qual é usado pela actionPerformed possibilitando a mobimentação correta das peças no tabuleiro
	 */
	public void zerarXY(){
		this.x = -1;
		this.y = -1;
	}

}
