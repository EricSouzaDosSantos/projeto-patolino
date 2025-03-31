package com.senac;

import java.util.Scanner;

public class set2Fase3 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    try {

      char alternativaFase9A = 'A';
      char alternativaFase9B = 'B';
      char alternativaFase9C = 'C';

      System.out.println("");

      System.out.println("Fase 3 - O Monstro dos Operadores!");
      System.out.println("");
      System.out.println("Pergunta: Qual operador representa 'E lógico'?");
      System.out.println("");

      Thread.sleep(1000);

      System.out.println("a) ||");
      Thread.sleep(500);
      System.out.println("b) &&");
      Thread.sleep(500);
      System.out.println("c) !");
      Thread.sleep(500);
      System.out.println("");
      System.out.println("Digite a respota correta a, b ou c");

      char respotaUsuario9 = sc.next().toUpperCase().charAt(0);

      if (respotaUsuario9 == alternativaFase9A || respotaUsuario9 == alternativaFase9C) {
        System.out.println(" ");
        System.out.println("Resposta Errada!");
        System.out.println(" ");
        System.out.println("Resposta correta: B");
      } else if (respotaUsuario9 == alternativaFase9B) {
        System.out.println("Resposta  Correta!");
      }
    } catch (InterruptedException exception) {
    }
  }
}