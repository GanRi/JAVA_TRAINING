package ex1_02;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextField;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CurrentTimePanel extends Panel implements Runnable {
	private Image iBuffer = null;
	private Graphics gBuffer = null;
	Thread clock;
	Font font = null;
	int fontSize = 50;
	String fontStyle = "TimesRoman";
	Color backgroundColor = Color.WHITE;
	Color fontColor = Color.BLACK;

	public CurrentTimePanel() {
		this.setFontType();
		start();
	}

	public void setFontSize(int size){
		fontSize = size;
		setFontType();
	}
	
	public int getFontSize(){
		return this.fontSize;
	}
	private void setFontType() {
		this.font = new Font(fontStyle, Font.BOLD, fontSize);
		setFont(font);
	}
	
	public void setFontStyle(String style){
		this.fontStyle = style;
		setFontType();
	}

	public void setBackgroudColor(Color color) {
		this.backgroundColor = color;
	}

	public void setFontColor(Color color){
		this.fontColor = color;
	}
	
	public Color getFontColor(){
		return this.fontColor;
	}
	public Color getBackgroudColor() {
		return this.backgroundColor;
	}

	public Font getFont() {
		return this.font;
	}
	
	public void start() {
		if (clock == null) {
			clock = new Thread(this);
			clock.start();
		}
	}

	public void run() {
		while (clock != null) {
			try {
				repaint();
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void stop() {
		clock = null;
	}

	public void paint(Graphics g) {
		super.paint(g);
		Calendar now = new GregorianCalendar();
		String timeInfo = "";
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		if (hour <= 9)
			timeInfo += "0" + hour + ":";
		else
			timeInfo += hour + ":";
		if (minute <= 9)
			timeInfo += "0" + minute + ":";
		else
			timeInfo += minute + ":";
		if (second <= 9)
			timeInfo += "0" + second;
		else
			timeInfo += second;
		g.setFont(getFont());
		g.setColor(getFontColor());
		g.drawString(timeInfo, ((int)(this.getSize().width * 0.5) -(int)(this.getFontSize()*2.4)), (int)(this.getSize().height * 0.5) -(int)(this.getFontSize()* 0.35));
	}
	
	public void update(Graphics scr){
		if(iBuffer ==null){
			iBuffer = createImage(2000,2000);
			gBuffer = iBuffer.getGraphics();
		}
		
		gBuffer.setColor(getBackgroudColor());
		Dimension dim = getSize();
		gBuffer.fillRect(0, 0, dim.width, dim.height);
		paint(gBuffer);
		scr.drawImage(iBuffer, 0, 0, this);
	}


}
