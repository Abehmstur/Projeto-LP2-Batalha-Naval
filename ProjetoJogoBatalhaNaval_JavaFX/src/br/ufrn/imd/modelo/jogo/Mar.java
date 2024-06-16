package br.ufrn.imd.modelo.jogo;

import br.ufrn.imd.modelo.barco.Barco;
import br.ufrn.imd.modelo.barco.Corverta;
import br.ufrn.imd.modelo.barco.Destroyer;
import br.ufrn.imd.modelo.barco.Fragata;
import br.ufrn.imd.modelo.barco.Pesqueiro;
import br.ufrn.imd.modelo.barco.Submarino;

public class Mar {
	private boolean temBarco;
	public boolean isAtacado;
	private Barco barco;
	
	public Mar() {
		this.temBarco = false;
		this.isAtacado = false;
	}
	
	public void addBarcoMar(Barco b) {
		this.temBarco = true;
		this.barco = b;
	}
	
	public boolean isAtacado() {
		return isAtacado;
	}
	
	public void ataque(){
		this.isAtacado = true;
		if(temBarco) {
			barco.acertou();
		}
	}
	
	public Barco getBarco() {
		return barco;
	}

	public boolean isTemBarco() {
		return temBarco;
	}

	public void setTemBarco(boolean temBarco) {
		this.temBarco = temBarco;
	}
	
    public String getBarcoTipo() {
        if (isTemBarco()) {
            return barco.getNome().substring(0, 1).toUpperCase(); 
        }
        return "~"; 
    }
	
//	para testes em console
    @Override
    public String toString() {
        if (isTemBarco() && barco instanceof Destroyer) {
            return "D";
        }
        else if(isTemBarco() && barco instanceof Corverta) {
        	return "C";
        }else if(isTemBarco() && barco instanceof Fragata) {
        	return "F";
        }else if(isTemBarco() && barco instanceof Submarino) {
        	return "S";
        }else if(isTemBarco() && barco instanceof Pesqueiro) {
        	return "P";
        } else if (isAtacado()) {
            return "*";
        } else {
            return "~";
        }
    }
	
}
