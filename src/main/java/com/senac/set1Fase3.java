package com.senac;

import java.util.Scanner;

public class set1Fase3 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    try {

      char alternativaFase3A = 'A';
      char alternativaFase3B = 'B';
      char alternativaFase3C = 'C';

      System.out.println("");

      System.out.println("Fase 3 - O Ciclope dos Loops!");
      System.out.println("");
      System.out.println("Pergunta: Qual estrutura repete enquanto uma condição for verdadeira?");
      System.out.println("");

      Thread.sleep(1000);

      System.out.println("a) while");
      Thread.sleep(500);
      System.out.println("b) if");
      Thread.sleep(500);
      System.out.println("c) switch");
      Thread.sleep(500);
      System.out.println("");
      System.out.println("Digite a respota correta a, b ou c");

      char respotaUsuario3 = sc.next().toUpperCase().charAt(0);

      if (respotaUsuario3 == alternativaFase3B || respotaUsuario3 == alternativaFase3C) {
        System.out.println(" ");
        System.out.println("Resposta Errada!");
        System.out.println(" ");
        System.out.println("Resposta correta: A");
      } else if (respotaUsuario3 == alternativaFase3A) {
        System.out.println("Resposta  Correta!");
      }
    } catch (InterruptedException exception) {
    }
  }
}