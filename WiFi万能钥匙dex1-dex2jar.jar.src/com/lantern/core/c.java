package com.lantern.core;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Environment;
import com.bluefay.b.h;
import java.io.File;

public class c
  extends com.bluefay.d.a
{
  protected boolean isAppForeground;
  protected int mActivityCount;
  private a mAppLunchServer;
  protected Activity mCurActivity;
  protected Application.ActivityLifecycleCallbacks mLifecycleCb;
  protected String mProcessName;
  protected String mSeeionId;
  private o mServer;
  private q mShareValue;
  
  public static a getAPPLunchedInfoServer()
  {
    return ((c)mInstance).mAppLunchServer;
  }
  
  public static File getAppCacheDir()
  {
    return new File(((c)mInstance).getFilesDir(), "appcache");
  }
  
  public static File getAppExternalRootDir()
  {
    return new File(Environment.getExternalStorageDirectory(), "WifiMasterKey");
  }
  
  public static File getAppRootDir()
  {
    return ((c)mInstance).getFilesDir();
  }
  
  public static Activity getCurActivity()
  {
    return ((c)mInstance).mCurActivity;
  }
  
  public static String getCurSessionId()
  {
    return ((c)mInstance).mSeeionId;
  }
  
  public static c getInstance()
  {
    return (c)mInstance;
  }
  
  public static String getProcessName()
  {
    return ((c)mInstance).mProcessName;
  }
  
  public static o getServer()
  {
    return ((c)mInstance).mServer;
  }
  
  public static q getShareValue()
  {
    return ((c)mInstance).mShareValue;
  }
  
  public boolean isAppForeground()
  {
    return this.isAppForeground;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mProcessName = getCurProcessName();
    this.mServer = new o(getApplicationContext());
    h.a(this.mServer.toString());
    this.mShareValue = new q();
    this.mAppLunchServer = new a(getApplicationContext());
    File localFile = getAppCacheDir();
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    localFile = new File(Environment.getExternalStorageDirectory(), "WifiMasterKey");
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      this.mLifecycleCb = new d(this);
      registerActivityLifecycleCallbacks(this.mLifecycleCb);
      com.lantern.core.config.d.a(getAppContext()).b("heartbeat");
    }
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    if (Build.VERSION.SDK_INT >= 14) {
      unregisterActivityLifecycleCallbacks(this.mLifecycleCb);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */