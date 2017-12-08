package com.bluefay.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import com.bluefay.b.h;
import com.jiangwei.Wraper;
import java.util.Iterator;
import java.util.List;

public class a
  extends Application
{
  protected static a mInstance;
  protected String mCustomTag;
  protected boolean mDebugable;
  protected long mFirstInstallTime;
  protected boolean mIsSystemApp;
  protected long mLastUpdateTime;
  protected c mObsever;
  protected int mVersionCode;
  protected String mVersionName;
  
  public static void addListener(b paramb)
  {
    mInstance.mObsever.a(paramb);
  }
  
  public static void dispatch(Message paramMessage)
  {
    mInstance.mObsever.b(paramMessage, 0L);
  }
  
  public static void dispatch(Message paramMessage, long paramLong)
  {
    mInstance.mObsever.b(paramMessage, paramLong);
  }
  
  public static void dispatchThreadMessage(Message paramMessage)
  {
    mInstance.mObsever.a(paramMessage, 0L);
  }
  
  public static void dispatchThreadMessage(Message paramMessage, long paramLong)
  {
    mInstance.mObsever.a(paramMessage, paramLong);
  }
  
  public static Context getAppContext()
  {
    return mInstance.getApplicationContext();
  }
  
  public static a getApplication()
  {
    return mInstance;
  }
  
  public static String getCurProcessName()
  {
    int i = Process.myPid();
    Object localObject = ((ActivityManager)getAppContext().getSystemService("activity")).getRunningAppProcesses().iterator();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
    } while (localRunningAppProcessInfo.pid != i);
    for (localObject = localRunningAppProcessInfo.processName;; localObject = null) {
      return (String)localObject;
    }
  }
  
  public static long getFirstInstallTime()
  {
    return mInstance.mFirstInstallTime;
  }
  
  public static long getLastUpdateTime()
  {
    return mInstance.mLastUpdateTime;
  }
  
  public static String getMetaValue(String paramString)
  {
    Object localObject2 = null;
    if (paramString == null)
    {
      localObject1 = localObject2;
      return (String)localObject1;
    }
    Object localObject1 = getAppContext();
    for (;;)
    {
      try
      {
        localObject1 = ((Context)localObject1).getPackageManager().getApplicationInfo(((Context)localObject1).getPackageName(), 128);
        if (localObject1 == null) {
          break label59;
        }
        localBundle = ((ApplicationInfo)localObject1).metaData;
        localObject1 = localObject2;
        if (localBundle == null) {
          break;
        }
        localObject1 = localBundle.getString(paramString);
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        localObject1 = localObject2;
      }
      break;
      label59:
      Bundle localBundle = null;
    }
  }
  
  public static c getObsever()
  {
    return mInstance.mObsever;
  }
  
  public static int getVersionCode()
  {
    return mInstance.mVersionCode;
  }
  
  public static String getVersionName()
  {
    return mInstance.mVersionName;
  }
  
  private void init()
  {
    mInstance = this;
    setLogParameters();
    initVersionInfo(this);
    h.a("versionName:" + this.mVersionName + " versioncode:" + this.mVersionCode);
    this.mObsever = new c();
  }
  
  private void initVersionInfo(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    for (;;)
    {
      try
      {
        paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 16384);
        this.mVersionName = paramContext.versionName;
        this.mVersionCode = paramContext.versionCode;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      try
      {
        this.mFirstInstallTime = paramContext.firstInstallTime;
        this.mLastUpdateTime = paramContext.lastUpdateTime;
        return;
      }
      catch (Exception paramContext)
      {
        h.a(paramContext);
      }
    }
  }
  
  public static boolean isDebugable()
  {
    return mInstance.mDebugable;
  }
  
  public static boolean isSystemApp()
  {
    return mInstance.mIsSystemApp;
  }
  
  public static void removeListener(b paramb)
  {
    mInstance.mObsever.b(paramb);
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    Wraper.hookPMS(paramContext);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    h.a("onConfigurationChanged");
  }
  
  public void onCreate()
  {
    super.onCreate();
    init();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    h.a("onLowMemory");
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    h.a("onTerminate");
  }
  
  protected void setLogParameters()
  {
    ApplicationInfo localApplicationInfo = getApplicationInfo();
    boolean bool1;
    if (localApplicationInfo != null)
    {
      if ((localApplicationInfo.flags & 0x2) == 0) {
        break label138;
      }
      bool1 = true;
      if (!bool1) {
        break label143;
      }
      h.a(1);
      label31:
      if (this.mCustomTag == null)
      {
        String str = localApplicationInfo.className;
        int i = str.lastIndexOf('.');
        if (i >= 0) {
          this.mCustomTag = str.substring(i + 1);
        }
      }
      this.mDebugable = bool1;
      if ((localApplicationInfo == null) || ((localApplicationInfo.flags & 0x1) <= 0)) {
        break label150;
      }
    }
    label138:
    label143:
    label150:
    for (boolean bool2 = true;; bool2 = false)
    {
      this.mIsSystemApp = bool2;
      h.d(this.mCustomTag);
      h.b("isDebug=%s, tag=%s, isSystemApp=%s", new Object[] { Boolean.valueOf(bool1), this.mCustomTag, Boolean.valueOf(this.mIsSystemApp) });
      return;
      bool1 = false;
      break;
      h.a(2);
      break label31;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */