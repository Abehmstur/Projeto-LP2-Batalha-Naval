package br.ufrn.imd.modelo.barco;

/**
 * Classe abstrata Barco representa uma embarca��o gen�rica 
 * no jogo batalha naval. 
 * 
 * @author Matheus Barros Medeiros - github: Abehmstur
 * @since jdk-11.0.22
 */
public abstract class Barco {
	
  /**
   * Nome do Barco.
   */
	protected String nome;
	
  /**
   * Tamanho do Barco.
   */
	protected int tamanho;
	
  /**
   * Posi��o X do Barco no mapa.
   */
	protected int posicaoX;
	
  /**
   * Posi��o Y do Barco no mapa.
   */
	protected int posicaoY;
	
  /**
   * Estado atual do Barco (ZERO_DANO, DANIFICADO, AFUNDADO).
   */
	protected ESTADO estado;
	
  /**
   * Quantidade m�xima de Barcos que podem ser colocados no tabuleiro.
   * Pendente implementar quatidadeMaximaDeBarcos de forma din�mica com entradas do usu�rio.
   */
	protected int quantidadeMaximaDeBarcos;
	
  /**
   * Enumera��o representando os estados de um Barco: ZERO_DANO, DANIFICADO, AFUNDADO;.
   */
	public enum ESTADO {
	  ZERO_DANO, DANIFICADO, AFUNDADO;
	}
	
  /**
   * M�todo abstrato que simula um ataque sofrido pelo Barco. 
   * 
   */
	public abstract void acertou();
	
  /**
   * M�todo abstrato que verifica se o Barco est� no estado AFUNDADO. 
   * @return true se o Barco estiver afundado, false caso contr�rio.
   */	 
	public abstract boolean isAfundado();

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public int getPosicaoX() {
		return posicaoX;
	}
	
	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}
	
	public int getPosicaoY() {
		return posicaoY;
	}
	
	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}
	
	public ESTADO getEstado() {
		return estado;
	}
	
	public void setEstado(ESTADO estado) {
		this.estado = estado;
	}
	
	public int getQuantidadeMaximaDeBarcos() {
		return quantidadeMaximaDeBarcos;
	}
	
	public void setQuantidadeMaximaDeBarcos(int quantidadeMaximaDeBarcos) {
		this.quantidadeMaximaDeBarcos = quantidadeMaximaDeBarcos;
	}
  
}
