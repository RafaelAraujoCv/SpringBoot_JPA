package br.com.dock.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dock.projeto.controller.dto.TransacaoDto;
import br.com.dock.projeto.modelo.Transacao;
import br.com.dock.projeto.repository.TransacaoRepository;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	/*@GetMapping("/extrato/{dataInicial}/{dataFinal}")
	public List<TransacaoDto> extratoPorPeriodo(@PathVariable("dataInicial") Integer dataInicial, @PathVariable("dataFinal") Integer dataFinal) {
		
		List<Transacao> transacoes = transacaoRepository.findAllData(dataInicial, dataFinal);
		
		return TransacaoDto.converter(transacoes);
		
	}*/

}
