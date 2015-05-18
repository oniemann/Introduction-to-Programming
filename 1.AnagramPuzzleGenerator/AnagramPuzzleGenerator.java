import java.util.*;
import java.io.*;

class Anagram {
	public static void main(String[] args) throws FileNotFoundException {
		//scans in the text file and stores the data into array "wordbank"
		Scanner in = new Scanner(new FileInputStream(args[0]));
		
		int size = in.nextInt();
		int i = 0;
		String[] wordbank = new String[size];

		while ( i < size) {
			wordbank[i] = in.next();
			i++;
		}
		
		//randomly selects a state from the list
		Random rng = new Random();
		int rnum = rng.nextInt(wordbank.length);
		String state = wordbank[rnum];
				
		/*creates two strings for original word and jumbled word,
		of which can be manipulated*/
		StringBuffer original = new StringBuffer(State) ; //answer
		StringBuffer jumbled = new StringBuffer("");	  //anagram

		/*randomly selects indices from original word, removes them,
		then appends them to new string representing the anagram*/
		for ( i = 0; i < state.length(); i++) {
			Random rng1 = new Random();
			int rnum1 = rng1.nextInt(original.length()); //selects random indice from answer
			char letter = original.charAt(rnum1);
			jumbled.append(letter);           //appends letter to anagram
			original.deleteCharAt(rnum1);     //deletes letter from answer
		}
		
		System.out.println("Guess the word!");
		System.out.printf("Anagram: %s \n\n", jumbled);

		/*player is given three attempts to guess the anagram, receiving a
		"game over" and the correct answer if unable to guess correctly*/
		i = 0;  //reinitializes i for next while loop

		while (i < 3) {
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();

			if (input.equals(state)) {
				System.out.println("You did it!");
				break;
				}
			else {
				if (2 - i > 0) {
				System.out.printf("Remaining Attempts: %d", 2-i);
				System.out.println("");
				}
				else {
					System.out.print("\nGame Over\n");
					System.out.println("Answer: " + state);
				}
			}
			
			i++;
		}
}


} 
