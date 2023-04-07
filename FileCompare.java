/*
Author: C20389531
Date: April 2023
Purpose: Compares the files using the standards from the document 'Assignment OO Programming Sem 2 2023 Java'. Assumption that the example sets the grading system "(e.g. 70% overlap in the top ten words = 70% likely to be about
the same topic or whatever way you decide to do this). Likewise, documents with small
overlap on most comment words (e.g. < 40%) are definitely different topics".
Compiler: eclipse Java-17 
*/

package topoic_modeller;

import java.util.Arrays;

public class FileCompare {
	
	public void ComparedFile(String a, String b) {
		// variable to keep tract of repeated words in both arrays
		int matches = 0;
		
		// turns the string inputs into arrays
		String [] Firstfile = a.split(" ", 10);
		String [] Secondfile = b.split(" ", 10);
		
		for (int i = 0; i < 10; i++) {
			
			// counts the number of words the repeat in the arrays 
			if(Arrays.stream(Firstfile).anyMatch(Secondfile[i]::equals)==true) {
				 matches++;
				 }
			 }
		// output to user of how many matches
		if(matches<=4) {
			System.out.println("There are "+matches+" matches between these files. These files are not related");
			}
		if(matches>=7) {
			System.out.println("There are "+matches+" matches between these files. These files are likey related");
			}
		if(matches>4 && matches<7) {
			System.out.println("There are "+matches+" matches between these files. These files are possibly related");
			}
		}
}
