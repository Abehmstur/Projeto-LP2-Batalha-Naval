package br.ufrn.imd.modelo.barco;

/**
 * A Classe Corverta representa uma embarcação do tipo Fragata
 * no jogo Batalha Naval.
 * 
 * @author Matheus Barros Medeiros - github: Abehmstur
 * @since jdk-11.0.22
 * @see Barco
 */

public class Fragata extends Barco{
	  /**
	   * Contador de acertos sofridos pela fragata.
	   */
	private int contadorDeAcertos = 0;
	
	  /**
	   * Construtor padrão da fragata.
	   * (!) Pendente implementar quatidadeMaximaDeBarcos de forma dinâmica com entradas do usuário.
	   */
	public Fragata() {
		this.nome = "Fragata";
		this.tamanho = 4;
		this.quantidadeMaximaDeBarcos = 1;
		this.estado = ESTADO.ZERO_DANO;
	}

  /**
   * Simula um ataque sofrido pela fragata.
   */
	@Override
	public void acertou() {
		contadorDeAcertos++;
		this.estado = ESTADO.DANIFICADO;
	}

  /**
   * Verifica se a fragata está afundada.
   * @return true se a fragata estiver afundada, false caso contrário.
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
