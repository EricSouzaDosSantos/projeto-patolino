package com.senac.service;

import com.senac.model.Jogador;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RankingService {
    private static final String ARQUIVO_RANKING = "src/main/resources/ranking.txt";

    public RankingService() {
        configurarTema();
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

    public List<Jogador> carregarRanking() {
        List<Jogador> ranking = new ArrayList<>();
        File arquivo = new File(ARQUIVO_RANKING);

        if (!arquivo.exists()) {
            System.out.println("Arquivo de ranking não encontrado: " + ARQUIVO_RANKING + ". Um novo será criado ao salvar.");
            return ranking;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    continue;
                }
                try {
                    ranking.add(Jogador.fromString(linha));
                } catch (IllegalArgumentException e) {
                    System.err.println("Linha ignorada no arquivo de ranking devido a formato inválido ('" + linha + "'): " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {

            System.err.println("Erro crítico: Arquivo de ranking não encontrado apesar da verificação prévia. " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro ao carregar o ranking do arquivo " + ARQUIVO_RANKING + ": " + e.getMessage());
        }
        return ranking;
    }

    public void salvarRanking(List<Jogador> ranking) {
        File arquivo = new File(ARQUIVO_RANKING);
        try {
            File diretorioPai = arquivo.getParentFile();
            if (diretorioPai != null && !diretorioPai.exists()) {
                if (!diretorioPai.mkdirs()) {
                    System.err.println("Falha ao criar o diretório para o arquivo de ranking: " + diretorioPai.getAbsolutePath());
                    return;
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
                for (Jogador jogador : ranking) {
                    writer.write(jogador.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar o ranking no arquivo " + ARQUIVO_RANKING + ": " + e.getMessage());
        }
    }

    public void atualizarRanking(String nick, int pontuacao) {
        List<Jogador> ranking = carregarRanking();
        Jogador jogadorExistente = null;

        for (Jogador jogador : ranking) {
            if (jogador.getNick().equalsIgnoreCase(nick)) {
                jogadorExistente = jogador;
                break;
            }
        }

        if (jogadorExistente != null) {
            if (pontuacao > jogadorExistente.getPontuacao()) {
                jogadorExistente.setPontuacao(pontuacao);
            }
        } else {
            ranking.add(new Jogador(nick, pontuacao));
        }

        // ranking.sort(Comparator.comparingInt(Jogador::getPontuacao).reversed());
        salvarRanking(ranking);
    }

    public void exibirRanking() {
        exibirRanking(null);
    }



    public void exibirRanking(Frame owner) {
        List<Jogador> ranking = carregarRanking();
        ranking.sort(Comparator.comparingInt(Jogador::getPontuacao).reversed());

        StringBuilder rankingTextBuilder = new StringBuilder();
        rankingTextBuilder.append("<html><div style='text-align: center; color: green; font-family: Monospaced;'>");
        rankingTextBuilder.append("<h2>RANKING DE JOGADORES</h2><br>");

        if (ranking.isEmpty()) {
            rankingTextBuilder.append("Ainda não há jogadores no ranking.<br>");
        } else {
            for (int i = 0; i < ranking.size(); i++) {
                Jogador jogador = ranking.get(i);
                String medalha = "";
                if (i < 3) {
                    switch (i) {
                        case 0: medalha = "🥇 "; break;
                        case 1: medalha = "🥈 "; break;
                        case 2: medalha = "🥉 "; break;
                    }
                }
                rankingTextBuilder.append(String.format("%2d. %s%s - %d pontos<br>",
                        (i + 1),
                        medalha,
                        jogador.getNick(),
                        jogador.getPontuacao()));
            }
        }
        rankingTextBuilder.append("</div></html>");

        SwingUtilities.invokeLater(() -> {
            JDialog rankingDialog = new JDialog(owner, "Ranking de Jogadores", true);
            rankingDialog.setLayout(new BorderLayout(10, 10));

            JLabel rankingLabel = new JLabel(rankingTextBuilder.toString());
            rankingLabel.setHorizontalAlignment(SwingConstants.CENTER);
            rankingLabel.setBackground(Color.BLACK);
            rankingLabel.setOpaque(true);

            JScrollPane scrollPane = new JScrollPane(rankingLabel);
            scrollPane.setBackground(Color.BLACK);
            rankingDialog.add(scrollPane, BorderLayout.CENTER);

            JButton okButton = new JButton("OK");
            okButton.addActionListener(e -> rankingDialog.dispose());

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(okButton);
            rankingDialog.add(buttonPanel, BorderLayout.SOUTH);

            rankingDialog.setSize(450, 400);
            rankingDialog.setLocationRelativeTo(owner);
            rankingDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            rankingDialog.setVisible(true);
        });
    }

    public String getRankingComoStringFormatada() {
        List<Jogador> ranking = carregarRanking();
        ranking.sort(Comparator.comparingInt(Jogador::getPontuacao).reversed());

        StringBuilder sb = new StringBuilder();
        if (ranking.isEmpty()) {
            sb.append("Ainda não há jogadores no ranking.\n");
        } else {
            for (int i = 0; i < ranking.size(); i++) {
                Jogador jogador = ranking.get(i);
                String medalha = "";
                if (i < 3) {
                    switch (i) {
                        case 0: medalha = "🥇 "; break;
                        case 1: medalha = "🥈 "; break;
                        case 2: medalha = "🥉 "; break;
                    }
                }
                sb.append(String.format("%2d. %s%s - %d pontos\n",
                        (i + 1),
                        medalha,
                        jogador.getNick(),
                        jogador.getPontuacao()));
            }
        }
        return sb.toString();
    }
}