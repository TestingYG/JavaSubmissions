//Author Guo,YingHao
//uses 4 threads to print the alphabet. in order thread 1 A thread 2 B etc...

import java.util.*;

public class ABC{

    //volitile is used so its not cached in the cpu.
    //use for printing ABCS
    static volatile char letter = 'A';
    //changes from 1-4 and repeating to tell which thread to run.
    static volatile int threadtorun = 1;
    //used as a lock
    static Object lock = new Object();

  public static void main(String[] args) {

      //creates 4 threads.
      Thread one = new Thread(new ABCprint(1));
      Thread two = new Thread(new ABCprint(2));
      Thread three = new Thread(new ABCprint(3));
      Thread four = new Thread(new ABCprint(4));

      //starts the threads.
      one.start();
      two.start();
      three.start();
      four.start();

  }

  //thread handler and printer
  static class ABCprint implements Runnable{
      private int threadnum;

      //consturcotr for thread number
      public ABCprint(int threadnum) {
          super();
          this.threadnum = threadnum;
      }

      //runs the threads to print Abc
      @Override
      public void run() {
          try {
            //tells the program to loop it untill it his [
              while (letter != '[') {
                  synchronized (lock) {
                      //puts threads on hold if they just ran and releases lock
                      if (threadnum != threadtorun) {
                          lock.wait();
                      }
                      else {
                          System.out.print(letter + " "); //prints the letter
                          letter++;// increases the letter by one.

                          //determins which thread to run in order of 1 2 3 4
                          if (threadnum == 1)
                            threadtorun = 2;
                          else if (threadnum == 2)
                            threadtorun = 3;
                          else if (threadnum == 3)
                            threadtorun = 4;
                          else
                            threadtorun = 1;

                          //wakes the rest of the threads up.
                          lock.notifyAll();
                      }
                  }
              }
          }
          catch (Exception e) {
              e.printStackTrace();
          }
    }
  }
}

//source
//1.https://www.javamex.com/tutorials/synchronization_volatile.shtml
//2.http://www.sci.brooklyn.cuny.edu/~bukhari/java_notes.txt
//3.https://www.asciitable.com/
