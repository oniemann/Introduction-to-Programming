import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.*;
import java.io.*;

class Anagram{

	public static void main(String[] args){
		/*
		File file = new File("list.txt");
		Scanner in = new Scanner(file);
		int size = in.nextInt();
		
		int i = 0;
		String[] wordlist = new String[size];
		while(i < size){
			wordlist[i] = in.next();
			System.out.println(wordlist[i]);
			}
		*/
		String testword = "Test";
		
		String answer[] = testword.split("");

		for (int i = 1; i <= testword.length(); i++) {
			System.out.println(i);
			System.out.println(answer[i]);
			}
		
		List<String> jumbled = new ArrayList<String>();
		
		for (int i = 1; i <= testword.length(); i++){
			Random rng = new Random();
			int rnum = rng.nextInt(testword.length());
			System.out.println(answer[rnum+1]);
			
			for (int j = 0; j <= jumbled.size(); j++){ 
				if (jumbled.get(j) == answer[rnum+1])		
					continue;   					
                                else
					jumbled.add(answer[rnum+1]);
			}
		}

		String anagram = "";

		for (int i = 1; i <= testword.length(); i++){
			anagram = anagram.concat(jumbled.get(i));
		}

		//System.out.println(anagram);

		}
}
