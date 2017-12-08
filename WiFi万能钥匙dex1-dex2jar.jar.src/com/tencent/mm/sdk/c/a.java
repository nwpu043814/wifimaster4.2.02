package com.tencent.mm.sdk.c;

import android.net.Uri;
import android.provider.BaseColumns;

public final class a
{
  public static final class a
  {
    public static Object a(int paramInt, String paramString)
    {
      Object localObject = paramString;
      switch (paramInt)
      {
      }
      try
      {
        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
        localObject = null;
        for (;;)
        {
          return localObject;
          localObject = Integer.valueOf(paramString);
          continue;
          localObject = Long.valueOf(paramString);
          continue;
          localObject = Boolean.valueOf(paramString);
          continue;
          localObject = Float.valueOf(paramString);
          continue;
          localObject = Double.valueOf(paramString);
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public static final class b
    implements BaseColumns
  {
    public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/mm/sdk/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */