package Jogador;

import java.util.ArrayList;
import java.util.List;

import Enum.Cor;
import Padroes.FactoryMethod;
import Pecas.*;
/**
 * 
 *@author Michael Fernandes
 *@author Silvana Silva
 *@author Jamile Felismina
 *@author Raul 
 *@author Anderson coutinho
 *
 *Classe Jogador, representa um jogador para o jogo de xadrez, contendo atributos
 *que ser�o ultilizados pelo classe Model. Esta classe faz uso do padr�o Factory Method
 */
public class Jogador {

	private String nome;
	private List<Peca> pecas;
	private Cor cor;
	private boolean vez;

	/**
	 * Construtor da classe, recebendo seus atributos e instanciando o ArrayList
	 * logo ap�s, chamado o m�todo addTodasAsPecas()
	 * @param nome recebe o nome do jogador
	 * @param cor recebe a cor da pe�a no qual representar� o lado no Tabuleiro de xadrez
	 */
	public Jogador(String nome, Cor cor) {
		pecas = new ArrayList();
		this.nome = nome;
		this.cor = cor;
		vez = true;
		addTodasAsPecas();
	}
	/**
	 * m�todo que verifica se a pe�a do jogador existe, assim, liberando o acesso caso
	 * exista.
	 * @param x representa a posi��o da coluna que ser� posicionada no tabuleiro
	 * @param y representa a posi��o da linha que ser� posicionada no tabuleiro
	 * @return returna a condi��o se existir a pe�a, verificando em cada elemento do arrayList.
	 */
	public boolean verificaSeExistePeca(int x, int y){

		for(Peca p: this.pecas){
			if(p.getX() == x && p.getY() == y){
				return true;
			}
		}

		return false;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Este m�todo adiciona pecas ao arrayList que esta presente como seu atributo.
	 * @param peca
	 */
	public void addPeca(Peca peca) {
		if(peca != null) {
			pecas.add(peca);
		}
	}
	/**
	 * Este m�todo faz uso do padr�o Factory Method para a cria��o de objetos
	 * espec�fico representando as pe�as do jogador com suas cores e posi��es
	 */
	public void addTodasAsPecas() {
		FactoryMethod factory = new FactoryMethod();
		if(cor==Cor.PRETO) {
			for(int x=0; x< 8;x++) {
				addPeca(factory.getPeca("peao",1,x,cor.PRETO));
			}
			addPeca(factory.getPeca("torre",0,0,cor.PRETO));
			addPeca(factory.getPeca("torre",0,7,cor.PRETO));
			addPeca(factory.getPeca("cavalo",0,1,cor.PRETO));
			addPeca(factory.getPeca("cavalo",0,6,cor.PRETO));
			addPeca(factory.getPeca("bispo",0,2,cor.PRETO));
			addPeca(factory.getPeca("bispo",0,5,cor.PRETO));
			addPeca(factory.getPeca("rainha",0,3,cor.PRETO));;
			addPeca(factory.getPeca("rei",0,4,cor.PRETO));

		}else {
			for(int x=0; x< 8;x++) {
				addPeca(factory.getPeca("peao",6,x,cor.BRANCO));
			}
			addPeca(factory.getPeca("torre",7,0,cor.BRANCO));
			addPeca(factory.getPeca("torre",7,7,cor.BRANCO));
			addPeca(factory.getPeca("cavalo",7,1,cor.BRANCO));
			addPeca(factory.getPeca("cavalo",7,6,cor.BRANCO));
			addPeca(factory.getPeca("bispo",7,2,cor.BRANCO));
			addPeca(factory.getPeca("bispo",7,5,cor.BRANCO));
			addPeca(factory.getPeca("rainha",7,3,cor.BRANCO));;
			addPeca(factory.getPeca("rei",7,4,cor.BRANCO));
		}
	}
	public List<Peca> getPecas(){
		return pecas;
	}
	public Cor getCor() {
		return cor;
	}
	/**
	 * m�todo ultilizado para passar a vez do jogador, que ser� ultilizada para a condi��o de movimenta��o
	 * de uma pe�a.
	 */
	public void passaVez(){
		if(this.vez){
			this.vez = false;
		}else{
			this.vez = true;
		}
	}
	/**
	 * m�todo para remover uma pe�a do arrayList baseado em suas posi��es
	 * este m�todo � ultilizado para remover pe�as de outro jogador quando
	 * uma pe�a "comer" uma outra.
	 * @param x
	 * @param y
	 */
	public void removePeca(int x, int y){
		for(Peca a: this.pecas){
			if(a.getX()== x && a.getY()==y){
				pecas.remove(a);
				break;
			}
		}
	}
	/**
	 * m�todo para pegar a pe�a do arrayList
	 * @param x posi��o coluna do tabuleiro
	 * @param y posi��o linha do tabuleiro
	 * @return retorna a pe�a encontrada
	 */
	public Peca getPeca(int x, int y){
		for(Peca p: this.pecas){
			if(p.getX() == x && p.getY() == y){
				return p;
			}
		}
		return null;
	}
	/**
	 * 
	 * @return retorna a vez do jogador
	 */
	public boolean getVez(){
		return this.vez;
	}
	/**
	 * 
	 * @return retorna a pe�a rei do jogador
	 */
	public Peca getRei(){

		for(Peca p: this.pecas){
			if(p instanceof Rei){
				return p;
			}
		}
		return null;
	}

}
