//Nguyễn Đức Thịnh - 20235841
//Bài 6.44

import java.util.Scanner;

public class DaysOfMonth{

    public boolean isLeapYear(int year){
        if((year%4 == 0 && year%100 != 0) || year%400 == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public int daysOfMonth(int year, String month){
        switch(month){
            case "January": case "March": case "May": case "July": case "August": case "October": case "December":
            case "1": case "3": case "5": case "7": case "8": case "10": case "12":
            case "Jan.": case "Mar.": case "Jul.": case "Aug.": case "Oct.": case "Dec.":
            case "Jan": case "Mar": case "Jul": case "Aug": case "Oct": case "Dec":

            return 31;

            case "4": case "6": case "9": case "11": 
            case "Apr.": case "June": case "Sep.": case "Nov.":
            case "April": case "September": case "November": 
            case "Apr": case "Sep": case "Nov":
            return 30;

            case "2": case "Feb.": case "Feb": case "February":
            if(isLeapYear(year)){
                return 29;
            }
            else{
                return 28;
            }

            default:
            System.out.println("Thang khong hop le");
            return -1;
        }
    }

    public static void main(String args[]){
        DaysOfMonth object = new DaysOfMonth();
        Scanner scan = new Scanner(System.in);
        System.out.println("year = ");
        int year = scan.nextInt();
        System.out.println("month = ");
        String month = scan.next();
        int day = object.daysOfMonth(year, month);
        if(day != -1){
            System.out.println("Thang " + month + ", nam " + year + " co " + day + " ngay." );
        }        
        scan.close();
    }
}
