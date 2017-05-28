package ftpcc.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import ftpcc.utils.Config;

public class MainFrame extends JFrame {

	private JTabbedPane tabPane;

	private JPanel setupPanel;
	private JPanel logPanel;

	public MainFrame() {
		// configure
		this.setSize(Config.GUI_MAIN_FRAME_SIZE);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("ftpCC GUI");
		this.setMinimumSize(Config.GUI_MAIN_FRAME_SIZE);
		this.setVisible(true);

		// init mainPanel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		this.add(mainPanel);

		// init tabbed pane
		this.tabPane = new JTabbedPane(JTabbedPane.TOP);
		mainPanel.add(tabPane, BorderLayout.CENTER);

		// add tabs
		this.setupPanel = new SetupPanel();
		tabPane.insertTab("Setup", Config.ICON_SETTINGS, this.setupPanel, null,
				0);

		this.logPanel = new LogPanel();
		tabPane.insertTab("Log", Config.ICON_QUEUE, this.logPanel, null, 1);

	}

}
