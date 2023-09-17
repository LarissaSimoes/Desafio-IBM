package br.com.desafioibm.repositories;

import br.com.desafioibm.entities.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}

