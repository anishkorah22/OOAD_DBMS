package com.utility;
import java.util.Scanner;

import com.service.EmployeeService;

public class EmployeeUtility {

    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        char choice = 'y';
 
   do
   {
	   System.out.println("Choose an option:");
       System.out.println("1. Display best performer");
       System.out.println("2. Display least performer");
       System.out.println("3. Display employees with rewards");
       System.out.println("4. Display employees with motivation sessions");
       System.out.println("ENTER YOUR CHOICE:-");
       int menuChoice=scanner.nextInt();
       
       switch (menuChoice) {
       case 1:
           employeeService.displayBestPerformer(choice);
           break;
       case 2:
           employeeService.displayLeastPerformer(choice);
           break;
       case 3:
          employeeService.displayEmployeesWithRewards(choice);
           break;
       case 4:
           employeeService.displayEmployeesWithMotivationSessions(choice);
           break;
       default:
           System.out.println("Invalid choice!");
       }
           System.out.println("Do you want to go to menu (y/n)");
           choice=scanner.next().charAt(0);
       
   }while(choice=='y');
    }
}