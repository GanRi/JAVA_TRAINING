package ch01.ex08;

public class Point {

	public double x,y;
	
	public void setPoint(Point p){
		this.x = p.x;
		this.y = p.y;		
	}
	
	public static void main(String arg[]){
		Point pointA = new Point();
		Point pointB = new Point();
		
		pointA.x = 22.45;
		pointA.y = 44.5;
		
		pointB.setPoint(pointA);
		
		System.out.println("x:" + pointB.x + "   y:" + pointB.y );
		
	}
}
