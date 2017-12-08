package com.lantern.wifilocating.push.i;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.lantern.wifilocating.push.c;
import com.lantern.wifilocating.push.d.f;
import com.lantern.wifilocating.push.d.g;
import com.lantern.wifilocating.push.util.e;
import com.lantern.wifilocating.push.util.j;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
{
  private static String a()
  {
    return d(g.d().g());
  }
  
  public static void a(String paramString)
  {
    a(paramString, 0);
  }
  
  private static void a(String paramString, int paramInt)
  {
    new a(paramString, paramInt).start();
  }
  
  private static String b()
  {
    return d(e.a(c.a()));
  }
  
  public static void b(String paramString)
  {
    a(paramString, 1);
  }
  
  private static String c()
  {
    int i = ((WifiManager)c.a().getSystemService("wifi")).getConnectionInfo().getIpAddress();
    if (i == 0) {}
    for (String str = null;; str = (i & 0xFF) + "." + (i >> 8 & 0xFF) + "." + (i >> 16 & 0xFF) + "." + (i >> 24 & 0xFF)) {
      return str;
    }
  }
  
  private static String d()
  {
    Object localObject = com.lantern.wifilocating.push.util.d.a().b();
    if (localObject != null) {}
    for (localObject = ((f)localObject).m;; localObject = null) {
      return (String)localObject;
    }
  }
  
  private static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      paramString = com.lantern.wifilocating.push.d.h.a(paramString);
    }
  }
  
  private static String e()
  {
    Object localObject = com.lantern.wifilocating.push.util.d.a().b();
    if (localObject != null) {}
    for (localObject = ((f)localObject).l;; localObject = null) {
      return (String)localObject;
    }
  }
  
  private static String e(String paramString)
  {
    localObject2 = null;
    for (;;)
    {
      try
      {
        if (!paramString.equals("{__OS__}")) {
          continue;
        }
        localObject1 = "0";
      }
      catch (Exception paramString)
      {
        com.lantern.wifilocating.push.util.h.a(paramString);
        Object localObject1 = localObject2;
        continue;
      }
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      return paramString;
      if (paramString.equals("{__IMEI__}"))
      {
        localObject1 = g.d().f();
      }
      else if (paramString.equals("{__MAC__}"))
      {
        localObject1 = g.d().g();
      }
      else if (paramString.equals("{__MAC1__}"))
      {
        localObject1 = a();
      }
      else if (paramString.equals("{__AndroidID__}"))
      {
        localObject1 = e.a(c.a());
      }
      else if (paramString.equals("{__AndroidID1__}"))
      {
        localObject1 = b();
      }
      else if (paramString.equals("{__IP__}"))
      {
        localObject1 = c();
      }
      else if (paramString.equals("{__OSVS__}"))
      {
        localObject1 = Build.VERSION.SDK;
      }
      else if (paramString.equals("{__TERM__}"))
      {
        localObject1 = Build.MODEL;
      }
      else
      {
        localObject1 = localObject2;
        if (!paramString.equals("{__AKEY__}"))
        {
          localObject1 = localObject2;
          if (!paramString.equals("{__ANAME__}")) {
            if (paramString.equals("{__LAT__}"))
            {
              localObject1 = d();
            }
            else if (paramString.equals("{__LNG__}"))
            {
              localObject1 = e();
            }
            else if (paramString.equals("{__MSP__}"))
            {
              localObject1 = f();
            }
            else if (paramString.equals("{__DHID__}"))
            {
              localObject1 = g();
            }
            else if (paramString.equals("{__SSID__}"))
            {
              localObject1 = h();
            }
            else if (paramString.equals("{__BSSID__}"))
            {
              localObject1 = i();
            }
            else if (paramString.equals("{__OS||MD5__}"))
            {
              localObject1 = d("0");
            }
            else if (paramString.equals("{__IMEI||MD5__}"))
            {
              localObject1 = d(g.d().f());
            }
            else if (paramString.equals("{__MAC||MD5__}"))
            {
              localObject1 = d(g.d().g());
            }
            else if (paramString.equals("{__MAC1||MD5__}"))
            {
              localObject1 = d(a());
            }
            else if (paramString.equals("{__AndroidID||MD5__}"))
            {
              localObject1 = d(e.a(c.a()));
            }
            else if (paramString.equals("{__AndroidID1||MD5__}"))
            {
              localObject1 = d(b());
            }
            else if (paramString.equals("{__IP||MD5__}"))
            {
              localObject1 = d(c());
            }
            else if (paramString.equals("{__OSVS||MD5__}"))
            {
              localObject1 = d(Build.VERSION.SDK);
            }
            else if (paramString.equals("{__TERM||MD5__}"))
            {
              localObject1 = d(Build.MODEL);
            }
            else if (paramString.equals("{__AKEY||MD5__}"))
            {
              localObject1 = d(null);
            }
            else if (paramString.equals("{__ANAME||MD5__}"))
            {
              localObject1 = d(null);
            }
            else if (paramString.equals("{__LAT||MD5__}"))
            {
              localObject1 = d(d());
            }
            else if (paramString.equals("{__LNG||MD5__}"))
            {
              localObject1 = d(e());
            }
            else if (paramString.equals("{__MSP||MD5__}"))
            {
              localObject1 = d(f());
            }
            else if (paramString.equals("{__DHID||MD5__}"))
            {
              localObject1 = d(g());
            }
            else if (paramString.equals("{__SSID||MD5__}"))
            {
              localObject1 = d(h());
            }
            else
            {
              localObject1 = localObject2;
              if (paramString.equals("{__BSSID||MD5__}")) {
                localObject1 = d(i());
              }
            }
          }
        }
      }
    }
  }
  
  private static String f()
  {
    Object localObject = com.lantern.wifilocating.push.util.d.a().b();
    if (localObject != null) {}
    for (localObject = ((f)localObject).k;; localObject = null) {
      return (String)localObject;
    }
  }
  
  private static String g()
  {
    Object localObject = com.lantern.wifilocating.push.util.d.a().b();
    if (localObject != null) {}
    for (localObject = ((f)localObject).b;; localObject = null) {
      return (String)localObject;
    }
  }
  
  private static String h()
  {
    if (j.d(c.a()))
    {
      localObject1 = ((WifiManager)c.a().getSystemService("wifi")).getConnectionInfo();
      if (localObject1 == null) {
        break label52;
      }
    }
    label52:
    for (Object localObject1 = j.c(((WifiInfo)localObject1).getSSID());; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {}
      for (localObject2 = "";; localObject2 = null) {
        return (String)localObject2;
      }
    }
  }
  
  private static String i()
  {
    Object localObject;
    if (j.d(c.a()))
    {
      localObject = ((WifiManager)c.a().getSystemService("wifi")).getConnectionInfo();
      if (localObject == null) {
        break label52;
      }
    }
    label52:
    for (String str = j.b(((WifiInfo)localObject).getBSSID());; str = null)
    {
      localObject = str;
      if (str == null) {}
      for (localObject = "";; localObject = null) {
        return (String)localObject;
      }
    }
  }
  
  private static final class a
    extends Thread
  {
    private JSONObject a;
    private String b;
    private int c;
    
    public a(String paramString, int paramInt)
    {
      this.b = paramString;
      this.c = paramInt;
    }
    
    private void a(String paramString)
    {
      JSONArray localJSONArray = this.a.optJSONArray(paramString);
      if (localJSONArray != null)
      {
        int j = localJSONArray.length();
        for (int i = 0; i < j; i++)
        {
          paramString = localJSONArray.optString(i);
          if (!TextUtils.isEmpty(paramString))
          {
            String str = paramString;
            if (!TextUtils.isEmpty(paramString))
            {
              Matcher localMatcher = Pattern.compile("\\{__\\w+(\\|\\|MD5)?__\\}").matcher(paramString);
              for (;;)
              {
                str = paramString;
                if (!localMatcher.find()) {
                  break;
                }
                str = localMatcher.group(0);
                paramString = paramString.replace(str, h.c(str));
              }
            }
            com.lantern.wifilocating.push.d.d.a(str);
          }
        }
      }
    }
    
    public final void run()
    {
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(this.b);
        this.a = localJSONObject;
        if (this.a != null)
        {
          if (this.c == 0) {
            a("show_urls");
          }
        }
        else {
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          continue;
          if (this.c == 1) {
            a("click_urls");
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/i/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */