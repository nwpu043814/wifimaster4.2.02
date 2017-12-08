package com.lantern.browser.c;

import android.text.TextUtils;
import com.bluefay.b.h;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static String a;
  private static int b;
  private static Map<String, String> c = new HashMap();
  private static Map<String, String> d = new HashMap();
  
  public static final void a()
  {
    b = 0;
  }
  
  public static final void a(String paramString)
  {
    b = 10;
    String str = UUID.randomUUID().toString();
    d.put(paramString, str);
    a(paramString, "broncs", null, (String)c.get(paramString), str);
  }
  
  public static final void a(String paramString1, String paramString2)
  {
    if (b == 4) {
      b = 1;
    }
    for (;;)
    {
      return;
      if ((b == 1) && (!TextUtils.isEmpty(a)))
      {
        b = 5;
        a(a, "brone", paramString2, (String)c.get(a), null);
      }
      a = paramString1;
      b = 1;
      String str = UUID.randomUUID().toString();
      c.put(paramString1, str);
      a(paramString1, "brons", paramString2, str, null);
    }
  }
  
  public static final void a(String paramString1, String paramString2, String paramString3)
  {
    b = 5;
    a(paramString1, "brone", paramString2, (String)c.get(paramString1), null, paramString3);
  }
  
  private static final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a(paramString1, paramString2, paramString3, paramString4, paramString5, null);
  }
  
  private static final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramString1);
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put("page", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localHashMap.put("news", paramString4);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      localHashMap.put("cmt", paramString5);
    }
    if (!TextUtils.isEmpty(paramString6)) {
      localHashMap.put("vp", paramString6);
    }
    paramString3 = new JSONObject(localHashMap).toString();
    paramString1 = new HashMap();
    paramString1.put("ext", paramString3);
    paramString1.put("funId", paramString2);
    paramString1.put("cts", String.valueOf(System.currentTimeMillis()));
    for (;;)
    {
      try
      {
        paramString2 = new org/json/JSONObject;
        paramString2.<init>(paramString1);
        paramString1 = new org/json/JSONArray;
        paramString1.<init>();
        h.a(paramString2);
      }
      catch (Exception paramString2)
      {
        try
        {
          paramString1.put(paramString2);
          if ((paramString1 != null) && (paramString1.length() > 0)) {
            com.lantern.analytics.a.e().a("005012", paramString1);
          }
          return;
        }
        catch (Exception paramString2)
        {
          for (;;) {}
        }
        paramString2 = paramString2;
        paramString1 = null;
      }
    }
  }
  
  public static final void b(String paramString)
  {
    b = 11;
    a(paramString, "bronce", null, (String)c.get(paramString), (String)d.get(paramString));
  }
  
  public static final void b(String paramString1, String paramString2)
  {
    b = 4;
    a(paramString1, "bronr", paramString2, (String)c.get(paramString1), null);
  }
  
  public static final void c(String paramString1, String paramString2)
  {
    if (b == 1)
    {
      b = 3;
      a(paramString1, "bronl", paramString2, (String)c.get(paramString1), null);
    }
  }
  
  public static final void d(String paramString1, String paramString2)
  {
    if ((b == 5) || (b == 11))
    {
      a = paramString1;
      b = 2;
      String str = UUID.randomUUID().toString();
      c.put(paramString1, str);
      a(paramString1, "brons", paramString2, str, null);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */