/***************************************************************************
*Author: Okeefe Niemann
*Date: 11/11/2014
*Class: CMPS12A
*Assignment 3
*
*Description: This program calculates odds of dice game "craps" via simulatian.
****************************************************************************/

import java.util.*;
import java.io.*;

class SimCraps {
    public static void main(String[] args) throws FileNotFoundException{

        //Scans in inputted number and declares it as variable "trials"
        Scanner scan = new Scanner(args[0]);
        Dice dice = new Dice();
        int wins = 0;
        float average = 0;
        int trials = scan.nextInt();

        /*Runs the game over multiple trials, keeping a sum of the wins to later
        average*/
        for (int i = 0; i < trials; ++i) {

            //Dice values are randomly obtained via the Dice class
            dice.roll();
            int point = dice.getTotal();

            //If the dice sum is equal to seven or eleven, round is won
            if (point == 7 || point == 11){
                wins += 1;
            }

            

            /*If any other value is thrown, it becomes the "point". Rolls will
            continue until conditions are met. Rules are explained in the method
            "tryForPoint".*/
            else {
                wins = tryForPoint(dice, point, wins);
            } 
        }

        //Average is calculated by definition
        average = (float) wins / trials;
        System.out.printf("Prob of Winning = %f\n", average);
        }


    static int tryForPoint(Dice dice, int point, int wins) {
    
        /*The boolean "restart" maintains the while loop below until one of the
        following criteria is met.*/
        boolean restart = true;

            while(restart){
                dice.roll();
                int newvalue = dice.getTotal();

                //If the new roll equals the point, round is won
                if (newvalue == point){
                    wins += 1;
                    restart = false;
                }

                //If the new roll equals 7, round is lost
                else if (newvalue == 7){
                    restart  = false;
                }
            }

        return wins;
    }
}


class Dice {
    
    Dice() {
        roller = new Random();
    }

    //Rolls two dice values via the random number generator "roller".
    void roll() {
        die1 = roller.nextInt(6) + 1;
        die2 = roller.nextInt(6) + 1;
    }

    //Returns the total of the randomly generated dice values
    int getTotal() {
        return die1 + die2;
    }

    private int die1, die2, total;
    private Random roller;
}