package br.com.dock.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dock.projeto.modelo.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

	List<Conta> findByFlagAtivo(Boolean flagAtivo);

}
