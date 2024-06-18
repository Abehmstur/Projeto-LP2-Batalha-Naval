package br.ufrn.imd.modelo.barco;

/**
 * A Classe Corverta representa uma embarca��o do tipo Corveta
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
     * Construtor padr�o da Corveta.
     * (!) Pendente implementar quatidadeMaximaDeBarcos de forma din�mica com entradas do usu�rio.
     */
     public Corverta() {
       this.nome = "Corverta";
       this.tamanho = 2;
       this.quantidadeMaximaDeBarcos = 1;
       this.estado = ESTADO.ZERO_DANO;
    }

    /**
     * Simula um ataque sofrido pela Corveta.
     * @throws Exception Se a Corveta j� estiver afundada.
     */
    @Override
    public void acertou(){
      contadorDeAcertos++;
      this.estado = ESTADO.DANIFICADO;
    }

    /**
     * Verifica se a Corveta est� afundada.
     * @return true se a Corveta estiver afundada, false caso contr�rio.
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

