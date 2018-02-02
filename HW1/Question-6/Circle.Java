//Author Guo, Yinghao

import java.util.Scanner;
import java.lang.Math;

public class Circle{
    
    public static void main(String[] args) {
        double r1, r2, x1, x2, y1, y2, distance;
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter The radius of the Circle and the Center coordinates of circle 1: ");
        r1 = s.nextDouble();
        x1 = s.nextDouble();
        y1 = s.nextDouble();
        
        System.out.print("Enter The radius of the Circle and the Center coordinates of circle 2: ");
        r2 = s.nextDouble();
        x2 = s.nextDouble();
        y2 = s.nextDouble();
        
        distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        
        if((r1+r2) < distance){
            System.out.print("The circles are far apart." + '\n');
        }
        else if (r1 >= r2 && distance <= (r1 - r2)|| r2 >= r1 && distance <= (r2 - r1)){
            System.out.print("The circles are comeplety in each other." + '\n');
        }
        else if((r1+r2) == distance){
            System.out.print("The circles are touching." + '\n');
        }
        else{
            System.out.print("The circles are overlapping." + '\n');
            
        }
        
    }
}
