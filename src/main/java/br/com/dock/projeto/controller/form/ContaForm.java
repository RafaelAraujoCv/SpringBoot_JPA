package br.com.dock.projeto.controller.form;

import javax.validation.constraints.NotNull;

import br.com.dock.projeto.modelo.Conta;

public class ContaForm {
	
	@NotNull 
	private float saldo;
	@NotNull 
	private float limiteSaqueDiario;
	@NotNull 
	private Integer tipoConta;
	
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public float getLimiteSaqueDiario() {
		return limiteSaqueDiario;
	}
	public void setLimiteSaqueDiario(float limiteSaqueDiario) {
		this.limiteSaqueDiario = limiteSaqueDiario;
	}
	public Integer getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(Integer tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public Conta converter() {
		// TODO Auto-generated method stub
		return new Conta(saldo, limiteSaqueDiario, tipoConta);
	}
	
	

}
