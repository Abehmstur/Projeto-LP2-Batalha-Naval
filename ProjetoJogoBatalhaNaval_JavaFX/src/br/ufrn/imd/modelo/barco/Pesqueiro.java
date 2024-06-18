package br.ufrn.imd.modelo.barco;
/**
 * A Classe Corverta representa uma embarca��o do tipo Pesquerio
 * no jogo Batalha Naval.
 * 
 * @author Matheus Barros Medeiros - github: Abehmstur
 * @since jdk-11.0.22
 * @see Barco
 * (i) Pendente adicionar "melhoria" ao jogo.
 *    Pesqueiro � um barco perigoso, se voc� o acertar, ao inv�s de pontuar, voc� sofer� danos por atacar civ�s;
 *
 */
public class Pesqueiro extends Barco{
  /**
   * Contador de acertos sofridos pelo pesqueiro.
   */
	private int contadorDeAcertos = 0;
	
	  /**
	   * Construtor padr�o da Pesqueiro.
	   * (!) Pendente implementar quatidadeMaximaDeBarcos de forma din�mica com entradas do usu�rio.
	   */
	public Pesqueiro() {
		this.nome = "Pesqueiro";
		this.tamanho = 1;
		this.quantidadeMaximaDeBarcos = 1;
		this.estado = ESTADO.ZERO_DANO;
	}
  /**
   * Simula um ataque sofrido pela Pesqueiro.
   */
	@Override
	public void acertou() {
		contadorDeAcertos++;
		this.estado = ESTADO.DANIFICADO;
	}

  /**
   * Verifica se o pesqueiro est� afundada.
   * @return true se o pesqueiro estiver afundada, false caso contr�rio.
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
