package ftpcc;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FtpTests {

	public static String ip = FtpCredentials.ip;
	public static String user = FtpCredentials.user;
	public static String pw = FtpCredentials.pw;
	public static int port = FtpCredentials.port;

	public static void main(String[] args) throws SocketException, IOException {
		System.out.println("FTP TEST");

		FTPClient client = new FTPClient();
		System.out.println("~ connect");
		client.connect(ip, port);
		showServerReply(client);

		System.out.println("~ login");
		client.login(user, pw);
		showServerReply(client);

		System.out.println("~ list");

		FTPFile[] dirs = client.listDirectories();

		for (FTPFile d : dirs) {
			System.out.println(d.toFormattedString());
			System.out.println(
					d.getLink() + "\t" + d.getName() + "\t" + d.getSize() + "\t" + d.getTimestamp().toString());

			String subdir = "/" + d.getName() + "/";
			System.out.println("subdir: " + subdir);
			FTPFile[] files = client.listFiles(subdir);
			System.out.println("subfiles: " + files.length);
			for (FTPFile f : files) {
				System.out.println("\t" + f.getName());
			}
		}

		FTPFile[] files = client.listFiles();

		client.disconnect();
	}

	public static void listRecursive() {

	}

	private static void showServerReply(FTPClient ftpClient) {
		String[] replies = ftpClient.getReplyStrings();
		if (replies != null && replies.length > 0) {
			for (String aReply : replies) {
				System.out.println("SERVER: " + aReply);
			}
		}
	}

}
