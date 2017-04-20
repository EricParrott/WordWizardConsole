/*
 * This class defines my custom comparator used when sorting the results ArrayList by word length.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WordLengthComparator extends Sort implements Comparator<String> {
	
	//this method is used in the string comparator - it returns 1 when string1 length > string2 length, 
	//0 when string1 length == string2 length, -1 when string1 length < string2 length.  Collections.sort() calls 
	//this compare method to sort the arraylist by length when initialized with instance of class.
	public int compare(String str1, String str2) {
		
		int length1 = str1.length();		
		int length2 = str2.length();		
		
		if (length1 > length2) {
			return 1;
		}
		
		else if (length1 == length2) {
			return 0;
		}
		
		else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> testList = new ArrayList<String>();
		
		testList.add("abcdefg");
		testList.add("abcdef");
		testList.add("abc");
		testList.add("abcd");
		testList.add("ab");
		testList.add("abce");
		testList.add("a");
		
		System.out.println("Before Sort: " + testList);
		System.out.println();
		Collections.sort(testList, new WordLengthComparator());
		System.out.println("After Sort: " + testList);

	}
}
