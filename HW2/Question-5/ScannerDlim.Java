//Author Guo,Yinghao
//Changing the scanner's Delimiter

import java.util.Scanner;

public class ScannerDlim{

    public static void main(String[] args){
        int a,b,c,d;
        Scanner s = new Scanner(System.in);
        s.useDelimiter(",");
        
        System.out.print("Enter 4 Integers serperted by a comma: ");
        a = s.nextInt();
        b = s.nextInt();
        c = s.nextInt();
        d = s.nextInt();
        
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        
        s.close();
    }
}


//Source
//https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
