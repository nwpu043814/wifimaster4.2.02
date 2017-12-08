package com.lantern.wifiseccheck;

import android.util.Log;

public class LogUtils
{
  public static final String DEFUALT_TAG = "safeCommand";
  public static boolean showLog = false;
  
  public static final void d(String paramString)
  {
    d("safeCommand", paramString);
  }
  
  public static final void d(String paramString1, String paramString2)
  {
    if (showLog) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static final void e(String paramString)
  {
    e("safeCommand", paramString);
  }
  
  public static final void e(String paramString1, String paramString2)
  {
    if (showLog) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public static final void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (showLog) {
      Log.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static final void i(String paramString)
  {
    i("safeCommand", paramString);
  }
  
  public static final void i(String paramString1, String paramString2)
  {
    if (showLog) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public static boolean isShowlog()
  {
    return showLog;
  }
  
  public static void setShowlog(boolean paramBoolean)
  {
    showLog = paramBoolean;
  }
  
  public static final void w(String paramString)
  {
    w("safeCommand", paramString);
  }
  
  public static final void w(String paramString1, String paramString2)
  {
    if (showLog) {
      Log.w(paramString1, paramString2);
    }
  }
  
  public static final void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (showLog) {
      Log.w(paramString1, paramString2, paramThrowable);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/LogUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */