package com.wifipay.common.security;

import com.wifipay.common.logging.Logger;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class Base64
{
  private static final int BASELENGTH = 128;
  private static final int EIGHTBIT = 8;
  private static final int FOURBYTE = 4;
  private static final int LOOKUPLENGTH = 64;
  private static final char PAD = '=';
  private static final int SIGN = -128;
  private static final int SIXTEENBIT = 16;
  private static final int TWENTYFOURBITGROUP = 24;
  private static final byte[] base64Alphabet;
  private static final boolean fDebug = false;
  private static final char[] lookUpBase64Alphabet;
  
  static
  {
    int k = 0;
    base64Alphabet = new byte[''];
    lookUpBase64Alphabet = new char[64];
    for (int i = 0; i < 128; i++) {
      base64Alphabet[i] = -1;
    }
    for (i = 90; i >= 65; i--) {
      base64Alphabet[i] = ((byte)(i - 65));
    }
    for (i = 122; i >= 97; i--) {
      base64Alphabet[i] = ((byte)(i - 97 + 26));
    }
    for (i = 57; i >= 48; i--) {
      base64Alphabet[i] = ((byte)(i - 48 + 52));
    }
    base64Alphabet[43] = 62;
    base64Alphabet[47] = 63;
    for (i = 0; i <= 25; i++) {
      lookUpBase64Alphabet[i] = ((char)(i + 65));
    }
    int j = 26;
    for (i = 0; j <= 51; i++)
    {
      lookUpBase64Alphabet[j] = ((char)(i + 97));
      j++;
    }
    i = 52;
    for (j = k; i <= 61; j++)
    {
      lookUpBase64Alphabet[i] = ((char)(j + 48));
      i++;
    }
    lookUpBase64Alphabet[62] = '+';
    lookUpBase64Alphabet[63] = '/';
  }
  
  public static byte[] dec(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      Object localObject1 = SecretKeyFactory.getInstance("DES");
      Object localObject2 = new javax/crypto/spec/DESKeySpec;
      ((DESKeySpec)localObject2).<init>(paramArrayOfByte1);
      localObject1 = ((SecretKeyFactory)localObject1).generateSecret((KeySpec)localObject2);
      localObject2 = Cipher.getInstance("DES/ECB/PKCS5Padding");
      paramArrayOfByte1 = new java/security/SecureRandom;
      paramArrayOfByte1.<init>();
      ((Cipher)localObject2).init(2, (Key)localObject1, paramArrayOfByte1);
      paramArrayOfByte1 = ((Cipher)localObject2).doFinal(paramArrayOfByte2);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      throw new RuntimeException(paramArrayOfByte1.getMessage(), paramArrayOfByte1);
    }
  }
  
  public static byte[] decode(String paramString)
  {
    Object localObject = null;
    if (paramString == null) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      char[] arrayOfChar = paramString.toCharArray();
      int i = removeWhiteSpace(arrayOfChar);
      paramString = (String)localObject;
      if (i % 4 == 0)
      {
        int m = i / 4;
        if (m == 0)
        {
          paramString = new byte[0];
        }
        else
        {
          byte[] arrayOfByte = new byte[m * 3];
          int k = 0;
          i = 0;
          int n;
          char c2;
          int i1;
          for (int j = 0;; j++)
          {
            if (j >= m - 1) {
              break label272;
            }
            n = k + 1;
            c1 = arrayOfChar[k];
            paramString = (String)localObject;
            if (!isData(c1)) {
              break;
            }
            k = n + 1;
            char c3 = arrayOfChar[n];
            paramString = (String)localObject;
            if (!isData(c3)) {
              break;
            }
            n = k + 1;
            char c4 = arrayOfChar[k];
            paramString = (String)localObject;
            if (!isData(c4)) {
              break;
            }
            k = n + 1;
            c2 = arrayOfChar[n];
            paramString = (String)localObject;
            if (!isData(c2)) {
              break;
            }
            int i4 = base64Alphabet[c1];
            int i3 = base64Alphabet[c3];
            i1 = base64Alphabet[c4];
            n = base64Alphabet[c2];
            int i2 = i + 1;
            arrayOfByte[i] = ((byte)(i4 << 2 | i3 >> 4));
            i4 = i2 + 1;
            arrayOfByte[i2] = ((byte)((i3 & 0xF) << 4 | i1 >> 2 & 0xF));
            i = i4 + 1;
            arrayOfByte[i4] = ((byte)(i1 << 6 | n));
          }
          label272:
          m = k + 1;
          char c1 = arrayOfChar[k];
          paramString = (String)localObject;
          if (isData(c1))
          {
            n = m + 1;
            c2 = arrayOfChar[m];
            paramString = (String)localObject;
            if (isData(c2))
            {
              k = base64Alphabet[c1];
              m = base64Alphabet[c2];
              c1 = arrayOfChar[n];
              c2 = arrayOfChar[(n + 1)];
              if ((!isData(c1)) || (!isData(c2)))
              {
                if ((isPad(c1)) && (isPad(c2)))
                {
                  paramString = (String)localObject;
                  if ((m & 0xF) == 0)
                  {
                    paramString = new byte[j * 3 + 1];
                    System.arraycopy(arrayOfByte, 0, paramString, 0, j * 3);
                    paramString[i] = ((byte)(k << 2 | m >> 4));
                  }
                }
                else
                {
                  paramString = (String)localObject;
                  if (!isPad(c1))
                  {
                    paramString = (String)localObject;
                    if (isPad(c2))
                    {
                      n = base64Alphabet[c1];
                      paramString = (String)localObject;
                      if ((n & 0x3) == 0)
                      {
                        paramString = new byte[j * 3 + 2];
                        System.arraycopy(arrayOfByte, 0, paramString, 0, j * 3);
                        paramString[i] = ((byte)(k << 2 | m >> 4));
                        paramString[(i + 1)] = ((byte)((m & 0xF) << 4 | n >> 2 & 0xF));
                      }
                    }
                  }
                }
              }
              else
              {
                n = base64Alphabet[c1];
                i1 = base64Alphabet[c2];
                j = i + 1;
                arrayOfByte[i] = ((byte)(k << 2 | m >> 4));
                arrayOfByte[j] = ((byte)((m & 0xF) << 4 | n >> 2 & 0xF));
                arrayOfByte[(j + 1)] = ((byte)(n << 6 | i1));
                paramString = arrayOfByte;
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean doCheck(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      Object localObject = KeyFactory.getInstance("RSA");
      paramString3 = decode(paramString3);
      X509EncodedKeySpec localX509EncodedKeySpec = new java/security/spec/X509EncodedKeySpec;
      localX509EncodedKeySpec.<init>(paramString3);
      localObject = ((KeyFactory)localObject).generatePublic(localX509EncodedKeySpec);
      paramString3 = Signature.getInstance("SHA1WithRSA");
      paramString3.initVerify((PublicKey)localObject);
      paramString3.update(paramString1.getBytes());
      bool = paramString3.verify(decode(paramString2));
      return bool;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        boolean bool = false;
      }
    }
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    int k = 0;
    if (paramArrayOfByte == null) {}
    int i;
    for (paramArrayOfByte = null;; paramArrayOfByte = "")
    {
      return paramArrayOfByte;
      i = paramArrayOfByte.length * 8;
      if (i != 0) {
        break;
      }
    }
    int i2 = i % 24;
    int i1 = i / 24;
    char[] arrayOfChar;
    label59:
    int i3;
    int i4;
    int i5;
    int i6;
    if (i2 != 0)
    {
      i = i1 + 1;
      arrayOfChar = new char[i * 4];
      j = 0;
      i = 0;
      if (j >= i1) {
        break label278;
      }
      m = k + 1;
      k = paramArrayOfByte[k];
      i3 = m + 1;
      m = paramArrayOfByte[m];
      i4 = paramArrayOfByte[i3];
      i5 = (byte)(m & 0xF);
      i6 = (byte)(k & 0x3);
      if ((k & 0xFFFFFF80) != 0) {
        break label237;
      }
      k = (byte)(k >> 2);
      label118:
      if ((m & 0xFFFFFF80) != 0) {
        break label249;
      }
      m = (byte)(m >> 4);
      label133:
      if ((i4 & 0xFFFFFF80) != 0) {
        break label263;
      }
    }
    label237:
    label249:
    label263:
    for (int n = (byte)(i4 >> 6);; n = (byte)(i4 >> 6 ^ 0xFC))
    {
      int i7 = i + 1;
      arrayOfChar[i] = lookUpBase64Alphabet[k];
      i = i7 + 1;
      arrayOfChar[i7] = lookUpBase64Alphabet[(m | i6 << 4)];
      k = i + 1;
      arrayOfChar[i] = lookUpBase64Alphabet[(n | i5 << 2)];
      arrayOfChar[k] = lookUpBase64Alphabet[(i4 & 0x3F)];
      j++;
      i = k + 1;
      k = i3 + 1;
      break label59;
      i = i1;
      break;
      k = (byte)(k >> 2 ^ 0xC0);
      break label118;
      m = (byte)(m >> 4 ^ 0xF0);
      break label133;
    }
    label278:
    if (i2 == 8)
    {
      j = paramArrayOfByte[k];
      k = (byte)(j & 0x3);
      if ((j & 0xFFFFFF80) == 0)
      {
        j = (byte)(j >> 2);
        m = i + 1;
        arrayOfChar[i] = lookUpBase64Alphabet[j];
        i = m + 1;
        arrayOfChar[m] = lookUpBase64Alphabet[(k << 4)];
        arrayOfChar[i] = '=';
        arrayOfChar[(i + 1)] = '=';
      }
    }
    while (i2 != 16) {
      for (;;)
      {
        paramArrayOfByte = new String(arrayOfChar);
        break;
        j = (byte)(j >> 2 ^ 0xC0);
      }
    }
    int j = paramArrayOfByte[k];
    k = paramArrayOfByte[(k + 1)];
    int m = (byte)(k & 0xF);
    n = (byte)(j & 0x3);
    if ((j & 0xFFFFFF80) == 0)
    {
      j = (byte)(j >> 2);
      label418:
      if ((k & 0xFFFFFF80) != 0) {
        break label499;
      }
    }
    label499:
    for (k = (byte)(k >> 4);; k = (byte)(k >> 4 ^ 0xF0))
    {
      i1 = i + 1;
      arrayOfChar[i] = lookUpBase64Alphabet[j];
      i = i1 + 1;
      arrayOfChar[i1] = lookUpBase64Alphabet[(k | n << 4)];
      arrayOfChar[i] = lookUpBase64Alphabet[(m << 2)];
      arrayOfChar[(i + 1)] = '=';
      break;
      j = (byte)(j >> 2 ^ 0xC0);
      break label418;
    }
  }
  
  public static X509Certificate getX509CertFromBase64Cert(String paramString)
  {
    if (paramString == null) {}
    for (paramString = null;; paramString = getX509CertFromBytes(decode(paramString))) {
      return paramString;
    }
  }
  
  private static X509Certificate getX509CertFromBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (paramArrayOfByte = null;; paramArrayOfByte = getX509CertFromInputStream(new ByteArrayInputStream(paramArrayOfByte))) {
      return paramArrayOfByte;
    }
  }
  
  private static X509Certificate getX509CertFromInputStream(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(paramInputStream);
      return paramInputStream;
    }
    catch (CertificateException paramInputStream)
    {
      for (;;)
      {
        Logger.e(paramInputStream.getMessage(), new Object[] { paramInputStream.toString() });
        paramInputStream = null;
      }
    }
  }
  
  private static boolean isData(char paramChar)
  {
    if ((paramChar < '') && (base64Alphabet[paramChar] != -1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean isPad(char paramChar)
  {
    if (paramChar == '=') {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean isWhiteSpace(char paramChar)
  {
    if ((paramChar == ' ') || (paramChar == '\r') || (paramChar == '\n') || (paramChar == '\t')) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static int removeWhiteSpace(char[] paramArrayOfChar)
  {
    int i = 0;
    int k = 0;
    if (paramArrayOfChar == null) {}
    int m;
    int j;
    do
    {
      return k;
      m = paramArrayOfChar.length;
      j = 0;
      k = i;
    } while (j >= m);
    if (!isWhiteSpace(paramArrayOfChar[j]))
    {
      k = i + 1;
      paramArrayOfChar[i] = paramArrayOfChar[j];
      i = k;
    }
    for (;;)
    {
      j++;
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/security/Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */