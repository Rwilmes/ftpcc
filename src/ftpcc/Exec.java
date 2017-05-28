package ftpcc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import ftpcc.crypto.Crypto;
import ftpcc.utils.IO;

/**
 * Used for executing the ftpcc program.
 * 
 * @author RWilmes
 *
 */
public class Exec {

	public static String testFilePlain = "data/DSC_6173.jpg";
	public static String testFileCrypt1 = "data/crypt1.dat";
	public static String testFileCrypt2 = "data/crypt2.dat";

	public static String key1 = "1234567812345678";
	public static String key2 = "8765432187654321";
	
	public static void main(String[] args) throws IOException {
		Crypto.initCrypto();
		System.out.println("Test!");

		File f = new File(testFilePlain);

//		FileInputStream f_in = new FileInputStream(f);
//		byte[] data = new byte[(int) f.length()];
//		f_in.read(data);

		byte[] data = IO.readFile(testFilePlain);
		
		byte[] cryptData1 = Crypto.encrypt(key1, data);
		byte[] cryptData2 = Crypto.encrypt(key2, data);
		
		
		
		len(data);
		len(cryptData1);
		
		
		IO.writeFile(testFileCrypt1, cryptData1, false);
		IO.writeFile(testFileCrypt2, cryptData2, true);
		
		

		byte[] data1Crypt = IO.readFile(testFileCrypt1);
		byte[] data2Crypt = IO.readFile(testFileCrypt2);
		
		byte[] data1decrypt = Crypto.decrypt(key1, data1Crypt);
		byte[] data2decrypt = Crypto.decrypt(key2, data2Crypt);
		
		
		IO.writeFile("data/1-1.jpg", data1decrypt, true);
		IO.writeFile("data/2-2.jpg", data2decrypt, true);
		
		
		
		data1decrypt = Crypto.decrypt(key2, data1Crypt);
		data2decrypt = Crypto.decrypt(key1, data2Crypt);
		
		
		IO.writeFile("data/1-2.jpg", data1decrypt, true);
		IO.writeFile("data/2-1.jpg", data2decrypt, true);
	}
	
	
	
	public static void len(byte[] data) {
		System.out.println(data.length);
	}
}
