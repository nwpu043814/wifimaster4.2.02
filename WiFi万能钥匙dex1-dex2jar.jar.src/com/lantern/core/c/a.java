package com.lantern.core.c;

import android.text.TextUtils;
import com.lantern.core.c;
import com.lantern.core.f;

public final class a
{
  public static String a()
  {
    String str = f.a(c.getAppContext()).a("host");
    if (!TextUtils.isEmpty(str)) {}
    for (str = String.format("%s%s", new Object[] { str, "/config/fa.sec" });; str = String.format("%s%s", new Object[] { "http://config.51y5.net", "/config/fa.sec" })) {
      return str;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */