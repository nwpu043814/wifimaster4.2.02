package com.wifipay.wallet.common.info;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.wifipay.R.string;
import com.wifipay.common.a.c;
import com.wifipay.common.a.g;
import com.wifipay.common.logging.Logger;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.common.utils.f;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public enum DeviceInfo
{
  INSTANCE;
  
  private static String DEFAULT_IMSI = "000000000000000";
  private Context mContext;
  private DisplayMetrics mDM;
  private AtomicBoolean mInited = new AtomicBoolean(false);
  private String mMac;
  private TelephonyManager mTM;
  private WifiManager mWM;
  
  private DeviceInfo() {}
  
  private String getUniquePsuedoID()
  {
    String str2 = "35" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 + Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 + Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10 + Build.TYPE.length() % 10 + Build.USER.length() % 10;
    try
    {
      String str3 = Build.class.getField("SERIAL").get(null).toString();
      Object localObject = new java/util/UUID;
      ((UUID)localObject).<init>(str2.hashCode(), str3.hashCode());
      localObject = ((UUID)localObject).toString();
      return (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1 = new UUID(str2.hashCode(), "serial".hashCode()).toString();
      }
    }
  }
  
  public final String getIMEI()
  {
    try
    {
      localObject2 = this.mTM.getDeviceId();
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() > 0) {}
      }
      else
      {
        localObject1 = UUID.nameUUIDFromBytes(Settings.Secure.getString(this.mContext.getContentResolver(), "android_id").getBytes()).toString();
      }
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() > 0) {}
      }
      else
      {
        localObject2 = getUniquePsuedoID();
      }
      Logger.v("zhao == %s", new Object[] { "uniqueDeviceStr " + (String)localObject2 });
      return (String)localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
  
  public final String getMacAddress()
  {
    if (!g.a(this.mMac))
    {
      localObject3 = this.mMac;
      return (String)localObject3;
    }
    Object localObject3 = null;
    WifiInfo localWifiInfo = null;
    Object localObject1;
    if (Build.VERSION.SDK_INT > 22) {
      localObject1 = "";
    }
    for (;;)
    {
      try
      {
        Object localObject4 = Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ");
        localObject3 = new java/io/InputStreamReader;
        ((InputStreamReader)localObject3).<init>(((Process)localObject4).getInputStream());
        localObject4 = new java/io/LineNumberReader;
        ((LineNumberReader)localObject4).<init>((Reader)localObject3);
        localObject3 = localWifiInfo;
        if (localObject1 != null)
        {
          localObject3 = ((LineNumberReader)localObject4).readLine();
          localObject1 = localObject3;
          if (localObject3 == null) {
            continue;
          }
          localObject3 = ((String)localObject3).trim();
        }
        localObject1 = localObject3;
        if (!g.a((CharSequence)localObject3)) {}
      }
      catch (Exception localException1)
      {
        try
        {
          localObject1 = c.a("/sys/class/net/eth0/address").toUpperCase().substring(0, 17);
          localObject3 = localObject1;
          if (g.a((CharSequence)localObject1)) {
            localObject3 = "02:00:00:00:00";
          }
          this.mMac = ((String)localObject3);
          break;
          localException1 = localException1;
          localException1.printStackTrace();
          localObject3 = localWifiInfo;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          localObject2 = localObject3;
          continue;
        }
      }
      Object localObject2 = localObject3;
      if (f.a(this.mWM))
      {
        localWifiInfo = this.mWM.getConnectionInfo();
        localObject2 = localObject3;
        if (f.a(localWifiInfo)) {
          localObject2 = localWifiInfo.getMacAddress();
        }
      }
    }
  }
  
  public final String getMobileModel()
  {
    return Build.MODEL;
  }
  
  public final String getOsVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public final void init(Context paramContext)
  {
    if (!this.mInited.get())
    {
      this.mContext = paramContext.getApplicationContext();
      this.mTM = ((TelephonyManager)this.mContext.getSystemService("phone"));
      this.mDM = this.mContext.getResources().getDisplayMetrics();
      this.mWM = ((WifiManager)this.mContext.getSystemService("wifi"));
      this.mInited.set(true);
    }
  }
  
  public final void startCall(String paramString, SuperActivity paramSuperActivity)
  {
    Object localObject = paramString;
    if (g.a(paramString)) {
      localObject = paramSuperActivity.getResources().getString(R.string.wifipay_setting_text_number);
    }
    try
    {
      String str = ((String)localObject).replaceAll("-", "");
      paramString = new android/content/Intent;
      paramString.<init>("android.intent.action.DIAL");
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>("tel:");
      paramString.setData(Uri.parse(str));
      paramSuperActivity.startActivity(paramString);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramSuperActivity.a(paramSuperActivity.getResources().getString(R.string.wifipay_call_service_failed));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/common/info/DeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */