package ex1_04;

import java.awt.Point;

public class ClockSetting {
	private String backgroudColor = "Wihte";
	private String font = "";
	private String fontColor = "Black";
	private int fontSize = 30;
	private Point location = new Point(100,100);
	
	public void setBackgroudColor(String backgroudColor){
		this.backgroudColor = backgroudColor;
	}
	
	public String getBackgroudColor(){
		return this.backgroudColor;
	}
	
	public void setFont(String font){
		this.font = font;
	}
	
	public String getFont(){
		return this.font;
	}
	
	public void setFontColor(String color){
		this.fontColor = color;
	}
	
	public String getFontColor(){
		return this.fontColor;
	}
	
	public void setFontSize(int size){
		this.fontSize = size;
	}
	
	public int getFontSize(){
		return this.fontSize;
	}
	
	public void setLocation(Point p){
		this.location = p;
	}
	
	public Point getLocation(){
		return this.location;
	}
	
}
