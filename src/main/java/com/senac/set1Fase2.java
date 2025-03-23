package com.senac;

import java.util.Scanner;

public class set1Fase2 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    try {

      char alternativaFase2A = 'A';
      char alternativaFase2B = 'B';
      char alternativaFase2C = 'C';

      System.out.println("");

      System.out.println("Fase 2 - O Goblin dos Métodos!");
      System.out.println("");
      System.out.println("Pergunta: Qual palavra-chave define um método que não retorna nada?");
      System.out.println("");

      Thread.sleep(1000);

      System.out.println("a) return");
      Thread.sleep(500);
      System.out.println("b) void");
      Thread.sleep(500);
      System.out.println("c) static");
      Thread.sleep(500);
      System.out.println("");
      System.out.println("Digite a respota correta a, b ou c");

      char respotaUsuario2 = sc.next().toUpperCase().charAt(0);

      if (respotaUsuario2 == alternativaFase2A || respotaUsuario2 == alternativaFase2C) {
        System.out.println(" ");
        System.out.println("Resposta Errada!");
        System.out.println(" ");
        System.out.println("Resposta Correta B");
      } else if (respotaUsuario2 == alternativaFase2B) {
        System.out.println("Resposta  Correta!");
      }
    } catch (InterruptedException exception) {
    }
  }
}