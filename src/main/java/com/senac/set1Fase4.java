package com.senac;

import java.util.Scanner;

public class set1Fase4 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    try {

      char alternativaFase4A = 'A';
      char alternativaFase4B = 'B';
      char alternativaFase4C = 'C';

      System.out.println("");

      System.out.println("Fase 4 - O Dragão das Classes!");
      System.out.println("");
      System.out.println("Pergunta: Como se cria uma classe em Java?");
      System.out.println("");

      Thread.sleep(1000);

      System.out.println("a) create");
      Thread.sleep(500);
      System.out.println("b) define");
      Thread.sleep(500);
      System.out.println("c) class");
      Thread.sleep(500);
      System.out.println("");
      System.out.println("Digite a respota correta a, b ou c");

      char respotaUsuario4 = sc.next().toUpperCase().charAt(0);

      if (respotaUsuario4 == alternativaFase4B || respotaUsuario4 == alternativaFase4A) {
        System.out.println(" ");
        System.out.println("Resposta Errada!");
        System.out.println(" ");
        System.out.println("Resposta correta: C");
      } else if (respotaUsuario4 == alternativaFase4C) {
        System.out.println("Resposta  Correta!");
      }
    } catch (InterruptedException exception) {
    }
  }
}