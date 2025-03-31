package com.senac;

import java.util.Scanner;

public class set2Fase5 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    try {

      char alternativaFase11A = 'A';
      char alternativaFase11B = 'B';
      char alternativaFase11C = 'C';

      System.out.println("");

      System.out.println("Fase 5 - A Fera da Lógica!");
      System.out.println("");
      System.out.println("Pergunta: Qual palavra-chave cria um objeto?");
      System.out.println("");

      Thread.sleep(1000);

      System.out.println("a) build");
      Thread.sleep(500);
      System.out.println("b) make");
      Thread.sleep(500);
      System.out.println("c) new");
      Thread.sleep(500);
      System.out.println("");
      System.out.println("Digite a respota correta a, b ou c");

      char respotaUsuario11 = sc.next().toUpperCase().charAt(0);

      if (respotaUsuario11 == alternativaFase11B || respotaUsuario11 == alternativaFase11A) {
        System.out.println(" ");
        System.out.println("Resposta Errada!");
        System.out.println(" ");
        System.out.println("Resposta correta: C");
      } else if (respotaUsuario11 == alternativaFase11C) {
        System.out.println("Resposta  Correta!");
      }
    } catch (InterruptedException exception) {
    }
  }
}