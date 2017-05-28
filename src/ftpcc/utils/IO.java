package ftpcc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;

/**
 * Utility class for IO operations.
 * 
 * @author RWilmes
 *
 */
public class IO {

	/** Reads a file from the given path and returns the data as byte[]. **/
	public static byte[] readFile(String path) throws IOException {
		File f = new File(path);
		FileInputStream f_in = new FileInputStream(f);
		byte[] data = new byte[(int) f.length()];
		f_in.read(data);
		f_in.close();

		return data;
	}

	/** Writes the given byte[] data to the path. **/
	public static void writeFile(String path, byte[] data, boolean force)
			throws IOException {
		File f = new File(path);

		if (f.exists() && f.isDirectory()) {
			Log.warn("destination already exists and is a directory... skipping");
			return;
		}

		if (f.exists() && f.isFile()) {
			if (force) {
				Log.warn("file already exists... overwrite");
			} else {
				Log.warn("file already exists... skipping");
				return;
			}
		}

		FileOutputStream f_out = new FileOutputStream(f);
		f_out.write(data);
		f_out.close();
	}

	/** Reads an ImageIcon from the given path. **/
	public static ImageIcon readImageIcon(String path) {
		return new ImageIcon(path);
	}
}
