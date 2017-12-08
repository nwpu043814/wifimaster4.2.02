package com.lantern.wifiseccheck.vpn.utils;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.protocol.AuthProtocolResult;
import com.lantern.wifiseccheck.protocol.appconf.AppConfRes;
import com.lantern.wifiseccheck.vpn.VpnConstants.Action;
import com.lantern.wifiseccheck.vpn.data.GlobalPreference;

public class UserUtils
{
  private static final String TAG = "UserUtils";
  
  public static AppConfRes getAppParams(Context paramContext)
  {
    paramContext = null;
    String str = GlobalPreference.getInstance(VpnUtils.getInstance().getApp()).getString("app_params" + VpnUtils.getInstance().getDhid(), null);
    if (!TextUtils.isEmpty(str)) {
      paramContext = (AppConfRes)JSON.parseObject(str, AppConfRes.class);
    }
    for (;;)
    {
      return paramContext;
      LogUtils.d("UserUtils", "result is null");
    }
  }
  
  public static AuthProtocolResult getAuthResult(Context paramContext)
  {
    paramContext = null;
    String str = GlobalPreference.getInstance(VpnUtils.getInstance().getApp()).getString("system_params" + VpnUtils.getInstance().getDhid(), null);
    if (!TextUtils.isEmpty(str)) {
      paramContext = (AuthProtocolResult)JSON.parseObject(str, AuthProtocolResult.class);
    }
    for (;;)
    {
      return paramContext;
      LogUtils.d("UserUtils", "result is null");
    }
  }
  
  public static String getDhid(Context paramContext)
  {
    return GlobalPreference.getInstance(paramContext).getString("dhid", "");
  }
  
  public static boolean getLog(Context paramContext)
  {
    return GlobalPreference.getInstance(paramContext).getBoolean("log", true);
  }
  
  public static String getSsid(Context paramContext)
  {
    return GlobalPreference.getInstance(paramContext).getString("ssid", "");
  }
  
  public static String getUhid(Context paramContext)
  {
    return GlobalPreference.getInstance(paramContext).getString("uhid", "");
  }
  
  public static boolean isScreenOriatationLandscape(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().orientation == 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean isVpnStart(Context paramContext)
  {
    return GlobalPreference.getInstance(paramContext).getBoolean("is_vpn_start", false);
  }
  
  public static boolean isVpnStartAuto(Context paramContext)
  {
    return GlobalPreference.getInstance(paramContext).getBoolean("is_vpn_start_auto", false);
  }
  
  public static void setAppParams(Context paramContext, AppConfRes paramAppConfRes1, AppConfRes paramAppConfRes2)
  {
    int j;
    int i;
    if (paramAppConfRes1 != null)
    {
      paramContext = new Intent(VpnConstants.Action.ACTION_MAIN_PARAMS_CHANGED);
      j = 0;
      if (TextUtils.isEmpty(paramAppConfRes1.getFilterRule())) {
        break label151;
      }
      paramContext.putExtra(VpnConstants.Action.EXTRA_FILTER_RULE_CHANGE, true);
      i = 1;
      if (TextUtils.isEmpty(paramAppConfRes1.getProtectAppList())) {
        break label172;
      }
      j = i + 1;
      paramContext.putExtra(VpnConstants.Action.EXTRA_APPLIST_CHANGE, true);
    }
    for (;;)
    {
      i = j;
      if (paramAppConfRes2 != null)
      {
        i = j;
        if (paramAppConfRes2.isNeedShowAppDownloadButton() != paramAppConfRes1.isNeedShowAppDownloadButton()) {
          i = j + 1;
        }
      }
      if ((GlobalPreference.getInstance(VpnUtils.getInstance().getApp()).setString("app_params" + VpnUtils.getInstance().getDhid(), JSON.toJSONString(paramAppConfRes1))) && (i > 0))
      {
        LogUtils.d("UserUtils", "params change send intent");
        VpnUtils.getInstance().getApp().sendBroadcast(paramContext);
      }
      return;
      label151:
      i = j;
      if (paramAppConfRes2 == null) {
        break;
      }
      paramAppConfRes1.setFilterRule(paramAppConfRes2.getFilterRule());
      i = j;
      break;
      label172:
      j = i;
      if (paramAppConfRes2 != null)
      {
        paramAppConfRes1.setProtectAppList(paramAppConfRes2.getProtectAppList());
        j = i;
      }
    }
  }
  
  public static void setAuthResult(AuthProtocolResult paramAuthProtocolResult, Context paramContext)
  {
    LogUtils.d("UserUtils", "setAuthResult");
    if (paramAuthProtocolResult != null) {
      GlobalPreference.getInstance(VpnUtils.getInstance().getApp()).setString("system_params" + VpnUtils.getInstance().getDhid(), JSON.toJSONString(paramAuthProtocolResult));
    }
  }
  
  public static void setDhid(String paramString, Context paramContext)
  {
    GlobalPreference.getInstance(paramContext).setString("dhid", paramString);
  }
  
  public static void setLog(boolean paramBoolean, Context paramContext)
  {
    GlobalPreference.getInstance(paramContext).setBoolean("log", paramBoolean);
  }
  
  public static void setSsid(String paramString, Context paramContext)
  {
    GlobalPreference.getInstance(paramContext).setString("ssid", paramString);
  }
  
  public static void setUhid(String paramString, Context paramContext)
  {
    GlobalPreference.getInstance(paramContext).setString("uhid", paramString);
  }
  
  public static void setVpnStart(boolean paramBoolean, Context paramContext)
  {
    GlobalPreference.getInstance(paramContext).setBoolean("is_vpn_start", paramBoolean);
  }
  
  public static void setVpnStartAuto(boolean paramBoolean, Context paramContext)
  {
    GlobalPreference.getInstance(paramContext).setBoolean("is_vpn_start_auto", paramBoolean);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/utils/UserUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */