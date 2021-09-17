package com.kremogen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ThreadLocalRandom;

public class MainWindow extends JFrame {

    private final int randNum = ThreadLocalRandom.current().nextInt(0, 20);

    private final JTextArea gameField;
    private final JLabel displayArea;

    private int attempts = 3;

    protected MainWindow() {
        super("Угадайка");

        this.setLayout(null);
        this.setSize(320, 240);

        JLabel displayNumber = new JLabel("Число: " + randNum, SwingConstants.CENTER);
        displayNumber.setFont(Font.getFont(Font.MONOSPACED));
        displayNumber.setSize(320, 100);
        displayNumber.setLocation(0, 15);

        displayArea = new JLabel("Угадайте число от 0 до 20", SwingConstants.CENTER);
        displayArea.setFont(Font.getFont(Font.MONOSPACED));
        displayArea.setSize(320, 100);
        displayArea.setLocation(0, 30);

        gameField = new JTextArea();
        gameField.setSize(100, 20);
        gameField.setLocation(110, 100);

        JButton btn1 = new JButton("Кликни");
        btn1.setSize(100, 20);
        btn1.setLocation(110, 140);

        this.add(gameField);
        this.add(displayNumber);
        this.add(displayArea);
        this.add(btn1);

        btn1.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                attempts--;

                if (attempts == 0)
                    System.exit(0);

                int ans = Integer.parseInt(gameField.getText());
                if (ans == randNum) {
                    displayArea.setText("Congrats! Вы угадали число!");
                    btn1.addMouseListener(null);
                } else if (ans < randNum) {
                    displayArea.setText("Нужное число немного больше! Попытки: " + attempts);
                } else {
                    displayArea.setText("Нужное число немного меньше! Попытки: " + attempts);
                }
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
    }
}