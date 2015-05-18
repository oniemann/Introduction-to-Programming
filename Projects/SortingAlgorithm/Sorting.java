import java.util.*;
import java.io.*;

class Sorting {
	public static void main(String[] args) {

		//prints out  the header
		System.out.println("/****************************************/");
		System.out.println("/*         SORT A LIST OF NUMBERS!      */");
		System.out.println("/****************************************/");
		System.out.println("");

		//scans in the list size as well as the range of numbers
		System.out.printf("How big do you want your list? ");
		Scanner scan = new Scanner(System.in);
		int indices = scan.nextInt();
		System.out.printf("Largest possible number? ");
		int biggestnumber = scan.nextInt();

		//creates a list of random numbers to the specification of the input
		int[] sorted = new int[indices];
		System.out.println("");

		for (int i = 0; i < sorted.length; i++) {
			Random rng = new Random();
			int rnum = rng.nextInt(biggestnumber);
			sorted[i] = rnum;
		}

		//displays the unsorted list in all of its glory
		System.out.printf("Unsorted list:\n");
		System.out.println(Arrays.toString(sorted));
		System.out.printf("\n");

		int i = 0;

		/*uses methods "min" and "swap" to sort the randomly generated list,
		incrementing the beginning indice to test for the minimum by one until 
		"i" equals the length of the randomly generated number list*/
		while (i < sorted.length) {
			int minimum = min(i, sorted, indices);
			int swap = swap(i, minimum, sorted);
			sorted[i] = swap;
			i++;
		}

		//outputs the list in all of its sorted glory
		System.out.printf("Sorted List:\n");
		System.out.println(Arrays.toString(sorted));
		System.out.println("");

	}

	/*goes through the list beginning at indice "i", finding the lowest term
	throughout and returning its indice to main*/
	static int min(int i, int[] sorted, int indices) {

		int rmin = sorted[i];
		int y = 0;
		int j = i;

		while (j < indices) {
			if (sorted[j] <= rmin) {
				rmin = sorted[j];
				y = j;
			}

		j++;
		}
		
		return y;
	}

	/*takes the indice of the lowest value in the list and swaps it with indice
	"i". The method then returns the list, just a little more sorted than
	before.*/
	static int swap(int i, int minimum, int[] sorted) {
		int temp = sorted[minimum];
		sorted[minimum] = sorted[i];
		sorted[i] = temp;

		return sorted[i];
	}
}