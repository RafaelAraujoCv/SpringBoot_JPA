package br.com.dock.projeto.controller.form;

import br.com.dock.projeto.modelo.Conta;
import br.com.dock.projeto.repository.ContaRepository;

public class AtualizacaoContaForm {
	
	//private float saldo;
	private float limiteSaqueDiario;
	private Integer tipoConta;

	private Boolean flagAtivo = true;
	
	/*public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}*/
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
	public Boolean getFlagAtivo() {
		return flagAtivo;
	}
	public void setFlagAtivo(Boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}
	
	public Conta atualizar(Integer id, ContaRepository contaRepository) {
		// TODO Auto-generated method stub
		Conta conta = contaRepository.getOne(id);
		
		//conta.setSaldo(this.saldo);
		conta.setLimiteSaqueDiario(this.limiteSaqueDiario);
		conta.setTipoConta(this.tipoConta);
		conta.setFlagAtivo(this.flagAtivo);
		
		return conta;
	}
	
	

}
