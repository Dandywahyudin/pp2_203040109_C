package Tugas2;
import java.awt.event.*;
import javax.swing.*;

public class HelloTextAreaLatihan4 extends JFrame {
    public HelloTextAreaLatihan4() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel labelInput = new JLabel("Input Nama");
        labelInput.setBounds(130, 40, 100, 10);
        
        JTextField textField = new JTextField();
        textField.setBounds(130, 60, 100, 30);
        
        JLabel labelTelp = new JLabel("Input Nomor Telp");
        labelTelp.setBounds(130, 100, 120, 10);  
        
        JTextField textTelp = new JTextField();
        textTelp.setBounds(130, 120, 100, 30);  
        
        JButton button = new JButton("Klik");
        button.setBounds(130, 160, 100, 30);
        
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(130, 200, 150, 100);
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textField.getText();
                String telpon = textTelp.getText(); 
                txtOutput.append("Hello " + nama + " - " + telpon + "\n");
                textField.setText("");
                textTelp.setText("");
            }
        });
        
        this.add(button);
        this.add(textField);
        this.add(txtOutput);
        this.add(labelInput);
        this.add(labelTelp);
        this.add(textTelp);
        
        this.setSize(400, 400);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloTextAreaLatihan4 h = new HelloTextAreaLatihan4();
                h.setVisible(true);
            }
        });
    }
}
