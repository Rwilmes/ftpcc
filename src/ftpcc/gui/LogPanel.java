package ftpcc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ftpcc.utils.Log;

/**
 * The LogPanel is a special GUI panel showing logging information.
 * 
 * @author RWilmes
 * 
 */
public class LogPanel extends JPanel {

	public LogPanel() {
		JTextArea textArea = Log.logTextArea;
		this.add(textArea);

		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Log.log("blub");
				validate();
			}
		});
		this.add(clearButton);

	}
}
