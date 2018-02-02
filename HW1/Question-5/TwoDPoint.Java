//Author Guo, Yinghao

import java.lang.Math;
import java.util.Scanner;

public class TwoDPoint{

    public static void main(String[] args){
        double a1,a2,b1,b2,c1,c2,sidea,sideb,sidec;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the X and Y Value Coordiantes for side A: ");
        a1 = s.nextDouble();
        a2 = s.nextDouble();
        
        System.out.print("Enter the X and Y Value Coordiantes for side B: ");
        b1 = s.nextDouble();
        b2 = s.nextDouble();
        
        System.out.print("Enter the X and Y  Value Coordiantes for side C: ");
        c1 = s.nextDouble();
        c2 = s.nextDouble();
        
        sidea = dist(a1,a2, b1, b2);
        sideb = dist(b1,b2,c1,c2);
        sidec = dist(c1,c2,a1,a2);
        
        triangle(sidea, sideb, sidec);

    }

    public static double dist(double x,double y,double x2, double y2){
        return Math.sqrt(Math.pow((x2 - x), 2) + Math.pow((y2 - y), 2));
    }
    
    public static void triangle(double a, double b, double c){
        if ((a+b) > c && (c+a) > b && (b+c) > a){
            System.out.print("This is a real Triangle"+ '\n');
        }
        else{
            System.out.print("This is not a Triangle"+ '\n');
        }
    }
}


