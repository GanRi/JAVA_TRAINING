package Clock;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PropertySetDialog extends Dialog {
	private Button saveButton = null;
	private Panel fontStylePanel = new Panel();
	private Panel fontSizePanel = new Panel();
	private Panel fontColorPanel = new Panel();
	private Panel backgroudPanel = new Panel();
	private Panel buttonPanel = new Panel();
	private Choice fontColor = new Choice();
	private Choice fontStyle = new Choice();
	private Choice fontSize = new Choice();
	private Choice backgroudColor = new Choice();
	public PropertySetDialog(ClockWindow frame, CurrentTimePanel timePanel) {
		super(frame);
		this.setTitle("Set Property");
		this.setLayout(new GridLayout(5, 1));
		this.setResizable(false);
		this.createFontStylePanel();
		this.createFontSizePanel();
		this.createFontColorPanel();
		this.createBackgroudColorPanel();
		this.createButtonPanel(frame, timePanel);
		this.add(fontStylePanel);
		this.add(fontSizePanel);
		this.add(fontColorPanel);
		this.add(backgroudPanel);
		this.add(buttonPanel);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		this.setSize(300, 200);
	}

	private void createFontStylePanel() {
		this.fontStylePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		Label setFont = new Label("Set Font Style: ");
		fontStyle.add("Arial Black");
		fontStyle.add("Tohoma");
		fontStyle.add("Segoe Print");
		fontStyle.add("Christina");
		this.fontStylePanel.add(setFont);
		this.fontStylePanel.add(fontStyle);
	}

	private void createFontSizePanel() {
		this.fontSizePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		Label setFontSize = new Label("Set Font Size:");
		fontSize.add("20");
		fontSize.add("30");
		fontSize.add("40");
		fontSize.add("50");
		fontSize.add("60");
		fontSize.add("70");
		fontSize.add("80");
		this.fontSizePanel.add(setFontSize);
		this.fontSizePanel.add(fontSize);
	}

	private void createFontColorPanel() {
		this.fontColorPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		Label setFontColor = new Label("Set Font Color:");		
		fontColor.add("Black");
		fontColor.add("White");
		fontColor.add("Red");
		fontColor.add("Blue");
		fontColor.add("Yellow");
		fontColor.add("Cyan");
		this.fontColorPanel.add(setFontColor);
		this.fontColorPanel.add(this.fontColor);
	}

	private void createBackgroudColorPanel() {
		this.backgroudPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		Label setBackgroudColor = new Label("Set Backgroud Color:");
		backgroudColor.add("White");
		backgroudColor.add("Black");
		backgroudColor.add("Red");
		backgroudColor.add("Blue");
		backgroudColor.add("Yellow");
		backgroudColor.add("Cyan");
		this.backgroudPanel.add(setBackgroudColor);
		this.backgroudPanel.add(backgroudColor);
	}

	private void createButtonPanel(ClockWindow frame, CurrentTimePanel timePanel) {
		saveButton = new Button("     Set     ");
		saveButton.addActionListener(new SaveButtonListener(frame, timePanel));
		this.buttonPanel.add(saveButton);
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
		}
		return Color.BLACK;
	}
}
