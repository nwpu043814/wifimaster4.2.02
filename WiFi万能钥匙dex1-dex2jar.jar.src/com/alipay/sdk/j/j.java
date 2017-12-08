package com.alipay.sdk.j;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.app.b;
import com.alipay.sdk.b.a;

public final class j
{
  public static String a(Context paramContext)
  {
    if (b.a()) {
      paramContext = "https://mobilegw.alipaydev.com/mgw.htm";
    }
    for (;;)
    {
      return paramContext;
      if (paramContext == null)
      {
        paramContext = a.a;
      }
      else
      {
        String str = a.a;
        paramContext = str;
        if (TextUtils.isEmpty(str)) {
          paramContext = a.a;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/j/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */