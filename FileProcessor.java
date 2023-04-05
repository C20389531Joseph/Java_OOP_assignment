package topoic_modeller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileProcessor {
	
	String textfile;
	
	public String readFile(String filelocation) throws FileNotFoundException
	{
	File role = new File(filelocation);
	Scanner myScanner = new Scanner(role);
	while (myScanner.hasNextLine())
	{
		textfile += myScanner.nextLine();
		textfile += " ";
	}
	myScanner.close();
	String strNew = textfile.substring(4);
	return strNew;
	} // readFile
}
