//Author Guo, Yinghao

import java.util.Scanner;

public class CommandLineRedirect{

    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        while(input.hasNext()){
            System.out.println(input.next());
        }
    }
}
