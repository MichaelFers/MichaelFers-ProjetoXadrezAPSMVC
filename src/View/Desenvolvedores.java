package View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
 *Esta classe representa uma tela, herdando de JFrame para a exibição dos desenvolvedores do projeto
 *em seu contrutor se encontra as instancias necessárias para a exibição dos elementos na tela
 */
public class Desenvolvedores extends JFrame {

	private JPanel contentPane;

	public Desenvolvedores() {
		setTitle("Desenvolvedores");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setResizable(false);
		
		setBounds(100, 100, 563, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblEsteProjetoFoi = new JLabel("Este projeto foi realizado com a parceria dos alunos da disciplina APS");
		lblEsteProjetoFoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEsteProjetoFoi.setBounds(49, 26, 452, 14);
		contentPane.add(lblEsteProjetoFoi);
		
		JLabel lblMichaelFernandesDa = new JLabel("Michael Fernandes da Silva");
		lblMichaelFernandesDa.setBounds(84, 127, 159, 25);
		contentPane.add(lblMichaelFernandesDa);
		
		JLabel lblSilvanaSilva = new JLabel("Silvana Silva ");
		lblSilvanaSilva.setBounds(339, 132, 119, 14);
		contentPane.add(lblSilvanaSilva);
		
		ImageIcon img = new ImageIcon("ufpb.png");
		
		
		JLabel lblNewLabel = new JLabel("Jamile Felismina");
		lblNewLabel.setBounds(90, 174, 119, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblRaulLouiz = new JLabel("Raul Louiz");
		lblRaulLouiz.setBounds(339, 174, 119, 14);
		contentPane.add(lblRaulLouiz);
		
		JLabel lblNewLabel_1 = new JLabel("Anderson coutinho");
		lblNewLabel_1.setBounds(221, 208, 119, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblProjetoJogoDe = new JLabel("Projeto: Jogo De Xadrez");
		lblProjetoJogoDe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProjetoJogoDe.setBounds(183, 67, 169, 14);
		contentPane.add(lblProjetoJogoDe);
		
		JLabel lblDesenvolvedores = new JLabel("Desenvolvedores:");
		lblDesenvolvedores.setBounds(220, 102, 120, 14);
		contentPane.add(lblDesenvolvedores);
		JLabel lbImg = new JLabel(img);
		lbImg.setBounds(68, 11, 414, 239);
		contentPane.add(lbImg);
		
		
		
		
		
		
	}
}
