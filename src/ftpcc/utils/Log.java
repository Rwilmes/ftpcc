package ftpcc.utils;

import java.io.PrintStream;

import javax.swing.JTextArea;

public class Log {

	public static final JTextArea logTextArea = initTextArea();

	private static PrintStream logStream = System.out;
	private static PrintStream warnStream = System.out;
	private static PrintStream errorStream = System.err;

	public static String delimiter = "~";

	public static void log(String msg) {
		String printString = delimiter + " " + msg;
		logStream.println(printString);
		logTextArea.setText(logTextArea.getText() + "\n" + printString);
	}

	public static void warn(String msg) {
		warnStream.println("warning: " + msg);
	}

	public static void err(String msg) {
		errorStream.println(msg);
	}

	private static JTextArea initTextArea() {
		JTextArea temp = new JTextArea();

		return temp;
	}
}
