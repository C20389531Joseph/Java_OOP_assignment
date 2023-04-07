/*
Author: C20389531
Date: April 2023
Purpose: finds the 10 most frequent words in the files
Compiler: eclipse Java-17 
*/

package topoic_modeller;

import java.util.ArrayList;
import java.util.Arrays;

public class calculateWords {

	public String mostFrequentWord(String arr[], int n)
	  {
		// make new array to contain the frequent words
		String [] FrequentWordsArray = new String [10];
		
		// loops through the array to find the most common word every loop
		for (int loop=0; loop<10; loop++) {
			
			// variables to keep track of frequency of words and most frequent word
			int freq = 0;
			String MostFrequent = "";
	 
			// loops through every element to see how many matches it has.
			for (int i = 0; i < n; i++) {
				int matches = 0;
			
				// turns array into array list to use contains function
				ArrayList<String> FrequentWordsList = new ArrayList<>(Arrays.asList(FrequentWordsArray));
			
				// compares the element with every other element
				for (int j = 0; j < n; j++) {
					if (arr[j].equals(arr[i])) {
						// if the word is already chosen as a most frequent it skips the increment
						if(FrequentWordsList.contains(arr[j])) {
							continue;
						}
						// tally matches
						matches++;
					}
				}
				// keeps tract of the current most frequent word
				if (matches >= freq) {
					MostFrequent = arr[i];
					freq = matches;
				}
			}
			//adds the most frequent word of each loop into the record keeping array
			FrequentWordsArray[loop]=MostFrequent;
		}
		// cleans array of null values
		FrequentWordsArray = Arrays.stream(FrequentWordsArray).filter(s -> (s != null && s.length() > 0)).toArray(String[]::new); 
		
		// turns array into string for maneuverability purposes
		String CleanedString = "";
		
		for (int i = 0; i < FrequentWordsArray.length; i++) {
			CleanedString += FrequentWordsArray[i] + " ";
			}
		
		return CleanedString;
	}
}
