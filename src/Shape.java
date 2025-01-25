// Authors: Christopher Waschke, Jackson Jenks, Brody Weinkauf
// Assignment: Week 3 - Thinking of Object
// Description: A class and manager for a shape, based upon it's points on a grid. Manager should be able to find length, width, area and parameter. Test class to validate methods.
// Citation: https://www.w3schools.com/java/java_regex.asp


package src;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

class Shape {

}

class ShapeManager {

}

class ShapeTest {

    public static double[] getPoint(){
        boolean found = false;
        String matchString = "";
        double[] outPair = new double[2];
        while(!found){
            System.out.println("Please enter point in ordered pair for (x,y)");
            Scanner lineScanner = new Scanner(System.in);
            Pattern pattern = Pattern.compile("(?<=\\()-?[0-9]{1,}\\.?[0-9]*,-?[0-9]{1,}\\.?[0-9]*(?=\\))"); // Regex translates into: If the string has a leading ( match, and a trailing ) match. Look for comma, and allow for optional decimal.
            Matcher match = pattern.matcher(lineScanner.nextLine());
            found = match.find();
            if(!found){
                System.out.println("Invalid ordered pair. Please try again.");
                continue;
            }
            matchString = match.group();
        }

        String[] splitPairStr = matchString.split(",");
        outPair[0] = Double.parseDouble(splitPairStr[0]);
        outPair[1] = Double.parseDouble(splitPairStr[1]);

        return outPair;
    }

    public static void main(String[] args) {
    }
}