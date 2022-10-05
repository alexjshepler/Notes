//*******************************************************
//
// Circle.java
//
// Name: Alex Shepler
// Date: 10/05/2022
// I promise to be academically honest
//
//*******************************************************
public class Circle {

    private double x;
    private double y;
    private double radius;

    // ----------------------------------------------
    // getX - returns the value of x
    // ----------------------------------------------

    public double getCenter_x() {
        return x;
    }

    // ----------------------------------------------
    // getY - returns the value of y
    // ----------------------------------------------
    public double getCenter_y() {
        return y;
    }

    // ----------------------------------------------
    // getRadius - returns the value of radius
    // ----------------------------------------------
    public double getRadius() {
        return radius;
    }

    // ----------------------------------------------
    // setX - assigns a new value to x
    // ----------------------------------------------
    public void setCenter_x(double _x) {
        x = _x;
    }

    // ----------------------------------------------
    // setY - assigns a new value to y
    // ----------------------------------------------
    public void setCenter_y(double _y) {
        y = _y;
    }

    // ----------------------------------------------
    // setRadius - assigns a new value to radius
    // ----------------------------------------------
    public void setRadius(double _r) {
        radius = _r;
    }

    // --------------------------------------------------------
    // diameter - calculates the diameter of the circle
    // --------------------------------------------------------
    public double diameter() {
        return (2 * radius);
    }

    // --------------------------------------------------------
    // area - returns the area of the circle
    // --------------------------------------------------------
    public double area() {
        return (Math.PI * radius * radius);
    }

    // --------------------------------------------------------
    // perimeter - returns the perimeter of the circle
    // --------------------------------------------------------
    public double perimeter() {
        return (2 * radius * Math.PI);
    }

    // --------------------------------------------------------
    // isUnitCircle - return true if the radius of this circle
    // is 1 and its center is (0,0) and false
    // otherwise.
    // --------------------------------------------------------
    public Boolean isUnitCircle() {
        if (x == 0 && y == 0 && radius == 1)
            return true;
        else
            return false;
    }

    // --------------------------------------------------------
    // toString - return a String representation of
    // this circle in the following format:
    // center:(x,y)
    // radius: r
    // --------------------------------------------------------
    public String toString() {
        return "center: (" + x + ", " + y + ")\nradius: " + radius;
    }

    public boolean equals(Circle _circle) {
        if (x == _circle.getCenter_x() && y == _circle.getCenter_y() && radius == _circle.getRadius())
            return true;
        else
            return false;
    }

    public boolean isConcentric(Circle _circle) {
        if (x == _circle.getCenter_x() && y == _circle.getCenter_y() && radius != _circle.getRadius())
            return true;
        else
            return false;
    }

    public double distance(Circle _circle) {
        return Math.sqrt(Math.pow(x - _circle.getCenter_x(), 2) + Math.pow(y - _circle.getCenter_y(), 2));
    }

    public boolean intersects(Circle _circle) {
        if ((radius + _circle.getRadius()) <= (distance(_circle)))
            return true;
        else
            return false;
    }
}