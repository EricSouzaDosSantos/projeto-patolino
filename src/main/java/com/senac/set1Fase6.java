package com.senac;

import java.util.Scanner;

public class set1Fase6 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    try {

      char alternativaFase6A = 'A';
      char alternativaFase6B = 'B';
      char alternativaFase6C = 'C';

      System.out.println("");

      System.out.println(" Fase 6 - O Senhor das Exceções!");
      System.out.println("");
      System.out.println("Pergunta: O que faz o bloco try-catch?");
      System.out.println("");

      Thread.sleep(1000);

      System.out.println("a) Executa repetição");
      Thread.sleep(500);
      System.out.println("b) Declara variáveis");
      Thread.sleep(500);
      System.out.println("c) Trata erros");
      Thread.sleep(500);
      System.out.println("");
      System.out.println("Digite a respota correta a, b ou c");

      char respotaUsuario6 = sc.next().toUpperCase().charAt(0);

      if (respotaUsuario6 == alternativaFase6B || respotaUsuario6 == alternativaFase6A) {
        System.out.println(" ");
        System.out.println("Resposta Errada!");
        System.out.println(" ");
        System.out.println("Resposta correta: C");
      } else if (respotaUsuario6 == alternativaFase6C) {
        System.out.println("Resposta  Correta!");
      }
    } catch (InterruptedException exception) {
    }
  }
}