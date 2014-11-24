package br.com.dojo.tictactoe.model;

import java.io.Serializable;

import br.com.dojo.tictactoe.util.JsonUtils;

public abstract class Jogador implements Serializable {

	private static final long serialVersionUID = -516212670193228931L;

	public enum JogadorEnum {
		PLAYER_A(-1), PLAYER_B(1);

		private final Integer indice;

		public Integer getIndice() {
			return indice;
		}

		private JogadorEnum(Integer indice) {
			this.indice = indice;
		}

	}

	public enum StatusEnum {
		VITORIA("venceu a partida!"),
		DERROTA("perdeu a partida!"),
		EMPATE("empatou a partida!");

		private final String descricao;

		public String getDescricao() {
			return descricao;
		}

		private StatusEnum(String descricao) {
			this.descricao = descricao;
		}

	}

	private String nome;
	private JogadorEnum jogador;
	private StatusEnum status;

	public Integer getIndice() {
		if (jogador != null) {
			return jogador.getIndice();
		}
		return 0;
	}

	public String getStatusFinal() {
		if (status != null) {
			return String.format("O jogador %s %s", nome, status.getDescricao());
		}
		return String.format("O jogador %s não possui status!", nome);
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public JogadorEnum getJogador() {
		return jogador;
	}

	public void setJogador(JogadorEnum jogador) {
		this.jogador = jogador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toJson() {
		return JsonUtils.toJson(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((nome == null) ? 0 : nome.hashCode());
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
		Jogador other = (Jogador) obj;
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return toJson();
	}

}
