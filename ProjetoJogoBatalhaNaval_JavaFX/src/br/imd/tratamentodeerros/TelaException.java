package br.imd.tratamentodeerros;

public class TelaException extends Exception {

	private static final long serialVersionUID = 3594849170406294988L;
	private String mensagem;
	
	public TelaException(String mensagem) {
	        this.mensagem = mensagem;
	    }

    @Override
    public String getMessage() {    
		return mensagem;
    }
}
