package gameplayer.UI;

import gameplayer.classes.Board;
import gameplayer.classes.ComputerPlayer;
import gameplayer.classes.Controller;
import gameplayer.classes.Globals;
import gameplayer.classes.LearningPlayer;
import gameplayer.classes.MinimaxPlayer;
import gameplayer.classes.Move;
import java.awt.Graphics;

public class GamePanel extends javax.swing.JPanel {

    public int gamesPlayed;
    DataFrame dFrame = new DataFrame();

    Controller c;
    Board b;

    boolean human;
    ComputerPlayer p1, p2;

    int pR, pC;
    int rR, rC;

    public GamePanel() {
        initComponents();
        p1 = new MinimaxPlayer(this);
        p2 = new LearningPlayer(this);
        b = new Board(p1, p2, this);
        b.rootBoard();
        p1.setCurrentBoard(b);
        p2.setCurrentBoard(b);
        p1.myTurn = true;
        c = new Controller(this, b, p1, p2);
        c.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        b.paint(g);
    }

    public void output(String s) {
        outputTF.setText(s);
    }

    public void updateData(int player) {
        dFrame.updateData(player);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outputTF = new javax.swing.JTextField();
        playButton = new javax.swing.JButton();
        delaySlider = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        sizeSlider = new javax.swing.JSlider();
        humanButton = new javax.swing.JToggleButton();
        learnerButton = new javax.swing.JToggleButton();
        minimaxSlider = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        learnedButton = new javax.swing.JButton();
        playManyButton = new javax.swing.JButton();
        trainSlider = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 204, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        playButton.setBackground(new java.awt.Color(0, 255, 102));
        playButton.setText("PLAY");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        delaySlider.setMajorTickSpacing(100);
        delaySlider.setMaximum(350);
        delaySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                delaySliderStateChanged(evt);
            }
        });

        jLabel1.setText("Delay:");

        jLabel2.setText("Board Size: ");

        resetButton.setBackground(new java.awt.Color(0, 255, 102));
        resetButton.setText("RESET");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        sizeSlider.setMajorTickSpacing(1);
        sizeSlider.setMaximum(5);
        sizeSlider.setMinimum(3);
        sizeSlider.setPaintLabels(true);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setSnapToTicks(true);
        sizeSlider.setValue(3);
        sizeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sizeSliderStateChanged(evt);
            }
        });

        humanButton.setText("MINIMAX vs ROTE");
        humanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanButtonActionPerformed(evt);
            }
        });

        learnerButton.setText("WHITE GOES SECOND");
        learnerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                learnerButtonActionPerformed(evt);
            }
        });

        minimaxSlider.setValue(0);
        minimaxSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                minimaxSliderStateChanged(evt);
            }
        });

        jLabel3.setText("Minimax Skill:");

        learnedButton.setText("LEARNED BOARDS");
        learnedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                learnedButtonActionPerformed(evt);
            }
        });

        playManyButton.setText("TRAIN ROTE LEARNER");
        playManyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playManyButtonActionPerformed(evt);
            }
        });

        trainSlider.setMajorTickSpacing(500);
        trainSlider.setMaximum(1000);
        trainSlider.setMinorTickSpacing(100);
        trainSlider.setPaintTicks(true);
        trainSlider.setSnapToTicks(true);
        trainSlider.setValue(0);

        jLabel4.setText("Games to Train: (0 to 1000)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outputTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(humanButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(resetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(minimaxSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(delaySlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(playManyButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(learnedButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(learnerButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trainSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minimaxSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(delaySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(humanButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resetButton)
                    .addComponent(playButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(learnerButton)
                .addGap(8, 8, 8)
                .addComponent(learnedButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playManyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trainSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(outputTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        c.toggleRunning();
        if (c.running) {
            playButton.setText("STOP");
        } else {
            playButton.setText("PLAY");
        }
    }//GEN-LAST:event_playButtonActionPerformed

    private void delaySliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_delaySliderStateChanged
        Globals.setTime(delaySlider.getValue());
    }//GEN-LAST:event_delaySliderStateChanged

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        b.reset();
        output("");
        repaint();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void sizeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sizeSliderStateChanged
        b.resetSize(sizeSlider.getValue());
        dFrame.reset();
        repaint();
        outputTF.setText("SIZE RESET TO " + b.size);
    }//GEN-LAST:event_sizeSliderStateChanged

    private void humanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanButtonActionPerformed
        human = !human;
        b.toggleHuman();
        c.toggleHuman();
        c.running = false;
        playButton.setText("PLAY");
        if (!human) {
            humanButton.setText("MINIMAX vs ROTE");
        } else {
            humanButton.setText("HUMAN vs ROTE");
        }
    }//GEN-LAST:event_humanButtonActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        pC = b.findCol(evt.getX());
        pR = b.findRow(evt.getY());
        rC = pC;
        rR = pR;
     }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        rC = b.findCol(evt.getX());
        rR = b.findRow(evt.getY());
        if (human) {
            if (b.inRange(rR, rC)) {
                if (!b.gameOver()) {
                    b.humanMove(new Move(pR, pC, rR, rC));
                } else {
                    output("GAME OVER");
                }
            } else {
                output("NOT ON BOARD");
            }
        } else {
            output("HUMAN IS NOT ACTIVE");
        }
        repaint();
    }//GEN-LAST:event_formMouseReleased

    private void learnerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_learnerButtonActionPerformed
        c.running = false;
        playButton.setText("PLAY");
        Globals.setFirst(-Globals.getFirst());
        if (Globals.getFirst() == 1) {
            p2.myTurn = true;
            learnerButton.setText("WHITE GOES FIRST");
        } else {
            p1.myTurn = true;
            learnerButton.setText("WHITE GOES SECOND");
        }
        b.reset();
        dFrame.reset();
    }//GEN-LAST:event_learnerButtonActionPerformed

    private void minimaxSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_minimaxSliderStateChanged
        p1.setSkill(minimaxSlider.getValue());
        p2.setSkill(minimaxSlider.getValue());
    }//GEN-LAST:event_minimaxSliderStateChanged

    private void learnedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_learnedButtonActionPerformed
        LearningPlayer ai = (LearningPlayer) p2;
        System.out.println("AI has learned: \n");
        System.out.println("" + ai.avoidThese.toString());
        System.out.println("" + ai.avoidThese.size() + " boards learned.");
    }//GEN-LAST:event_learnedButtonActionPerformed

    private void playManyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playManyButtonActionPerformed
        Globals.toggleFastMode();
        while (gamesPlayed < trainSlider.getValue()) {
            while (!b.gameOver()) {
                b.simPlay();
            }
            gamesPlayed++;
            b.reset();
        }
        Globals.toggleFastMode();
        output("");
        repaint();
        dFrame.repaint();
        gamesPlayed = 0;
    }//GEN-LAST:event_playManyButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider delaySlider;
    private javax.swing.JToggleButton humanButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton learnedButton;
    private javax.swing.JToggleButton learnerButton;
    private javax.swing.JSlider minimaxSlider;
    private javax.swing.JTextField outputTF;
    private javax.swing.JButton playButton;
    private javax.swing.JButton playManyButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JSlider sizeSlider;
    private javax.swing.JSlider trainSlider;
    // End of variables declaration//GEN-END:variables

}
