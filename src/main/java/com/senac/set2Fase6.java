package com.senac;

import java.util.Scanner;

public class set2Fase6 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    try {

      char alternativaFase12A = 'A';
      char alternativaFase12B = 'B';
      char alternativaFase12C = 'C';

      System.out.println("");

      System.out.println("Fase 6 - O Lorde dos Arrays!");
      System.out.println("");
      System.out.println("Pergunta: Qual índice representa o primeiro elemento de um array?");
      System.out.println("");

      Thread.sleep(1000);

      System.out.println("a) 1");
      Thread.sleep(500);
      System.out.println("b) 0");
      Thread.sleep(500);
      System.out.println("c) -1");
      Thread.sleep(500);
      System.out.println("");
      System.out.println("Digite a respota correta a, b ou c");

      char respotaUsuario12 = sc.next().toUpperCase().charAt(0);

      if (respotaUsuario12 == alternativaFase12C || respotaUsuario12 == alternativaFase12A) {
        System.out.println(" ");
        System.out.println("Resposta Errada!");
        System.out.println(" ");
        System.out.println("Resposta correta: B");
      } else if (respotaUsuario12 == alternativaFase12B) {
        System.out.println("Resposta  Correta!");
      }
    } catch (InterruptedException exception) {
    }
  }
}
