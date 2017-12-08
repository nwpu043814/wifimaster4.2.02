package com.lantern.auth;

import android.text.TextUtils;
import com.lantern.core.c;
import com.lantern.core.f;

public final class h
{
  public static String a()
  {
    String str = f.a(c.getAppContext()).a("ssohost");
    if (str != null) {}
    for (str = String.format("%s%s", new Object[] { str, "/sso/fa.sec" });; str = String.format("%s%s", new Object[] { "https://sso.51y5.net", "/sso/fa.sec" })) {
      return str;
    }
  }
  
  public static String b()
  {
    String str = f.a(c.getAppContext()).a("ssohost");
    if (str != null) {}
    for (str = String.format("%s%s", new Object[] { str, "/sso/open/register.do?" });; str = String.format("%s%s", new Object[] { "https://sso.51y5.net", "/sso/open/register.do?" })) {
      return str;
    }
  }
  
  public static String c()
  {
    return f.a(c.getAppContext()).a("ssohost");
  }
  
  public static String d()
  {
    String str = c();
    if (TextUtils.isEmpty(str)) {}
    for (str = String.format("%s%s", new Object[] { "https://oauth.51y5.net", "/open-sso/fa.sec" });; str = String.format("%s%s", new Object[] { str, "/open-sso/fa.sec" })) {
      return str;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */