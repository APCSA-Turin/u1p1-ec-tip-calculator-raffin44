package com.example.project;
import java.util.Scanner;

public class ExtraCredit {

    public static String calculateTip(int people, int percent, double cost, String items) {
        StringBuilder result = new StringBuilder();

        // Copy and paste your existing tip calculator code here
        double tipamt = (percent * cost) / 100;
        double totalbill = (tipamt + cost); 
        double perpersoncostbfr = (cost / people);
        double perpersontip = (tipamt / people);
        double totalcostperperson = (totalbill / people);

        result.append("-------------------------------\n");
        result.append("Total bill before tip: $" + cost + "\n");
        result.append("Total percentage: " + percent + "%" + "\n");
        result.append("Total tip: $" + String.format("%.2f", tipamt) + "\n");
        result.append("Total Bill with tip: $" + String.format("%.2f", totalbill) + "\n");
        result.append("Per person cost before tip: $" + String.format("%.2f", perpersoncostbfr) + "\n");
        result.append("Tip per person: $" + String.format("%.2f", perpersontip) + "\n");
        result.append("Total cost per person: $" + String.format("%.2f", totalcostperperson) + "\n");
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

        // Consume the newline character left by nextDouble
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
    }
}

// source: https://www.w3schools.com/java/java_while_loop.asp