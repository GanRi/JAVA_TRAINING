package ex1_03;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClockPopupMenu extends PopupMenu {
	private Menu fontStyleMenu = new Menu("Font Style");
	private Menu fontColorMenu = new Menu("Font Color");
	private Menu backgroudMenu = new Menu("Backgroud Color");
	private Menu fontSizeMenu = new Menu("Font Size");
	private MenuItem exit = new MenuItem("Exit");
	private CurrentTimePanel panel = null;
	private ClockWindow window = null;
	
	private String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment()
			.getAvailableFontFamilyNames();

	public ClockPopupMenu(final CurrentTimePanel panel,final ClockWindow window) {
		this.window = window;
		this.panel = panel;
		Font f = new Font("f", 1, 12);
		this.setFont(f);
		for (int i = 0; i < fonts.length; i++){
			fontStyleMenu.add(makeFontStyleMenuItem(fonts[i]));
		}
		this.setFontColorMenu();
		this.setFontSizeMenu();
		this.setBackgroudMenu();
		this.add(fontStyleMenu);
		this.add(fontColorMenu);
		this.add(fontSizeMenu);
		this.add(backgroudMenu);
		this.addSeparator();
		
		ActionListener exit = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				window.dispose();
				System.exit(0);
			}
		};
		
		this.exit.addActionListener(exit);
		this.add(this.exit);
	}
	
	private MenuItem makeFontStyleMenuItem(String label){
		MenuItem m = new MenuItem(label);
		ActionListener fontColorAL = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object ob = e.getSource();
				String s = ((MenuItem)ob).getLabel();
				panel.setFontStyle(s);
			}
		};		
		m.addActionListener(fontColorAL);
		return m;
	}	 

	private void setBackgroudMenu() {
		backgroudMenu.add(makeBackgroudColorMenuItem("Yellow"));
		backgroudMenu.add(makeBackgroudColorMenuItem("Blue"));
		backgroudMenu.add(makeBackgroudColorMenuItem("Black"));
		backgroudMenu.add(makeBackgroudColorMenuItem("White"));
		backgroudMenu.add(makeBackgroudColorMenuItem("Red"));
	}

	private MenuItem makeBackgroudColorMenuItem(String label){
		MenuItem m = new MenuItem(label);
		ActionListener fontColorAL = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object ob = e.getSource();
				String s = ((MenuItem)ob).getLabel();
				panel.setBackgroudColor(convertToColor(s));
			}
		};		
		m.addActionListener(fontColorAL);
		return m;
	}	 
	
	private void setFontColorMenu() {
		fontColorMenu.add(makeFontColorMenuItem("Yellow"));
		fontColorMenu.add(makeFontColorMenuItem("Blue"));
		fontColorMenu.add(makeFontColorMenuItem("Black"));
		fontColorMenu.add(makeFontColorMenuItem("White"));
		fontColorMenu.add(makeFontColorMenuItem("Red"));
	}
	
	private MenuItem makeFontColorMenuItem(String label){
		MenuItem m = new MenuItem(label);
		ActionListener fontColorAL = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object ob = e.getSource();
				String s = ((MenuItem)ob).getLabel();
				panel.setFontColor(convertToColor(s));
			}
		};		
		m.addActionListener(fontColorAL);
		return m;
	}	 
	
	private void setFontSizeMenu(){
		fontSizeMenu.add(makeFontSizeMenuItem("20"));
		fontSizeMenu.add(makeFontSizeMenuItem("30"));
		fontSizeMenu.add(makeFontSizeMenuItem("40"));
		fontSizeMenu.add(makeFontSizeMenuItem("50"));
		fontSizeMenu.add(makeFontSizeMenuItem("60"));
		fontSizeMenu.add(makeFontSizeMenuItem("70"));
		fontSizeMenu.add(makeFontSizeMenuItem("80"));
	}
	
	
	private MenuItem makeFontSizeMenuItem(String label){
		MenuItem m = new MenuItem(label);
		ActionListener fontSizeAL = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object ob = e.getSource();
				String s = ((MenuItem)ob).getLabel();
				panel.setFontSize(Integer.parseInt(s));
			}
		};		
		m.addActionListener(fontSizeAL);
		return m;
	}
	
	private Color convertToColor(String color){
		switch (color){
		case "Black":
			return Color.BLACK;
		case "White":
			return Color.WHITE;
		case "Red":
			return Color.RED;
		case "Yellow":
			return Color.YELLOW;
		case "Blue":
			return Color.BLUE;
		}
		return Color.BLACK;
	}
	
}
