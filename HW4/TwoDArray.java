//Author Guo, Yinghao
//given a two dimensional array of characters prints
//out the combination of every letter with every other letter.

import java.util.*;

public class TwoDArray{

  public static void main(String[] args){
    int row, column = 0, count = 0, count2 = 0, combinations = 1;

    Scanner s = new Scanner(System.in);
    System.out.print("Enter how many rows you want: ");
    row = s.nextInt();

    //creating the 2d array with user define row
    //creats an array to hold row column positions.
    String array[][] = new String[row][];
    int rowPos[] = new int[row];

    //user input to fill 2D array.
    //also creates the multidimenstional array
    for(int i = 0; i < row; i++){
      System.out.print("Enter how many columns you want for " + (i+1) + ": ");
      column = s.nextInt();
      array[i] = new String[column];
      s.nextLine();
      for(int j = 0; j < column; j++){
        System.out.print("Enter the data for row " + (i+1) + " column " + (j+1) + ": ");
        array[i][j] = s.nextLine();
      }
    }

    //counts the total number of combinations and prints it
    for(int i = 0; i < row; i++){
      combinations = combinations * array[i].length;
    }
    System.out.println("total number of possible combinations " + combinations);

    //prints the 2d array back to the user.
    System.out.print('\n');
    System.out.print("This is your 2D array" + '\n');
    for(int i = 0; i < row; i++){
      for(int j = 0; j < array[i].length; j++){
        System.out.print(array[i][j] + " ");
      }
      System.out.print('\n');
    }
    System.out.println();

    //prints the combinations.
    System.out.println("These are your combinations: ");
    while(count < combinations){
      for(int i = 0; i < row; i++){
        System.out.print(array[i][rowPos[i]]);
        count2++;
        //checks to see how many characters got pritned for formating.
        //then resets it when it prints out the max.
        if(count2 == row){
          System.out.println();
          count2 = 0;
        }
      }

      //incriments the rows column positions for one row. starting with row 0
      //if it incriments, loop will break
      for(int j = 0; j < row; j++){
        if(rowPos[j]+ 1 != array[j].length){
          rowPos[j] ++;
          break;
        }
        //Resets the row poistion when it hits rowLength.
        else
          rowPos[j] = 0;
      }
    count++;
    }
  }
}

//soruce
//1.http://www.techiedelight.com/jagged-array-ragged-array-java/
//2.https://www.geeksforgeeks.org/default-array-values-in-java/
