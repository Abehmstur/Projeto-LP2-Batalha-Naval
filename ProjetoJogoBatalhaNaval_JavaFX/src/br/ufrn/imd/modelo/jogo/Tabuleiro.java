package br.ufrn.imd.modelo.jogo;

import java.util.ArrayList;

import br.ufrn.imd.modelo.barco.Barco;

/**
 * Classe respons�vel por criar um tabuleiro do jogo.
 * @author Matheus Barros Medeiros - github: Abehmstur
 * @since jdk-11.0.22
 */
public class Tabuleiro {

    /**
     * Matriz de objetos Mar que representam as c�lulas do tabuleiro.
     */
    private Mar[][] celulaDoMar;

    /**
     * Tamanho do tabuleiro. (!)Melhoria criar tabuleiro dinamicamente a partir da dificiuldade
     */
    private int tamanho;

    /**
     * Construtor que inicializa um novo tabuleiro com o tamanho especificado.
     * @param tamanho Tamanho do tabuleiro (quantidade de linhas e colunas).
     */
    public Tabuleiro(int tamanho) {
        this.tamanho = tamanho;
        celulaDoMar = new Mar[tamanho][tamanho];

        // Inicializa cada c�lula do mar com um objeto Mar vazio.
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                celulaDoMar[i][j] = new Mar();
            }
        }
    }
    
    /**
     * Tenta colocar um barco no tabuleiro.
     * 
     * @param b O barco a ser colocado.
     * @param x Coordenada X da posi��o inicial do barco.
     * @param y Coordenada Y da posi��o inicial do barco.
     * @param direcao � iniciada aleat�riamente na classe barcoDAO true para colocar na horizontal e false para vertical.
     * @return true se o barco foi colocado com sucesso e false caso contr�rio.
     */
    public boolean colocarBarco(Barco b, int x, int y, boolean direcao) {
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

        }

        return true;
    }
	
	
    /**
     * Ataque em uma c�lula espec�fica do tabuleiro.
     * @param x Coordenada X da c�lula a ser atacada.
     * @param y Coordenada Y da c�lula a ser atacada.
     * @return `true` se a c�lula cont�m um barco, `false` caso contr�rio.
     */
    public boolean levarAtaque(int x, int y) {
        celulaDoMar[x][y].ataque();
        return celulaDoMar[x][y].isTemBarco();
    }
	
    
    /**
     * M�todo para verificar se todos os barcos do tabuleiro j� foram afundados.
     * @return True para afirmar que j� foram afundados todos e pode finalizar o jogo e false se for o contr�rio.
     */
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
