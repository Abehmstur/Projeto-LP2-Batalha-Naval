package br.ufrn.imd.modelo.barco;

public class Corverta extends Barco{
	private int contadorDeAcertos = 0;
	
	public Corverta() {
		this.nome = "Corverta";
		this.tamanho = 2;
		this.quantidadeMaximaDeBarcos = 4;
		this.estado = ESTADO.ZERO_DANO;
	}

	@Override
	public void acertou() {
		contadorDeAcertos++;
		this.estado = ESTADO.DANIFICADO;
	}

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
