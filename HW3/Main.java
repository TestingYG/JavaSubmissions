//author Guo,Yinghao

public class Main {
    public static void main(String[] args) {
        char[] Hello = {'H','e','l','l','o'};
        char[] Hello2 = {'H','e','l','l','o'};
        char[] Prof = {'P','r','o','f','s','s','o','r',' ','B','u','k','h','a','r','i'};
        char[] Alpha = {'H','O','M','E','W','O','R','K',' ','i','s',' ','f','i','n','s','h','e','d'};
        
        MyString s1 = new MyString(Hello);
        MyString s2 = new MyString(Prof);
        MyString s3 = new MyString(Alpha);
        MyString s4 = new MyString(Hello2);
        
        System.out.println("Index Test (6) of string 2 is "+s2.charAt(6));
        System.out.println("Length of string test of string one two and three: "+ s1.length()+"," + s2.length() + "," + s3.length());
        System.out.println("substring of string 3 from 4 - 14 is " +s3.subString(4,17));
        System.out.println("Lowercase conversion: "+s3.toLowerCase());
        System.out.println("Uppercase Conversion "+s3.toUpperCase());
        System.out.println("Comparing "+s1+" and "+s2+" results in "+s1.compareTo(s2));
        System.out.println("Comparing "+s2+" and "+s3+" results in "+s2.compareTo(s3));
        System.out.println("Comparing "+s3+" and "+s1+" results in "+s3.compareTo(s1));
        System.out.println("Comparing "+s1+" and "+s4+" results in "+s1.compareTo(s4));
        
        
        
        String stringTest = s1.toString();
        String stringTest2 = s2.toString();
        System.out.println("This is a string: "+stringTest);
        System.out.println("This is a string: "+stringTest2);

        char[] array = new char[1];
        
        MyString s1Array = new MyString(array);
        
        System.out.println("The value of int -45678 is "+ MyString.valueOf(-45678));
        System.out.println("The value of int 123456789 is "+ MyString.valueOf(123456789));
        
        System.out.println(s1.getMyString());
        System.out.println(s2.getMyString());
        System.out.println(s3.getMyString());
        
    
    }
}
