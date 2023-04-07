/*
Author: C20389531
Date: April 2023
Purpose: Act as both the Graphic User Interface and control class
Compiler: eclipse Java-17 
*/

package topoic_modeller;

//Java imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {

	//declared variables
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel Firstdoclabel;
	private static JTextField Doc1;
	private static JLabel Seconddoclabel;
	private static JTextField Doc2;
	private static JButton button;
	private static JLabel InfoLabel;
	private static String FirstFileRead;
	private static String SecondFileRead;
	
	public static void main(String[] args) {
		
		//gui
		frame = new JFrame();
		panel = new JPanel();
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.setLayout(null);
		
		Firstdoclabel = new JLabel("First document");
		Firstdoclabel.setBounds(10,20,200,25);
		panel.add(Firstdoclabel);
		
		Doc1 = new JTextField(20);
		Doc1.setBounds(120, 20, 260, 25);
		panel.add(Doc1);
		
		Seconddoclabel = new JLabel("Second document");
		Seconddoclabel.setBounds(10,50,200,25);
		panel.add(Seconddoclabel);
		
		Doc2 = new JTextField(20);
		Doc2.setBounds(120, 50, 260, 25);
		panel.add(Doc2);
		
		button = new JButton("Submit");
		button.setBounds(10, 80, 80, 25);
		button.addActionListener(new GUI());
		panel.add(button);
		
		InfoLabel = new JLabel("The document's name needs to be entered in the formate 'C:/Users/JOSEP/OneDrive/Documents/roles.txt'. Without the '");
		InfoLabel.setBounds(10, 110, 700, 25);
		panel.add(InfoLabel);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//initialize FileProcessor class
		FileProcessor FirstFileProcessor = new FileProcessor();
		FileProcessor SecondFileProcessor = new FileProcessor();
		
		//the files names get sent to FileProcessor class to be opened
		try {
			FirstFileRead = FirstFileProcessor.readFile(Doc1.getText()); // C:/Users/JOSEP/OneDrive/Documents/roles.txt
			SecondFileRead = SecondFileProcessor.readFile(Doc2.getText());
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		//initialize FileClean class
		FileClean FirstFileCleaned = new FileClean();
		FileClean SecondFileCleaned = new FileClean();
		
		//use CompareFile function to clean files
		String FirstCompared=FirstFileCleaned.CompareFile(FirstFileRead);
		String SecondCompared=SecondFileCleaned.CompareFile(SecondFileRead);
		
		// turn results from CompareFile function back into arrays
		String [] strArray = FirstCompared.split(" ", 100);
		String [] strArray2 = SecondCompared.split(" ", 100);
		
		//remove null values from arrays
		strArray = Arrays.stream(strArray)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new); 
		strArray2 = Arrays.stream(strArray2)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);
		
		//initialize calculateWords class
		calculateWords calculatewords = new calculateWords();
		
		//use mostFrequentWord function to find most common words of the files
		String firstDocSorted = calculatewords.mostFrequentWord(strArray, strArray.length);
		String secondDocSorted = calculatewords.mostFrequentWord(strArray2, strArray2.length);
		
		//initialize FileCompare class
		FileCompare FileCompared = new FileCompare();
		
		//use ComparedFile function to see how related the files are
		FileCompared.ComparedFile(firstDocSorted, secondDocSorted);
	}

}
