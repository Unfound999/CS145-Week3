package src;

class Shape {

    //  initializes coordinates
    private double[] topLeft, bottomLeft, topRight, bottomRight;
    private double triangleHeight, triangleSide;

    //  Constructs Shape object type
    public Shape(double[] topLeft, double[] bottomLeft, double[] topRight, double[] bottomRight, double triangleHeight, double triangleSide) {
        this.topLeft = topLeft;
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
        this.bottomRight = bottomRight;
        this.triangleHeight = triangleHeight;
        this.triangleSide = triangleSide;
    } //  ends Shape object constructor method

    public double[] getTopLeft() {
        return topLeft;
    } //  ends getTopLeft method

    public double[] getBottomLeft() {
        return bottomLeft;
    } //  ends getBottomLeft method

    public double[] getTopRight() {
        return topRight;
    } //  ends getTopRight method

    public double[] getBottomRight() {
        return bottomRight;
    } //  ends getBottomRight method

    public double getTriangleHeight() {
        return triangleHeight;
    } //  end getTriangleHeight method

    public double getTriangleSide() {
        return triangleSide;
    } //  ends getTriangleSide method

    public void setTopLeft(double[] topLeft) {
        this.topLeft = topLeft;
    } //  ends setTopLeft method

    public void setBottomLeft(double[] bottomLeft) {
        this.bottomLeft = bottomLeft;
    } //  ends setBottomLeft method

    public void setTopRight(double[] topRight) {
        this.topRight = topRight;
    } //  ends setTopRight method

    public void setBottomRight(double[] bottomRight) {
        this.bottomRight = bottomRight;
    } //  ends setBottomRight method

    public void setTriangleHeight(Integer triangleHeight) {
        this.triangleHeight = triangleHeight;
    } //  ends setTriangleHeight method

    public void setTriangleSide(Integer triangleSide) {
        this.triangleSide = triangleSide;
    } //  ends setTriangleSide method
} //  ends Shape class

class ShapeManager {

}

class ShapeTest {
    public static void main(String[] args) {
        
    }
}