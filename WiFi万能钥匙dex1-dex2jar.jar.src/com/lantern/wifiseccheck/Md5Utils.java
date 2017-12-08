package com.lantern.wifiseccheck;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class Md5Utils
{
  protected static char[] hexDigits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static final String Digest(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = "";
    }
    for (;;)
    {
      return paramString1;
      try
      {
        paramString1 = byte2hex(MessageDigest.getInstance(paramString2).digest(paramString1.getBytes("utf-8")));
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = "";
      }
    }
  }
  
  private static void appendHexPair(byte paramByte, StringBuffer paramStringBuffer)
  {
    char c2 = hexDigits[((paramByte & 0xF0) >> 4)];
    char c1 = hexDigits[(paramByte & 0xF)];
    paramStringBuffer.append(c2);
    paramStringBuffer.append(c1);
  }
  
  private static String bufferToHex(byte[] paramArrayOfByte)
  {
    return bufferToHex(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private static String bufferToHex(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 2);
    for (int i = paramInt1; i < paramInt1 + paramInt2; i++) {
      appendHexPair(paramArrayOfByte[i], localStringBuffer);
    }
    return localStringBuffer.toString();
  }
  
  private static final String byte2hex(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {}
      for (localStringBuffer = localStringBuffer.append("0").append(str);; localStringBuffer = localStringBuffer.append(str))
      {
        i++;
        break;
      }
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  public static String getMD5(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 110
    //   2: invokestatic 48	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_3
    //   6: new 112	java/io/FileInputStream
    //   9: astore_2
    //   10: aload_2
    //   11: aload_0
    //   12: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: aload_2
    //   16: astore_0
    //   17: sipush 1024
    //   20: newarray <illegal type>
    //   22: astore 4
    //   24: aload_2
    //   25: astore_0
    //   26: aload_2
    //   27: aload 4
    //   29: invokevirtual 119	java/io/FileInputStream:read	([B)I
    //   32: istore_1
    //   33: iload_1
    //   34: ifle +40 -> 74
    //   37: aload_2
    //   38: astore_0
    //   39: aload_3
    //   40: aload 4
    //   42: iconst_0
    //   43: iload_1
    //   44: invokevirtual 123	java/security/MessageDigest:update	([BII)V
    //   47: goto -23 -> 24
    //   50: astore_3
    //   51: aload_2
    //   52: astore_0
    //   53: aload_3
    //   54: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   57: ldc 42
    //   59: astore_3
    //   60: aload_3
    //   61: astore_0
    //   62: aload_2
    //   63: ifnull +9 -> 72
    //   66: aload_2
    //   67: invokevirtual 126	java/io/FileInputStream:close	()V
    //   70: aload_3
    //   71: astore_0
    //   72: aload_0
    //   73: areturn
    //   74: aload_2
    //   75: astore_0
    //   76: aload_3
    //   77: invokevirtual 129	java/security/MessageDigest:digest	()[B
    //   80: invokestatic 131	com/lantern/wifiseccheck/Md5Utils:bufferToHex	([B)Ljava/lang/String;
    //   83: astore_3
    //   84: aload_3
    //   85: astore_0
    //   86: aload_2
    //   87: invokevirtual 126	java/io/FileInputStream:close	()V
    //   90: goto -18 -> 72
    //   93: astore_2
    //   94: aload_2
    //   95: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   98: goto -26 -> 72
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   106: aload_3
    //   107: astore_0
    //   108: goto -36 -> 72
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: ifnull +7 -> 122
    //   118: aload_0
    //   119: invokevirtual 126	java/io/FileInputStream:close	()V
    //   122: aload_2
    //   123: athrow
    //   124: astore_0
    //   125: aload_0
    //   126: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   129: goto -7 -> 122
    //   132: astore_2
    //   133: goto -19 -> 114
    //   136: astore_3
    //   137: aconst_null
    //   138: astore_2
    //   139: goto -88 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramFile	java.io.File
    //   32	12	1	i	int
    //   9	78	2	localFileInputStream	java.io.FileInputStream
    //   93	2	2	localIOException	java.io.IOException
    //   111	12	2	localObject1	Object
    //   132	1	2	localObject2	Object
    //   138	1	2	localObject3	Object
    //   5	35	3	localMessageDigest	MessageDigest
    //   50	4	3	localException1	Exception
    //   59	48	3	str	String
    //   136	1	3	localException2	Exception
    //   22	19	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   17	24	50	java/lang/Exception
    //   26	33	50	java/lang/Exception
    //   39	47	50	java/lang/Exception
    //   76	84	50	java/lang/Exception
    //   86	90	93	java/io/IOException
    //   66	70	101	java/io/IOException
    //   0	15	111	finally
    //   118	122	124	java/io/IOException
    //   17	24	132	finally
    //   26	33	132	finally
    //   39	47	132	finally
    //   53	57	132	finally
    //   76	84	132	finally
    //   0	15	136	java/lang/Exception
  }
  
  public static String sign(Map<String, String> paramMap, String paramString)
  {
    LogUtils.d("Md5Utils", "---------------key of md5:" + paramString);
    Object[] arrayOfObject = paramMap.keySet().toArray();
    Arrays.sort(arrayOfObject);
    StringBuilder localStringBuilder = new StringBuilder();
    int j = arrayOfObject.length;
    for (int i = 0; i < j; i++) {
      localStringBuilder.append((String)paramMap.get(arrayOfObject[i]));
    }
    localStringBuilder.append(paramString);
    return Digest(localStringBuilder.toString(), "MD5").toUpperCase();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/Md5Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */