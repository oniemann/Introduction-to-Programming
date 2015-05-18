import java.util.*;
import java.io.*;

class test {
    public static void main(String[] args) {
            int[][][] lines = {
    {{0,0,0},{0,0,1},{0,0,2},{0,0,3}},  //lev 0; row 0   rows in each lev
    {{0,1,0},{0,1,1},{0,1,2},{0,1,3}},  //       row 1     
    {{0,2,0},{0,2,1},{0,2,2},{0,2,3}},  //       row 2     
    {{0,3,0},{0,3,1},{0,3,2},{0,3,3}},  //       row 3     
    {{1,0,0},{1,0,1},{1,0,2},{1,0,3}},  //lev 1; row 0     
    {{1,1,0},{1,1,1},{1,1,2},{1,1,3}},  //       row 1     
    {{1,2,0},{1,2,1},{1,2,2},{1,2,3}},  //       row 2     
    {{1,3,0},{1,3,1},{1,3,2},{1,3,3}},  //       row 3     
    {{2,0,0},{2,0,1},{2,0,2},{2,0,3}},  //lev 2; row 0     
    {{2,1,0},{2,1,1},{2,1,2},{2,1,3}},  //       row 1     
    {{2,2,0},{2,2,1},{2,2,2},{2,2,3}},  //       row 2       
    {{2,3,0},{2,3,1},{2,3,2},{2,3,3}},  //       row 3     
    {{3,0,0},{3,0,1},{3,0,2},{3,0,3}},  //lev 3; row 0     
    {{3,1,0},{3,1,1},{3,1,2},{3,1,3}},  //       row 1 
    {{3,2,0},{3,2,1},{3,2,2},{3,2,3}},  //       row 2       
    {{3,3,0},{3,3,1},{3,3,2},{3,3,3}},  //       row 3           
    {{0,0,0},{0,1,0},{0,2,0},{0,3,0}},  //lev 0; col 0   cols in each lev
    {{0,0,1},{0,1,1},{0,2,1},{0,3,1}},  //       col 1    
    {{0,0,2},{0,1,2},{0,2,2},{0,3,2}},  //       col 2    
    {{0,0,3},{0,1,3},{0,2,3},{0,3,3}},  //       col 3    
    {{1,0,0},{1,1,0},{1,2,0},{1,3,0}},  //lev 1; col 0     
    {{1,0,1},{1,1,1},{1,2,1},{1,3,1}},  //       col 1    
    {{1,0,2},{1,1,2},{1,2,2},{1,3,2}},  //       col 2    
    {{1,0,3},{1,1,3},{1,2,3},{1,3,3}},  //       col 3    
    {{2,0,0},{2,1,0},{2,2,0},{2,3,0}},  //lev 2; col 0     
    {{2,0,1},{2,1,1},{2,2,1},{2,3,1}},  //       col 1    
    {{2,0,2},{2,1,2},{2,2,2},{2,3,2}},  //       col 2    
    {{2,0,3},{2,1,3},{2,2,3},{2,3,3}},  //       col 3    
    {{3,0,0},{3,1,0},{3,2,0},{3,3,0}},  //lev 3; col 0     
    {{3,0,1},{3,1,1},{3,2,1},{3,3,1}},  //       col 1
    {{3,0,2},{3,1,2},{3,2,2},{3,3,2}},  //       col 2
    {{3,0,3},{3,1,3},{3,2,3},{3,3,3}},  //       col 3
        {{0,0,0},{1,0,0},{2,0,0},{3,0,0}},  //cols in vert plane in front
        {{0,0,1},{1,0,1},{2,0,1},{3,0,1}},
        {{0,0,2},{1,0,2},{2,0,2},{3,0,2}},
        {{0,0,3},{1,0,3},{2,0,3},{3,0,3}},
        {{0,1,0},{1,1,0},{2,1,0},{3,1,0}},  //cols in vert plane one back
        {{0,1,1},{1,1,1},{2,1,1},{3,1,1}},
        {{0,1,2},{1,1,2},{2,1,2},{3,1,2}},
        {{0,1,3},{1,1,3},{2,1,3},{3,1,3}},
        {{0,2,0},{1,2,0},{2,2,0},{3,2,0}},  //cols in vert plane two back
        {{0,2,1},{1,2,1},{2,2,1},{3,2,1}},
        {{0,2,2},{1,2,2},{2,2,2},{3,2,2}},
        {{0,2,3},{1,2,3},{2,2,3},{3,2,3}},
        {{0,3,0},{1,3,0},{2,3,0},{3,3,0}},  //cols in vert plane in rear
        {{0,3,1},{1,3,1},{2,3,1},{3,3,1}},
        {{0,3,2},{1,3,2},{2,3,2},{3,3,2}},
        {{0,3,3},{1,3,3},{2,3,3},{3,3,3}},
        {{0,0,0},{0,1,1},{0,2,2},{0,3,3}},  //diags in lev 0
    {{0,3,0},{0,2,1},{0,1,2},{0,0,3}},
        {{1,0,0},{1,1,1},{1,2,2},{1,3,3}},  //diags in lev 1
        {{1,3,0},{1,2,1},{1,1,2},{1,0,3}},
        {{2,0,0},{2,1,1},{2,2,2},{2,3,3}},  //diags in lev 2
        {{2,3,0},{2,2,1},{2,1,2},{2,0,3}},
        {{3,0,0},{3,1,1},{3,2,2},{3,3,3}},  //diags in lev 3
        {{3,3,0},{3,2,1},{3,1,2},{3,0,3}},
        {{0,0,0},{1,0,1},{2,0,2},{3,0,3}},  //diags in vert plane in front
        {{3,0,0},{2,0,1},{1,0,2},{0,0,3}},
        {{0,1,0},{1,1,1},{2,1,2},{3,1,3}},  //diags in vert plane one back
        {{3,1,0},{2,1,1},{1,1,2},{0,1,3}},
        {{0,2,0},{1,2,1},{2,2,2},{3,2,3}},  //diags in vert plane two back
        {{3,2,0},{2,2,1},{1,2,2},{0,2,3}},
        {{0,3,0},{1,3,1},{2,3,2},{3,3,3}},  //diags in vert plane in rear
        {{3,3,0},{2,3,1},{1,3,2},{0,3,3}},
        {{0,0,0},{1,1,0},{2,2,0},{3,3,0}},  //diags left slice      
        {{3,0,0},{2,1,0},{1,2,0},{0,3,0}},        
        {{0,0,1},{1,1,1},{2,2,1},{3,3,1}},  //diags slice one to right
        {{3,0,1},{2,1,1},{1,2,1},{0,3,1}},        
        {{0,0,2},{1,1,2},{2,2,2},{3,3,2}},  //diags slice two to right      
        {{3,0,2},{2,1,2},{1,2,2},{0,3,2}},        
        {{0,0,3},{1,1,3},{2,2,3},{3,3,3}},  //diags right slice      
        {{3,0,3},{2,1,3},{1,2,3},{0,3,3}},        
        {{0,0,0},{1,1,1},{2,2,2},{3,3,3}},  //cube vertex diags
        {{3,0,0},{2,1,1},{1,2,2},{0,3,3}},
        {{0,3,0},{1,2,1},{2,1,2},{3,0,3}},
        {{3,3,0},{2,2,1},{1,1,2},{0,0,3}}        
    };
    /*
    for(int k = 0; k < 76; k++) {
        for(int j = 0; j < 4; j++) {
            for(int i = 0; i < 3; i++) {
                System.out.printf("%d", lines[k][j][i]);
            }

        System.out.printf("\n");
        }
    }
    */
int[][][] potmoves = new int[76][4][3];

    for(int i = 0; i < 76; i++) {
        
        int sum = 0;

        for(int j = 0; j < 4; j++) {
            int x = lines[i][j][0];
            int y = lines[i][j][1];
            int z = lines[i][j][2];

            sum += board[x][y][z];
        }

        if(sum = 15) {
            for(int k = 0; k < 4; k++) {
                if (board[lines[i][k][0]][lines[i][k][1]][lines[i][k][2]] = 0) {
                    board[lines[i][k][0]][lines[i][k][1]][lines[i][k][2]] = 5;
                    System.out.println("Computer Wins, GAME OVER");
                    game = false;
                }    
            }
        }
    }

    //compinitialmoves
            if (sum % 13 = 0) {
                for(k = 0; k < 4; k++) {

                }
            }

        }
    }

    int[][][] board = new int[4][4][4];
    int sum = 0;


    System.out.println("Winning combos:");

//  for (int[][] indices : lines /*length of 76*/) {
   //     for (int[] j : indices /*length of 4*/) {
     //      board[indices[0]][indices[1]][indices[2]] = 
      //  System.out.print(" ");
       // }
       // System.out.println("");
  //  }
}
}

if(sum == 10) {
    int testsum = 0;
    int threeinrow = 0;
    int[][][] testboard = new int(4)(4)(4);

    //creates a board replica to check future scenarios
    for(int l = 3;  l > 0; l--) {
        for(m = 3; m > 0; m--) {
            for(n = 0; n < 4; n++)
                testboard[l][m][n] = board[l][m][n];
        }
    }

    //takes the point we're looking to test and puts an "X"
    testboard[point[i][j][0]][point[i][j][1]][point[i][j][2]] = 5;

    //all the potential winning lines are checked in the test board see if two or more lines have three X's in a row
    //if so, then the test point is placed on the actual board
    for(int l = 0; l < 76; l++) {
        for(int m = 0; m < 4; m++) {
            testsum += testboard[point[i][j][0]][point[i][j][1]][point[i][j][2]];
        }
        if (testsum = 10) {
            threeinrow += 1;
        }
    }

    if(threeinrow > 1)
        board[point[i][j][0]][point[i][j][1]][point[i][j][2]] = testboard[point[i][j][0]][point[i][j][1]][point[i][j][2]];
}

/*if there exists a line that has two X's in it 
    then set the board number equal to that
    loop through the whole lines array to see if there's now two lines which equal 15 (ie has three x's)
    if there are two
        board(test points) = 5 */

//set the board equal to that

for(i = 0; i )