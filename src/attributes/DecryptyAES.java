package attributes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DecryptyAES {
	
	public static Cipher ecipher;
	public static Cipher dcipher;
	public static byte[] buf = new byte['Ѐ'];
	  static final String HEXES = "0123456789ABCDEF";
	public DecryptyAES(String paramString) 
	  {
		SecretKeySpec localSecretKeySpec = new SecretKeySpec(getMD5(paramString), "AES");
	    setupCrypto(localSecretKeySpec);
	  }
	  
	  private void setupCrypto(SecretKey paramSecretKey)
	  {
	    byte[] arrayOfByte = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
	    



	    IvParameterSpec localIvParameterSpec = new IvParameterSpec(arrayOfByte);
	    try
	    {
	      ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	      dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	      

	      ecipher.init(1, paramSecretKey, localIvParameterSpec);
	      dcipher.init(2, paramSecretKey, localIvParameterSpec);
	    }
	    catch (Exception localException)
	    {
	      localException.printStackTrace();
	    }
	  }
	  
	  public void decrypt(InputStream paramInputStream, OutputStream paramOutputStream)
	  {
	    try
	    {
	      paramInputStream = new CipherInputStream(paramInputStream, dcipher);
	      

	      int i = 0;
	      while ((i = paramInputStream.read(buf)) >= 0) {
	        paramOutputStream.write(buf, 0, i);
	      }
	      paramOutputStream.close();
	    } catch (IOException localIOException) {
	      localIOException.printStackTrace();
	    }
	  }
	  


	  public String decrypt(String paramString)
	  {
	    try
	    {
	      return new String(dcipher.doFinal(hexToByte(paramString)), "UTF-8");
	    }
	    catch (Exception localException) {
	      localException.printStackTrace(); }
	    return null;
	  }
	  
	  public String decrypt(byte[] paramArrayOfByte)
	  {
	    try {
	      return new String(dcipher.doFinal(paramArrayOfByte), "UTF-8");
	    }
	    catch (Exception localException) {
	      localException.printStackTrace(); }
	    return null;
	  }
	  
	  private static byte[] getMD5(String paramString)
	  {
	    try {
	      byte[] arrayOfByte = paramString.getBytes("UTF-8");
	      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
	      return localMessageDigest.digest(arrayOfByte);
	    } catch (Exception localException) {}
	    return null;
	  }
	  public static String byteToHex(byte[] paramArrayOfByte)
	  {
	    if (paramArrayOfByte == null) {
	      return null;
	    }
	    String str = "";
	    for (int i = 0; i < paramArrayOfByte.length; i++) {
	      str = str + Integer.toString((paramArrayOfByte[i] & 0xFF) + 256, 16).substring(1);
	    }
	    
	    return str;
	  }
	  
	  public static byte[] hexToByte(String paramString) {
	    int i = paramString.length();
	    byte[] arrayOfByte = new byte[i / 2];
	    for (int j = 0; j < i; j += 2) {
	      arrayOfByte[(j / 2)] = ((byte)((Character.digit(paramString.charAt(j), 16) << 4) + Character.digit(paramString.charAt(j + 1), 16)));
	    }
	    return arrayOfByte;
	  }
}
