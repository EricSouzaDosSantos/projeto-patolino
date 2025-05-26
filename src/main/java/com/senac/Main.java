package com.senac;



import com.senac.service.Menu;
import com.senac.service.PatolinoGm;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PatolinoGm intro = new PatolinoGm();
            intro.introducao();

            intro.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    new Menu();
                }
            });
        });
    }
}
