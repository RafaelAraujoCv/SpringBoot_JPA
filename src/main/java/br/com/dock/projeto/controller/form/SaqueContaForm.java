package br.com.dock.projeto.controller.form;


import javax.validation.constraints.NotNull;

import br.com.dock.projeto.modelo.Conta;
import br.com.dock.projeto.modelo.Transacao;
import br.com.dock.projeto.repository.ContaRepository;
import br.com.dock.projeto.repository.TransacaoRepository;

public class SaqueContaForm {
	
	@NotNull
	private float saldo;

	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public Conta saqueEmConta(Integer id, ContaRepository contaRepository, TransacaoRepository transacaoRepository) {
		// TODO Auto-generated method stub
		Conta conta = contaRepository.getOne(id);
		
		conta.setSaldo( conta.getSaldo() - this.saldo);
		
		Transacao transacao = new Transacao();
		transacao.setValor(this.saldo);
		//transacao.getConta().setIdConta(id);
		
		transacaoRepository.save(transacao);
		
		return conta;
	}
	public Conta depositoEmConta(Integer id, ContaRepository contaRepository, TransacaoRepository transacaoRepository) {
		// TODO Auto-generated method stub
		Conta conta = contaRepository.getOne(id);
		
		conta.setSaldo( conta.getSaldo() + this.saldo);
		
		Transacao transacao = new Transacao();
		transacao.setValor(this.saldo);
		//transacao.getConta().setIdConta(id);
		
		transacaoRepository.save(transacao);
		
		return conta;
	}

	
	
	
	

}
