package com.lantern.core;

import android.content.Context;
import android.os.Build.VERSION;

public class WkSecretKeyNativeNew
{
  static
  {
    System.loadLibrary("wifi_core");
  }
  
  public static String f1()
  {
    return com.bluefay.a.c.c(c.getAppContext());
  }
  
  public static String f2()
  {
    return com.bluefay.a.c.e(c.getAppContext());
  }
  
  public static String f3()
  {
    return c.getProcessName();
  }
  
  public static String f4()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static String f5()
  {
    return c.getVersionCode();
  }
  
  public static String f6()
  {
    return c.getVersionName();
  }
  
  public static String f7()
  {
    return c.getLastUpdateTime();
  }
  
  public static native boolean s0(Context paramContext);
  
  public static native boolean s1(Context paramContext);
  
  public static native byte[] s10(byte[] paramArrayOfByte, Context paramContext);
  
  public static native byte[] s11(byte[] paramArrayOfByte, Context paramContext);
  
  public static native byte[] s12(byte[] paramArrayOfByte, boolean paramBoolean, Context paramContext);
  
  public static native byte[] s13(byte[] paramArrayOfByte, boolean paramBoolean, Context paramContext);
  
  public static native byte[] s14(byte[] paramArrayOfByte, String paramString, Context paramContext);
  
  public static native byte[] s15(byte[] paramArrayOfByte, String paramString, Context paramContext);
  
  public static native byte[] s16(byte[] paramArrayOfByte, boolean paramBoolean, Context paramContext);
  
  public static native byte[] s17(byte[] paramArrayOfByte, boolean paramBoolean, Context paramContext);
  
  public static native String s2(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Context paramContext);
  
  public static native boolean s3(String paramString, Context paramContext);
  
  public static native String s4(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Context paramContext);
  
  public static native String s5(String paramString, Context paramContext);
  
  public static native String s6(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte, Context paramContext);
  
  public static native String s7(Context paramContext);
  
  public static native byte[] s8(byte[] paramArrayOfByte, Context paramContext);
  
  public static native boolean s9(String paramString, Context paramContext);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/WkSecretKeyNativeNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */