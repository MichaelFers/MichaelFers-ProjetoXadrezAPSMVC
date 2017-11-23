package App;

import Padroes.Facade;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *Classe principal fazendo uso do padrão Fachada e seu método de
 *inicialização do jogo
 */
public class Main {

	public static void main(String[] args) {
		Facade fachada = new Facade();
		fachada.iniciaJogo();
	}

}
