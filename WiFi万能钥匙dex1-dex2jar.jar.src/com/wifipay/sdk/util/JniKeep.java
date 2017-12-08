package com.wifipay.sdk.util;

import com.shengpay.crypto.JNICrypto;

public class JniKeep
{
  public static String[] createRandomArray(int paramInt)
  {
    return JNICrypto.createRandomArray(paramInt);
  }
  
  public static int deleteEncrypt(String paramString)
  {
    return JNICrypto.deleteEncrypt(paramString);
  }
  
  public static String getTicket(String[] paramArrayOfString, int paramInt, boolean paramBoolean)
  {
    return JNICrypto.getTicket(paramArrayOfString, paramInt, paramBoolean);
  }
  
  public static void initCrypto(int paramInt, String paramString)
  {
    JNICrypto.initCrypto(paramInt, paramString);
  }
  
  public static String inputEncrypt(String paramString)
  {
    return JNICrypto.inputEncrypt(paramString);
  }
  
  public static String sdpEnc1(String paramString)
  {
    return JNICrypto.sdpEnc1(paramString);
  }
  
  public static String sdpEnc2(String paramString1, String paramString2)
  {
    return JNICrypto.sdpEnc2(paramString1, paramString2);
  }
  
  public static String sdpEnc3(String paramString1, String paramString2)
  {
    return JNICrypto.sdpEnc3(paramString1, paramString2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/util/JniKeep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */