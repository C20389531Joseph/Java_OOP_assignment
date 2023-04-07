/*
Author: C20389531
Date: April 2023
Purpose: removes stop words using "https://gist.github.com/sebleier/554280" list
Compiler: eclipse Java-17 
*/

package topoic_modeller;

import java.util.Arrays;

public class FileClean extends FileProcessor {
	// Array of the stop words
	static String[] StopWords = {"i",
			"me", "my", "myself", "we", "our", "ours", "ourselves", "you", "your", "yours", "yourself", "yourselves", "he", "him", "his", "himself", "she", "her", "hers", 
			"herself", "it", "its", "itself", "they", "them", "their", "theirs", "themselves","what", "which", "who", "whom", "this", "that", "these", "those", "am", "is",
			"are", "was", "were", "be", "been", "being", "have", "has", "had", "having", "do", "does", "did", "doing", "a", "an", "the", "and", "but", "if", "or", "because",
			"as", "until", "while", "of", "at", "by", "for", "with", "about", "against", "between", "into", "through", "during", "before", "after", "above", "below",
			"to", "from", "up", "down", "in", "out", "on", "off", "over", "under", "again", "further", "then", "once", "here", "there", "when", "where", "why",
			"how", "all", "any", "both", "each", "few", "more", "most", "other", "some", "such", "no", "nor", "not", "only", "own", "same", "so", "than", "too",
			"very", "s", "t", "can", "just", "will", "don", "should", "now"};
	
	public String CompareFile(String str) {
		
		//turns the string input into an array
		String [] ImportDocArray = str.split(" ", 100);
		String [] ExportDocArray = new String [ImportDocArray.length];
		
		int j = 0;
		
		// for loop to copy all words that are not in the StopWords array. The logic is that it loops through the strArray array and if the word is not in the StopWords array it
		// goes into the strArray array.
		for (int i = 0; i < ImportDocArray.length; i++) {
			
			 if(Arrays.stream(StopWords).anyMatch(ImportDocArray[i]::equals)==false) {
				 ExportDocArray[j]=ImportDocArray[i];
				 j++;
			 }
		}
		
		// remove null values
		ExportDocArray = Arrays.stream(ExportDocArray).filter(s -> (s != null && s.length() > 0)).toArray(String[]::new); 
		
		// turns the array into a string to be more easily moved
		String CleanedString = "";
		for (int i = 0; i < ExportDocArray.length; i++) {
			CleanedString += ExportDocArray[i] + " ";
		}
		
		return CleanedString;
		
	}
}
