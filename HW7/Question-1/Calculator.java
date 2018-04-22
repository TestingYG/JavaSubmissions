//Author Guo, Ying

//Command line Calculator

import java.util.*;
import java.util.Stack;

public class Calculator{
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    System.out.println("Enter your math probem. Use X for multiplication and E for exponent: ");
    String infix = s.nextLine();
    String postfix = "";

    postfix = postfixConv(infix);

    System.out.println("This is your problem in postfix notation " + postfix);
    System.out.println("This is your problem solved " + solve(postfix));
  }

  //converts infix notation to post fix notation;
  public static String postfixConv(String infix) throws AlgebraFailException, QuitMashingOnYourKeyboardException, UserIsADumbassException {
    String postfix = "";
    Stack<Character> stack = new Stack<>();
    char[] notsupportarr = new char[]{'^','!', '@' ,'#','$','%','&','*','[', ']','<','>',',','{','}','|','`','~'};
    char tempchar;

    //checks if string is empty
  	if(infix.isEmpty())
  		throw new UserIsADumbassException();

    if (infix.charAt(0) == '+' || infix.charAt(0) == '-' || infix.charAt(0) == 'x' ||infix.charAt(0) == 'X' || infix.charAt(0) == '/' ||infix.charAt(0) == '^')
      throw new AlgebraFailException();

    //main loop to get infix to postfix
    for(int i = 0; i < infix.length(); ++i){
      tempchar = infix.charAt(i);

      //checks for non supported operations.
      for(int j = 0; j < notsupportarr.length; j++){
        if (tempchar == notsupportarr[j])
          throw new QuitMashingOnYourKeyboardException();
      }

      //makes sure the other letters are not x or E
      //E = exponent
      //X = multiplication
      if(Character.isLetter(tempchar) && ((tempchar !='x' && tempchar != 'X' && tempchar != 'e' && tempchar != 'E')))
        throw new QuitMashingOnYourKeyboardException();

      //pushes the operationts to the stack.
      if(tempchar == 'x' || tempchar == 'X' || tempchar == '+' || tempchar == '-' || tempchar == '/'|| tempchar == 'e' || tempchar == 'E'){
          while(!stack.empty() && precedence(tempchar) <= precedence(stack.peek()))
            postfix = postfix + stack.pop();
          stack.push(tempchar);
      }
      //pushes ( to the stack
      else if(tempchar == '(')
        stack.push(tempchar);
      else if(tempchar == ')'){
        //pops the remaning operations in () and add it to postfix
        while (!stack.empty() && stack.peek() != '('){
          postfix = postfix + " "  + stack.pop();
        }
        //pops the last ( after an )
        if(!stack.empty() && stack.peek() == '('){
          stack.pop();
        }
      }
      //checks if the operation is supported and checks if the number is not a letter.
      else
        postfix = postfix + tempchar;
    }

    //emptys the stack and push the rest of the operators to postfix.
    while(!stack.empty()){
      if (stack.peek() == '(')
        {
          throw new QuitMashingOnYourKeyboardException();
        }
      else
        postfix = postfix + " " + stack.pop();
    }
    return postfix;
  }

  public static int precedence(char tempchar){
    switch(tempchar){
      case '+':
        return 1;
      case '-':
        return 1;

      case 'x':
        return 2;
      case 'X':
        return 2;
      case '/':
        return 2;

      case 'E':
        return 3;
      case 'e':
        return 3;
    }
      return -1;
  }
  public static double solve(String postfix)throws ArithmeticException{
    Stack<Double> stack = new Stack<Double> ();
    double num1, num2, tempdouble, newnum1;
    Scanner s = new Scanner(postfix);

    while(s.hasNext()){
      if(s.hasNextInt() || s.hasNextDouble()){
        stack.push(s.nextDouble());
      }
      else{
        num2 = stack.peek();
        stack.pop();
        num1 = stack.peek();
        stack.pop();
        String operation = s.next();

        if(operation.equals("-")){
          stack.push(num1 - num2);
        }
        else if(operation.equals("+"))
          stack.push(num1 + num2);
        else if(operation.equals("x") || operation.equals("X"))
          stack.push(num1 * num2);
        else if(operation.equals("/") ){
          if(num2 == 0 || num2 == 0.0)
            throw new ArithmeticException();
          else
            stack.push(num1 /num2);
        }
        else if(operation.equals("e") || operation.equals("E")){
          tempdouble = num1;
          for(int i = 0;  i < num2 - 1; i++)
            tempdouble = tempdouble * num1;
          stack.push(tempdouble);
        }
      }
    }
    return stack.pop();
  }
}

//sources
//1. https://stackoverflow.com/questions/15633228/how-to-remove-all-white-spaces-in-java/15633290
//2. https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
//3. https://www.youtube.com/watch?v=QCnANUfgC-w
//4. https://www.youtube.com/watch?v=XSdXSmwb550
