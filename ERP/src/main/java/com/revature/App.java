package com.revature;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Please Enter Info");
        Scanner scanner = new Scanner(System.in);
        // scanner.useDelimiter(" ");

        String id = scanner.next();
        String amount = scanner.next();
        String manager = scanner.next();

        System.out.println("Employee ID: " + id);
        System.out.println("Reimbursement amount: "+ amount);
        System.out.println("Manager ID: " + manager);
        
        scanner.close();
    }
}
