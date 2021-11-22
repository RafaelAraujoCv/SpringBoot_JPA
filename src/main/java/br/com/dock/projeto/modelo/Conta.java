package br.com.dock.projeto.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Contas")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConta;
	private float saldo;
	private float limiteSaqueDiario;
	private Boolean flagAtivo = true;
	private Integer tipoConta;
	private LocalDate dataCriacao = LocalDate.now();
	@ManyToOne
	private Pessoa pessoa;
	
	public Conta() {
		// TODO Auto-generated constructor stub
	}
	public Conta(float saldo, float limiteSaqueDiario, Integer tipoConta) {
		super();
		this.saldo = saldo;
		this.limiteSaqueDiario = limiteSaqueDiario;
		this.tipoConta = tipoConta;
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
	public float getLimiteSaqueDiario() {
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
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	

}
