package src;

import java.awt.image.SampleModel;
import java.lang.reflect.Parameter;

class Shape {

}

class ShapeManager {
/* ToDo List: non static Methods that are needed are double calculateArea, double calculatePerameter, double calculateLength, double calculateHeight. There should
 * be a property of a shape that holds information about shape (Initialized in the constructor) CREATE METHOD that calculates distance between points and then
 * use that to calcualte area and perameter in other methods
 */

    private Shape myShape;

    ShapeManager(double[] topLeft, double[] topRight, double[] bottomLeft, double[] bottomRight) {

        this.myShape = new Shape(topLeft, topRight, bottomLeft, bottomRight);
    }

    public double grabArea(double[] topLeft, double[] topRight, double[] bottomLeft, double[] bottomRight) {

        double length = grabLengthRectangle(topLeft, bottomLeft)(topLeft, bottomLeft);
        double width = grabWidthRectangle(bottomLeft, bottomRight)(bottomLeft, bottomRight);

        double area = length * width;

        return area;
    }

    public double grabPerameter(double[] topLeft, double[] topRight, double[] bottomLeft, double[] bottomRight) {

        double length = grabLengthRectangle(topLeft, bottomLeft)(topLeft, bottomLeft);
        double width = grabWidthRectangle(bottomLeft, bottomRight)(bottomLeft, bottomRight);

        double parameter = length * 2 + width * 2;

        return parameter;
    }

    public double grabLengthRectangle(double[] topLeft, double[] bottomLeft) {

        topLeft[1] = this.getTopLeft();
        bottomLeft[1] = this.getBottomLeft();

        double length = topLeft[1] - bottomLeft[1];

        return length;
    }

    public double grabWidthRectangle(double[] bottomLeft, double[] bottomRight) {

        bottomRight[0] = this.getTopLeft();
        bottomLeft[0] = this.getBottomLeft();

        double width = topLeft[1] - bottomLeft[1];

        return width;
    }

    public double grabAreaTriangle(double[] bottomLeft, double[] bottomRight) {

        double height = this.getTriangleHeight(); //Side a is the left side of the triangle
        double base = this.getTriangleSideB(); //Side b is the base of the triangle

        double area = .5 * base[0] * height[1];

        return area;
    }

    public double grabParameterTriangle(double[] bottomLeft, double[] bottomRight) {

        double sideA = this.getTrianlgeSideA(); //Side a is the left side of the triangle
        double base = this.getTrianlgeSideB(); //Side b is the base of the triangle
        double sideC = this.getTrianlgeSideC(); //Side c is the right side of the triangle

        double parameter = sideA + base[0] + sideC;

        return parameter;
    }

    public double grabCircumferenceCircle(double[] bottomLeft, double[] bottomRight) {

        double radius = this.radius();

        double area = 3.14159265359 * 2 * radius;

        return area;
    }

    public double grabAreaCircle(double[] bottomLeft, double[] bottomRight) {

        double radius = this.radius();

        double area = (3.14159265359 * radius) * (3.14159265359 * radius);

        return area;
    }



    public void calcualteArea() {

        

    }
    

}

class ShapeTest {
    public static void main(String[] args) {
        
    }
}