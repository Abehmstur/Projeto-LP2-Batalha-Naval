package br.ufrn.imd.modelo.jogo;

import br.ufrn.imd.modelo.barco.Barco;
import br.ufrn.imd.modelo.barco.Corverta;
import br.ufrn.imd.modelo.barco.Destroyer;
import br.ufrn.imd.modelo.barco.Fragata;
import br.ufrn.imd.modelo.barco.Pesqueiro;
import br.ufrn.imd.modelo.barco.Submarino;

/**
 * Classe que representa uma célula do mar no tabuleiro do jogo Batalha Naval.
 * @author Matheus Barros Medeiros - github: Abehmstur
 * @since jdk-11.0.22
 */
public class Mar {

    /**
     * Diz se tem um barco na célula.
     */
    private boolean temBarco;

    /**
     * Diz se a célula já foi atacada.
     */
    private boolean isAtacado;

    /**
     * Atribnuto para o objeto Barco caso a célula contenha um.
     */
    private Barco barco;

    /**
     * Construtor que inicia a célula como sem barco e não atacada.
     */
    public Mar() {
        this.temBarco = false;
        this.isAtacado = false;
    }

    /**
     * Adiciona um barco na célula do mar.
     * @param b O barco a ser adicionado.
     */
    public void addBarcoMar(Barco b) {
        this.temBarco = true;
        this.barco = b;
    }

    /**
     * Olha se a célula já foi atacada.
     * @return `true` se a célula foi atacada, `false` caso contrário.
     */
    public boolean isAtacado() {
        return isAtacado;
    }

    /**
     * Ataque na celula do mar.
     * * Se houver um barco o método acertou() do barco é chamado.
     */
    public void ataque() {
        this.isAtacado = true;
        if (temBarco) {
            barco.acertou();
        }
    }

    /**
     * Retorna o barco se houver na célula.
     * @return O objeto Barco associado na célula e nulo se não tiver barco.
     */
    public Barco getBarco() {
        return barco;
    }

    /**
     * Verifica se tem um barco na célula.
     * @return `true` se há um barco na célula, `false` caso contrário.
     */
    public boolean isTemBarco() {
        return temBarco;
    }

    /**
     * Seta uma um bool para indicar se tem ou não tem barco na celula.
     * @param temBarco `true` para indicar a presença de um barco, `false` caso contrário.
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
     * Retorna uma letra para cada barco para visualização no console, um ~ para representar a água e * para representar um local que não tem barco mas foi atingido.
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
