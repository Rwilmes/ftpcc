package ftpcc.utils;

import java.io.PrintStream;

public class Log {

	private static PrintStream logStream = System.out;
	private static PrintStream warnStream = System.out;
	private static PrintStream errorStream = System.err;

	public static String delimiter = "~";

	public static void log(String msg) {
		logStream.println(delimiter + " " + msg);
	}

	public static void warn(String msg) {
		warnStream.println("warning: " + msg);
	}

	public static void err(String msg) {
		errorStream.println(msg);
	}
}
