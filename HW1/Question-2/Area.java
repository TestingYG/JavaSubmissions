//Author Guo, Yinghao

import java.util.Scanner;
import java.lang.Math;
import java.lang.String;


public class Area{
    
    public static void main(String[] args) {
        double result, toDouble;
        String radius;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter The radius of the Circle: ");
        radius = s.nextLine();
        toDouble = Double.parseDouble(radius);
        
        while(true){
            result = (Math.PI)*(Math.pow(toDouble, 2));
            System.out.printf("The area of the Circle is: " + result +". %n");
            
            System.out.print("Enter The radius of the Circle: ");
            if(s.hasNextLine()){
                radius = s.nextLine();
                toDouble = Double.parseDouble(radius);
            }
            else break;
            
        }
    }
}

