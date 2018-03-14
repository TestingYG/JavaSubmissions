//Author Guo, Yinghao

import java.util.*;
import java.util.Scanner;

public class NQueen{

  static int soultion = 0;

  public static void main(String[] args){
    int boardSize;
    Scanner s = new Scanner(System.in);
    System.out.print("How big you would like your board to be? ");
    boardSize = s.nextInt();

    int[][] boardArray = new int[boardSize][boardSize];

    solveProblem(boardArray,0,boardSize);
  }

  //checks to see if other queens are attacking the placeing queen
  public static boolean safe(int boardArray[][], int row, int col,int size){
    int i, j;

            // checks the left row for the attakcing queen.
            for (i = 0; i < col; i++)
                if (boardArray[row][i] == 1)
                    return false;

            //checks the upper left doangle of the queen
            for (i=row, j=col; i>=0 && j>=0; i--, j--)
                if (boardArray[i][j] == 1)
                    return false;

            //checks the left lower diangel of the queen
            for (i=row, j=col; j>=0 && i<size; i++, j--)
                if (boardArray[i][j] == 1)
                    return false;

            return true;
  }

  //recusivie call to check for a soultion, if one hits then it will print it out.
  //if no solution is printed then incrment the queen to the next row and reset the previouse point to zero.
  public static void solveProblem(int boardArray[][], int collum, int size){
    if(collum >= size){
      printSoultion(boardArray, size);
    }

    //recursive call to place other queens.
    //if solveProblem comes out of the recurisve call it either printed all soultions
    //for that spot or there were no solutions
    for(int i = 0; i <size; i++){
      if (safe(boardArray, i, collum,size)){
        boardArray[i][collum] = 1;
        solveProblem(boardArray, collum+1, size);
        boardArray[i][collum] = 0;
      }
    }
  }

  //prints out the soultions
  public static void printSoultion(int boardArray[][], int size){
    soultion ++;
    System.out.println("Soultion Number " + soultion);
    for(int i = 0; i < size ; i++){
      for(int j = 0; j < size ; j++){
        System.out.print(boardArray[i][j] + " ");
      }
      System.out.print('\n');
    }
    System.out.println();
  }
}







//source
//https://www.youtube.com/watch?v=0DeznFqrgAI
//https://stackoverflow.com/questions/13431013/increments-by-1-and-add-it-with-every-created-object
//http://www.durangobill.com/N_Queens.html
