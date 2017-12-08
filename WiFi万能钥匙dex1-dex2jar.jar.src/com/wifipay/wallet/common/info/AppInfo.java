package com.wifipay.wallet.common.info;

import android.content.Context;
import android.content.Intent;
import java.security.cert.X509Certificate;
import java.util.Stack;

public enum AppInfo
{
  INSTANCE;
  
  private Context mContext;
  private String mDefaultCert;
  private Stack<Intent> mNextIntent = new Stack();
  private X509Certificate mX509Certificate;
  
  private AppInfo() {}
  
  public final String getAppId()
  {
    return "ZF1037";
  }
  
  public final String getAppVersion()
  {
    return "1.2.0";
  }
  
  public final int getAppVersionCode()
  {
    return 1;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public final Intent getNextIntent()
  {
    if (this.mNextIntent.empty()) {}
    for (Intent localIntent = null;; localIntent = (Intent)this.mNextIntent.pop()) {
      return localIntent;
    }
  }
  
  public final String getOSType()
  {
    return "Android";
  }
  
  public final String getPackageName()
  {
    return "com.wifipay.wallet";
  }
  
  public final String getSourceApp()
  {
    return "WIFI";
  }
  
  public final void init(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mContext.getPackageManager();
  }
  
  public final void setNextIntent(Intent paramIntent)
  {
    this.mNextIntent.push(paramIntent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/common/info/AppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */