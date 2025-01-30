// Author: Christopher Waschke
// Description: Translated our Java code to JavaScript, to calculate a rectangle's area and perimeter.


// Shape Class, holds data about the points of our shape.
class Shape {
    constructor(topLeft, topRight, bottomLeft, bottomRight) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

// ShapeManager Class, performs the calculations for our shape.
class ShapeManager {

    // Our Constructor.
    // Initializes the shape our Manager holds and works with.
    constructor(topLeft, topRight, bottomLeft, bottomRight) {
        this.shape = new Shape(topLeft, topRight, bottomLeft, bottomRight);
    }

    // Calculates the length of the shape, using the distance formula.
    grabLength() {
        return Math.sqrt(Math.pow(this.shape.topLeft.x - this.shape.topRight.x, 2) + Math.pow(this.shape.topLeft.y - this.shape.topRight.y, 2));
    }

    // Calculates the width of the shape, using the distance formula.
    grabWidth() {
        return Math.sqrt(Math.pow(this.shape.topLeft.x - this.shape.bottomLeft.x, 2) + Math.pow(this.shape.topLeft.y - this.shape.bottomLeft.y, 2));
    }

    // Calculates the area of the shape.
    grabArea() {
        return this.grabLength() * this.grabWidth();
    }

    // Calculates the perimeter of the shape.
    grabPerimeter() {
        return 2 * (this.grabLength() + this.grabWidth());
    }

    // Checks if our shape Length and Width are equal, to determine if it's a square or rectangle.
    grabGetShapeType(){
        if (this.grabLength() === this.grabWidth()) {
            return "Square";
        } else {
            return "Rectangle";
        }
    }
}

// This method handles the button click on our HTML form.
// This is equivalent to our test in Java, except we're not using regex to parse a single input string
// But instead grabbing the values from the form.
function calculateRect(){
    let topLeft = {x: document.getElementById("topLeftX").value, y: document.getElementById("topLeftY").value};
    let topRight = {x: document.getElementById("topRightX").value, y: document.getElementById("topRightY").value};
    let bottomLeft = {x: document.getElementById("bottomLeftX").value, y: document.getElementById("bottomLeftY").value};
    let bottomRight = {x: document.getElementById("bottomRightX").value, y: document.getElementById("bottomRightY").value};

    let shape = new ShapeManager(topLeft, topRight, bottomLeft, bottomRight);
    let outPut = document.getElementById("output");
    let outputDiv = document.getElementById("shape-output");
    outputDiv.classList.remove("hidden");
    
    outPut.innerText = `The area is ${shape.grabArea()} and the perimeter is ${shape.grabPerimeter()}. The width is ${shape.grabWidth()}, and the length is ${shape.grabLength()} The shape is a ${shape.grabGetShapeType()}`;
}