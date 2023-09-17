package br.com.desafioibm.controllers;

import br.com.desafioibm.entities.Jogador;
import br.com.desafioibm.services.LarissaSimoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class JogadorController {

    @Autowired
    private LarissaSimoesService larissaSimoes;

    @PostMapping("/jogador")
    public ResponseEntity<Void> addJogador(@RequestBody Jogador jogador) {
        larissaSimoes.addJogador(jogador);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/times")
    public ResponseEntity<Map<String, List<String>>> getTimes() {
        List<Jogador> jogadores = larissaSimoes.getAllJogadores();
        List<String> nomesJogadores = jogadores.stream()
                .map(Jogador::getNome)
                .collect(Collectors.toList());
        Map<String, List<String>> times = larissaSimoes.organizarTimes(nomesJogadores);
        return new ResponseEntity<>(times, HttpStatus.OK);
    }

    @DeleteMapping("/jogador/all")
    public ResponseEntity<Void> deleteAll() {
        larissaSimoes.deleteAllJogadores();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
