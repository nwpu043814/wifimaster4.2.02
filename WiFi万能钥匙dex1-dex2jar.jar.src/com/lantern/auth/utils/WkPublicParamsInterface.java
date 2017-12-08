package com.lantern.auth.utils;

import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.g.j;
import com.lantern.core.k;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.o;
import com.lantern.core.p;

public class WkPublicParamsInterface
{
  private String getSimOperatorName()
  {
    for (;;)
    {
      try
      {
        str1 = ((TelephonyManager)c.getInstance().getSystemService("phone")).getSubscriberId();
        if (TextUtils.isEmpty(str1)) {
          continue;
        }
        if ((str1.startsWith("46000")) || (str1.startsWith("46002"))) {
          continue;
        }
        if (!str1.startsWith("46001")) {
          continue;
        }
        str1 = "Unicom";
      }
      catch (Exception localException)
      {
        String str1;
        h.a(localException);
        String str2 = "Other";
        continue;
      }
      return str1;
      if (!str1.startsWith("46003")) {
        continue;
      }
      str1 = "ChinaNet";
      continue;
      str1 = "CMCC";
    }
  }
  
  public String getcltInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    for (;;)
    {
      return paramString;
      if (paramString.equals("vcode"))
      {
        paramString = String.valueOf(k.b(c.getInstance()));
      }
      else if (paramString.equals("vname"))
      {
        paramString = k.a(c.getInstance());
      }
      else if (paramString.equals("chanid"))
      {
        paramString = k.l(c.getInstance());
      }
      else if (paramString.equals("appid"))
      {
        paramString = c.getServer().k();
      }
      else if (paramString.equals("uhid"))
      {
        paramString = p.c("");
      }
      else if (paramString.equals("dhid"))
      {
        paramString = p.b("");
      }
      else if (paramString.equals("userToken"))
      {
        paramString = p.f(c.getInstance());
      }
      else if (paramString.equals("ii"))
      {
        paramString = k.c(c.getInstance());
      }
      else if (paramString.equals("mac"))
      {
        paramString = k.e(c.getInstance());
      }
      else if (paramString.equals("ssid"))
      {
        paramString = j.b(c.getInstance()).a();
        h.a("getcltInfo ssid:" + paramString, new Object[0]);
      }
      else if (paramString.equals("bssid"))
      {
        paramString = j.b(c.getInstance()).b();
        h.a("getcltInfo bssid:" + paramString, new Object[0]);
      }
      else if (paramString.equals("ph"))
      {
        paramString = p.c(c.getInstance());
      }
      else if (paramString.equals("nick"))
      {
        paramString = p.d(c.getInstance());
      }
      else if ("osver".equals(paramString))
      {
        paramString = String.valueOf(Build.VERSION.SDK_INT);
      }
      else if ("netmode".equals(paramString))
      {
        paramString = k.n(c.getInstance());
      }
      else if ("simop".equals(paramString))
      {
        paramString = getSimOperatorName();
      }
      else if ("manufacturer".equals(paramString))
      {
        paramString = Build.MANUFACTURER;
      }
      else if ("osvername".equals(paramString))
      {
        paramString = Build.VERSION.RELEASE;
      }
      else if ("model".equals(paramString))
      {
        paramString = Build.MODEL;
      }
      else if ("device".equals(paramString))
      {
        paramString = Build.DEVICE;
      }
      else if ("brand".equals(paramString))
      {
        paramString = Build.BRAND;
      }
      else if ("product".equals(paramString))
      {
        paramString = Build.PRODUCT;
      }
      else if ("androidid".equals(paramString))
      {
        paramString = k.g(c.getInstance());
      }
      else
      {
        paramString = "";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/utils/WkPublicParamsInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */