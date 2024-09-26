package com.example.project;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ExtraCredit {

    public static String calculateTip(int people, int percent, double cost, String items) {
        StringBuilder result = new StringBuilder();

        // Copy and paste your existing tip calculator code here
        double tipamt = (percent*cost)/100;
        double totalbill = (tipamt+cost);
        double perpersoncostbfr = (cost/people);
        double perpersontip = (tipamt/people);
        double totalcostperperson = (totalbill/people);

        DecimalFormat df = new DecimalFormat("0.00");
        String roundedTipAmount = df.format(tipamt);
        String roundedTotalBill = df.format(totalbill);
        String roundedPerPersonCostBeforeTip = df.format(perpersoncostbfr);
        String roundedPerPersonTip = df.format(perpersontip);
        String roundedTotalCostPerPerson = df.format(totalcostperperson);

        result.append("-------------------------------\n");
        result.append("Total bill before tip: $"+ cost+"\n"); //concatenate to this string. DO NOT ERASE AND REWRITE
        result.append("Total percentage: "+ percent+ "%" + "\n");
        result.append("Total tip: $"+ roundedTipAmount+ "\n");
        result.append("Total Bill with tip: $"+ roundedTotalBill+ "\n");
        result.append("Per person cost before tip: $"+ roundedPerPersonCostBeforeTip+ "\n");
        result.append("Tip per person: $"+ roundedPerPersonTip+"\n");
        result.append("Total cost per person: $"+ roundedTotalCostPerPerson+"\n");
        result.append("-------------------------------\n");

        // Add the items ordered section
        result.append("Items ordered:\n");
        result.append(items);  // Print all items ordered

        return result.toString();
    }

    public static void main(String[] args) {
        int people;
        int percent;
        double cost;
        StringBuilder items = new StringBuilder();  // StringBuilder to capture multiple items

        Scanner scan = new Scanner(System.in);

        // Prompt the user for input details
        System.out.print("Enter the number of people: ");
        people = scan.nextInt();

        System.out.print("Enter the tip percentage: ");
        percent = scan.nextInt();

        System.out.print("Enter the total cost: ");
        cost = scan.nextDouble();

        scan.nextLine();

        // Ask the user to enter menu items
        System.out.println("Enter an item name or type '-1' to finish:");
        String itemName = scan.nextLine();

        // Loop to capture menu items
        while (!itemName.equals("-1")) {
            items.append(itemName).append("\n");  // Append each item to the string           
            System.out.println("Enter another item name or type '-1' to finish:");
            itemName = scan.nextLine();
        }

        // Call the method to calculate the tip and print the result
        System.out.println(calculateTip(people, percent, cost, items.toString()));


        scan.close();
    }
}

// source: https://www.w3schools.com/java/java_while_loop.asp