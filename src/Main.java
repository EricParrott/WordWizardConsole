/*
 * This class needs to be refined further to the Main run class (Main Activity when moved to AS).
 * It is handles user input and generates output, and the user should be able to access all functionality
 * of the app via this main class file.  Ex. Return word list, sort by length, score, run timer, lookup definitions, etc.  
 * It should only make function calls when finished, there should be no stray code here.  
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {

		ReadInFile.convertFileToHashtable();	//returns a hashtable populated with all the words from dictionary.txt along with keys.
		
		System.out.println("There are " + Permutations.dictionary.size() + " entries stored in the hashtable.");
		//System.out.println("Value stored in dictionary entry with key (204): " + Permutations.dictionary.get(dictionaryArrayList.get(204).hashCode()));
		
		
		String letterBank = "aacdefg";

		
		//System.out.println(letterBank.length());
		
		System.out.println("My playable tiles: [" + letterBank+ ']');
		
		Permutations.combine(letterBank, new StringBuffer(), 0);
		
		//System.out.println("Combinations: " + Permutations.combinations.toString());
		
		for (String str: Permutations.combinations) {
			Permutations.allPermutations.addAll(Permutations.permutation(str));
		}
		
		//System.out.println("allPermutations: " + Permutations.allPermutations.toString());
		
		//check for matches in the hashtable
		for(int i=0; i<Permutations.allPermutations.size(); i++) {
			String possibleWord = Permutations.allPermutations.get(i).toUpperCase();
			int hash = possibleWord.hashCode();
			if (Permutations.dictionary.get(hash) != null) {
				Permutations.matches.add(Permutations.dictionary.get(hash));
			}
		}
		
		//filter out the duplicates in matches by converting the matches arraylist to a set
		//(as sets auto-filter out duplicates) and then convert back to arraylist.
		Set<String> s = new HashSet<String>(Permutations.matches);
		ArrayList<String> results = new ArrayList<String>(s);
		
		//filter out any results whose word length is longer than letterBank
		//or any results that contain characters NOT in letterbank.
		for (int i=0; i<results.size(); i++) {
			if (results.get(i).length() > letterBank.length()) {
				System.out.println("Will be removed from result set due to length: " + results.get(i));
				results.remove(i);
			}
		}
		
		for (int i=0; i<results.size(); i++) {
			if (Sort.containsAllChars(letterBank, results.get(i).toLowerCase()) == false) {
				System.out.println("Will be removed from result set due to char differences: " + results.get(i));
				results.remove(i);
			}
		}
		
		Sort.sortAlphabetically(results);
		//System.out.println("Matches before filtering Dupes: " + Permutations.matches);
		System.out.println("Results: " + results.toString());
		
//		String d = "DECOMMISSIONED";
//		int key = d.hashCode();
//		system.out.println(Permutations.dictionary.get(key));
		
		String dog = "dog";
		System.out.println(dog.hashCode());
	}
}
