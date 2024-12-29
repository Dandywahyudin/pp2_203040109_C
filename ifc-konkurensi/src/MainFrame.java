/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author teknik_baru
 */
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame {
    public static void main (String[] args){
        SwingUtilities.invokeLater(() -> {
        JFrame frame =  new JFrame("Contoh Kunkurensi di Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,200);
        frame.setLayout(new BorderLayout());
        
        JLabel statusLabel = new JLabel("Tekan tombol untuk mulai tugas berat", JLabel.CENTER);
        JButton startButton = new JButton("Mulai");
        
        JProgressBar progressBar = new JProgressBar(0, 60);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        
        frame.add(statusLabel, BorderLayout.NORTH);
        frame.add(progressBar, BorderLayout.CENTER);
        frame.add(startButton, BorderLayout.SOUTH);
        
//        Latihan 1
//        startButton.addActionListener(e -> {
//            for (int i = 0; i <= 60; i++) {
//                progressBar.setValue(i);
//                try {
//                    Thread.sleep(1000);
//                }catch (Exception ex){
//                    System.err.println(ex.getMessage());
//                }
//            }
//        });
        

        startButton.addActionListener(e -> {
            startButton.setEnabled(false);
            statusLabel.setText("Proses berjalan..");
            
            SwingWorker<Void, Integer> worker = new SwingWorker<>() {
                @Override 
                protected Void doInBackground() throws Exception {
                    for (int i = 0; i <= 100; i++){
                        Thread.sleep(50);
                        publish(i);
                    }
                    return null;
                }
                
                @Override
                protected void process(List<Integer> chunks) {
                    int latestProgress = chunks.get(chunks.size() - 1);
                    progressBar.setValue(latestProgress);
                }
                
                @Override
                protected void done() {
                    startButton.setEnabled(true);
                    statusLabel.setText("Proses selesai");
                }
            };
            worker.execute();
        });
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        });
    }
}