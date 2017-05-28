package ftpcc.gui;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * A SetupPanel object is a GUI object used for basic configuration by the user.
 * 
 * @author RWilmes
 * 
 */
public class SetupPanel extends JPanel {

	public SetupPanel() {

		JButton testButton = new JButton("test-button");
		this.add(testButton);

		JButton connectButton = new JButton("Connect");
		this.add(connectButton);

		JButton disconnectButton = new JButton("Disconnect");
		disconnectButton.setEnabled(false);
		this.add(disconnectButton);

	}
}
