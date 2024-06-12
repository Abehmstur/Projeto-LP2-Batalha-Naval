package br.ufrn.imd.modelo.barco;

import java.util.Objects;

public abstract class Barco {
	protected String nome;
	protected int tamanho;
	protected int posicaoX;
	protected int posicaoY;
	protected ESTADO estado;
	protected int quantidadeMaximaDeBarcos;
	
	protected enum ESTADO {ZERO_DANO, DANIFICADO, AFUNDADO};
		
	public String getNome() {
		return nome;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Barco other = (Barco) obj;
		return Objects.equals(nome, other.nome);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public int getPosicaoX() {
		return posicaoX;
	}
	
	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}
	
	public int getPosicaoY() {
		return posicaoY;
	}
	
	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}
	
	public ESTADO getEstado() {
		return estado;
	}
	
	public void setEstado(ESTADO estado) {
		this.estado = estado;
	}
	
	public int getQuantidadeMaximaDeBarcos() {
		return quantidadeMaximaDeBarcos;
	}
	
	public void setQuantidadeMaximaDeBarcos(int quantidadeMaximaDeBarcos) {
		this.quantidadeMaximaDeBarcos = quantidadeMaximaDeBarcos;
	}
	
	public abstract void acertou();
	public abstract boolean isAfundado();
	

}
