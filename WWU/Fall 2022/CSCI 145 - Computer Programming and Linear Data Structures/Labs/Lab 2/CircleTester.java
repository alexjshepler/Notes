//*******************************************************
// CircleTester.java
//
//
//  A client to test the functionality of objects
//  of the class Circle
// 
//*******************************************************
public class CircleTester{
	
	public static void main(String[] args) {
		
		Circle circle1 = new Circle();
		Circle circle2 = new Circle();
		circle1.setCenter_x(0.0);
		circle1.setCenter_y(0.0);
		circle1.setRadius(2);
		circle2.setCenter_x(2.0);
		circle2.setCenter_y(1.0);
		circle2.setRadius(1);
		System.out.println("circle1="+circle1);
		System.out.println("circle2="+circle2);
		
		// If the method setRadius is implemented correctly,
		// a call to setRadius with a negative number
		// will not change the value of the circle's radius.
		//
		circle1.setRadius(-2.0); 
		
		//
		// Reset the center of circle1 (-3.0,4.0)
		//
		circle1.setCenter_x(-3.0);
		circle1.setCenter_y(4.0);
		
		
		// print circle1 characteristics (center and radius), use a statement similar 
		// to the previous println statements. Note that is not necessary to call
		//the method toString, why?
        
		// Because the return method of the toString() method in the circle class is String
		
		
		// set the circle2 radius to 5.3
		circle2.setRadius(5.3);
      
		
		// print circle2 characteristics (center and radius), use a statement similar to the first and
		// second println statements
		System.out.println("circle2=" + circle2);
		
		// print circle1 diameter, area and perimeter
		System.out.println("circle1 diameter=" + circle1.diameter());
		System.out.println("circle1 area=" + circle1.area());
		System.out.println("circle1 perimeter=" + circle1.perimeter());

		// print circle2 diameter, area and perimeter
		System.out.println("circle2 diameter=" + circle2.diameter());
		System.out.println("circle2 area=" + circle2.area());
		System.out.println("circle2 perimeter=" + circle2.perimeter());

		// display whether circle1 is a unit circle
		System.out.println("circle1 isUnitCircle=" + circle1.isUnitCircle());
		
		// display whether circle2 is a unit circle
		System.out.println("circle2 isUnitCircle=" + circle2.isUnitCircle());
		
		// your additional tests should be placed below here
		

		// print circle1 center and radius
		System.out.println("circle1:\n" + circle1.toString());

		// set circle2 radius to 5.3
		circle2.setRadius(5.3);

		// print circle2 center and radius
		System.out.println("circle2:\n" + circle2.toString());

		// print circle1 diameter area and perimeter
		System.out.println("circle1 diameter=" + circle1.diameter());
		System.out.println("circle1 area=" + circle1.area());
		System.out.println("circle1 perimeter=" + circle1.perimeter());

		// print circle2 diameter area and perimeter
		System.out.println("circle2 diameter=" + circle2.diameter());
		System.out.println("circle2 area=" + circle2.area());
		System.out.println("circle2 perimeter=" + circle2.perimeter());

		// display whether circle1 is a unit circle
		System.out.println("circle1 unit circle:" + circle1.isUnitCircle());

		// display whether circle2 is a unit circle
		System.out.println("circle2 unit circle:" + circle2.isUnitCircle());

		// Comparison method tests
		circle1.setCenter_x(5.7);
		circle1.setCenter_y(5.7);
		circle1.setRadius(3);

		circle2.setCenter_x(5.7);
		circle2.setCenter_y(5.7);
		circle2.setRadius(3);

		System.out.println("circle1:\n" + circle1.toString());
		System.out.println("circle2:\n" + circle2.toString());

		// Check to see if circles are equal
		System.out.println("circle1=circle2:" + circle1.equals(circle2));

		// Check to see if they are intersecting
		System.out.println("circle1 & circle2 intersect:" + circle1.intersects(circle2));

		// Check to see if the circles are concentric
		System.out.println("circle1 & circle2 concentric:" + circle1.isConcentric(circle2));

		// Move circle1
		circle1.setCenter_x(-5);
		circle1.setCenter_y(0);
		circle1.setRadius(5);

		System.out.println("circle1:\n" + circle1.toString());
		System.out.println("circle2:\n" + circle2.toString());

		// Check to see if intersect
		System.out.println("circle1 & circle2 intersect:" + circle1.intersects(circle2));		

		// Check to see if equal
		System.out.println("circle1=circle2:" + circle1.equals(circle2));

		// Move circle2
		circle2.setCenter_x(5);
		circle2.setCenter_y(0);
		circle2.setRadius(5);

		System.out.println("circle1:\n" + circle1.toString());
		System.out.println("circle2:\n" + circle2.toString());

		// Check intersect
		System.out.println("circle1 & circle2 intersect:" + circle1.intersects(circle2));

		// Check concentric
		System.out.println("circle1 & circle2 concentric:" + circle1.isConcentric(circle2));

		// Move circle1
		circle1.setCenter_x(5);
		circle1.setCenter_y(0);
		circle1.setRadius(4);

		System.out.println("\ncircle1:\n" + circle1.toString());
		System.out.println("\ncircle2:\n" + circle2.toString());

		// Check concentric
		System.out.println("circle1 & circle2 concentric:" + circle1.isConcentric(circle2));

		// Check equal
		System.out.println("circle1=circle2:" + circle1.equals(circle2));
	}
}
