package com.senac.service;

import com.senac.model.GerenciadorDeArquivos;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    private GerenciadorDeArquivos arquivos = new GerenciadorDeArquivos();
    private PerguntaService perguntaService = new PerguntaService(arquivos);
    private RankingService rankingService = new RankingService();
    private JogoService jogoService = new JogoService(perguntaService, rankingService);

    public Menu(){
//        patolinoGm.introducao();
        configurarTema();
        iniciarMenu();
        setVisible(true);
    }
    private void configurarTema() {
        UIManager.put("Panel.background", Color.BLACK);
        UIManager.put("OptionPane.background", Color.BLACK);
        UIManager.put("OptionPane.messageForeground", Color.GREEN);
        UIManager.put("OptionPane.buttonFont", new Font("Monospaced", Font.PLAIN, 16));
        UIManager.put("OptionPane.messageFont", new Font("Monospaced", Font.PLAIN, 16));
        UIManager.put("OptionPane.foreground", Color.GREEN);

        UIManager.put("Button.background", Color.GREEN);
        UIManager.put("Button.foreground", Color.BLACK);
        UIManager.put("Button.font", new Font("Monospaced", Font.PLAIN, 16));

        UIManager.put("Label.font", new Font("Monospaced", Font.PLAIN, 16));
        UIManager.put("Label.foreground", Color.GREEN);

        UIManager.put("RadioButton.background", Color.BLACK);
        UIManager.put("RadioButton.foreground", Color.GREEN);
        UIManager.put("RadioButton.font", new Font("Monospaced", Font.PLAIN, 16));

        UIManager.put("TextField.background", Color.BLACK);
        UIManager.put("TextField.foreground", Color.GREEN);
        UIManager.put("TextField.font", new Font("Monospaced", Font.PLAIN, 16));
    }


    private void iniciarMenu() {
        setTitle("Jogo de Perguntas");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        panel.setBackground(Color.BLACK);
        panel.setForeground(Color.GREEN);
//        textArea.setBackground(Color.BLACK);
//        textArea.setForeground(Color.GREEN);

        JLabel titleLabel = new JLabel("MENU PRINCIPAL", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
        titleLabel.setForeground(Color.GREEN);

        JButton btnJogar = new JButton("Jogar");
        JButton btnRanking = new JButton("Ver Ranking");
        JButton btnSair = new JButton("Sair");
        btnJogar.setBackground(Color.GREEN);
        btnJogar.setForeground(Color.BLACK);
        btnJogar.setFont(new Font("Monospaced", Font.PLAIN, 20));
        btnRanking.setBackground(Color.GREEN);
        btnRanking.setFont(new Font("Monospaced", Font.PLAIN, 20));
        btnRanking.setForeground(Color.BLACK);
        btnSair.setBackground(Color.GREEN);
        btnSair.setForeground(Color.BLACK);
        btnSair.setFont(new Font("Monospaced", Font.PLAIN, 20));


        btnJogar.addActionListener(e -> iniciarJogo());
        btnRanking.addActionListener(e -> rankingService.exibirRanking());
        btnSair.addActionListener(e -> System.exit(0));

        panel.add(titleLabel);
        panel.add(btnJogar);
        panel.add(btnRanking);
        panel.add(btnSair);

        add(panel);
    }


    private void iniciarJogo() {
        String input = JOptionPane.showInputDialog(this, "Quantos jogadores vão jogar? (1 a 4):");
        if (input == null) return;

        try {
            int total = Integer.parseInt(input);

            if (total < 1 || total > 4) {
                JOptionPane.showMessageDialog(this, "Número inválido. Digite entre 1 e 4.");
                return;
            }

            String[] nicks = new String[total];
            for (int i = 0; i < total; i++) {
                nicks[i] = JOptionPane.showInputDialog(this, "Jogador " + (i + 1) + ", digite seu nick:");
                if (nicks[i] == null || nicks[i].trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Nick inválido!");
                    return;
                }
            }

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JRadioButton nivel1 = new JRadioButton("Aprendiz de Feitiçaria (Fácil)");
            JRadioButton nivel2 = new JRadioButton("Mago Estagiário (Médio)");
            JRadioButton nivel3 = new JRadioButton("Feiticeiro Experiente (Difícil)");
            JRadioButton nivel4 = new JRadioButton("Mestre dos Encantos (Muito Difícil)");
            JRadioButton nivel5 = new JRadioButton("Patolino Supremo (Extremo)");

            nivel1.setSelected(true);

            ButtonGroup group = new ButtonGroup();
            group.add(nivel1);
            group.add(nivel2);
            group.add(nivel3);
            group.add(nivel4);
            group.add(nivel5);

            panel.add(new JLabel("Selecione o nível de dificuldade:"));
            panel.add(nivel1);
            panel.add(nivel2);
            panel.add(nivel3);
            panel.add(nivel4);
            panel.add(nivel5);

            int result = JOptionPane.showConfirmDialog(
                    this,
                    panel,
                    "Níveis de Dificuldade",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (result != JOptionPane.OK_OPTION) {
                return;
            }

            int nivelSelecionado;
            if (nivel1.isSelected()) {
                nivelSelecionado = 1;
            } else if (nivel2.isSelected()) {
                nivelSelecionado = 2;
            } else if (nivel3.isSelected()) {
                nivelSelecionado = 3;
            } else if (nivel4.isSelected()) {
                nivelSelecionado = 4;
            } else {
                nivelSelecionado = 5;
            }

            jogoService.jogar(nicks, nivelSelecionado);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite um número válido!");
        }
    }

}
