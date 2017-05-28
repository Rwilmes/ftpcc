package ftpcc.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import ftpcc.utils.Config;

public class MainFrame extends JFrame {

	private JTabbedPane tabPane;

	private JPanel setupPanel;

	public MainFrame() {
		// configure
		this.setSize(Config.GUI_MAIN_FRAME_SIZE);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("ftpCC GUI");
		this.setMinimumSize(Config.GUI_MAIN_FRAME_SIZE);
		this.setVisible(true);

		this.tabPane = new JTabbedPane(JTabbedPane.TOP);

		this.setupPanel = new JPanel();
		this.setupPanel.add(new JButton("test-button"));

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		this.add(mainPanel);

		// init tabbed pane
		tabPane = new JTabbedPane(JTabbedPane.TOP);
		tabPane.insertTab("Setup", Config.ICON_SETTINGS, this.setupPanel, null,
				0);

		mainPanel.add(tabPane, BorderLayout.CENTER);

	}

}
