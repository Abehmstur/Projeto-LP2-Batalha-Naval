package br.ufrn.imd.modelo.barco;

public class Destroyer extends Barco{
	private int contadorDeAcertos = 0;

	public Destroyer() {
		this.nome = "Destroyer";
		this.tamanho = 5;
		this.quantidadeMaximaDeBarcos = 1;
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
