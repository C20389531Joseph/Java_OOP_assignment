/*
Author: C20389531
Date: April 2023
Purpose: Turns the file locations from 
Compiler: eclipse Java-17 
*/

package topoic_modeller;

//imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileProcessor {
	
	//declare variable
	String textfile;
	
	public String readFile(String filelocation) throws FileNotFoundException
	{
		//open file
		File fileopen = new File(filelocation);
		
		//use scanner to read file
		Scanner myScanner = new Scanner(fileopen);
		while (myScanner.hasNextLine())
		{
			textfile += myScanner.nextLine();
			textfile += " ";
		}
		myScanner.close();
		
		// remove the null at the start of textfile
		String openedFile = textfile.substring(4);
		
		return openedFile;
	}
}
