package Tugas2;

import javax.swing.*;
import java.awt.event.*;

public class HelloRadioButton2 extends JFrame{
	
	private String checkBoxSelected;

		public HelloRadioButton2() {
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JLabel labelInput = new JLabel("Nama: ");
			labelInput.setBounds(15, 40, 350, 10);
			
			JTextField textField = new JTextField();
			textField.setBounds(15, 60, 350, 30);
			
			JLabel labelTelp = new JLabel("Input Nomor Telp: ");
	        labelTelp.setBounds(15, 80, 350, 40);  
	        
	        JTextField textTelp = new JTextField();
	        textTelp.setBounds(15, 115, 350, 30);  
			
			JLabel labelRadio = new JLabel("Jenis Kelamin:");
			labelRadio.setBounds(15, 160, 350, 10);
			
			JRadioButton radioButton1 = new JRadioButton("Laki - Laki");
			radioButton1.setBounds(15, 175, 350, 30);
			
			JRadioButton radioButton2 = new JRadioButton("Perempuan");
			radioButton2.setBounds(15, 200, 350, 30);
			
			ButtonGroup bg = new ButtonGroup();
			bg.add(radioButton1);
			bg.add(radioButton2);
			
			JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
			checkBox.setBounds(15,230,350,30);
			
			JButton button = new JButton("Simpan");
			button.setBounds(15, 260, 100, 30);
			
			JTextArea txtOutput = new JTextArea("");
			txtOutput.setBounds(15,300,350,140);
			
			checkBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					checkBoxSelected = (e.getStateChange() == ItemEvent.SELECTED) ? "Ya"  : "Bukan";
				}
			});
			
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String jenisKelamin = "";
					if(radioButton1.isSelected()) {
						jenisKelamin = radioButton1.getText();
					}
					if(radioButton2.isSelected()) {
						jenisKelamin = radioButton2.getText();
					}
						
						String nama = textField.getText();
						String telp = textTelp.getText();
						txtOutput.append("Nama 	: "+nama+"\n");
						txtOutput.append("Nomor HP 	: "+telp+"\n");
						txtOutput.append("Jenis Kelamin	: "+jenisKelamin+"\n");
						txtOutput.append("WNA	: "+checkBoxSelected+"\n");
						txtOutput.append("========================================\n");
				}
			});
			
			this.add(button);
			this.add(txtOutput);
			this.add(labelRadio);
			this.add(radioButton1);
			this.add(radioButton2);
			this.add(textField);
			this.add(labelInput);
			this.add(textTelp);
			this.add(labelTelp);
			this.add(checkBox);
			
			this.setSize(400, 500);
			this.setLayout(null);
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					HelloRadioButton2 h = new HelloRadioButton2();
					h.setVisible(true);
				}
			});
		}
	}
