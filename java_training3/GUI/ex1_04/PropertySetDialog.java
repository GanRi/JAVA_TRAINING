package ex1_04;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PropertySetDialog extends Dialog {
	private Button saveButton = new Button("     Set     ");
	private Button cancelButton = new Button("  Cancel  ");
	private GridBagLayout layout = new GridBagLayout();
	
	private Label fontColorLabel = new Label("Font Color: ");
	private Label fontSizeLabel = new Label("Font Size: ");
	private Label fontLabel = new Label("Font: ");
	private Label backgroudColorLable = new Label("Backgroud Color: ");
	
	private Choice fontColor = new Choice();
	private Choice fontStyle = new Choice();
	private Choice fontSize = new Choice();
	private Choice backgroudColor = new Choice();
	
	private ClockSetting set = new ClockSetting();
	
	private String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment()
			.getAvailableFontFamilyNames();
	
	public PropertySetDialog(ClockWindow frame, CurrentTimePanel timePanel, ClockSetting set) {
		super(frame);
		this.set = set;
		this.setTitle("Set Property");
		this.setResizable(false);
		this.setLayout(layout);
		this.createContents();
		this.createButton(frame, timePanel);
		this.createLayout();

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		this.setSize(300, 200);
	}

	private void createLayout(){
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0,0,0,0);
		constraints.ipadx = 0;
		constraints.ipady = 0;
		makeLayoutContents(layout, constraints, fontColorLabel);
		constraints.gridx = 1;
		constraints.anchor = GridBagConstraints.WEST;
		makeLayoutContents(layout, constraints, fontColor);
		constraints.gridy = 1;
		constraints.gridx = 0;
		constraints.anchor = GridBagConstraints.EAST;
		makeLayoutContents(layout, constraints, fontSizeLabel);
		constraints.gridx = 1;
		constraints.anchor = GridBagConstraints.WEST;
		makeLayoutContents(layout, constraints, fontSize);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.anchor = GridBagConstraints.EAST;
		makeLayoutContents(layout, constraints, fontLabel);
		constraints.gridx = 1;
		constraints.anchor = GridBagConstraints.WEST;
		makeLayoutContents(layout, constraints, fontStyle);
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.anchor = GridBagConstraints.EAST;
		makeLayoutContents(layout, constraints, backgroudColorLable);
		constraints.gridx = 1;
		constraints.anchor = GridBagConstraints.WEST;
		makeLayoutContents(layout, constraints, backgroudColor);
		
		constraints.gridx = 1;
		constraints.gridy = 6;
		constraints.anchor = GridBagConstraints.SOUTH;
		makeLayoutContents(layout, constraints, saveButton);
		
		constraints.gridx = 1;
		constraints.gridy = 6;
		constraints.anchor = GridBagConstraints.SOUTHEAST;
		makeLayoutContents(layout, constraints, cancelButton);
	}
	
	private void makeLayoutContents(GridBagLayout layout, GridBagConstraints constraints, Component component){
		layout.setConstraints(component, constraints);
		add(component);
	}
	
	private void createContents() {
		for (int i = 0; i < fonts.length; i++){
			fontStyle.add(fonts[i]);
		}
		
		fontStyle.select(set.getFont());
		
		fontSize.add("20");
		fontSize.add("30");
		fontSize.add("40");
		fontSize.add("50");
		fontSize.add("60");
		fontSize.add("70");
		fontSize.add("80");
		fontSize.select(String.valueOf(set.getFontSize()));
		
		fontColor.add("Black");
		fontColor.add("White");
		fontColor.add("Red");
		fontColor.add("Blue");
		fontColor.add("Yellow");
		fontColor.add("Cyan");
		fontColor.select(set.getFontColor());
		
		backgroudColor.add("White");
		backgroudColor.add("Black");
		backgroudColor.add("Red");
		backgroudColor.add("Blue");
		backgroudColor.add("Yellow");
		backgroudColor.add("Cyan");
		backgroudColor.select(set.getBackgroudColor());
		

	}

	private void createButton(final ClockWindow frame, CurrentTimePanel timePanel) {
		saveButton.addActionListener(new SaveButtonListener(frame, timePanel));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				fontStyle.select(set.getFont());
				fontSize.select(String.valueOf(set.getFontSize()));
				fontColor.select(set.getFontColor());
				backgroudColor.select(set.getBackgroudColor());
				dispose();
			}			
		});
	}

	class SaveButtonListener implements ActionListener {
		CurrentTimePanel timePanel = null;
		ClockWindow window = null;
		public SaveButtonListener(ClockWindow frame, CurrentTimePanel timePanel) {
			this.timePanel = timePanel;
			this.window = frame;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			dispose();
			timePanel.setBackgroudColor(convertToColor(backgroudColor.getSelectedItem()));
			timePanel.setFontColor(convertToColor(fontColor.getSelectedItem()));
			timePanel.setFontSize(Integer.parseInt(fontSize.getSelectedItem()));
			timePanel.setFontStyle(fontStyle.getSelectedItem());
			window.setSize((Integer.parseInt(fontSize.getSelectedItem()) * 10 + 100), (Integer.parseInt(fontSize.getSelectedItem()) * 3 + 150));
			
			Point location = window.getLocation();
			save(backgroudColor.getSelectedItem(),fontStyle.getSelectedItem(),fontColor.getSelectedItem(),Integer.parseInt(fontSize.getSelectedItem()), location);
		}
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
		case "Cyan":
			return Color.CYAN;
		}
		return Color.BLACK;
	}
	
	private void save(String backgroudColor, String font, String fontColor, int fontSize, Point location){
		Preferences p = Preferences.userRoot();
		Preferences clock = p.node("LiYanClock");
		clock.put("LiYanClockFont", font);
        clock.putInt("LiYanClockFontSize", fontSize);
        clock.put("LiYanClockFontColor", fontColor);
        clock.put("LiYanClockBackgroudColor", backgroudColor);
        clock.putInt("LiYanClockLocationx",(int)location.getX());
        System.out.println(location.getX());
        clock.putInt("LiYanClockLocationy", (int)location.getY());
        System.out.println(location.getY());
        try {
            p.flush();
        } catch (BackingStoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
