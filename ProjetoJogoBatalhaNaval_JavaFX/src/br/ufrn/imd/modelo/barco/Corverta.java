package br.ufrn.imd.modelo.barco;

/**
 * A Classe Corverta representa uma embarcação do tipo Corveta
 * no jogo Batalha Naval.
 * 
 * @author Matheus Barros Medeiros - github: Abehmstur
 * @since jdk-11.0.22
 * @see Barco
 */
public class Corverta extends Barco {

    /**
     * Contador de acertos sofridos pela Coeveta.
     */
	private int contadorDeAcertos = 0;

    /**
     * Construtor padrão da Corveta.
     * (!) Pendente implementar quatidadeMaximaDeBarcos de forma dinâmica com entradas do usuário.
     */
     public Corverta() {
       this.nome = "Corverta";
       this.tamanho = 2;
       this.quantidadeMaximaDeBarcos = 1;
       this.estado = ESTADO.ZERO_DANO;
    }

    /**
     * Simula um ataque sofrido pela Corveta.
     * @throws Exception Se a Corveta já estiver afundada.
     */
    @Override
    public void acertou(){
      contadorDeAcertos++;
      this.estado = ESTADO.DANIFICADO;
    }

    /**
     * Verifica se a Corveta está afundada.
     * @return true se a Corveta estiver afundada, false caso contrário.
     */
    @Override
    public boolean isAfundado() {
      if (contadorDeAcertos >= tamanho) {
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

