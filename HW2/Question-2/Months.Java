//Author Guo,Yinghao
//Ask user for a year and when what day the year began and print the calender

import java.util.Scanner;
import java.lang.String;

public class Months{

    public static void main(String[] args){
        int year, day, daycount = 1, i = 0, count=0, temp =0;
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};
        int days[] = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a year: ");
        year = s.nextInt();
        System.out.print("What day the first of January fell on? (1 - Sun, 2 - Mon, ... 7 - Sat) ");
        day = s.nextInt();
        day = day - 1;
        
        //controls the months
        for (int a = 0; a < 12; a++){
            System.out.printf("%1s %s %1d %n", " ", month[a], year);
            System.out.printf("%s %s %3s %3s %3s %3s %3s %3s %n"," ", "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa");
            
            if (days[i] == 0){
                if ( year % 4 == 0 && year % 100 !=0 || year % 400 == 0)
                    days[i] = 29;
                else
                    days[i] = 28;
            }
            
            //controls the shifting before the 1 is placed
            for (int d = 0; d < day; d ++)
                System.out.printf("%4s", " ");
            
            count = count + day;
            
            //contols the weeks in a month;
            for(int b = 0; b <= 5; b++){
                
                //controls the number of days are a week
                for(int j = day; j < 7 ; j++){
                    System.out.printf("%4d", daycount);
                    daycount ++;
                    count++;
                    temp = count;
                    if(daycount > days[i]){
                        daycount = 1;
                        break;
                    }
                }
                System.out.print("\n");
                day = 0;
                count = 0;
                
                //resets day count
                if(daycount == 1){
                    break;
                }
            }
            
            //if statement to see how many days i need to shift before placeing 1.
            if(temp == 7)
                day = 0;
            else
                day = temp;
            
            temp = 0;
            System.out.print("\n");
            i++;
        
        }
    }
}

//source
//1. https://www.timeanddate.com/date/leapyear.html
//2. https://www.timeanddate.com/calendar/months/
