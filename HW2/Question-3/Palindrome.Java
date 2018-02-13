//Author Guo, Yinghao
//Checks if a string is a Palindrome

import java.util.*;

public class Palindrome{

    public static void main(String[] args){
        String orginal, reverse = "";
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter a word to check for palindrome: ");
        orginal = s.nextLine();
        
        for(int i = orginal.length() - 1; i >= 0; i--)
            reverse = reverse + orginal.charAt(i);
        
        if(orginal.equals(reverse))
            System.out.println("This word is a palindrome.");
        else
            System.out.println("This word is not a palindrome.");
        
    }
}
