package topoic_modeller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI2 implements ActionListener {

	private static JFrame frame;
	private static JPanel panel;
	private static JLabel Fdoclabel;
	private static JTextField Doc1;
	private static JLabel Sdoclabel;
	private static JTextField Doc2;
	private static JButton button;
	private static JLabel success;
	private static String docs;
	
	public static void main(String[] args) {
		/*
		FileProcessor fp = new FileProcessor();
		String koj = "C:/Users/JOSEP/OneDrive/Documents/roles.txt";
		try {
			docs = fp.readFile(koj); //"C:/Users/JOSEP/OneDrive/Documents/roles.txt"  "C:\Users\JOSEP\OneDrive\Documents\roles.txt"
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(docs); 
		*/
		frame = new JFrame();
		panel = new JPanel();
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.setLayout(null);
		
		Fdoclabel = new JLabel("First document");
		Fdoclabel.setBounds(10,20,200,25);
		panel.add(Fdoclabel);
		
		Doc1 = new JTextField(20);
		Doc1.setBounds(120, 20, 165, 25);
		panel.add(Doc1);
		
		Sdoclabel = new JLabel("Second document");
		Sdoclabel.setBounds(10,50,200,25);
		panel.add(Sdoclabel);
		
		Doc2 = new JTextField(20);
		Doc2.setBounds(120, 50, 165, 25);
		panel.add(Doc2);
		
		button = new JButton("Submit");
		button.setBounds(10, 80, 80, 25);
		button.addActionListener(new GUI2());
		panel.add(button);
		
		success = new JLabel("");
		success.setBounds(10, 110, 300, 25);
		panel.add(success);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String file = Doc1.getText();
		String file2 = Doc2.getText();
		System.out.println(file+ " " +file2);
		
		FileProcessor fp2 = new FileProcessor();
		String koj = "C:/Users/JOSEP/OneDrive/Documents/roles.txt";
		try {
			docs = fp2.readFile(Doc1.getText()); //"C:/Users/JOSEP/OneDrive/Documents/roles.txt"  "C:\Users\JOSEP\OneDrive\Documents\roles.txt"
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println(docs);
	}

}
