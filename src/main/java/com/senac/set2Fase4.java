package com.senac;

import java.util.Scanner;

public class set2Fase4 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    try {

      char alternativaFase10A = 'A';
      char alternativaFase10B = 'B';
      char alternativaFase10C = 'C';

      System.out.println("");

      System.out.println("Fase 4 - A Serpente da Comparação!");
      System.out.println("");
      System.out.println("Pergunta: O que o operador == faz?");
      System.out.println("");

      Thread.sleep(1000);

      System.out.println(" a) Compara valores");
      Thread.sleep(500);
      System.out.println(" b) Soma números");
      Thread.sleep(500);
      System.out.println(" c) Atribui valor");
      Thread.sleep(500);
      System.out.println("");
      System.out.println("Digite a respota correta a, b ou c");

      char respotaUsuario10 = sc.next().toUpperCase().charAt(0);

      if (respotaUsuario10 == alternativaFase10B || respotaUsuario10 == alternativaFase10C) {
        System.out.println(" ");
        System.out.println("Resposta Errada!");
        System.out.println(" ");
        System.out.println("Resposta correta: A");
      } else if (respotaUsuario10 == alternativaFase10A) {
        System.out.println("Resposta  Correta!");
      }
    } catch (InterruptedException exception) {
    }
  }
}