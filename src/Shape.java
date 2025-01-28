package src;

class Shape {

    //  initializes enum that determines type of shape
    private enum shapeType {
        RECTANGLE,
        SQUARE
    } //  ends enum

    //  initializes coordinates
    private double[] topLeft, bottomLeft, topRight, bottomRight;

    //  Constructs Shape object type
    public Shape(double[] topLeft, double[] bottomLeft, double[] topRight, double[] bottomRight) {
        this.topLeft = topLeft;
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
        this.bottomRight = bottomRight;
    } //  ends Shape object constructor method

    //  methods return called values from Shape object
    public double[] getTopLeft() {return topLeft;}
    public double[] getBottomLeft() {return bottomLeft;}
    public double[] getTopRight() {return topRight;}
    public double[] getBottomRight() {return bottomRight;}

    //  methods set values in Shape object to the passed values
    public void setTopLeft(double[] topLeft) {this.topLeft = topLeft;}
    public void setBottomLeft(double[] bottomLeft) {this.bottomLeft = bottomLeft;}
    public void setTopRight(double[] topRight) {this.topRight = topRight;}
    public void setBottomRight(double[] bottomRight) {this.bottomRight = bottomRight;}
} //  ends Shape class

class ShapeManager {

}

class ShapeTest {
    public static void main(String[] args) {
        
    }
}