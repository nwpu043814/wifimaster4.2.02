package com.lantern.safecommand.security;

import android.util.Base64;
import com.lantern.safecommand.service.SvpnShared;
import com.lantern.wifiseccheck.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

public final class a
{
  public static int a = 1;
  public static int b = 2;
  
  static
  {
    System.loadLibrary("svpn_shared");
  }
  
  public static String a(String paramString, PrivateKey paramPrivateKey)
  {
    int j = 0;
    try
    {
      byte[] arrayOfByte = Base64.decode(paramString, 0);
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(2, paramPrivateKey);
      int k = arrayOfByte.length;
      paramPrivateKey = new java/io/ByteArrayOutputStream;
      paramPrivateKey.<init>();
      int i = 0;
      if (k - j > 0)
      {
        if (k - j > 128) {}
        for (paramString = localCipher.doFinal(arrayOfByte, j, 128);; paramString = localCipher.doFinal(arrayOfByte, j, k - j))
        {
          paramPrivateKey.write(paramString, 0, paramString.length);
          i++;
          j = i * 128;
          break;
        }
      }
      paramString = paramPrivateKey.toByteArray();
      paramPrivateKey.close();
      paramString = new String(paramString, "UTF-8");
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        LogUtils.d("Chiper", "decript meet execption: \n" + paramString.getMessage());
        paramString.printStackTrace();
        paramString = null;
      }
    }
    return paramString;
  }
  
  public static String a(Key paramKey)
  {
    return new String(Base64.encode(paramKey.getEncoded(), 0));
  }
  
  public static KeyPair a()
  {
    try
    {
      localObject1 = KeyPairGenerator.getInstance("RSA");
      ((KeyPairGenerator)localObject1).initialize(1024);
      KeyPair localKeyPair = ((KeyPairGenerator)localObject1).genKeyPair();
      localObject1 = localKeyPair;
      if (localKeyPair != null)
      {
        String str = new java/lang/String;
        str.<init>(Base64.encode(localKeyPair.getPublic().getEncoded(), 0));
        localObject1 = new java/lang/String;
        ((String)localObject1).<init>(Base64.encode(localKeyPair.getPrivate().getEncoded(), 0));
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("generated client key pair. \n pkString: \n");
        LogUtils.d("Chiper", str + "\n prStr:    \n" + (String)localObject1);
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
  
  public static byte[] a(String paramString, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramInt == 1)
    {
      paramString = SvpnShared.getInstance().rsaVpnAuthEncrypt(paramString);
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = paramString.getBytes();
      }
    }
    for (;;)
    {
      return (byte[])localObject1;
      localObject1 = localObject2;
      if (paramInt == 2) {
        try
        {
          localObject1 = SvpnShared.getInstance().rsaUploadDataEncrypt(paramString.getBytes("utf-8"));
        }
        catch (UnsupportedEncodingException paramString)
        {
          paramString.printStackTrace();
          localObject1 = localObject2;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/safecommand/security/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */