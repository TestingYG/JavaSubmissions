//author Guo, Yinghao
//Version 3.0
//1.got rid of the point class
//2.changed the for loop. and incooperate the equation of the cricle.

public class Speed3{

  public static void main (String[] args ){
    long before = System.currentTimeMillis();

    double radius = 1;
	long max = 4000000000L; 
	long inCircle = 0L;
	Long inSquare = 0L;
	Double pi = 0.0;

	//randomly gerneates points to see if they are in the circle or outside of the circle.
	for (long count = 0L; count < max; count++){
	   double x = Math.random();
	   double y = Math.random();
	   if((x*x)+(y*y)<= radius)
			inCircle++;
    }

	inSquare = max - inCircle; 
	
	double x = Double.longBitsToDouble(inCircle);
	double y = Double.longBitsToDouble(max);

	pi = (x/y)* 4; 

    System.out.println("There are " + max + " points created.");
    System.out.println("The number of points in the circle is " + inCircle + ". ");
    System.out.println("The number of points in the square is " + inSquare + ". ");
    System.out.println("Caluclated pi is " + pi + ".");

    System.out.println(System.currentTimeMillis()-before);

  }
}

//source 
//1.https://stackoverflow.com/questions/9472766/faster-than-constructor

