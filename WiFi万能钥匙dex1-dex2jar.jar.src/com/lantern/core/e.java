package com.lantern.core;

import android.net.Uri;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.config.StandbyIPConf;
import com.lantern.core.h.b;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public static String a(String paramString1, String paramString2)
  {
    Object localObject1 = new com.bluefay.b.d(paramString1);
    ((com.bluefay.b.d)localObject1).a(30000, 30000);
    localObject1 = ((com.bluefay.b.d)localObject1).c(paramString2);
    Object localObject2 = localObject1;
    String str;
    if (!a((String)localObject1))
    {
      str = Uri.parse(paramString1).getHost();
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = ((StandbyIPConf)com.lantern.core.config.d.a(c.getAppContext()).a(StandbyIPConf.class)).a(str);
        if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
          break label95;
        }
        h.a("ip try list is empty");
      }
    }
    for (localObject2 = localObject1;; localObject2 = localObject1)
    {
      return (String)localObject2;
      label95:
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        h.a("try ip:" + (String)localObject1);
        localObject1 = new com.bluefay.b.d(paramString1.replaceFirst(str, (String)localObject1));
        ((com.bluefay.b.d)localObject1).a(30000, 30000);
        localObject2 = ((com.bluefay.b.d)localObject1).c(paramString2);
        localObject1 = localObject2;
        if (a((String)localObject2)) {
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label19;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        label19:
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(paramString);
        bool1 = localJSONObject.has("retCd");
      }
      catch (JSONException paramString)
      {
        h.a(paramString);
        bool1 = bool2;
      }
    }
  }
  
  private static boolean a(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArrayOfByte != null)
    {
      bool1 = bool2;
      if (paramArrayOfByte.length > 4)
      {
        byte[] arrayOfByte = new byte[4];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 4);
        int i = b.a(arrayOfByte);
        if (i != 0)
        {
          bool1 = bool2;
          if (i != -1) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    return a(paramString, paramArrayOfByte, 30000, 30000);
  }
  
  public static byte[] a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject = new com.bluefay.b.d(paramString);
    ((com.bluefay.b.d)localObject).a("Content-Type", "application/octet-stream");
    ((com.bluefay.b.d)localObject).a(paramInt1, paramInt2);
    byte[] arrayOfByte = ((com.bluefay.b.d)localObject).a(paramArrayOfByte);
    if (a(arrayOfByte)) {
      localObject = arrayOfByte;
    }
    for (;;)
    {
      return (byte[])localObject;
      String str = Uri.parse(paramString).getHost();
      localObject = arrayOfByte;
      if (!TextUtils.isEmpty(str))
      {
        localObject = ((StandbyIPConf)com.lantern.core.config.d.a(c.getAppContext()).a(StandbyIPConf.class)).a(str);
        if ((localObject == null) || (((List)localObject).size() == 0))
        {
          h.a("ip try list is empty");
          localObject = arrayOfByte;
        }
        else
        {
          Iterator localIterator = ((List)localObject).iterator();
          localObject = arrayOfByte;
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localObject = (String)localIterator.next();
              h.a("try ip:" + (String)localObject);
              localObject = new com.bluefay.b.d(paramString.replaceFirst(str, (String)localObject));
              ((com.bluefay.b.d)localObject).a("Content-Type", "application/octet-stream");
              ((com.bluefay.b.d)localObject).a(paramInt1, paramInt2);
              arrayOfByte = ((com.bluefay.b.d)localObject).a(paramArrayOfByte);
              localObject = arrayOfByte;
              if (a(arrayOfByte))
              {
                localObject = arrayOfByte;
                break;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */