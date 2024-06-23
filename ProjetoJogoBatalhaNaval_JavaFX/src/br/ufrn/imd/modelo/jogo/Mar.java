package br.ufrn.imd.modelo.jogo;

import br.ufrn.imd.modelo.barco.Barco;
import br.ufrn.imd.modelo.barco.Corverta;
import br.ufrn.imd.modelo.barco.Destroyer;
import br.ufrn.imd.modelo.barco.Fragata;
import br.ufrn.imd.modelo.barco.Pesqueiro;
import br.ufrn.imd.modelo.barco.Submarino;

/**
 * Classe que representa uma c�lula do mar no tabuleiro do jogo Batalha Naval.
 * @author Matheus Barros Medeiros - github: Abehmstur
 * @since jdk-11.0.22
 */
public class Mar {

    /**
     * Diz se tem um barco na c�lula.
     */
    private boolean temBarco;

    /**
     * Diz se a c�lula j� foi atacada.
     */
    private boolean isAtacado;

    /**
     * Atribnuto para o objeto Barco caso a c�lula contenha um.
     */
    private Barco barco;

    /**
     * Construtor que inicia a c�lula como sem barco e n�o atacada.
     */
    public Mar() {
        this.temBarco = false;
        this.isAtacado = false;
    }

    /**
     * Adiciona um barco na c�lula do mar.
     * @param b O barco a ser adicionado.
     */
    public void addBarcoMar(Barco b) {
        this.temBarco = true;
        this.barco = b;
    }

    /**
     * Olha se a c�lula j� foi atacada.
     * @return `true` se a c�lula foi atacada, `false` caso contr�rio.
     */
    public boolean isAtacado() {
        return isAtacado;
    }

    /**
     * Ataque na celula do mar.
     * * Se houver um barco o m�todo acertou() do barco � chamado.
     */
    public void ataque() {
        this.isAtacado = true;
        if (temBarco) {
            barco.acertou();
        }
    }

    /**
     * Retorna o barco se houver na c�lula.
     * @return O objeto Barco associado na c�lula e nulo se n�o tiver barco.
     */
    public Barco getBarco() {
        return barco;
    }

    /**
     * Verifica se tem um barco na c�lula.
     * @return `true` se h� um barco na c�lula, `false` caso contr�rio.
     */
    public boolean isTemBarco() {
        return temBarco;
    }

    /**
     * Seta uma um bool para indicar se tem ou n�o tem barco na celula.
     * @param temBarco `true` para indicar a presen�a de um barco, `false` caso contr�rio.
     */
    public void setTemBarco(boolean temBarco) {
        this.temBarco = temBarco;
    }
    
    /**
     * Retorna a primeira letra do nome da cada barco para ser usada no tabuleiro no front.
     * @return Uma string representando a parte do mar.
     */
    public String getBarcoTipo() {
        if (isTemBarco()) {
            return barco.getNome().substring(0, 1).toUpperCase(); 
        }
        return "~"; 
    }

    /**
     * Retorna uma letra para cada barco para visualiza��o no console, um ~ para representar a �gua e * para representar um local que n�o tem barco mas foi atingido.
     * @return Uma string representando a parte do mar.
     */
    @Override
    public String toString() {
        if (isTemBarco() && barco instanceof Destroyer) {
            return "D";
        }
        else if(isTemBarco() && barco instanceof Corverta) {
        	return "C";
        }else if(isTemBarco()&& barco instanceof Fragata) {
        	return "F";
        }else if(isTemBarco()&& barco instanceof Submarino) {
        	return "S";
        }else if(isTemBarco()&& barco instanceof Pesqueiro) {
        	return "P";
        } else if (isAtacado()) {
            return "*";
        } else {
            return "~";
        }
    }
}
