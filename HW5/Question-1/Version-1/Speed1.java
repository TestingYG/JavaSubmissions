//Author Guo, Yinghao
//VERSION 1.0

import java.math.BigDecimal;
import java.util.Scanner;

public class Speed1{

  public static void main (String[] args ){
    long before = System.currentTimeMillis();

    double radius = 1;
    BigDecimal max = new BigDecimal("4000000000");
    BigDecimal inSquare = new BigDecimal("0");
    BigDecimal inCircle = new BigDecimal("0");
    BigDecimal count = new BigDecimal("0");
    BigDecimal add = new BigDecimal("1");
    Point origin = new Point();

    while(max.compareTo(count) != 0){
	  Point xyPoint = new Point(Math.random(), Math.random());
      if((Math.sqrt(Math.pow(xyPoint.x - origin.y,2) +  Math.pow(xyPoint.y - origin.y,2))*radius) <= radius){
        inCircle = new BigDecimal(inCircle.add(add).toString());
      }
      else{
        inSquare = new BigDecimal(inSquare.add(add).toString());
      }
      count = new BigDecimal(count.add(add).toString());
    }

    System.out.println("There are " + max + " points created.");
    System.out.println("The number of points in the circle is " + inCircle + ". ");
    System.out.println("The number of points in the square is " + inSquare + ". ");
    System.out.println("Caluclated pi is " + inCircle.divide(max).multiply(new BigDecimal("4")) + ".");

    System.out.println(System.currentTimeMillis()-before);

  }
  }

class Point{
  double x;
  double y;

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }

  public Point(){
    this.x = 0;
    this.y = 0;
  }
}

//source
//1.https://www.tutorialspoint.com/java/math/java_math_bigdecimal.htm
//2.http://mathfaculty.fullerton.edu/mathews/n2003/montecarlopimod.html
//3.https://docs.oracle.com/javase/7/docs/api/java/math/BigDecimal.html
