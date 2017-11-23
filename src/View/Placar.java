package View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import javax.swing.JLabel;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *Esta classe representa uma tela, herdando de JFrame para a exibição do placar de partidas antigas
 *fazendo uso do objeto gravador e solicitando pelo controller conforme padrãp MVC
 *em seu contrutor se encontra as instancias necessárias para a exibição dos elementos na tela
 */
public class Placar extends JFrame {

	private JPanel contentPane;
	private Controller controle;
	public Placar() {
		setTitle("Histórico de partidas");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setResizable(false);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		controle = new Controller();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel historico = new JLabel(controle.mostrarPartidasAntiga());
		historico.setBounds(10, 11, 424, 249);
		contentPane.add(historico);
		
	}
}
