package br.com.dock.projeto.controller.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.dock.projeto.modelo.Conta;

public class SaldoDaContaDto {
	
	private Integer idConta;
	private float saldo;
	//private float limiteSaqueDiario;
	//private Boolean flagAtivo = true;
	//private Integer tipoConta;
	//private LocalDate dataCriacao = LocalDate.now();
	private String pessoaNome;
	private String cpf;
	
	public SaldoDaContaDto(Conta conta) {
		this.idConta = conta.getIdConta();
		this.saldo = conta.getSaldo();
		//this.limiteSaqueDiario = conta.getLimiteSaqueDiario();
		//this.flagAtivo = conta.getFlagAtivo();
		//this.tipoConta = conta.getTipoConta();
		//this.dataCriacao = conta.getDataCriacao();
		this.pessoaNome = conta.getPessoa().getNome();
		this.cpf = conta.getPessoa().getCpf();
	}

	public Integer getIdConta() {
		return idConta;
	}

	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	/*public float getLimiteSaqueDiario() {
		return limiteSaqueDiario;
	}

	public void setLimiteSaqueDiario(float limiteSaqueDiario) {
		this.limiteSaqueDiario = limiteSaqueDiario;
	}

	public Boolean getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(Boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	public Integer getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(Integer tipoConta) {
		this.tipoConta = tipoConta;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}*/

	public String getPessoaNome() {
		return pessoaNome;
	}

	public void setPessoaNome(String pessoaNome) {
		this.pessoaNome = pessoaNome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	

}
