package hust.soict.globalict.swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class LookAndFeelDemo extends JFrame{

	public LookAndFeelDemo() {
		addDemoComponents();
		addLookAndFeelComboBox();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(380,100);
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	
	void addDemoComponents() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("Label: "));
		cp.add(new JTextField("Text field"));
		cp.add(new JRadioButton("Radio button"));
		cp.add(new JButton("Button"));
	}
	
	void addLookAndFeelComboBox() {
		Container cp = getContentPane();
		cp.add(new JLabel("Change Look and Feel Here: "));
		
		//create the combo box
		LookAndFeelInfo[] lafInfos =UIManager.getInstalledLookAndFeels();
		
		String[] lafNames = new String[7];
		//System.out.println(lafInfos.length);
		int i=0;
		for(i=0;i<lafInfos.length;i++) {
			lafNames[i] = lafInfos[i].getName();
		}
		lafNames[5] ="Java";
		lafNames[6] ="System";
//		for(i=0;i<lafNames.length;i++) {
//			System.out.println(lafNames[i] );
//		}
		JComboBox cbLookAndFeel = new JComboBox(lafNames);
		cp.add(cbLookAndFeel);
		
		//handle change look and feel
		JFrame frame = this;
		cbLookAndFeel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				int index = cbLookAndFeel.getSelectedIndex();
				if(index<5) {
					try {
						UIManager.setLookAndFeel((lafInfos[index].getClassName()));
					}catch(Exception e) {
						e.printStackTrace();
					}
					setTitle(lafInfos[index].getName()+ " Look And Feel");
				}
				else if(index==5) {
					try {
						UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
					}catch(Exception e) {
						e.printStackTrace();
					}
					setTitle("Java Look And Feel");
				}
				else if(index ==6) {
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					}catch(Exception e) {
						e.printStackTrace();
					}
					setTitle("System Look And Feel");
				}
				
				SwingUtilities.updateComponentTreeUI(frame);
			}
		}
				
		);
		
	}
	public static void main (String[] args) {
		new LookAndFeelDemo();
	}

}
