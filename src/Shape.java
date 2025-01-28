package src;

class Shape {

}

class ShapeManager {
/* ToDo List: non static Methods that are needed are double calculateArea, double calculatePerameter, double calculateLength, double calculateHeight. There should
 * be a property of a shape that holds information about shape (Initialized in the constructor) CREATE METHOD that calculates distance between points and then
 * use that to calcualte area and perameter in other methods
 */

    private Shape myShape;

    public ShapeManager(double[] topLeft, double[] topRight, double[] bottomLeft, double[] bottomRight) {

        this.myShape = new Shape(topLeft, topRight, bottomLeft, bottomRight);
    }

    public double grabArea() {

        double length = this.grabLengthRectangle();
        double width = this.grabWidthRectangle();

        double area = length * width;

        return area;
    }

    public double grabPerameter() {

        double length = this.grabLengthRectangle();
        double width = this.grabWidthRectangle();

        double parameter = length * 2 + width * 2;

        return parameter;
    }

    public double grabLengthRectangle() {

        double[] topLeft = this.myShape.getTopLeft();
        double[] bottomLeft = this.myShape.getBottomLeft();

        double length = topLeft[1] - bottomLeft[1];

        return length;
    }

    public double grabWidthRectangle() {

        double[] bottomRight = this.myShape.getBottomRight();
        double[] bottomLeft = this.myShape.getBottomLeft();

        double width = bottomRight[0] - bottomLeft[0];

        return width;
    }

}

class ShapeTest {
    public static void main(String[] args) {
        
    }
}