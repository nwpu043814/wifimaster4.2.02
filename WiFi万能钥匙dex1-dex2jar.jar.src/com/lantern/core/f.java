package com.lantern.core;

import android.content.Context;
import android.content.res.AssetManager;
import com.bluefay.b.b;
import com.bluefay.b.h;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private static f a;
  private JSONObject b;
  
  private f(Context paramContext)
  {
    paramContext = paramContext.getAssets();
    try
    {
      paramContext = paramContext.open("config.dat");
      localObject = new java/io/ByteArrayOutputStream;
      ((ByteArrayOutputStream)localObject).<init>();
      b.a(paramContext, (OutputStream)localObject);
      paramContext = new java/lang/String;
      paramContext.<init>(((ByteArrayOutputStream)localObject).toByteArray(), "UTF-8");
      if ((paramContext == null) || (paramContext.length() == 0))
      {
        h.a("Init local config OK");
        return;
      }
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        Object localObject;
        h.a(paramContext);
        paramContext = null;
        continue;
        try
        {
          localObject = new org/json/JSONObject;
          ((JSONObject)localObject).<init>(paramContext);
          this.b = ((JSONObject)localObject);
        }
        catch (JSONException paramContext)
        {
          h.a(paramContext);
        }
      }
    }
  }
  
  public static f a()
  {
    return a(c.getAppContext());
  }
  
  public static f a(Context paramContext)
  {
    if (a == null) {
      a = new f(paramContext.getApplicationContext());
    }
    return a;
  }
  
  public static String b()
  {
    return a(c.getAppContext()).a("host");
  }
  
  public static String c()
  {
    return a(c.getAppContext()).a("host");
  }
  
  public static String d()
  {
    return a(c.getAppContext()).a("channel");
  }
  
  public static boolean e()
  {
    return a(c.getAppContext()).a("multi", true);
  }
  
  public static boolean f()
  {
    return a(c.getAppContext()).a("seckey", false);
  }
  
  public static boolean g()
  {
    return a(c.getAppContext()).a("appstore", true);
  }
  
  public static int h()
  {
    return a(c.getAppContext()).b("sp_upgrade_ver");
  }
  
  public static boolean i()
  {
    return a(c.getAppContext()).a("tigerlocation", false);
  }
  
  public static boolean j()
  {
    return a(c.getAppContext()).a("ap_alias", true);
  }
  
  public static boolean k()
  {
    return a(c.getAppContext()).a("pkm", true);
  }
  
  public static boolean l()
  {
    return a(c.getAppContext()).a("feed", true);
  }
  
  public final String a(String paramString)
  {
    if ((this.b != null) && (this.b.has(paramString))) {}
    for (;;)
    {
      try
      {
        paramString = this.b.getString(paramString);
        return paramString;
      }
      catch (JSONException paramString)
      {
        h.a(paramString);
      }
      paramString = null;
    }
  }
  
  public final String a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (this.b != null)
    {
      str = paramString2;
      if (!this.b.has(paramString1)) {}
    }
    try
    {
      str = this.b.getString(paramString1);
      return str;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        h.a(paramString1);
        str = paramString2;
      }
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.b != null)
    {
      bool = paramBoolean;
      if (!this.b.has(paramString)) {}
    }
    try
    {
      bool = this.b.getBoolean(paramString);
      return bool;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        h.a(paramString);
        bool = paramBoolean;
      }
    }
  }
  
  public final int b(String paramString)
  {
    if ((this.b != null) && (this.b.has(paramString))) {}
    for (;;)
    {
      try
      {
        i = this.b.getInt(paramString);
        return i;
      }
      catch (Exception paramString)
      {
        h.a(paramString);
      }
      int i = 0;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */