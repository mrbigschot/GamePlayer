package gameplayer.UI;

import java.awt.Color;
import java.awt.Graphics;

public class DataPanel extends javax.swing.JPanel {

    int learnWins;
    int oppWins;
    int total;
    int left = 50;
    int width = 400;

    public DataPanel() {
        initComponents();
    }

    public void update(int player) {
        if (player == 1) {
            learnWins++;
        } else {
            oppWins++;
        }
        total++;
    }

    @Override
    public void paintComponent(Graphics g) {
        int oWidth = (int) (percentOpponent() * width);
        int lWidth = (int) (percentLearn() * width);
        g.setColor(Color.BLACK);
        g.fillRect(left, 100, oWidth, 50);
        g.drawString("BLACK WINS: " + oppWins, left, 200);
        g.setColor(Color.WHITE);
        g.fillRect(left + oWidth, 100, lWidth, 50);
        g.drawString("WHITE WINS: " + learnWins, left + width - 100, 200);
    }

    public double percentOpponent() {
        return (double) (oppWins) / total;
    }

    public double percentLearn() {
        return (double) (learnWins) / total;
    }

    public void reset() {
        learnWins = 0;
        oppWins = 0;
        total = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 204, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
