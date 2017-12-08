package com.lantern.core;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.lantern.core.g.i;
import com.lantern.core.g.n;
import com.lantern.core.model.d;
import com.lantern.core.model.f;

public class WkSecretKeyNative
{
  static
  {
    System.loadLibrary("wkcore");
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    for (;;)
    {
      return paramString;
      try
      {
        f localf = n.b();
        paramString = a(Uri.encode(paramString), localf.b, localf.c, c.getAppContext()).trim();
      }
      catch (Exception paramString)
      {
        paramString = null;
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject = n.b();
    String str = ((f)localObject).b;
    localObject = ((f)localObject).c;
    d locald = i.a().a(paramString2);
    paramString2 = (String)localObject;
    if (locald != null)
    {
      str = locald.a();
      paramString2 = locald.b();
    }
    localObject = c.getAppContext();
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = dp(paramString1, str, paramString2, (Context)localObject);
      if (TextUtils.isEmpty(paramString1)) {}
    }
    for (paramString1 = paramString1.trim();; paramString1 = "") {
      return paramString1;
    }
  }
  
  public static String a(String paramString1, String paramString2, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = "";
    }
    for (;;)
    {
      return paramString1;
      paramString1 = md(paramString1, paramString2, paramContext);
      if ((paramString1 == null) || (paramString1.length == 0))
      {
        paramString1 = "";
      }
      else
      {
        paramString2 = new StringBuilder(paramString1.length * 2);
        int j = paramString1.length;
        for (int i = 0; i < j; i++)
        {
          int k = paramString1[i];
          paramString2.append("0123456789abcdef".charAt(k >> 4 & 0xF));
          paramString2.append("0123456789abcdef".charAt(k & 0xF));
        }
        paramString1 = paramString2.toString();
      }
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (paramString1 = "";; paramString1 = ep(paramString1, paramString2, paramString3, paramContext))
    {
      return paramString1;
      int j = paramString1.length();
      for (int i = 0; i < 16 - j % 16; i++) {
        paramString1 = paramString1 + ' ';
      }
    }
  }
  
  public static native String dp(String paramString1, String paramString2, String paramString3, Context paramContext);
  
  public static native String ep(String paramString1, String paramString2, String paramString3, Context paramContext);
  
  public static native byte[] md(String paramString1, String paramString2, Context paramContext);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/WkSecretKeyNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */