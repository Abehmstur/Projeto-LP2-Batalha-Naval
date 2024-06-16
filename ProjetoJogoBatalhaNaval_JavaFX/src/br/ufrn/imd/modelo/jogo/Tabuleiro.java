package br.ufrn.imd.modelo.jogo;

import java.util.ArrayList;

import br.ufrn.imd.dao.BarcosDAO;
import br.ufrn.imd.modelo.barco.Barco;

public class Tabuleiro {
	private Mar[][] celulaDoMar;
	private int tamanho = 0;
	
	public Tabuleiro(int tamanho) {
		this.tamanho = tamanho;
		celulaDoMar = new Mar[tamanho][tamanho];
//		teste = new String[tamanho][tamanho];
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				celulaDoMar[i][j] = new Mar();
//				teste[i][j] = "~";
			}
		}
		
	}
	
	public boolean colocarBarco(Barco b, int x, int y, boolean direcao, ArrayList<Barco> barcosJaAdicionados) {
	    if (direcao) {
	        if (x + b.getTamanho() > celulaDoMar.length) {
	            return false; 
	        }
	        for (int i = 0; i < b.getTamanho(); i++) {
	            if (celulaDoMar[x + i][y].isTemBarco()) {
	                return false; 
	            }
	        }
	        for (int i = 0; i < b.getTamanho(); i++) {
	            celulaDoMar[x + i][y].addBarcoMar(b);
	        }
	        barcosJaAdicionados.add(b);
	    } else {
	        if (y + b.getTamanho() > celulaDoMar[0].length) {
	            return false; 
	        }
	        for (int i = 0; i < b.getTamanho(); i++) {
	            if (celulaDoMar[x][y + i].isTemBarco()) {
	                return false; 
	            }
	        }
	        for (int i = 0; i < b.getTamanho(); i++) {
	            celulaDoMar[x][y + i].addBarcoMar(b);
	        }
	        barcosJaAdicionados.add(b);
	    }
	   	    
	    return true;
	}
	
	
	public boolean levarAtaque(int x, int y){
		celulaDoMar[x][y].ataque();
		return celulaDoMar[x][y].isTemBarco();
	}
	
	public boolean allBarcosAfundados() {
		for (Mar[] linhaMar : celulaDoMar) {
			for (Mar celMar : linhaMar) {
				if(celMar.isTemBarco() && !celMar.isAtacado()) {
					return false;
				}
			}
		}
		return true;
	}

	public Mar getCelulaDoMar(int x, int y) {
		return celulaDoMar[x][y];
	}

	public void setCelulaDoMar(Mar[][] celulaDoMar) {
		this.celulaDoMar = celulaDoMar;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
}
