package ex2_4;

import java.awt.Color;
import java.awt.Point;

public class ClockSetting {
	private Color backgroudColor = Color.BLUE;
	private String font = "";
	private Color fontColor = Color.YELLOW;
	private int fontSize = 30;
	private Point location = new Point(100,100);
	
	public void setBackgroudColor(Color backgroudColor){
		this.backgroudColor = backgroudColor;
	}
	
	public Color getBackgroudColor(){
		return this.backgroudColor;
	}
	
	public void setFont(String font){
		this.font = font;
	}
	
	public String getFont(){
		return this.font;
	}
	
	public void setFontColor(Color color){
		this.fontColor = color;
	}
	
	public Color getFontColor(){
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
