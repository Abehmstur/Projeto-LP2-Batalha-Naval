package br.ufrn.imd.modelo.barco;

/**
 * A Classe Corverta representa uma embarca��o do tipo Fragata
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
	   * Construtor padr�o da fragata.
	   * (!) Pendente implementar quatidadeMaximaDeBarcos de forma din�mica com entradas do usu�rio.
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
   * Verifica se a fragata est� afundada.
   * @return true se a fragata estiver afundada, false caso contr�rio.
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
