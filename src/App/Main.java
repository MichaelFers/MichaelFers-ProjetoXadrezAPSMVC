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
 *Classe principal fazendo uso do padr�o Fachada e seu m�todo de
 *inicializa��o do jogo
 */
public class Main {

	public static void main(String[] args) {
		Facade fachada = new Facade();
		fachada.iniciaJogo();
	}

}
