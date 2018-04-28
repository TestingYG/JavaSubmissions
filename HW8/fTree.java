//Author Ying Guo
//reads in a path and prints out it's directory and file names.

import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class fTree{
  //allows all functions to write to file
  static PrintWriter writer = null;

  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    System.out.print("Enter a path to print files: ");
    String path = s.nextLine();

    File dir = new File(path);

    //assings the what the output file is and where to put the file output.txt
    try{
      writer = new PrintWriter(new FileWriter("C:\\Users\\Ying\\Desktop\\HW8\\output.txt"), true);
    }
    catch (IOException error){
      error.printStackTrace();
    }
    //checks if the path exist and also if its a directroy
    if(dir.exists() && dir.isDirectory()){
      File filearr[] = dir.listFiles();

      System.out.println("Printing out files from: " + path);
      writer.println("Printing out files from: " + path);

      printFiles(filearr, 0);
    }
    else
      System.out.println(path + " is not a valid input");
  }

  static void printFiles(File [] filearr, int level){

    //loop to print all the files in each folder.
    for(File file: filearr){
      for(int i = 0; i < level; i++){
        System.out.print("|     ");
        writer.print("|     ");
      }

      //checks to see if its a file. if its a file print it.
      if(file.isFile()){
        System.out.print("|    ");
        System.out.println(file.getName());
        writer.print("|    ");
        writer.println(file.getName());
      }

      //checks to see if the file a directroy if it is print it. then do a recusive call
      if(file.isDirectory()){
        System.out.print("|-----");
        System.out.println(file.getName());
        writer.print("|-----");
        writer.println(file.getName());

        //reserive call to print everything in the subdirectroy.
        printFiles(file.listFiles(), level +1);
        System.out.println();
        writer.println();
      }
    }
  }
}

//sources
//1. http://www.computerhope.com/treehlp.htm
//2. https://www.programcreek.com/2011/03/java-write-to-a-file-code-example/
//3. Directroy source for files https://github.com/nhnent/tui.calendar
