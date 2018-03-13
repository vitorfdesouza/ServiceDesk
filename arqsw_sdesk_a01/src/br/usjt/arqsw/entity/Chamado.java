package br.usjt.arqsw.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author 816124616 - Vitor Fonseca de Souza
 */


public class Chamado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String ABERTO = "aberto";
	public static final String FECHADO = "fechado";
	
	@NotNull(message="O chamado n�o pode ser nulo")
	private int numero;
	
	@NotNull 
	@Size(max=100,min=10, message="O tamanho da descri��o deve estar entre 10 e 100 caracteres")
	private String descricao;
	
	@NotNull
	private Date dataAbertura;
	
	
	private Date dataFechamento;
	
	@NotNull
	private String status;
	
	@NotNull
	private Fila fila;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Date getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Fila getFila() {
		return fila;
	}
	public void setFila(Fila fila) {
		this.fila = fila;
	}
	
	@Override
	public String toString() {
		return "Chamado [numero=" + numero + ", descricao=" + descricao + ", dataAbertura=" + dataAbertura + ", dataFechamento="
				+ dataFechamento + ", status=" + status + ", fila=" + fila + "]";
	}

}
