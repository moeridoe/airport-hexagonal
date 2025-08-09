package airporthexagonal.adapters.presentation;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public MainView() {
		super("Airport Schmairport");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(ViewConstants.BACKGROUND);
		setLocationRelativeTo(null);
		setPreferredSize(new Dimension(600, 800));
		setVisible(true);
	}
	
	public void setActiveView(JPanel view) {
		getContentPane().removeAll();
		
		getContentPane().add(view);
		
		pack();
	}
}
