//Author Guo, Yinghao

import java.util.Random;
import java.time.Month;

public class NumToMonths{

    public static void main(String[] args){
        
        Random rand = new Random();
        int randomNumb = rand.nextInt(12)+1;
        Month m = Month.of(randomNumb);
        
        System.out.println("The number randomly generated is "+ randomNumb+  ". This month is " + m.name() +"."+ '/n');
    
    }
}
