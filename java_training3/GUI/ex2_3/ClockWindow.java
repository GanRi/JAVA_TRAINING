package ex2_3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class ClockWindow extends Window implements Runnable,
		MouseMotionListener {
	// private CurrentTimePanel timeFrame = null;
	private Image iBuffer = null;
	private Graphics gBuffer = null;
	private Point clockPosition;
	ClockPopupMenu popupMenu = null;
	Thread clock;
	Font font = null;
	int fontSize = 50;
	String fontStyle = "TimesRoman";
	Color backgroundColor = Color.RED;
	Color fontColor = Color.BLACK;

	public ClockWindow(Window owner, GraphicsConfiguration gc) {
		super(owner, gc);
		
		// timeFrame = new CurrentTimePanel(this);
		setSize(500, 500);
		setBackground(backgroundColor);
		// this.add(timeFrame);
		this.setVisible(true);
		popupMenu = new ClockPopupMenu(this);

		this.setFontType();
		start();
		this.add(popupMenu);
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3)
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
			}

			public void mouseEntered(MouseEvent e) {
				System.out.println("Entered");
			}

			public void mouseExited(MouseEvent e) {
				System.out.println("Exited");
			}

			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					System.out.println("mouse pressed------");
					clockPosition = e.getLocationOnScreen();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					System.out.println("mouse released-----");
					clockPosition = null;
				}
			}
		});
		addMouseMotionListener(this);
	}

	public void setWindowSize(int size) {
		this.setSize(size * 8, size * 2);
	}

	public static void main(String args[]) {
		ClockWindow ob = new ClockWindow(new Frame("frame"), null);
	}

	public void setFontSize(int size) {
		fontSize = size;
		setFontType();
	}

	public int getFontSize() {
		return this.fontSize;
	}

	private void setFontType() {
		this.font = new Font(fontStyle, Font.BOLD, fontSize);
		setFont(font);
	}

	public void setFontStyle(String style) {
		this.fontStyle = style;
		setFontType();
	}

	public void setBackgroudColor(Color color) {
		this.backgroundColor = color;
	}

	public void setFontColor(Color color) {
		this.fontColor = color;
	}

	public Color getFontColor() {
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
			if (clockPosition == null)
				clockPosition = e.getLocationOnScreen();
			int dx = e.getXOnScreen() - clockPosition.x;
			int dy = e.getYOnScreen() - clockPosition.y;
			clockPosition = e.getLocationOnScreen();
			Point newLocation = getLocation();
			newLocation.translate(dx, dy);
			ajustWindowLocation(newLocation);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private void ajustWindowLocation(Point newLocation) {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		if (newLocation.x < 0)
			newLocation.x = 0;
		if (newLocation.y < 0)
			newLocation.y = 0;
		if (newLocation.x + getSize().width > screen.width)
			newLocation.x = screen.width - getSize().width;
		if (newLocation.y + getSize().height > screen.height)
			newLocation.y = screen.height - getSize().height;
		setLocation(newLocation);
	}

//	public void paint(Graphics g) {
//		super.paint(g);
//		Calendar now = new GregorianCalendar();
//		String timeInfo = "";
//		int hour = now.get(Calendar.HOUR_OF_DAY);
//		int minute = now.get(Calendar.MINUTE);
//		int second = now.get(Calendar.SECOND);
//		if (hour <= 9)
//			timeInfo += "0" + hour + ":";
//		else
//			timeInfo += hour + ":";
//		if (minute <= 9)
//			timeInfo += "0" + minute + ":";
//		else
//			timeInfo += minute + ":";
//		if (second <= 9)
//			timeInfo += "0" + second;
//		else
//			timeInfo += second;
//
//		setBackground(getBackgroudColor());
//		g.setFont(getFont());
//		g.setColor(getFontColor());
//		g.drawString(
//				timeInfo,
//				((int) (this.getSize().width * 0.5) - (int) (this.getFontSize() * 2.4)),
//				(int) (this.getSize().height * 0.5)
//						- (int) (this.getFontSize() * 0.35));
//	}
//	
	
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
		setBackground(getBackgroudColor());
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
	
	
//	public void paintComponent(Graphics g) {
//		//super.paintComponents(g);
//		Calendar now = new GregorianCalendar();
//		String timeInfo = "";
//		int hour = now.get(Calendar.HOUR_OF_DAY);
//		int minute = now.get(Calendar.MINUTE);
//		int second = now.get(Calendar.SECOND);
//		if (hour <= 9)
//			timeInfo += "0" + hour + ":";
//		else
//			timeInfo += hour + ":";
//		if (minute <= 9)
//			timeInfo += "0" + minute + ":";
//		else
//			timeInfo += minute + ":";
//		if (second <= 9)
//			timeInfo += "0" + second;
//		else
//			timeInfo += second;
//
//		setBackground(getBackgroudColor());
//		g.setFont(getFont());
//		g.setColor(getFontColor());
//		g.drawString(
//				timeInfo,
//				((int) (this.getSize().width * 0.5) - (int) (this.getFontSize() * 2.4)),
//				(int) (this.getSize().height * 0.5)
//						- (int) (this.getFontSize() * 0.35));
//	}
}
