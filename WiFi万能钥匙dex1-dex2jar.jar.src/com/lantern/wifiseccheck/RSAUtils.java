package com.lantern.wifiseccheck;

import android.util.Base64;
import com.lantern.safecommand.service.SvpnShared;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class RSAUtils
{
  private static final int KEY_LENGTH = 1024;
  private static final int MAX_DECRYPT_BLOCK = 128;
  private static final int MAX_ENCRYPT_BLOCK = 117;
  public static int PUBLICKEY_AUTHCHECK = 2;
  public static int PUBLICKEY_WIFICHECK = 1;
  private static final String TAG = "Chiper";
  
  public static byte[] decrypt(byte[] paramArrayOfByte, PrivateKey paramPrivateKey)
  {
    int j = 0;
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(2, paramPrivateKey);
      int k = paramArrayOfByte.length;
      ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
      localByteArrayOutputStream.<init>();
      int i = 0;
      if (k - j > 0)
      {
        if (k - j > 128) {}
        for (paramPrivateKey = localCipher.doFinal(paramArrayOfByte, j, 128);; paramPrivateKey = localCipher.doFinal(paramArrayOfByte, j, k - j))
        {
          localByteArrayOutputStream.write(paramPrivateKey, 0, paramPrivateKey.length);
          i++;
          j = i * 128;
          break;
        }
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        LogUtils.d("Chiper", "decript meet execption: \n" + paramArrayOfByte.getMessage());
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
    }
    return paramArrayOfByte;
  }
  
  public static KeyPair genKey()
  {
    try
    {
      localObject1 = KeyPairGenerator.getInstance("RSA");
      ((KeyPairGenerator)localObject1).initialize(1024);
      KeyPair localKeyPair = ((KeyPairGenerator)localObject1).genKeyPair();
      localObject1 = localKeyPair;
      if (localKeyPair != null)
      {
        String str1 = new java/lang/String;
        str1.<init>(Base64.encode(localKeyPair.getPublic().getEncoded(), 0));
        String str2 = new java/lang/String;
        str2.<init>(Base64.encode(localKeyPair.getPrivate().getEncoded(), 0));
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("generated client key pair. \n pkString: \n");
        LogUtils.d("Chiper", str1 + "\n prStr:    \n" + str2);
        localObject1 = localKeyPair;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        Object localObject1;
        localNoSuchAlgorithmException.printStackTrace();
        Object localObject2 = null;
      }
    }
    return (KeyPair)localObject1;
  }
  
  public static PublicKey getPublicKeyFromString(String paramString)
  {
    try
    {
      X509EncodedKeySpec localX509EncodedKeySpec = new java/security/spec/X509EncodedKeySpec;
      localX509EncodedKeySpec.<init>(Base64.decode(paramString, 0));
      paramString = KeyFactory.getInstance("RSA").generatePublic(localX509EncodedKeySpec);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;)
      {
        LogUtils.d("Chiper", "getPublicKeyFromString meet exception: " + paramString.getMessage());
        paramString = null;
      }
    }
    catch (InvalidKeySpecException paramString)
    {
      for (;;)
      {
        LogUtils.d("Chiper", "getPublicKeyFromString meet exception: " + paramString.getMessage());
      }
    }
  }
  
  public static String getStringFromKey(Key paramKey)
  {
    return new String(Base64.encode(paramKey.getEncoded(), 0));
  }
  
  public static byte[] soEncrypt(byte[] paramArrayOfByte, int paramInt)
  {
    String str = null;
    LogUtils.d("Chiper", "soEncrypt source " + paramArrayOfByte);
    if (paramInt == Chiper.PUBLIC_KEY_CHECK) {
      paramArrayOfByte = SvpnShared.getInstance().encryptPostBody(paramArrayOfByte);
    }
    for (;;)
    {
      byte[] arrayOfByte = paramArrayOfByte;
      if (str != null) {}
      try
      {
        arrayOfByte = str.getBytes("UTF-8");
        return arrayOfByte;
        if (paramInt == Chiper.PUBLIC_KEY_CONF)
        {
          str = SvpnShared.getInstance().encryptConfPostBody(paramArrayOfByte);
          paramArrayOfByte = null;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
          arrayOfByte = paramArrayOfByte;
        }
        paramArrayOfByte = null;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/RSAUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */