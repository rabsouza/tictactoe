package br.com.dojo.tictactoe.model;

import java.util.Arrays;

import br.com.dojo.tictactoe.util.JsonUtils;

public class Jogada {

	private Jogador jogador;
	private Integer[] tentativa = new Integer[2];

	public Jogada(Jogador jogador) {
		super();
		this.jogador = jogador;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Integer[] getTentativa() {
		return tentativa;
	}

	public void setTentativa(Integer[] tentativa) {
		this.tentativa = tentativa;
	}

	public String toJson() {
		return JsonUtils.toJson(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + Arrays.hashCode(tentativa);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Jogada other = (Jogada) obj;
		if (!Arrays.equals(tentativa, other.tentativa)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return toJson();
	}
}
