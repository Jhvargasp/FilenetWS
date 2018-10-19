package mx.com.metlife.encrypt;

import java.util.ResourceBundle;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

public class Blowfish {
	private Logger log = Logger.getLogger(getClass());
	String llave = "";

	public Blowfish() {
		ResourceBundle localResourceBundle = ResourceBundle.getBundle("WcmApiConfig");
		llave = localResourceBundle.getString("KEY");
	}

	public String encode(String paramString) throws Exception {
		StringBuffer localStringBuffer = new StringBuffer();
		Base64 localBase64 = new Base64();
		if (this.llave == null) {
			this.log.debug("Key not detected, used value by default [masterkey]");
			this.llave = "masterkey";
		}
		byte[] arrayOfByte1 = localBase64.decode(this.llave.getBytes());
		SecretKeySpec localSecretKeySpec = new SecretKeySpec(arrayOfByte1, "Blowfish");
		Cipher localCipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		localCipher.init(1, localSecretKeySpec);
		byte[] arrayOfByte2 = paramString.getBytes();
		byte[] arrayOfByte3 = localCipher.doFinal(arrayOfByte2);
		byte[] arrayOfByte4 = localBase64.encode(arrayOfByte3);
		localStringBuffer = new StringBuffer();
		for (int i = 0; i < arrayOfByte4.length; i++) {
			localStringBuffer.append((char) arrayOfByte4[i]);
		}
		return localStringBuffer.toString();
	}

	public String decode(String paramString) throws Exception {
		try {
			StringBuffer localStringBuffer = new StringBuffer();
			Base64 localBase64 = new Base64();
			byte[] arrayOfByte1 = localBase64.decode(this.llave.getBytes());
			SecretKeySpec localSecretKeySpec = new SecretKeySpec(arrayOfByte1, "Blowfish");
			Cipher localCipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
			localCipher.init(2, localSecretKeySpec);
			byte[] arrayOfByte2 = paramString.getBytes();
			byte[] arrayOfByte3 = localBase64.decode(arrayOfByte2);
			byte[] arrayOfByte4 = localCipher.doFinal(arrayOfByte3);
			localStringBuffer = new StringBuffer();
			for (int i = 0; i < arrayOfByte4.length; i++) {
				localStringBuffer.append((char) arrayOfByte4[i]);
			}
			return localStringBuffer.toString();
		} catch (Exception localException) {
			this.log.debug(localException);
			throw new Exception("Decode Password Exception");
		}
	}
	
	public String decodeBytes(byte[] arrayOfByte2) throws Exception {
		try {
			StringBuffer localStringBuffer = new StringBuffer();
			Base64 localBase64 = new Base64();
			byte[] arrayOfByte1 = localBase64.decode(this.llave.getBytes());
			SecretKeySpec localSecretKeySpec = new SecretKeySpec(arrayOfByte1, "Blowfish");
			Cipher localCipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
			localCipher.init(2, localSecretKeySpec);
			//byte[] arrayOfByte2 = paramString.getBytes();
			byte[] arrayOfByte3 = localBase64.decode(arrayOfByte2);
			byte[] arrayOfByte4 = localCipher.doFinal(arrayOfByte3);
			localStringBuffer = new StringBuffer();
			for (int i = 0; i < arrayOfByte4.length; i++) {
				localStringBuffer.append((char) arrayOfByte4[i]);
			}
			return localStringBuffer.toString();
		} catch (Exception localException) {
			this.log.debug(localException);
			throw new Exception("Decode Password Exception");
		}
	}

	public static void main(String[] args) throws Exception {
		Blowfish blowfish = new Blowfish();
		String encoded=blowfish.encode("sistemas2012");
		System.out.println(encoded);
		System.out.println("####################");
		System.out.println(blowfish.decode(encoded));
		
	}
}
