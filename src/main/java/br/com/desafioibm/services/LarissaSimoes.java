//package br.com.desafioibm.services;
//
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//@Service
//public class LarissaSimoes {
//
//    public Map<String, List<String>> organizarTimes(List<String> jogadores) {
//        Map<String, List<String>> times = new HashMap<>();
//        Map<String, Integer> contagemSobrenomes = new HashMap<>();
//        int timeID = 1;
//
//        for (String jogador : jogadores) {
//            String[] partes = jogador.split(" ");
//
//            if (partes.length != 2) continue;
//
//            String sobrenome = partes[1];
//            char primeiraLetra = sobrenome.charAt(0);
//
//            String chave = primeiraLetra + "_" + timeID;
//
//            if (!times.containsKey(chave)) {
//                times.put(chave, new ArrayList<>());
//            }
//
//            int contagem = contagemSobrenomes.getOrDefault(sobrenome, 0);
//
//            if (contagem > 0) {
//                timeID++;
//                chave = primeiraLetra + "_" + timeID;
//                times.put(chave, new ArrayList<>());
//            }
//
//            times.get(chave).add(jogador);
//
//            contagemSobrenomes.put(sobrenome, contagem + 1);
//        }
//
//        return times;
//    }
////    public static void main(String[] args) {
////        List<String> jogadores = Arrays.asList(
////                "Lionel Messi", "Cristiano Ronaldo", "Neymar Jr.",
////                "Kylian Mbappé", "Luka Modric", "Sergio Ramos",
////                "Gareth Bale", "Gianluigi Buffon", "Gonzalo Higuain",
////                "Thiago Silva", "Sergio Aguero", "Angel Di Maria",
////                "Pedro Silveira", "Paulo Silva", "Patricia Silva"
////        );
////
////        Map<String, List<String>> times = organizarTimes(jogadores);
////
////        int timeID = 1;
////        for (Map.Entry<String, List<String>> entry : times.entrySet()) {
////            System.out.println("Time '" + timeID + "': " + entry.getValue());
////            timeID++;
////        }
////    }
//
//}
