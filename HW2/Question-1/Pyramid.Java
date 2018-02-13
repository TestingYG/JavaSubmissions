//Author Guo, Yinghao
//makes a pyramid out of user define height.

import java.util.Scanner;

public class Pyramid{

    public static void main(String[] args){
        int height, countTwo = 1;
        
        Scanner s = new Scanner(System.in);
        System.out.print("Enter how tall the pyramid should be: ");
        height = s.nextInt();
        
        //Pyramid Creater
        for(int row = 0; row < height; row++){
            for(int j = 1; j < height - row; j++){
                System.out.print("  ");
            }
            //left side of the pyramid until highest output
            for(int count = 1; count <row+1; count++){
                System.out.print(countTwo + " ");
                countTwo++;
               }
            //right side of the pyramid from highest output to 1
            for(int i = row; i >= 0; i--){
                System.out.print(countTwo + " ");
                countTwo--;
            }
            
            countTwo = 1;
            System.out.println();
        }
        
    }
}
