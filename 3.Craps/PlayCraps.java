/***************************************************************************
*Author: Okeefe Niemann
*Date: 11/11/2014
*Class: CMPS12A
*Assignment 3
*
*Description: This program is an interactive simulation of the dice game "craps"
****************************************************************************/

import java.util.*;
import java.io.*;

class PlayCraps {
    public static void main(String[] args) {

        /*User is asked questions to initialize the random number generator and 
        initial conditions of the game.*/
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Seed");
        Dice dice = new Dice(scan.nextInt());
        System.out.println("");
        System.out.println("How many chips to start?");
        int chips = scan.nextInt();
        System.out.println("");

        //Below while loop restarts the game until the player runs out of chips
        while(chips > 0) {
            System.out.printf("This is your first throw of the round" +
                " (press enter)\n");
            Scanner scans = new Scanner(System.in);
            scans.nextLine();

            //Player is prompted to place a bet on the game
            System.out.println("Place a bet");
            int bet = scan.nextInt();

            /*Makes the user submit their bet again if it's higher than the
            chips they have*/       
            while (bet > chips) {
                System.out.println("Not enough chips, try again.");
                bet = scan.nextInt();
            }

            //Dice values are randomly obtained and displayed via the dice class
            dice.roll();
            dice.showDie();
            int point = dice.getTotal();

            System.out.println("");

            /*If the dice sum is equal to seven or eleven, player wins the round
            and is awarded the bet's worth of chips*/
            if (point == 7 || point == 11){

                chips += bet;
                
                System.out.printf("total = %d, You win!\n", point);
                System.out.printf("Remaining chips: %d\n\n", chips);
            }

            /*If the dice sum is equal to 2, 3, or 12, player loses the round
            and loses the bet's worth of chips*/
            else if (point == 2 || point == 3 || point == 12){

                chips -= bet;
                
                /*If player has greater than 0 chips, the game is restarted. If
                not, game over.*/
                if (chips > 0){
                    System.out.printf("total = %d, You lose...\n", point);
                    System.out.printf("Remaining chips: %d\n\n", chips);
                }
                else {
                    System.out.println("GAME OVER");
                    System.out.println("");
                }
            }

            /*If any other value is thrown, it becomes the "point". The player 
            must continue rolling until conditions are met. Rules are explained 
            in the method "tryForPoint".*/
            else {
                System.out.printf("Current point is %d\n", point);
                System.out.println("Try for point.");
                scans.nextLine();
                System.out.println("");

                chips = tryForPoint(dice, chips, bet, point, scans);
            }       
        }
    }   

    static int tryForPoint(Dice dice, int chips, int bet, int point, Scanner 
        scans) {
    
        /*The boolean "restart" maintains the while loop below until one of the
        following criteria is met.*/
        boolean restart = true;

            while(restart){
                //restart = true;
                dice.roll();
                dice.showDie();
                int newvalue = dice.getTotal();

                //If the new roll equals the point, player wins round/chips
                if (newvalue == point){
                    System.out.printf("total = %d, You win!\n", newvalue);
                    chips += bet;
                    System.out.printf("Remaining chips: %d\n\n", chips);
                    restart = false;
                }

                //If the new roll equals 7, player loses round/chips
                else if (newvalue == 7){
                    System.out.printf("total = %d, You lose...\n\n", newvalue);
                    chips -= bet;

                    //If the chips are greater than 0 after loss, restarts game
                    if(chips > 0) {
                        System.out.printf("Remaining chips: %d\n\n", chips);
                    }

                    //Less than zero, game over
                    else {
                        System.out.println("GAME OVER");
                        System.out.println("");
                    }

                    restart  = false;
                }
                else {
                    System.out.printf("total = %d, roll again!\n\n", newvalue);
                    scans.nextLine();
                }
            }

        return chips;
    }
}


class Dice {
    
    Dice(int seed) {
        roller = new Random(seed);
    }

    /*Rolls two dice values via the random number generator "roller". The seed
    is submitted by the player*/
    void roll() {
        die1 = roller.nextInt(6) + 1;
        die2 = roller.nextInt(6) + 1;
    }

    //Returns the total of the randomly generated dice values
    int getTotal() {
        System.out.printf("Roll is %d, %d\n", die1, die2);
        return die1 + die2;
    }

    //Provides a visual aid with the roll obtained
    void showDie() {
    
        total = (10 * die1) + die2;
        
        switch(total) {
            case 11:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|       |  |       |");
                System.out.println("|   *   |  |   *   |");
                System.out.println("|       |  |       |");
                System.out.println("|_______|  |_______|");
                break;
            case 12:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|       |  |   *   |");
                System.out.println("|   *   |  |       |");
                System.out.println("|       |  |   *   |");
                System.out.println("|_______|  |_______|");
                break;
            case 13:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|       |  |   *   |");
                System.out.println("|   *   |  |   *   |");
                System.out.println("|       |  |   *   |");
                System.out.println("|_______|  |_______|");
                break;
            case 14:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|       |  |  * *  |");
                System.out.println("|   *   |  |       |");
                System.out.println("|       |  |  * *  |");
                System.out.println("|_______|  |_______|");
                break;
            case 15:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|       |  |  * *  |");
                System.out.println("|   *   |  |   *   |");
                System.out.println("|       |  |  * *  |");
                System.out.println("|_______|  |_______|");
                break;                      
            case 16: 
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|       |  |  * *  |");
                System.out.println("|   *   |  |  * *  |");
                System.out.println("|       |  |  * *  |");
                System.out.println("|_______|  |_______|");
                break;
            case 21:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|   *   |  |       |");
                System.out.println("|       |  |   *   |");
                System.out.println("|   *   |  |       |");
                System.out.println("|_______|  |_______|");
                break;
            case 22: 
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|   *   |  |   *   |");
                System.out.println("|       |  |       |");
                System.out.println("|   *   |  |   *   |");
                System.out.println("|_______|  |_______|");
                break;
            case 23:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|   *   |  |   *   |");
                System.out.println("|       |  |   *   |");
                System.out.println("|   *   |  |   *   |");
                System.out.println("|_______|  |_______|");
                break;
            case 24:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|   *   |  |  * *  |");
                System.out.println("|       |  |       |");
                System.out.println("|   *   |  |  * *  |");
                System.out.println("|_______|  |_______|");
                break;
            case 25:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|   *   |  |  * *  |");
                System.out.println("|       |  |   *   |");
                System.out.println("|   *   |  |  * *  |");
                System.out.println("|_______|  |_______|");
                break;
            case 26:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|   *   |  |  * *  |");
                System.out.println("|   *   |  |  * *  |");
                System.out.println("|   *   |  |  * *  |");
                System.out.println("|_______|  |_______|");
                break;
            case 31:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|   *   |  |       |");
                System.out.println("|   *   |  |   *   |");
                System.out.println("|   *   |  |       |");
                System.out.println("|_______|  |_______|");
                break;
            case 32:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|   *   |  |   *   |");
                System.out.println("|   *   |  |       |");
                System.out.println("|   *   |  |   *   |");
                System.out.println("|_______|  |_______|");
                break;
            case 33:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|   *   |  |   *   |");
                System.out.println("|   *   |  |   *   |");
                System.out.println("|   *   |  |   *   |");
                System.out.println("|_______|  |_______|");
                break;
            case 34:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|   *   |  |  * *  |");
                System.out.println("|   *   |  |       |");
                System.out.println("|   *   |  |  * *  |");
                System.out.println("|_______|  |_______|");
                break;
            case 35:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|   *   |  |  * *  |");
                System.out.println("|   *   |  |   *   |");
                System.out.println("|   *   |  |  * *  |");
                System.out.println("|_______|  |_______|");
                break;
            case 36:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|   *   |  |  * *  |");
                System.out.println("|   *   |  |  * *  |");
                System.out.println("|   *   |  |  * *  |");
                System.out.println("|_______|  |_______|");
                break;
            case 41:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |       |");
                System.out.println("|       |  |   *   |");
                System.out.println("|  * *  |  |       |");
                System.out.println("|_______|  |_______|");
                break;      
            case 42:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |   *   |");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |   *   |");
                System.out.println("|_______|  |_______|");
                break;
            case 43:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |   *   |");
                System.out.println("|       |  |   *   |");
                System.out.println("|  * *  |  |   *   |");
                System.out.println("|_______|  |_______|");
                break;              
            case 44:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|_______|  |_______|");
                break;      
            case 45:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|       |  |   *   |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|_______|  |_______|");
                break;  
            case 46:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|       |  |  * *  |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|_______|  |_______|");
                break;  
            case 51:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |       |");
                System.out.println("|   *   |  |   *   |");
                System.out.println("|  * *  |  |       |");
                System.out.println("|_______|  |_______|");
                break;
            case 52:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |   *   |");
                System.out.println("|   *   |  |       |");
                System.out.println("|  * *  |  |   *   |");
                System.out.println("|_______|  |_______|");
                break;
            case 53:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |   *   |");
                System.out.println("|   *   |  |   *   |");
                System.out.println("|  * *  |  |   *   |");
                System.out.println("|_______|  |_______|");
                break;
            case 54:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|   *   |  |       |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|_______|  |_______|");
                break;
            case 55:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|   *   |  |   *   |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|_______|  |_______|");
                break;
            case 56:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|   *   |  |  * *  |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|_______|  |_______|");
                break;
            case 61:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |       |");
                System.out.println("|  * *  |  |   *   |");
                System.out.println("|  * *  |  |       |");
                System.out.println("|_______|  |_______|");
                break;
            case 62:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |   *   |");
                System.out.println("|  * *  |  |       |");
                System.out.println("|  * *  |  |   *   |");
                System.out.println("|_______|  |_______|");
                break;
            case 63:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |   *   |");
                System.out.println("|  * *  |  |   *   |");
                System.out.println("|  * *  |  |   *   |");
                System.out.println("|_______|  |_______|");
                break;
            case 64:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|  * *  |  |       |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|_______|  |_______|");
                break;
            case 65:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|  * *  |  |   *   |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|_______|  |_______|");
                break;
            case 66:
                System.out.println(" _______    _______");
                System.out.println("|       |  |       |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|  * *  |  |  * *  |");
                System.out.println("|_______|  |_______|");
                break;
        }
    }

    private int die1, die2, total;
    private Random roller;
}