//author Guo, Yinghao
//Version 2.0
//1.Change data type to long.
//2.Got rid of inSquare incriment;

public class Speed2{

  public static void main (String[] args ){
    long before = System.currentTimeMillis();

    double radius = 1;
	long max = 4000000000L; 
	long inCircle = 0L;
	long inSquare = 0L;
	double pi = 0.0;
	Point origin = new Point();

	//randomly gerneates points to see if they are in the circle or outside of the circle.
	for (long count = 0L; count < max; count++){
	   Point xyPoint = new Point(Math.random(), Math.random());
	   if((Math.sqrt(Math.pow(xyPoint.x - origin.y,2) +  Math.pow(xyPoint.y - origin.y,2))*radius) <= radius)
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

  //this class creates the x and y points. 
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
//1.https://stackoverflow.com/questions/31748028/long-vs-biginteger
