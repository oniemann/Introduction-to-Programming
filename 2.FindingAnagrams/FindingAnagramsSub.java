/***************************************************************************
*Author: Okeefe Niemann
*Date: 10/24/2014
*Class: CMPS12A
*Assignment 2
*
*Description: This program asks a user to input a word, then refers to an
                imported dictionary to find all possible anagrams.
****************************************************************************/


import java.util.*;
import java.io.*;
                                                                                  
class FindingAnagrams {
    public static void  main(String[] args) throws FileNotFoundException {
        /*Following lines to the while statement fills array "wordbank" with all
        the words from the dictionary*/
        Scanner in = new Scanner(new FileInputStream(args[0]));
        int size = in.nextInt();
        int i = 0;
        String[] wordbank = new String[size];

        while ( i < size) {
            wordbank[i] = in.next();
            i++;
        }

        /*array prime contains 26 indices corresponding to each letter of the 
        alphabet. The most frequent letters used in the English language are
        given the lowest prime values.*/
        int[] prime = {5, 71, 37, 29, 2, 53, 59, 19, 11, 83, 79, 31, 43, 13, 7, 
        67, 101, 23, 17, 3, 41, 73, 47, 97, 61, 103};

        /*Boolean and first while loop creates an option where the user may opt 
        to find anagrams of another word.*/ 
        boolean go = true;

        while (go) {
        /*The user is prompted to type a word, which is then scanned into the
        program*/
            System.out.println("Enter a word and get the anagrams!");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();

            double inputproduct = 1;
            char x;
            int number, j = 0;

        /*The word the user submits to the program is then assigned a value.
        This unique value is the product of prime numbers of which the word's 
        letters have been assigned above. Proof of uniqueness is referred to
        as "the fundamental theorem of arithmetic."*/
            while (j < input.length()) {
                x = input.charAt(j);
                /*"number" takes the ASCII number representative of selected 
                letter and scales it down to the appropriate indice in array 
                "prime"*/
                number = prime[((int) x - 'a')];
                inputproduct *= number;
                j++;
            }

            j = 0;
            int k = 0;
            double dictproduct;
            char y;
            String test;

            System.out.println("");

        /*Because the inputted word's corresponding value is unique, only
        anagrams of said word will have the same value. Using the same method
        as with the inputted word, the program loops through the whole imported
        word list, assigning each a value in the same method as above. If the
        program finds a value which is equal to that representing the inputted
        word, it prints the word. This loop also omits the inputted word.*/
            while (j < wordbank.length) {
                k = 0;
                dictproduct = 1;
                test = wordbank[j];

                while(k < test.length()){
                    y = test.charAt(k);
                    /*"number" takes the ASCII number representative of selected 
                    letter and scales it down to the appropriate indice in array 
                    "prime"*/
                    number = prime[((int) y - 'a')];
                    dictproduct *= number;
                    k++;
                }

                if ((dictproduct == inputproduct) && !test.equals(input))
                    System.out.printf("%s\n", test);

                j++;
            }

            System.out.println("");
        /*The user is asked if they want to try another word. While loop repeats
        this inquiry until the user accurately types "yes" or "no". The former
        loops back to the beginning of the program, while the latter terminates
        the program.*/
            boolean correct = true;

            while (correct) {
                System.out.println("Check another word? (yes/no)");
                Scanner scans = new Scanner(System.in);
                String inputs = scans.nextLine();

                if (inputs.charAt(0) == 'y'){
                    correct = false;
                    go = true;
                }
                else if (inputs.charAt(0) == 'n'){
                    correct = false;
                    go = false;
                }
                else {
                    System.out.println("");
                    System.out.println("Invalid response; try again");
                    correct = true;
                }

            System.out.println("");
            }
        }
    }
}   