package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.k.a;

public final class g
{
  private static a a = null;
  private static String b = null;
  
  public static void a(Activity paramActivity, String paramString)
  {
    try
    {
      Intent localIntent = new android/content/Intent;
      localIntent.<init>("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString));
      paramActivity.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramActivity)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/auth/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */