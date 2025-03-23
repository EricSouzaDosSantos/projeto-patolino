package com.senac;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            char alternativaFase1A = 'A';
            char alternativaFase1B = 'B';
            char alternativaFase1C = 'C';

            System.out.println("");

            System.out.println("Fase 1 - O Feiticeiro das Variáveis!");
            System.out.println("");
            System.out.println("Pergunta: Qual tipo armazena números inteiros em Java?");
            System.out.println("");

            Thread.sleep(1000);

            System.out.println("a) float");
            Thread.sleep(500);
            System.out.println("b) int");
            Thread.sleep(500);
            System.out.println("c) double");
            Thread.sleep(500);
            System.out.println("");
            System.out.println("Digite a respota correta a, b ou c");

            char respotaUsuario1 = sc.next().toUpperCase().charAt(0);

            if (respotaUsuario1 == alternativaFase1A || respotaUsuario1 == alternativaFase1C) {
                System.out.println("");
                System.out.println("Resposta Errada!");
                System.out.println("");
                System.out.println("Resposta Correta B");
            } else if (respotaUsuario1 == alternativaFase1B) {
                System.out.println("Resposta  Correta!");
            }

        }
        catch (InterruptedException exception) {
        }
    }
}