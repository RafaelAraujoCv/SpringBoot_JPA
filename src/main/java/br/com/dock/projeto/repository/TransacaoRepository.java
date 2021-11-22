package br.com.dock.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.dock.projeto.modelo.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {




}
