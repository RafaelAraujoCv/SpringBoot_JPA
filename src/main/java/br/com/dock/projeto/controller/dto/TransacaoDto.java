package br.com.dock.projeto.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.dock.projeto.modelo.Transacao;

public class TransacaoDto {
	
	private Integer idTransacao;
	private float valor;
	private LocalDate dataTransacao;
	
	public TransacaoDto(Transacao transacao) {
		super();
		this.idTransacao = transacao.getIdTransacao();
		this.valor = transacao.getValor();
		this.dataTransacao = transacao.getDataTransacao();
	}

	public Integer getIdTransacao() {
		return idTransacao;
	}

	public float getValor() {
		return valor;
	}

	public LocalDate getDataTransacao() {
		return dataTransacao;
	}

	public static List<TransacaoDto> converter(List<Transacao> transacoes) {
		// TODO Auto-generated method stub
		
		return transacoes.stream().map(TransacaoDto::new).collect(Collectors.toList());
	}
	
	
	
	
	

}
