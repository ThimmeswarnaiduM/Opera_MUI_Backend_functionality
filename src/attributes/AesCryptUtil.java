package attributes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONException;
import org.json.JSONObject;

import com.squareup.okhttp.Response;


public class AesCryptUtil {
	  Cipher ecipher;
	  Cipher dcipher;
	  
	  public AesCryptUtil()
	  {
	    try
	    {
	      KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
	      localKeyGenerator.init(128);
	      setupCrypto(localKeyGenerator.generateKey());
	    } catch (Exception localException) {
	      localException.printStackTrace();
	    }
	  }
	  
	  public AesCryptUtil(String paramString) 
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
	  

	  byte[] buf = new byte['Ѐ'];
	  static final String HEXES = "0123456789ABCDEF";
	  
	  public void encrypt(InputStream paramInputStream, OutputStream paramOutputStream) {
	    try {
	      paramOutputStream = new CipherOutputStream(paramOutputStream, ecipher);
	      

	      int i = 0;
	      while ((i = paramInputStream.read(buf)) >= 0) {
	        paramOutputStream.write(buf, 0, i);
	      }
	      paramOutputStream.close();
	    }
	    catch (IOException localIOException) {
	      localIOException.printStackTrace();
	    }
	  }
	  


	  public String encrypt(String paramString)
	  {
	    try
	    {
	      byte[] arrayOfByte = ecipher.doFinal(paramString.getBytes("UTF-8"));
	      return byteToHex(arrayOfByte);
	    } catch (Exception localException) {
	      localException.printStackTrace(); }
	    return null;
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
	  
	  public static void main(String[] paramArrayOfString) throws IOException
	  {
	    String str1 = null;	//Encrypt Decrypt res
	    String str2 = null;	//error msg
	    String str3 = null;	//key
	    String str4 = null;	//data - text
	    String str5 = null;	//action - enc,dec
	    
	    str3 = "9A9C525B00C77455D71AD2BFBBE3F02E";
	    //str3 = "A058A1DEA4D67E14746A35282879A098";
	   /* str4 = "{\r\n" + 
				"   \"customer_name\":\"chandni\",\r\n" + 
				"   \"bill_delivery_type\":\"EMAIL\",\r\n" + 
				"   \"customer_mobile_no\":8688045150,\r\n" + 
				"   \"customer_email_id\":\"ugender.chepuri@innovacx.com\",\r\n" + 
				"   \"customer_email_subject\":\"Test\",\r\n" + 
				"   \"invoice_description\":\"Test\",\r\n" + 
				"   \"currency\":\"INR\",\r\n" + 
				"   \"valid_for\":2,\r\n" + 
				"   \"valid_type\":\"days\",\r\n" + 
				"   \"amount\":10,\r\n" + 
				"   \"merchant_reference_no\":123456987,\r\n" + 
				"   \"terms_and_conditions\":\"terms and condition\",\r\n" + 
				"   \"sms_content\":\"Pls call +91-9909652306\\/ +91-9904443499 \\/ +91-9624070999 to pay your LegalEntity_Name bill # Invoice_ID for Invoice_Amount or pay online at Pay_Link.\"\r\n" + 
				"}";*/
	    
	   /* str5 = "enc";
	    str4 = "{\r\n" + 
	    		"\"from_date\":\"20-04-2017\",\r\n" + 
	    		"\"to_date\":\"22-04-2019\"\r\n" + 
	    		"}";*/
	    str5 = "dec";
	    
	 //   str4 = "fa6cc910544fa6e7eb12ba011bc144be5ebb77ccf3503baa26220f568f820c9842a6b3c397cdc4b3160882fa8f9299f2639056bc93315ad08b9cb42f5eb6ebd5df9782df1d04d50daffbd5b92b2484d74261c4461162dd2dc55334d7e8d14d53921ecdda1498c3a14f9c50a3393e517b649666eec4269f4df559bb0056c50139b654aa03e8683abfd4d9acaaacfeeee9f8b1c5dc2f5b621d7f750420c5329547959b6d52808be3cd592f1df3e23801129539fef908c7b00ee25b218a9eb25b42171fbb8913ff9cea2985282b2474aebb176a0bca74d16ad398b8efbe3f1f172a16ab31c35faa107875237c4d2998c944d8589ce056cc88fcc2cfa6cc2998d753639767247d0bcde1c2987997aff701b4832c14fd28aeb1904d31f8502b13d0be7ea8f45be9b3f959d11c1bd20194cb7eaab715ea11dfd776d657f5515eb7c66b2f2a96f43bc1c9c6330a99ffca74636da8f71e58703f085f95de707f42f72254ecacd555c9245dbabd42c9e56b801eb94ea28cbf3395cb59aec0a340e58c38c689274f13b25879f661472b7afa9cd309ccd3ef00430cf03350d0f7e0cd541aca4e637c62d1441f528e9f5846b84f62df8ebfe60f73f397fdd485b54230a063179848977d65367bb794f593ffd6199d8b89377e0ec020c321bf30bdb1ea5ca64e77dff3c3ebfe33ac5a35dbe75f4b94cd6933912afba0656b3c86649d479e5d111084f552a26e8af268319b161f5fe3a017206f672bedb18d0000b962d2a60e8386166f775237cc7bf555b1e5ab9d22bcdbb71d3079220827470175aebc51eead30bf3b5d6b495c1961e390842ea17c99f9be90eaba268dc2fde148db13698651c141ab92fdc992ac3a9f366204c08d41c0b7ddf71488e23859843d2078a83794aed1d36c5b59fe795cc3d99177df34cb795b22dea2fe87837d9753fd09366bedd3c65af9e426ea934cfd4fc742e6401b2f021cf9cf33f6b1143bee732f86306fe8265b2bb12ec17e8b65b961e3dc64bfae6386bbba93c8dd29044162fe987e8829fce63928730ecb7def30eb15f3ce02e82342b318a51c89b8751888323aefa6ba396fb62dd13f2ca20e32c1a3ee0026aac2230d95b7fad97f7de670cd3c0c746d1b65f2c7073eb9c7c4915ab6c86fdeaff289b5a7103861d5e4aa46d51160b24acd41388dbe0cf421f07dc8b88f331681674fadd3e5d95680b8496c79782d9f16f705cf29ff8e762feaef65aa71f7b506e6bf0dd16de4c7bf650729b8de836f6ddeb620b5b7c36eca7184c1d94420e3e0bd6c4d104e7126c3f7c18005744552c9aa475a0ec21c818e63eacd30167b402bda3ba6c02211718a511f59b759c7e31f7f91502d07780d1b476156b36dd6ce";
	    str4 = "f9522d6d19d98b850c02f66b1782477591db4c970082a28cbaa06481c3e8b27f79de35860f2bf067a216892d43767771dc524725f81fb6c796cc296a32cd0abed946ba805ef233149a797ab6c8d22b01deecf9db2960f15558eebc4029d1f21c3eb1d646403fe79feec37d98abb42bd6f1a9a9ee23e992f0a027c09a0c9270f1304791a17de379e029dab3ea2003dff7c56e0c985a6631efbf686008f0ad2e17e32629bdaf4497323a7ab45e737e63736daab576cea4bce7be4368c44432b49dd599a1c5a6ea71178dfe0c0ff0e48bcb";
	   if (str2 == null) {
	      try {
	        AesCryptUtil localAesCryptUtil = new AesCryptUtil(str3);
	        
	        if (str5.equals("enc")) {
	          str1 = localAesCryptUtil.encrypt(str4);
	        } else {
	          str1 = localAesCryptUtil.decrypt(str4);
	          
	          /*JSONObject decryptJSON = new JSONObject(str1);
	          JSONObject Generate_Invoice_Result = decryptJSON.getJSONObject("Generate_Invoice_Result");
	          System.out.println("Value : "+Generate_Invoice_Result.getString("tiny_url"));
	          System.out.println("Value : "+Generate_Invoice_Result.getString("qr_code"));
	          System.out.println("Value : "+Generate_Invoice_Result.getInt("invoice_id"));*/
	        }
	      } catch (Exception localException) {
	        System.out.println("error : Exception in performing the requested operation : " + localException);
	      }
	    }
	    if (str1 != null) {
	      System.out.println(str1);
	    } else {
	      System.out.println(str2);
	    }
	  

	    
	  }
	  
	  
}
