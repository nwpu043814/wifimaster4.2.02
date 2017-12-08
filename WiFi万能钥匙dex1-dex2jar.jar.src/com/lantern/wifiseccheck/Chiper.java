package com.lantern.wifiseccheck;

import java.security.KeyPair;

public class Chiper
{
  public static int PUBLIC_KEY_CHECK = 1;
  public static int PUBLIC_KEY_CONF = 2;
  private static final String TAG = "Chiper";
  private int key;
  private KeyPair kp = null;
  
  public Chiper(int paramInt)
  {
    this.key = paramInt;
  }
  
  /* Error */
  public byte[] genReqeustContent(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 42	com/lantern/wifiseccheck/ClientRequest
    //   3: dup
    //   4: aload_0
    //   5: getfield 28	com/lantern/wifiseccheck/Chiper:kp	Ljava/security/KeyPair;
    //   8: invokevirtual 48	java/security/KeyPair:getPublic	()Ljava/security/PublicKey;
    //   11: invokestatic 52	com/lantern/wifiseccheck/RSAUtils:getStringFromKey	(Ljava/security/Key;)Ljava/lang/String;
    //   14: aload_1
    //   15: invokespecial 55	com/lantern/wifiseccheck/ClientRequest:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: invokestatic 61	com/alibaba/fastjson/JSON:toJSONString	(Ljava/lang/Object;)Ljava/lang/String;
    //   21: astore_1
    //   22: aload_1
    //   23: ldc 63
    //   25: invokevirtual 69	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   28: astore_1
    //   29: iload_2
    //   30: ifeq +49 -> 79
    //   33: invokestatic 75	com/lantern/wifiseccheck/GzipUtils:getInstance	()Lcom/lantern/wifiseccheck/GzipUtils;
    //   36: aload_1
    //   37: invokevirtual 79	com/lantern/wifiseccheck/GzipUtils:gZip	([B)[B
    //   40: astore_3
    //   41: aload_3
    //   42: astore_1
    //   43: ldc 12
    //   45: aload_1
    //   46: invokevirtual 83	java/lang/Object:toString	()Ljava/lang/String;
    //   49: invokestatic 88	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_1
    //   53: aload_0
    //   54: getfield 36	com/lantern/wifiseccheck/Chiper:key	I
    //   57: invokestatic 92	com/lantern/wifiseccheck/RSAUtils:soEncrypt	([BI)[B
    //   60: areturn
    //   61: astore_3
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 95	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   68: goto -16 -> 52
    //   71: astore_3
    //   72: goto -8 -> 64
    //   75: astore_3
    //   76: goto -12 -> 64
    //   79: goto -36 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	Chiper
    //   0	82	1	paramString	String
    //   0	82	2	paramBoolean	boolean
    //   40	2	3	arrayOfByte	byte[]
    //   61	4	3	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   71	1	3	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   75	1	3	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   22	29	61	java/io/UnsupportedEncodingException
    //   33	41	71	java/io/UnsupportedEncodingException
    //   43	52	75	java/io/UnsupportedEncodingException
  }
  
  public byte[] getResponseString(byte[] paramArrayOfByte)
  {
    return RSAUtils.decrypt(paramArrayOfByte, this.kp.getPrivate());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/Chiper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */