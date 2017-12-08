package com.shengpay.crypto;

public class JNICrypto
{
  static
  {
    System.loadLibrary("Crypto");
  }
  
  public static native String[] createRandomArray(int paramInt);
  
  public static native int deleteEncrypt(String paramString);
  
  public static native String getTicket(String[] paramArrayOfString, int paramInt, boolean paramBoolean);
  
  public static native void initCrypto(int paramInt, String paramString);
  
  public static native String inputEncrypt(String paramString);
  
  public static native String sdpEnc1(String paramString);
  
  public static native String sdpEnc2(String paramString1, String paramString2);
  
  public static native String sdpEnc3(String paramString1, String paramString2);
  
  public static native byte[] sdpEnc4(byte[] paramArrayOfByte);
  
  public static native boolean sdpEnc5(String paramString1, String paramString2);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/shengpay/crypto/JNICrypto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */