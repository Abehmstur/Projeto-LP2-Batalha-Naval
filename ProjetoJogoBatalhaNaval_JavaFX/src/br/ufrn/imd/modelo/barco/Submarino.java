package br.ufrn.imd.modelo.barco;

/**
 * A Classe Corverta representa uma embarcação do tipo Submarino
 * no jogo Batalha Naval.
 * 
 * @author Matheus Barros Medeiros - github: Abehmstur
 * @since jdk-11.0.22
 * @see Barco
 */
public class Submarino extends Barco{
	  /**
	   * Contador de acertos sofridos pelo submarino.
	   */
	private int contadorDeAcertos = 0;
	
	  /**
	   * Construtor padrão da Submarino.
	   * (!) Pendente implementar quatidadeMaximaDeBarcos de forma dinâmica com entradas do usuário.
	   */
	public Submarino() {
		this.nome = "Submarino";
		this.tamanho = 3;
		this.estado = ESTADO.ZERO_DANO;
		this.quantidadeMaximaDeBarcos = 1;
	}
	
  /**
   * Simula um ataque sofrido pelo submarino.
   */	
	@Override
	public void acertou() {
		contadorDeAcertos++;
		this.estado = ESTADO.DANIFICADO;
	}

  /**
   * Verifica se o submarino está afundada.
   * @return true se o submarino estiver afundada, false caso contrário.
   */
	@Override
	public boolean isAfundado() {
		// TODO Auto-generated method stub
		if(contadorDeAcertos >= tamanho) {
			this.estado = ESTADO.AFUNDADO;
			return true;
		}
		return false;
	}

	public int getContadorDeAcertos() {
		return contadorDeAcertos;
	}

	public void setContadorDeAcertos(int contadorDeAcertos) {
		this.contadorDeAcertos = contadorDeAcertos;
	}
	
}
