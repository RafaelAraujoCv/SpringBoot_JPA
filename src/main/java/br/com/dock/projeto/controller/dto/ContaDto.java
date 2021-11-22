package br.com.dock.projeto.controller.dto;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.dock.projeto.modelo.Conta;

public class ContaDto {
	
	private Integer idConta;
	private float saldo;
	private float limiteSaqueDiario;
	private Boolean flagAtivo = true;
	private Integer tipoConta;
	private LocalDate dataCriacao = LocalDate.now();
	
	public ContaDto(Conta conta) {
		this.idConta = conta.getIdConta();
		this.saldo = conta.getSaldo();
		this.limiteSaqueDiario = conta.getLimiteSaqueDiario();
		this.flagAtivo = conta.getFlagAtivo();
		this.tipoConta = conta.getTipoConta();
		this.dataCriacao = conta.getDataCriacao();
	}
	
	
	
	public Integer getIdConta() {
		return idConta;
	}



	public float getSaldo() {
		return saldo;
	}



	public float getLimiteSaqueDiario() {
		return limiteSaqueDiario;
	}



	public Boolean getFlagAtivo() {
		return flagAtivo;
	}
	public Integer getTipoConta() {
		return tipoConta;
	}
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}


	public static List<ContaDto> converter(List<Conta> contas) {
		// TODO Auto-generated method stub
		return contas.stream().map(ContaDto::new).collect(Collectors.toList());
	}
	
	
	
	

}
