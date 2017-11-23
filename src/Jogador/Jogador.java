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
 *que serão ultilizados pelo classe Model. Esta classe faz uso do padrão Factory Method
 */
public class Jogador {

	private String nome;
	private List<Peca> pecas;
	private Cor cor;
	private boolean vez;

	/**
	 * Construtor da classe, recebendo seus atributos e instanciando o ArrayList
	 * logo após, chamado o método addTodasAsPecas()
	 * @param nome recebe o nome do jogador
	 * @param cor recebe a cor da peça no qual representará o lado no Tabuleiro de xadrez
	 */
	public Jogador(String nome, Cor cor) {
		pecas = new ArrayList();
		this.nome = nome;
		this.cor = cor;
		vez = true;
		addTodasAsPecas();
	}
	/**
	 * método que verifica se a peça do jogador existe, assim, liberando o acesso caso
	 * exista.
	 * @param x representa a posição da coluna que será posicionada no tabuleiro
	 * @param y representa a posição da linha que será posicionada no tabuleiro
	 * @return returna a condição se existir a peça, verificando em cada elemento do arrayList.
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
	 * Este método adiciona pecas ao arrayList que esta presente como seu atributo.
	 * @param peca
	 */
	public void addPeca(Peca peca) {
		if(peca != null) {
			pecas.add(peca);
		}
	}
	/**
	 * Este método faz uso do padrão Factory Method para a criação de objetos
	 * específico representando as peças do jogador com suas cores e posições
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
	 * método ultilizado para passar a vez do jogador, que será ultilizada para a condição de movimentação
	 * de uma peça.
	 */
	public void passaVez(){
		if(this.vez){
			this.vez = false;
		}else{
			this.vez = true;
		}
	}
	/**
	 * método para remover uma peça do arrayList baseado em suas posições
	 * este método é ultilizado para remover peças de outro jogador quando
	 * uma peça "comer" uma outra.
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
	 * método para pegar a peça do arrayList
	 * @param x posição coluna do tabuleiro
	 * @param y posição linha do tabuleiro
	 * @return retorna a peça encontrada
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
	 * @return retorna a peça rei do jogador
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
