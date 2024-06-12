package br.ufrn.imd.modelo.barco;
/*Pendente adicionar "melhoria" ao jogo.
 * Pesqueiro � um barco perigoso, se voc� o acertar, ao inv�s de pontuar, voc� sofer� danos por atacar civ�s;
 * */
public class Pesqueiro extends Barco{
		private int contadorDeAcertos = 0;
		
		
		public Pesqueiro() {
			this.nome = "Pesqueiro";
			this.tamanho = 1;
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
