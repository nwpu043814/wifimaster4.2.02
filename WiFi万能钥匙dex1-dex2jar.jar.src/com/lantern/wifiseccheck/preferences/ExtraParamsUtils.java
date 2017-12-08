package com.lantern.wifiseccheck.preferences;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.lantern.wifiseccheck.item.CheckItemDNS;
import com.lantern.wifiseccheck.item.CheckItemSSL;
import com.lantern.wifiseccheck.item.CheckItemWebMd5;
import com.lantern.wifiseccheck.protocol.SecCheckExtraParams;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExtraParamsUtils
{
  private static final String PREF_KEY_EXTRA_PARAMS = "sec_check_extra_params";
  
  public static String[] getDNSUrls(Application paramApplication)
  {
    paramApplication = getExtraParams(paramApplication);
    if (paramApplication != null)
    {
      List localList = paramApplication.getDnsCheckURL();
      if ((localList != null) && (!localList.isEmpty()))
      {
        paramApplication = new String[localList.size()];
        for (int i = 0; i < localList.size(); i++) {
          paramApplication[i] = ((String)localList.get(i));
        }
      }
    }
    for (;;)
    {
      return paramApplication;
      paramApplication = CheckItemDNS.CHECK_DOMAINS;
    }
  }
  
  public static SecCheckExtraParams getExtraParams(Application paramApplication)
  {
    paramApplication = PreferencesManager.getInstance(paramApplication).getString("sec_check_extra_params", "");
    if (!TextUtils.isEmpty(paramApplication)) {}
    for (paramApplication = (SecCheckExtraParams)JSON.parseObject(paramApplication, SecCheckExtraParams.class);; paramApplication = null) {
      return paramApplication;
    }
  }
  
  public static Integer getParamsVer(Application paramApplication)
  {
    paramApplication = getExtraParams(paramApplication);
    if (paramApplication != null) {}
    for (paramApplication = paramApplication.getVer();; paramApplication = null) {
      return paramApplication;
    }
  }
  
  public static String[] getSSLUrls(Application paramApplication)
  {
    paramApplication = getExtraParams(paramApplication);
    if (paramApplication != null)
    {
      Object localObject = paramApplication.getSslCheckURL();
      if ((localObject != null) && (!((Map)localObject).isEmpty()))
      {
        paramApplication = new String[((Map)localObject).size()];
        localObject = ((Map)localObject).keySet().iterator();
        for (int i = 0; ((Iterator)localObject).hasNext(); i++) {
          paramApplication[i] = ((String)((Iterator)localObject).next());
        }
      }
    }
    for (;;)
    {
      return paramApplication;
      paramApplication = CheckItemSSL.SSL_URL;
    }
  }
  
  public static String[] getWebMd5Urls(Application paramApplication)
  {
    paramApplication = getExtraParams(paramApplication);
    if (paramApplication != null)
    {
      Object localObject = paramApplication.getWebCheckURL();
      if ((localObject != null) && (!((Map)localObject).isEmpty()))
      {
        paramApplication = new String[((Map)localObject).size()];
        localObject = ((Map)localObject).keySet().iterator();
        for (int i = 0; ((Iterator)localObject).hasNext(); i++) {
          paramApplication[i] = ((String)((Iterator)localObject).next());
        }
      }
    }
    for (;;)
    {
      return paramApplication;
      paramApplication = CheckItemWebMd5.CHECK_DOMAINS;
    }
  }
  
  public static void saveExtraParams(Application paramApplication, SecCheckExtraParams paramSecCheckExtraParams)
  {
    if (paramSecCheckExtraParams == null) {}
    for (;;)
    {
      return;
      paramSecCheckExtraParams = JSON.toJSONString(paramSecCheckExtraParams);
      PreferencesManager.getInstance(paramApplication).setString("sec_check_extra_params", paramSecCheckExtraParams);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/preferences/ExtraParamsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */