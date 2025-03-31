package com.senac;

import java.util.Scanner;

public class set2Fase1 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    try {

      char alternativaFase7A = 'A';
      char alternativaFase7B = 'B';
      char alternativaFase7C = 'C';

      System.out.println("");

      System.out.println("Fase 1 - O Fantasma da Entrada!");
      System.out.println("");
      System.out.println("Pergunta: Qual classe lê dados digitados no terminal?");
      System.out.println("");

      Thread.sleep(1000);

      System.out.println("a) Scanner");
      Thread.sleep(500);
      System.out.println("b) Input");
      Thread.sleep(500);
      System.out.println("c) Reader");
      Thread.sleep(500);
      System.out.println("");
      System.out.println("Digite a respota correta a, b ou c");

      char respotaUsuario7 = sc.next().toUpperCase().charAt(0);

      if (respotaUsuario7 == alternativaFase7B || respotaUsuario7 == alternativaFase7C) {
        System.out.println(" ");
        System.out.println("Resposta Errada!");
        System.out.println(" ");
        System.out.println("Resposta correta: A");
      } else if (respotaUsuario7 == alternativaFase7A) {
        System.out.println("Resposta  Correta!");
      }
    } catch (InterruptedException exception) {
    }
  }
}