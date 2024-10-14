package Tugas;

import javax.swing.*;
import java.awt.event.*;

public class WindowListenerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("WindowListener Example");
		
		JLabel label = new JLabel("Lakukan Operasi Pada Jendela");
		label.setBounds(50, 50, 300, 30);
		
		frame.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) {
				label.setText("window opened");
			}
			
			public void windowClosing(WindowEvent e) {
				label.setText("window Closing");
			}
			
			public void windowClosed(WindowEvent e) {
				System.out.println("Window Closed");
			}
			
			public void windowIconified(WindowEvent e) {
				label.setText("Window Minimized");
				
			}
			public void windowDeiconified(WindowEvent e) {
				label.setText("Window Restored.");
			
			}
			public void windowActivated(WindowEvent e) {
				label.setText("Window Activated");
			
			}
			public void windowDeactivated(WindowEvent e) {
				label.setText("Window Deactivated");
			
			}
		});
		
		frame.add(label);
		
		frame.setSize(400, 200);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
