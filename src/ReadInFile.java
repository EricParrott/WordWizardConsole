/*
 * This class has only one purpose.  It is the routine Main.java calls to read in the dictionary
 * text file and adds each of the file's lines into a hashtable of <key,pair> values. 
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class ReadInFile extends Main {

		public static Hashtable<Integer, String> convertFileToHashtable() throws IOException {
			
			//create the bufferedReader
			int bufferSize = 8 * 1024;
			String filePath = "C:\\Users\\Eric\\Documents\\Software Development\\workspace\\ConsoleScrabbleApplication\\res\\dictionary2.txt";
			BufferedReader br = new BufferedReader(new FileReader(filePath), bufferSize);

			// create arrayList of words from read-in dictionary
			ArrayList<String> dictionaryArrayList = new ArrayList<String>();
			
			// loop dictionary
			String currentLine = br.readLine();
			while (currentLine != null) {
				
				//filter out words with length longer than 15, not useful in scrabble.
				if (currentLine.length() <= 10) {												
					// add word to arrayList													
					dictionaryArrayList.add(currentLine);										
				}

				// read the next line
				currentLine = br.readLine();
			}
			
			//close reader
			br.close();			
			//fill hashtable using indexes from dictionaryArrayList
			for (int i=0; i<dictionaryArrayList.size(); i++) {
				Permutations.dictionary.put(dictionaryArrayList.get(i).hashCode(), dictionaryArrayList.get(i));
			}
			
			return Permutations.dictionary;
		}
		
}
