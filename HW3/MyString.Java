//Author Guo,Yinghao

import java.util.*;

public class MyString{

    private char[] charsA;

    //Constuctor
    public MyString(char[] input){
        charsA = new char[input.length];
        
        for(int i=0; i<input.length; i++)
            charsA[i] = input[i];
    }

    //Returns the value at user define index
    public char charAt(int index){
        if((index >= charsA.length) || (index<0))
            return 0;
        else
            return charsA[index];
    }

    //returns the legnth of the string
    public int length(){
        return charsA.length;
    }

    //creates a new string based on a previous string with user define which part of the string
    //they are starting with and ending with.
    public MyString subString(int begin, int end){
        char[] newString = new char[end - begin];
        for(int i = begin; i < end; i++){
            newString[i - begin] = charsA[i];
        }

        return new MyString(newString);
    }

    //changes the string to lowercase
    public MyString toLowerCase(){
        char[] lowString = new char[charsA.length];
        for(int i = 0; i < charsA.length; i++){
            lowString[i] = Character.toLowerCase(charsA[i]);
        }

        return new MyString(lowString);
    }

    //changes the string to uppercase
    public MyString toUpperCase(){
        char[] upString = new char[charsA.length];
        for(int i = 0; i < charsA.length; i++){
            upString[i] = Character.toUpperCase(charsA[i]);
        }

        return new MyString(upString);
    }

    //comapres the string lexicographically
    //return 0 if equal
    //return < 0 if string is bigger then string arugment
    //return > 0 if string is smaller then string arugment
    public int compareTo(MyString s){
        int length = Math.min(s.length(), charsA.length);
        if(s.length() != charsA.length)
            return (s.length() - charsA.length);
        
        for(int i=0; i< length; i++){
            if(s.charAt(i) != charsA[i])
                return(s.charAt(i) - charsA[i]);
        }
        
        return 0;
        
    }

    //getter fucntion to return MyString.
    public MyString getMyString(){
        return new MyString(charsA);
    }

    //converts MyString in to a String
    public String toString(){
        return new String(charsA);
    }

    //converts an interger to a string object
    public static MyString valueOf(int i){
        int temp = i;
        int length = 0;
        
        //checks if i is negative.
        if(i < 0){
            length++;
        }
        
        //counts the length of the number by cutting off the last digit.
        while(temp != 0){
            length++;
            temp = temp / 10;
        }
        
        //creates a new character array
        char[] newString = new char[length];
        
        //adds a negative sign if its a negative number
        if(i < 0){
            newString[0] = (char)(45);
            i = i *-1;
        }
        
        //coverts individual digits in i to decmial value base on ASCII Table and store it in newString.
        while (i != 0){
            newString[--length] = (char)(i%10 + 48);
            i = i/10;
        }
        
        return new MyString(newString);
    }
}


//source
//1.https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
//2.https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
//3.https://stackoverflow.com/questions/20451786/whats-the-difference-between-return-string-expr-and-return-new-stringstring
//4.https://www.geeksforgeeks.org/collections-reverse-java-examples/

