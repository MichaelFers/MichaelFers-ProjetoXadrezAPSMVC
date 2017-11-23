package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.Controller;
import Excecoes.CorDaPecaNaoExiste;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *Esta classe representa uma tela, sendo a tela inicial do jogo, herdando de JFrame para a exibição de seus componentes
 *e fazendo uso de ações ao clique do botões e/ou de objetos do tipo JMenuItem
 *fazendo uso do objeto controller e solicitando pelo mesmo a criação de jogadores conforme padrãp MVC
 *em seu contrutor se encontra as instancias necessárias para a exibição dos elementos na tela
 */
public class TelaInicial extends JFrame implements ActionListener {

	private JPanel contentPane;
	JMenuBar menuBar;
	JMenu mnNewMenu;
	JMenuItem novoJogo;
	JMenuItem placar;
	JMenuItem about;
	JMenuItem sair; 
	ImageIcon img1;
	JButton btInicia; 
	ImageIcon img2;
	JLabel lbImg;
	Controller c;


	public TelaInicial() {
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
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(400, 100, 589, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Jogo Xadrez");

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 573, 21);
		contentPane.add(menuBar);

		mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		novoJogo = new JMenuItem("Novo Jogo");
		mnNewMenu.add(novoJogo);

		placar = new JMenuItem("Placar Partidas");
		placar.addActionListener(this);
		mnNewMenu.add(placar);

		about = new JMenuItem("About");
		about.addActionListener(this);
		mnNewMenu.add(about);

		sair = new JMenuItem("Sair");
		menuBar.add(sair);
		sair.addActionListener(this);
		novoJogo.addActionListener(this);

		img1 = new ImageIcon(
				"img/start.jpg");

		btInicia = new JButton(img1);
		btInicia.setBounds(236, 159, 121, 87);
		btInicia.addActionListener(this);
		contentPane.add(btInicia);

		img2 = new ImageIcon(
				"img/telaInicial.jpg");

		lbImg = new JLabel(img2);
		lbImg.setBounds(0, 0, 566, 426);
		contentPane.add(lbImg);
		c = new Controller();

	}
/**
 * este método é usado como ação ao clique fazendo comparações de ações geradas e reagindo conforme é representado
 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		if(arg0.getSource() == btInicia || arg0.getSource() == novoJogo) {

			try {
				c.recebeEntradaNome(JOptionPane.showInputDialog("Informe o nome do jogador 1"),JOptionPane.showInputDialog("Informe a cor do jogador"), JOptionPane.showInputDialog("Informe o nome do jogador 2"));
				TelaTabuleiro tela  = new TelaTabuleiro();
				tela.setVisible(true);
				dispose();

			} catch (CorDaPecaNaoExiste | IOException  e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}if(arg0.getSource() == placar) {
			Placar p = new Placar();
			p.setVisible(true);
		}
		if(arg0.getSource() == sair) {

			int i = JOptionPane.showConfirmDialog(null ,"Deseja sair?", "Sair",JOptionPane.YES_NO_OPTION);
			if (i == JOptionPane.YES_OPTION) {
				System.exit(0);
			} else {
				repaint();
			}
		}if(arg0.getSource() == about) {
			Desenvolvedores d = new Desenvolvedores();
			d.setVisible(true);
		}
	}
}
