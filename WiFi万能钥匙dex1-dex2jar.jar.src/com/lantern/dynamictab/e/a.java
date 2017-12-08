package com.lantern.dynamictab.e;

import android.os.Bundle;
import android.text.TextUtils;
import com.bluefay.b.h;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static void a()
  {
    try
    {
      com.lantern.dynamictab.b.a locala = b();
      if (locala != null) {
        a(locala);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private static void a(com.lantern.dynamictab.b.a parama)
  {
    b.a().a(parama);
    Bundle localBundle = new Bundle();
    if (parama == null) {
      localBundle.putBoolean("extra_key_config_rm", true);
    }
    for (;;)
    {
      b.a().a(localBundle, false);
      return;
      com.lantern.dynamictab.a.a();
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (TextUtils.isEmpty(paramString1)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(paramString1);
        bool1 = bool2;
        if (!"json_from_sync".equals(paramString2)) {
          continue;
        }
        bool1 = bool2;
        if (!localJSONObject.has("tab")) {
          continue;
        }
        paramString1 = com.lantern.dynamictab.b.a.a(localJSONObject.optJSONObject("tab"));
        if (paramString1 != null) {
          break label90;
        }
        com.lantern.analytics.a.e().onEvent("friend_tab_jsonerror");
        h.c("Friends: error json");
        bool1 = bool2;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        bool1 = bool2;
      }
      continue;
      label90:
      com.lantern.analytics.a.e().onEvent("dy_config_parsed");
      try
      {
        b.a().b = System.currentTimeMillis();
        paramString2 = new java/io/File;
        paramString2.<init>(d.a);
        if (paramString2.exists()) {
          paramString2.delete();
        }
        d.a(paramString1, d.a);
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
        }
      }
      a(paramString1);
      bool1 = true;
    }
  }
  
  public static com.lantern.dynamictab.b.a b()
  {
    com.lantern.analytics.a.e().onEvent("dy_get_locconfig");
    try
    {
      com.lantern.dynamictab.b.a locala = (com.lantern.dynamictab.b.a)d.a(d.a);
      if (locala != null) {
        com.lantern.analytics.a.e().onEvent("dy_got_locconfig");
      }
      return locala;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public static void c()
  {
    File localFile = new File(d.a);
    if (localFile.exists()) {
      localFile.delete();
    }
    a(null);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dynamictab/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */