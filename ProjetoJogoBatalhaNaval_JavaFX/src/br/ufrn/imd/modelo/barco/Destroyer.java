package br.ufrn.imd.modelo.barco;

/**
 * A Classe Corverta representa uma embarcação do tipo Destroyer
 * no jogo Batalha Naval.
 * 
 * @author Matheus Barros Medeiros - github: Abehmstur
 * @since jdk-11.0.22
 * @see Barco
 */

public class Destroyer extends Barco{
  /**
   * Contador de acertos sofridos pela Coeveta.
   */
	private int contadorDeAcertos = 0;
	
  /**
   * Construtor padrão da Destrouyer.
   * (!) Pendente implementar quatidadeMaximaDeBarcos de forma dinâmica com entradas do usuário.
   */
	public Destroyer() {
		this.nome = "Destroyer";
		this.tamanho = 5;
		this.quantidadeMaximaDeBarcos = 1;
		this.estado = ESTADO.ZERO_DANO;
	}
	
  /**
   * Simula um ataque sofrido pela Corveta.
   */
	@Override
	public void acertou() {
		contadorDeAcertos++;
		this.estado = ESTADO.DANIFICADO;
	}
	
  /**
   * Verifica se a Destroyer está afundada.
   * @return true se a Destroyer estiver afundada, false caso contrário.
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
