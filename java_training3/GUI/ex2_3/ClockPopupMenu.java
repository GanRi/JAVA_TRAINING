package ex2_3;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClockPopupMenu extends JPopupMenu {
	private JMenu fontStyleMenu = new JMenu("Font Style");
	private JMenu fontColorMenu = new JMenu("Font Color");
	private JMenu backgroudMenu = new JMenu("Backgroud Color");
	private JMenu fontSizeMenu = new JMenu("Font Size");
	private JMenuItem exit = new JMenuItem("Exit");
	private JColorChooser fontColorChooser = new JColorChooser();
	private JColorChooser backgroudColorChooser = new JColorChooser();
	//private CurrentTimePanel panel = null;
	private ClockWindow panel = null;
	
	private String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment()
			.getAvailableFontFamilyNames();

	public ClockPopupMenu(final ClockWindow window) {
		this.panel = window;
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
		
		ColorSelectionModel fontModel = fontColorChooser.getSelectionModel();
	    ChangeListener changeListener = new ChangeListener() {
	      public void stateChanged(ChangeEvent changeEvent) {
	    	Color newForegroundColorFont = fontColorChooser.getColor();
	        panel.setFontColor(newForegroundColorFont);
	      }
	    };
	    
	    fontModel.addChangeListener(changeListener);
	    
		ColorSelectionModel backgroudModel = backgroudColorChooser.getSelectionModel();
	    ChangeListener backgroudChangeListener = new ChangeListener() {
	      public void stateChanged(ChangeEvent changeEvent) {
	    	Color newForegroundColor = backgroudColorChooser.getColor();
	        panel.setBackgroudColor(newForegroundColor);
	      }
	    };
	    
	    backgroudModel.addChangeListener(backgroudChangeListener);
	    
	    
		ActionListener exit = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				window.dispose();
				System.exit(0);
			}
		};
		
		this.exit.addActionListener(exit);
		this.add(this.exit);
	}
	
	private JMenuItem makeFontStyleMenuItem(String label){
		JMenuItem m = new JMenuItem(label);
		ActionListener fontColorAL = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object ob = e.getSource();
				String s = ((JMenuItem)ob).getLabel();
				panel.setFontStyle(s);
			}
		};		
		m.addActionListener(fontColorAL);
		return m;
	}	 

	private void setBackgroudMenu() {
		backgroudMenu.add(backgroudColorChooser);
	}
	
	private void setFontColorMenu() {
		fontColorMenu.add(fontColorChooser);
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
	
	
	private JMenuItem makeFontSizeMenuItem(String label){
		JMenuItem m = new JMenuItem(label);
		ActionListener fontSizeAL = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object ob = e.getSource();
				String s = ((JMenuItem)ob).getLabel();
				panel.setFontSize(Integer.parseInt(s));
			}
		};		
		m.addActionListener(fontSizeAL);
		return m;
	}
	
	
}
