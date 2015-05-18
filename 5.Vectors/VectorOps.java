/***************************************************************************
*Author: Okeefe Niemann
*Date: 12/7/2014
*Class: CMPS12A
*Assignment 5
*
*Description: This program implements the concept of vectors and its important 
              operations.
****************************************************************************/

import java.util.*;
import java.io.*;

class VectorOps {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean repeat = true;

        //prints options of the program
        initialize();
    
        /*repeats the program until the user decides they don't want to use it
        anymore*/
        while(repeat) {
            System.out.printf("\nEnter your choice...\n");
            int choice = scan.nextInt();
            operations(choice);

            System.out.printf("\nDo you want to continue? (y/n)\n");
            String goagain = scan.next();

            if(goagain.charAt(0) == 'y')
                continue;
            else if(goagain.charAt(0) == 'n')
                repeat = false;
        }
    }

    //contains all the vector operations that is given in the initialize() list
    static void operations(int choice){
        Vector v1, v2;

        //switch statement determines what operation the user chose
        switch(choice) {
            //adds inputted vectors
            case 1: 
                System.out.println("Enter the first vector:");
                v1 = new Vector();
                System.out.println("Enter the second vector:");
                v2 = new Vector();
                v1.addVectors(v2);
                break;
            //subtracts second inputted vector from the first
            case 2:
                System.out.println("Enter the first vector:");
                v1 = new Vector();
                System.out.println("Enter the second vector:");
                v2 = new Vector();
                v1.subtractVectors(v2);
                break;
            //finds the magnitude of the inputted vector
            case 3:
                System.out.println("Enter the vector:");
                v1 = new Vector();
                System.out.printf("magnitude: %.3f\n", v1.magnitude());
                break;
            //finds the product of an inputted vector with inputted scalar
            case 4:
                System.out.println("Enter the vector:");
                v1 = new Vector();
                v1.scalarProduct();
                break;
            //finds the dot product of two inputted vectors
            case 5:
                System.out.println("Enter the first vector:");
                v1 = new Vector();
                System.out.println("Enter the second vector:");
                v2 = new Vector();
                System.out.printf("Dot Product: %.3f\n", v1.dotProduct(v2));
                break;
            //finds the angle between the two inputted vectors
            case 6:
                System.out.println("Enter the first vector:");
                v1 = new Vector();
                System.out.println("Enter the second vector:");
                v2 = new Vector();
                v1.angle(v2);
                break;
        }
    }

    //prints the choices of vector operations from which the user chooses.
    static void initialize() {
        System.out.println("What would you like to find?");
        System.out.println("1. Sum of two vectors");
        System.out.println("2. Difference of two vectors");
        System.out.println("3. Magnitude of a vector");
        System.out.println("4. Scalar product of a vector");
        System.out.println("5. Dot product of two vectors");
        System.out.println("6. Angle between two vectors");
    }
}

//contains all the properties of an object vector
class Vector {

    float vx, vy;
    double mag;

    //initializes the object, asking for the x and y component of it
    Vector() {
        Scanner scans = new Scanner(System.in);
        float vx = scans.nextFloat();
        float vy = scans.nextFloat();
        this.vx = vx;
        this.vy = vy;
    }

    //adds the vectors together, printing the sum once computed
    void addVectors(Vector vector) {
        float sumx = vx + vector.vx;
        float sumy = vy + vector.vy;
        System.out.printf("\nSum: (%.2f, %.2f)\n", sumx, sumy);
    }

    //subtracts one vector from the other
    void subtractVectors(Vector vector){
        float difx = vx - vector.vx;
        float dify = vy - vector.vy;
        System.out.printf("\nDifference: (%.2f, %.2f)\n", difx, dify);
    }

    //returns the magnitude of a vector
    //i.e. |v| = (vx^2 + vy^2)^.5
    double magnitude() {
        double mag = Math.sqrt(vx*vx + vy*vy);
        return mag;
    }

    /*takes a vector, then multiplies it by the inputted scalar asked for at the 
    beginning of the instance method*/
    void scalarProduct() {
        System.out.println("Enter scalar multiple:");
        Scanner scanner = new Scanner(System.in);
        float constant = scanner.nextFloat();
        float scalarx = constant * vx;
        float scalary = constant * vy;
        System.out.printf("\nScalar Product: (%.2f, %.2f)\n", scalarx, scalary);
    }    

    //finds the dot product
    //i.e. A • B = A_x * B_x + A_y * B_y
    float dotProduct(Vector vector) {
        float dotx = vx * vector.vx;
        float doty = vy * vector.vy;
        float dot = dotx + doty;
        return dot;
    }

    //calculates the angle between two vectors
    //i.e. θ = arccos(A•B / |A||B|)
    void angle(Vector vector) {
        double maga = this.magnitude();
        double magb = vector.magnitude();
        double mag = maga * magb;
        double dot = this.dotProduct(vector);

        double angle = Math.acos(dot/mag);
        System.out.printf("\nAngle: %.3f\n", angle);
    }
}