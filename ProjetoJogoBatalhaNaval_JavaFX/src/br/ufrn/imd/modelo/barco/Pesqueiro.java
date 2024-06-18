package br.ufrn.imd.modelo.barco;
/**
 * A Classe Corverta representa uma embarcação do tipo Pesquerio
 * no jogo Batalha Naval.
 * 
 * @author Matheus Barros Medeiros - github: Abehmstur
 * @since jdk-11.0.22
 * @see Barco
 * (i) Pendente adicionar "melhoria" ao jogo.
 *    Pesqueiro é um barco perigoso, se você o acertar, ao invés de pontuar, você soferá danos por atacar civís;
 *
 */
public class Pesqueiro extends Barco{
  /**
   * Contador de acertos sofridos pelo pesqueiro.
   */
	private int contadorDeAcertos = 0;
	
	  /**
	   * Construtor padrão da Pesqueiro.
	   * (!) Pendente implementar quatidadeMaximaDeBarcos de forma dinâmica com entradas do usuário.
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
   * Verifica se o pesqueiro está afundada.
   * @return true se o pesqueiro estiver afundada, false caso contrário.
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
