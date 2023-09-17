package br.com.desafioibm.services;

import br.com.desafioibm.entities.Jogador;
import br.com.desafioibm.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LarissaSimoesService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public Map<String, List<String>> organizarTimes(List<String> jogadores) {
        Map<String, List<String>> times = new HashMap<>();
        Map<String, Integer> contagemSobrenomes = new HashMap<>();
        int timeID = 1;

        for (String jogador : jogadores) {
            String[] partes = jogador.split(" ");

            if (partes.length != 2) continue;

            String sobrenome = partes[1];
            char primeiraLetra = sobrenome.charAt(0);

            String chave = primeiraLetra + "_" + timeID;

            if (!times.containsKey(chave)) {
                times.put(chave, new ArrayList<>());
            }

            int contagem = contagemSobrenomes.getOrDefault(sobrenome, 0);

            if (contagem > 0) {
                timeID++;
                chave = primeiraLetra + "_" + timeID;
                times.put(chave, new ArrayList<>());
            }

            times.get(chave).add(jogador);

            contagemSobrenomes.put(sobrenome, contagem + 1);
        }

        return times;
    }

    public void deleteAllJogadores() {
        jogadorRepository.deleteAll();
    }

    public List<Jogador> getAllJogadores() {
        return jogadorRepository.findAll();
    }

    public Jogador addJogador(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }
}
