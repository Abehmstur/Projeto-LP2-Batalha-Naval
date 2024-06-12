package br.ufrn.imd.modelo.barco;


public class Submarino extends Barco{
	private int contadorDeAcertos = 0;
	
	
	public Submarino() {
		this.nome = "Submarino";
		this.tamanho = 3;
		this.estado = ESTADO.ZERO_DANO;
		this.quantidadeMaximaDeBarcos = 1;
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
