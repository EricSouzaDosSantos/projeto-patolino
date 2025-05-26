package com.senac.service;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PatolinoGm extends JFrame {

    private JTextArea textArea;
    private List<String> filaDeTextos = new ArrayList<>();
    private int indiceTexto = 0;
    private int indiceLetra = 0;
    private Timer timer;
    private String textoAtual = "";

    public PatolinoGm() {
        setTitle("A Jornada de Patolino");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.addActionListener(e -> {
            if (timer != null) timer.stop();
            dispose();
        });
        add(btnContinuar, BorderLayout.SOUTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.GREEN);

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        setVisible(true);
    }

    public void introducao() {
        filaDeTextos.add("Patolino... outrora um mísero mago de magia, dominava feitiços comuns. System.err.println.");
        filaDeTextos.add("Mas algo dentro dele ansiava por mais...");
        filaDeTextos.add("Ele descobriu um grimório antigo, perdido entre código e circuitos.");
        filaDeTextos.add("Seu nome: Algoritmos e Estruturas de Dados.");
        filaDeTextos.add("");
        filaDeTextos.add("Foi então que Patolino decidiu transcender a magia tradicional...");
        filaDeTextos.add("E se tornar o SUPREMO MAGO DA PROGRAMAÇÃO! ");
        filaDeTextos.add("");
        filaDeTextos.add("Sua missão? Derrotar os 5 grandes chefões do conhecimento em Java.");
        filaDeTextos.add("Mas cuidado... a cada resposta errada, uma vida será perdida.");
        filaDeTextos.add("Se todas as vidas se forem, o mago cairá... e tudo começará de novo. ");
        filaDeTextos.add("");
        filaDeTextos.add("Prepare sua mente.");
        filaDeTextos.add("Afie sua lógica.");
        filaDeTextos.add("E entre no reino encantado dos códigos com Patolino!");
        filaDeTextos.add("");
        filaDeTextos.add("Aperte o botão de continuar abaixo para o desafio começar... ");
        filaDeTextos.add("\n==========================================\n");

        iniciarEscrita();
    }

    private void iniciarEscrita() {
        if (indiceTexto >= filaDeTextos.size()) return;

        textoAtual = filaDeTextos.get(indiceTexto);
        indiceLetra = 0;

        timer = new Timer(40, e -> {
            if (indiceLetra < textoAtual.length()) {
                textArea.append(String.valueOf(textoAtual.charAt(indiceLetra)));
                indiceLetra++;
                textArea.setCaretPosition(textArea.getDocument().getLength());
            } else {
                textArea.append("\n");
                ((Timer) e.getSource()).stop();
                indiceTexto++;
                new Timer(400, ev -> {
                    ((Timer) ev.getSource()).stop();
                    iniciarEscrita();
                }).start();
            }
        });
        timer.start();
    }
}
