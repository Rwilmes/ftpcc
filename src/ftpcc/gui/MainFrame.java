package ftpcc.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import ftpcc.utils.Config;

public class MainFrame extends JFrame {

	private JTabbedPane tabPanel;

	public MainFrame() {
		// configure
		this.setSize(Config.GUI_MAIN_FRAME_SIZE);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("ftpCC GUI");

		this.tabPanel = new JTabbedPane();
		this.add(this.tabPanel);
		this.tabPanel.addTab("test", new JButton("test"));

		// set visible
		this.setVisible(true);

	}

}
