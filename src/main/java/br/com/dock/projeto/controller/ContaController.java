package br.com.dock.projeto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.dock.projeto.controller.dto.ContaDto;
import br.com.dock.projeto.controller.dto.SaldoDaContaDto;
import br.com.dock.projeto.controller.form.AtualizacaoContaForm;
import br.com.dock.projeto.controller.form.ContaForm;
import br.com.dock.projeto.controller.form.SaqueContaForm;
import br.com.dock.projeto.modelo.Conta;
import br.com.dock.projeto.repository.ContaRepository;
import br.com.dock.projeto.repository.TransacaoRepository;

@RestController
@RequestMapping("/contas")
public class ContaController {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@GetMapping
	public List<ContaDto> listarConta(Boolean flagAtivo) {
		if(flagAtivo == null) {
			List<Conta> contas = contaRepository.findAll();
			return ContaDto.converter(contas);
		} else {
			List<Conta> contas = contaRepository.findByFlagAtivo(flagAtivo);
			return ContaDto.converter(contas);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ContaDto> cadastrarConta(@RequestBody @Valid ContaForm contaForm, UriComponentsBuilder uriBuilder) {
		
		Conta conta = contaForm.converter();
		contaRepository.save(conta);
		
		URI uri = uriBuilder.path("/contas/{id}").buildAndExpand(conta.getIdConta()).toUri();
		return ResponseEntity.created(uri).body(new ContaDto(conta));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SaldoDaContaDto> saldoConta(@PathVariable("id") Integer id) {
		
		Optional<Conta> optionalConta = contaRepository.findById(id);
		if (optionalConta.isPresent()) {
			return ResponseEntity.ok(new SaldoDaContaDto(optionalConta.get()));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ContaDto> atualizarConta(@PathVariable("id") Integer id,@RequestBody @Valid AtualizacaoContaForm form) {
		
		Optional<Conta> optionalConta = contaRepository.findById(id);
		if (optionalConta.isPresent()) {
			Conta conta = form.atualizar(id, contaRepository);
			return ResponseEntity.ok(new ContaDto(conta));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/saque/{id}")
	@Transactional
	public ResponseEntity<ContaDto> saqueConta(@PathVariable("id") Integer id,@RequestBody @Valid SaqueContaForm form) {
		
		Optional<Conta> optionalConta = contaRepository.findById(id);
		if (optionalConta.isPresent()) {
			Conta conta = form.saqueEmConta(id, contaRepository, transacaoRepository);
			return ResponseEntity.ok(new ContaDto(conta));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/deposito/{id}")
	@Transactional
	public ResponseEntity<ContaDto> depositoConta(@PathVariable("id") Integer id,@RequestBody @Valid SaqueContaForm form) {
		
		Optional<Conta> optionalConta = contaRepository.findById(id);
		if (optionalConta.isPresent()) {
			Conta conta = form.depositoEmConta(id, contaRepository, transacaoRepository);
			return ResponseEntity.ok(new ContaDto(conta));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<String> remover(@PathVariable("id") Integer id) {
		
		Optional<Conta> optionalConta = contaRepository.findById(id);
		if (optionalConta.isPresent()) {
			contaRepository.deleteById(id);
			return ResponseEntity.ok("Conta de ID " + id + " Excluido!");
		}
		
		return ResponseEntity.notFound().build();
		
	}
	

}
