package ftpcc.crypto;

import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;

/**
 * The Crypto class contains methods for cryptographic operations.
 * 
 * @author RWilmes
 * 
 */
public class Crypto {

	private static AESEngine aesEngine;

	public static void initCrypto() {
		Crypto.aesEngine = new AESEngine();
	}

	public static byte[] encrypt(String key, byte[] plainText) {
		byte[] k = key.getBytes();
		byte[] ptBytes = plainText;
		BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(
				new CBCBlockCipher(aesEngine));
		cipher.init(true, new KeyParameter(k));
		byte[] rv = new byte[cipher.getOutputSize(ptBytes.length)];
		int tam = cipher.processBytes(ptBytes, 0, ptBytes.length, rv, 0);
		try {
			cipher.doFinal(rv, tam);
		} catch (Exception ce) {
			ce.printStackTrace();
		}
		return rv;
	}

	public static byte[] decrypt(String key, byte[] cipherText) {
		byte[] k = key.getBytes();
		BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(
				new CBCBlockCipher(aesEngine));
		cipher.init(false, new KeyParameter(k));
		byte[] rv = new byte[cipher.getOutputSize(cipherText.length)];
		int tam = cipher.processBytes(cipherText, 0, cipherText.length, rv, 0);
		try {
			cipher.doFinal(rv, tam);
		} catch (Exception ce) {
			ce.printStackTrace();
		}
		return rv;
	}
}
