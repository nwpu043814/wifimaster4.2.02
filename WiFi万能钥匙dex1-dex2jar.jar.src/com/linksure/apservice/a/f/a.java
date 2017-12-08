package com.linksure.apservice.a.f;

import com.linksure.apservice.a.d.a.b;
import java.io.File;

public final class a
{
  public static void a(String paramString)
  {
    if ((paramString == null) || (!new File(paramString).exists())) {
      throw new b("file is empty or not exist");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */