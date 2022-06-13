package hust.soict.globalict.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener{
		private NumberGrid numbergrid;
		
	public ButtonListener(NumberGrid numbergrid) {
			this.numbergrid = numbergrid;
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String button = e.getActionCommand();
		if(button.charAt(0)>='0'&& button.charAt(0)<='9') {
			numbergrid.button09(button);
		}
		else if (button.equals("DEL")) {
			//handle the "DEL" case
			numbergrid.buttonDel();
		}
		else {
			//handles the "C" case
			numbergrid.buttonReset();
		}
	}
	
}