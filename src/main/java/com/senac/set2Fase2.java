package com.senac;

import java.util.Scanner;

public class set2Fase2 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    try {

      char alternativaFase8A = 'A';
      char alternativaFase8B = 'B';
      char alternativaFase8C = 'C';

      System.out.println("");

      System.out.println("Fase 2 - O Minotauro do Print!");
      System.out.println("");
      System.out.println("Pergunta: Qual comando exibe algo no console?");
      System.out.println("");

      Thread.sleep(1000);

      System.out.println("a) System.out.println()");
      Thread.sleep(500);
      System.out.println("b) echo");
      Thread.sleep(500);
      System.out.println("c) print()");
      Thread.sleep(500);
      System.out.println("");
      System.out.println("Digite a respota correta a, b ou c");

      char respotaUsuario8 = sc.next().toUpperCase().charAt(0);

      if (respotaUsuario8 == alternativaFase8B || respotaUsuario8 == alternativaFase8C) {
        System.out.println(" ");
        System.out.println("Resposta Errada!");
        System.out.println(" ");
        System.out.println("Resposta correta: A");
      } else if (respotaUsuario8 == alternativaFase8A) {
        System.out.println("Resposta  Correta!");
      }
    } catch (InterruptedException exception) {
    }
  }
}