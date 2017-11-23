package Padroes;

import View.TelaInicial;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *Esta classe representa o padrão Facade para a abstração do todo do programa, iniciando em seu contrutor
 *a viwe que representa a tela inicial do jogo
 */
public class Facade {
	
	public void iniciaJogo() {
		TelaInicial frame = new TelaInicial();
		frame.setVisible(true);
	}

}
