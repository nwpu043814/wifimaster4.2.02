package com.lantern.wifilocating.push.d;

import com.lantern.wifilocating.push.util.h;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class b
{
  public static String a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = a.a(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;)
      {
        h.a(paramString);
        paramString = "";
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        h.a(paramString);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */