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

    /* doube[][] method. Returns a 2d array, row size of count, of ordered pairs doubles. (Equivent to two columns).
     * We redo the user input portion if the regex fails to match to an index of the count we're looking for.
     * Parameters:
     *  count (int) The number of ordered pairs we're searching for.
     */
    public static double[][] getPoints(int count) {
        double[][] outArr = new double[count][2];
        int index;
        do {
            index = 0; // Set index to 0 upon entering the loop, important to do it here, incase of re-loop.

            System.out.printf("Please enter %d ordered pairs in proper form (x,y)> ", count);
            Scanner lineScanner = new Scanner(System.in);

            // Regex translates into: If the string has a leading ( match, and a trailing )
            // match. Look for comma, and allow for optional decimal.
            Pattern pattern = Pattern.compile("(?<=\\()-?[0-9]{1,}\\.?[0-9]*,\\s?-?[0-9]{1,}\\.?[0-9]*(?=\\))");
            Matcher match = pattern.matcher(lineScanner.nextLine());

            // For each match in the string, split at comma, convert to double, and stick in our output array at the current row.
            while (match.find()) {
                String matchString = match.group();
                String[] splitPairStr = matchString.split(",");
                outArr[index][0] = Double.parseDouble(splitPairStr[0]);
                outArr[index][1] = Double.parseDouble(splitPairStr[1]);
                index++; //Increase our current index.
            }
            
            // Give the user some feedback if we're looping around again.
            if(index != count){
                System.out.printf("Unable to parse %d ordered pairs. Please make sure you typed them in order syntax.\n", count);
            }
        } while(index != count);

        return outArr;
    }
    
    /*
     * Our Main method for our tests.
     * Gets the user's input of ordered pairs, then creates a shape using those points.
     * Tests the logical fuction of Manager for finding area/parameter/length/width.
     */
    public static void main(String[] args) {
        double[][] pointArr = getPoints(4);

        ShapeManager shapeManager = new ShapeManager(pointArr[0], pointArr[1], pointArr[2], pointArr[3]);
        System.out.printf("The area is %f, the parameter is %f, the length and width is %f, %f",
                shapeManager.calcArea(), shapeManager.calcParameter(), shapeManager.calcLength(),
                shapeManager.calcWidth());
    }
}