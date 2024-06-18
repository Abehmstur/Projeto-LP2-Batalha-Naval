package br.ufrn.imd.modelo.barco;

/**
 * A Classe Corverta representa uma embarca��o do tipo Submarino
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
	   * Construtor padr�o da Submarino.
	   * (!) Pendente implementar quatidadeMaximaDeBarcos de forma din�mica com entradas do usu�rio.
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
   * Verifica se o submarino est� afundada.
   * @return true se o submarino estiver afundada, false caso contr�rio.
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
