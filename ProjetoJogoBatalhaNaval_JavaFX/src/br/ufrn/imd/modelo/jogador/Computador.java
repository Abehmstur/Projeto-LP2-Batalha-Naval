package br.ufrn.imd.modelo.jogador;

import java.util.Random;

public class Computador extends Jogador{
	private Random random;

	public Computador(String nome, int tamanhoTabuleiro) {
		super(tamanhoTabuleiro);
		this.random = new Random();
	}
	
	public void atacar() {
		int x, y;
		boolean acertou = false;
		
		while(!acertou) {
			x = random.nextInt(getTabuleiroDoInimigo().getTamanho());
			y = random.nextInt(getTabuleiroDoInimigo().getTamanho());
			if(!getTabuleiroDoInimigo().getCelulaDoMar(x, y).isAtacado()) {
				acertou = getTabuleiroDoInimigo().levarAtaque(x, y);
/*				Nos jogos que joguei, se você acertou, você pode jogar novamente, mas eu preciso pensar em como analisar a área ao redor e atacar no local próximo ao barco encontrado.
 *				Por enquanto, cada jogador joga e passa a vez independentemente de ter acerto.
  				if(acertou) {
					atacar();
				}

*/				
				System.out.println("teste, acertou em: " + x+ " - "+ y);
			}
		}
	}
	
}
