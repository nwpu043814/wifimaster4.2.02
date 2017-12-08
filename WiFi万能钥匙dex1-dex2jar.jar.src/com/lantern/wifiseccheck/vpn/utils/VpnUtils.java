package com.lantern.wifiseccheck.vpn.utils;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.lantern.safecommand.service.SafeVpnService;
import com.lantern.wifiseccheck.WifiUtils;
import com.lantern.wifiseccheck.protocol.AppBaseAttr;
import com.lantern.wifiseccheck.protocol.appconf.AppConfRes;

public class VpnUtils
{
  private static final String TAG = "VpnUtils";
  private static VpnUtils instance;
  private Application app;
  private AppConfRes appConfRes;
  private String appId;
  private String channel;
  private String dhid;
  private SafeVpnService service;
  private String uhid;
  
  public static VpnUtils getInstance()
  {
    try
    {
      if (instance == null)
      {
        VpnUtils localVpnUtils = new com/lantern/wifiseccheck/vpn/utils/VpnUtils;
        localVpnUtils.<init>();
        instance = localVpnUtils;
      }
      return instance;
    }
    finally {}
  }
  
  public Application getApp()
  {
    return this.app;
  }
  
  public AppBaseAttr getAppBaseAttr(Context paramContext)
  {
    AppBaseAttr localAppBaseAttr = new AppBaseAttr();
    localAppBaseAttr.setManuf(Build.MANUFACTURER);
    localAppBaseAttr.setModel(Build.MODEL);
    localAppBaseAttr.setOsVer(Build.VERSION.RELEASE);
    localAppBaseAttr.setOsVerCode(String.valueOf(Build.VERSION.SDK_INT));
    try
    {
      Object localObject = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (localObject != null)
      {
        localAppBaseAttr.setChannel(this.channel);
        if (TextUtils.isEmpty(localAppBaseAttr.getChannel()))
        {
          String str = ((ApplicationInfo)localObject).metaData.getString("conn_chanid");
          if (!TextUtils.isEmpty(str)) {
            localAppBaseAttr.setChannel(str);
          }
        }
        localAppBaseAttr.setAppID(this.appId);
        if (TextUtils.isEmpty(localAppBaseAttr.getAppID()))
        {
          localObject = ((ApplicationInfo)localObject).metaData.getString("WK_APP_ID");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localAppBaseAttr.setAppID((String)localObject);
          }
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
    localAppBaseAttr.setDhid(getInstance().getDhid());
    localAppBaseAttr.setMac(WifiUtils.getAPMacAddress(paramContext));
    localAppBaseAttr.setSsid(WifiUtils.getWifiName(paramContext));
    localAppBaseAttr.setVersionCode(getInstance().getLocalAppVersionCode());
    localAppBaseAttr.setVersionName(getInstance().getLocalAppVersionName());
    return localAppBaseAttr;
  }
  
  public AppConfRes getAppConfRes()
  {
    return this.appConfRes;
  }
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public String getChannel()
  {
    return this.channel;
  }
  
  public String getChannelId()
  {
    String str3 = this.channel;
    String str1 = str3;
    if (TextUtils.isEmpty(str3)) {}
    try
    {
      str1 = this.app.getPackageManager().getApplicationInfo(this.app.getPackageName(), 128).metaData.get("conn_chanid").toString();
      return str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = "unkown";
      }
    }
  }
  
  public String getDhid()
  {
    return this.dhid;
  }
  
  public int getLocalAppVersionCode()
  {
    int j = -1;
    try
    {
      i = this.app.getPackageManager().getPackageInfo(this.app.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Log.e("VpnUtils", "Error while getting the local app version code.", localNameNotFoundException);
        int i = j;
      }
    }
  }
  
  public String getLocalAppVersionName()
  {
    try
    {
      String str1 = this.app.getPackageManager().getPackageInfo(this.app.getPackageName(), 0).versionName;
      return str1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Log.e("VpnUtils", "Error while getting the local app version name.", localNameNotFoundException);
        String str2 = "";
      }
    }
  }
  
  public SafeVpnService getService()
  {
    return this.service;
  }
  
  public String getUhid()
  {
    return this.uhid;
  }
  
  public void setApp(Application paramApplication)
  {
    this.app = paramApplication;
  }
  
  public void setAppConfRes(AppConfRes paramAppConfRes)
  {
    this.appConfRes = paramAppConfRes;
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setChannel(String paramString)
  {
    this.channel = paramString;
  }
  
  public void setDhid(String paramString)
  {
    this.dhid = paramString;
  }
  
  public void setService(SafeVpnService paramSafeVpnService)
  {
    this.service = paramSafeVpnService;
  }
  
  public void setUhid(String paramString)
  {
    this.uhid = paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/utils/VpnUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */