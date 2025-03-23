package com.senac;

import java.util.Scanner;

public class set1Fase5 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    try {

      char alternativaFase5A = 'A';
      char alternativaFase5B = 'B';
      char alternativaFase5C = 'C';

      System.out.println("");

      System.out.println("Fase 5 - O Troll da Herança!");
      System.out.println("");
      System.out.println("Pergunta: Qual palavra indica herança em Java?");
      System.out.println("");

      Thread.sleep(1000);

      System.out.println("a) inherits");
      Thread.sleep(500);
      System.out.println("b) extends");
      Thread.sleep(500);
      System.out.println("c) override");
      Thread.sleep(500);
      System.out.println("");
      System.out.println("Digite a respota correta a, b ou c");

      char respotaUsuario5 = sc.next().toUpperCase().charAt(0);

      if (respotaUsuario5 == alternativaFase5C || respotaUsuario5 == alternativaFase5A) {
        System.out.println(" ");
        System.out.println("Resposta Errada!");
        System.out.println(" ");
        System.out.println("Resposta correta: B");
      } else if (respotaUsuario5 == alternativaFase5B) {
        System.out.println("Resposta  Correta!");
      }
    } catch (InterruptedException exception) {
    }
  }
}