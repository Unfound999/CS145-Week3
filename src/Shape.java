// Authors: Christopher Waschke, Jackson Jenks, Brody Weinkauf
// Assignment: Week 3 - Thinking of Object
// Description: A class and manager for a shape, based upon it's points on a grid. Manager should be able to find length, width, area and parameter. Test class to validate methods.
// Citation: https://www.w3schools.com/java/java_regex.asp

package src;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

// Creates the Enum for our square type. 
enum ShapeType {
    RECTANGLE,
    SQUARE
} //  ends enum

class Shape {


    //  initializes coordinates
    private double[] topLeft, topRight, bottomLeft, bottomRight;

    //  Constructs Shape object type
    public Shape(double[] topLeft, double[] topRight, double[] bottomLeft, double[] bottomRight) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    } //  ends Shape object constructor method

    //  methods return called values from Shape object
    public double[] getTopLeft() {return topLeft;}
    public double[] getTopRight() {return topRight;}
    public double[] getBottomLeft() {return bottomLeft;}
    public double[] getBottomRight() {return bottomRight;}

    //  methods set values in Shape object to the passed values
    public void setTopLeft(double[] topLeft) {this.topLeft = topLeft;}
    public void setTopRight(double[] topRight) {this.topRight = topRight;}
    public void setBottomLeft(double[] bottomLeft) {this.bottomLeft = bottomLeft;}
    public void setBottomRight(double[] bottomRight) {this.bottomRight = bottomRight;}
} //  ends Shape class

class ShapeManager {

    //Create the data for myShape
    private Shape myShape;

    //Constructor class created for pulling in shape data from data class
    public ShapeManager(double[] topLeft, double[] topRight, double[] bottomLeft, double[] bottomRight) {

        this.myShape = new Shape(topLeft, topRight, bottomLeft, bottomRight);
    }

    //Method that returns the area of a rectangle and brings in length and width from methods in this class
    public double grabArea() {

        double length = this.grabLengthRectangle();
        double width = this.grabWidthRectangle();

        double area = length * width;

        return area;
    }

    //Method that calculates the parameter of the rectangle, returns the parameter, and pulls in length and width from methods in this class
    public double grabPerameter() {

        double length = this.grabLengthRectangle();
        double width = this.grabWidthRectangle();

        double parameter = length * 2 + width * 2;

        return parameter;
    }

    //Method that retunrs the lengths and grabs in coordinates from the myShape object
    public double grabLengthRectangle() {

        double[] topLeft = this.myShape.getTopLeft();
        double[] bottomLeft = this.myShape.getBottomLeft();

        double length = topLeft[1] - bottomLeft[1];

        return length;
    }

    //Method that returns the lengths and grabs in coordinates from the myShape object
    public double grabWidthRectangle() {

        double[] bottomRight = this.myShape.getBottomRight();
        double[] bottomLeft = this.myShape.getBottomLeft();

        double width = bottomRight[0] - bottomLeft[0];

        return width;
    }

    public ShapeType grabShapeType(){
        if(this.grabLengthRectangle() == this.grabWidthRectangle()){
            return ShapeType.SQUARE;
        } else {
            return ShapeType.RECTANGLE;
        }
    }

}

class ShapeTest {

    /* double[][] method. Returns a 2d array, row size of count, of ordered pairs doubles. (Equivalent to two columns).
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
     * Tests the logical function of Manager for finding area/parameter/length/width.
     */
    public static void main(String[] args) {

        System.out.println("Please give us the four points to create a rectangle.");
        double[][] pointArr = getPoints(4);

        ShapeManager shapeManager = new ShapeManager(pointArr[0], pointArr[1], pointArr[2], pointArr[3]);
        System.out.printf("The area is %f, the parameter is %f, the length and width is %f, %f and is type %s",
                shapeManager.grabArea(), shapeManager.grabPerameter(), shapeManager.grabLengthRectangle(),
                shapeManager.grabWidthRectangle(), shapeManager.grabShapeType().name());
    }
}