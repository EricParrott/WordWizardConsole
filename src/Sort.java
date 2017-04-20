/*
 * This class will contain all the methods used when the application user 
 * wants to arrange his results by length, score, alphabetized, etc. 
 * 
 * SCRABBLE LETTER SCORE VALUES
 * a=1   e=1   i=1    m=3   q=10   u=1    y=4
 * b=3   f=4   j=8    n=1   r=1    v=4    z=10
 * c=3   g=2   k=5    o=1   s=1    w=4
 * d=2   h=4   l=1    p=3   t=1    x=8
 */
	
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Sort extends Main {

	//sorts your word choices and returns an alphabetized array
	public static void sortAlphabetically(ArrayList<String> playableWords) {
		Collections.sort(playableWords);
	}
	
	public static void sortByWordScore(ArrayList<String> playableWords) {
		Collections.sort(playableWords, new WordScoreComparator());	//see my WordScoreComparator class
	}
	
	//sorts your word choices by length and returns the new ordering in an array.
	public static void sortByWordLength(ArrayList<String> playableWords) {
		Collections.sort(playableWords, new WordLengthComparator());
	}
	
	//get score for word so as can be sorted by that score later on
	public static int getWordScore(String word) {
		//initialize word score to zero
		int score=0;
		//for length of the word
		for (int i=0; i<word.length(); i++) {
			//get each character in the word and add its point value to the score variable
			int charAt = (int)word.charAt(i);
			switch (charAt) {
				case 97:   score += 1;  break;		//if 'a' append 1 pt to word score
				case 98:   score += 3;  break;		//if 'b' append 3 pts to word score 
				case 99:   score += 3;  break;		//etc
				case 100:  score += 2;  break;
				case 101:  score += 1;  break;
				case 102:  score += 4;  break;
				case 103:  score += 2;  break;
				case 104:  score += 4;  break;
				case 105:  score += 1;  break;
				case 106:  score += 8;  break;
				case 107:  score += 5;  break;
				case 108:  score += 1;  break;
				case 109:  score += 3;  break;
				case 110:  score += 1;  break;
				case 111:  score += 1;  break;
				case 112:  score += 3;  break;
				case 113:  score += 10; break;
				case 114:  score += 1;  break;
				case 115:  score += 1;  break;
				case 116:  score += 1;  break;
				case 117:  score += 1;  break;
				case 118:  score += 4;  break;
				case 119:  score += 4;  break;				
				case 120:  score += 8;  break;				
				case 121:  score += 4;  break;
				case 122:  score += 10; break;
				default:   score = 0;   break;
			}
		}
		return score;
	}
	
//this chunk of code is used in Main to filter out any results that contain chars not in letterbank--
//the logic might be wrong because it isnt working correctly at the moment.
	public static Set<Character> stringToCharacterSet(String s) {
		Set<Character> set = new HashSet<>();
		for (char c : s.toCharArray()) {
			set.add(c);
		}
		return set;
	}
	
	public static boolean containsAllChars(String container, String containee) {
		return stringToCharacterSet(container).containsAll(stringToCharacterSet(containee));
	}
//----------------------------------------------------------------------------------------------------
	
	//unit testing class for sorting methods defined above.
	public static void main(String[] args) {
		
		ArrayList<String> sortTests = new ArrayList<String>();

		sortTests.add("quarrel");
		sortTests.add("a");
		sortTests.add("cat");
		sortTests.add("xqm");
		sortTests.add("apple");
		
		//sometimes breaks when adding words above - need to ask 
//		System.out.println("Before calling alphabetized sort method: " + sortTests);
//		sortAlphabetically(sortTests);
//		System.out.println("After calling alphabetized sort method: " + sortTests);
//		System.out.println();
		
		//breaks when you add single char words to list
//		System.out.println("Before calling byLength sort method: " + sortTests);
//		sortByWordLength(sortTests);
//		System.out.print("After calling byLength sort method: " + sortTests);
//		System.out.println();
		
//		System.out.println();
//		System.out.println("Before calling byScore method" + sortTests);
//		sortByWordScore(sortTests);				//uses WordScoreComparator class to sortByScore
//		System.out.println("After calling byScore method" + sortTests);
//		System.out.println();
		
		System.out.println();
		System.out.println("points for 'kor': " + getWordScore("kor"));
		System.out.println("points for 'pro': " + getWordScore("pro"));
		System.out.println("points for 'quarrel': " + getWordScore("quarrel"));
		System.out.println("points for 'xqm': " + getWordScore("xqm"));
		System.out.println("points for 'apple': " + getWordScore("apple"));

		System.out.println();
		
		String s = "bcdefmr";
		System.out.println("should be true: " + s.matches("[a-zA-Z]*"));
		
		String t = "faced";
		System.out.println(containsAllChars(s,t));
		
		System.out.println("Matches Testing");
		
		String Str = new String("Welcome to Tutorialspoint.com");

		System.out.print("Return Value :" );
		System.out.println(Str.matches("(.*)Tutorials(.*)"));
		
		System.out.print("Return Value :" );
		System.out.println(Str.matches("Tutorials"));
		
		System.out.print("Return Value :" );
		System.out.println(Str.matches("Welcome(.*)"));

		
	
	}

}
