/*
 * This class defines my custom comparator used when sorting the results ArrayList according to each entry's word score.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WordScoreComparator extends Sort implements Comparator<String> {

	//this method is used in the string comparator - it returns 1 when string1 > string2, 
	//0 when string1 == string2, -1 when string1 < string2.  Collections.sort() calls 
	//compare to sort the arraylist by wordscore.
	public int compare(String str1, String str2) {
		
		int score1 = getWordScore(str1);		
		int score2 = getWordScore(str2);		
		
		if (score1 > score2) {
			return 1;
		}
		
		else if (score1 == score2) {
			return 0;
		}
		
		else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> testList = new ArrayList<String>();
		
		testList.add("hashtable");
		testList.add("map");
		testList.add("array");
		testList.add("queue");
		testList.add("stack");
		testList.add("linkedlist");
		testList.add("tree");
		
		System.out.println("Before Sort: " + testList);
		System.out.println();
		System.out.println("hashtable " + getWordScore("hashtable"));
		System.out.println("map " + getWordScore("map"));
		System.out.println("array " + getWordScore("array"));
		System.out.println("queue " + getWordScore("queue"));
		System.out.println("stack " + getWordScore("stack"));
		System.out.println("tree " + getWordScore("tree"));
		System.out.println("linkedlist " + getWordScore("linkedlist"));
		System.out.println();
		
		Collections.sort(testList, new WordScoreComparator());
		System.out.println("After Sort: " + testList);

	}
}
