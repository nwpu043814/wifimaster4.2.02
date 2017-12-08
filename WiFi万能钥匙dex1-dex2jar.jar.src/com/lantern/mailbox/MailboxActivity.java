package com.lantern.mailbox;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import bluefay.app.m;
import com.qihoo.util.StubApp1053578832;

public class MailboxActivity
  extends m
{
  static
  {
    StubApp1053578832.interface11(32);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = paramString1;
      if (URLUtil.isNetworkUrl(paramString1)) {}
    }
    else
    {
      localObject = "http://www.wifi.com";
    }
    Object localObject = new Intent("wifi.intent.action.BROWSER", Uri.parse((String)localObject));
    ((Intent)localObject).setPackage(paramContext.getPackageName());
    paramString1 = new Bundle();
    paramString1.putBoolean("showoptionmenu", false);
    paramString1.putString("from", paramString2);
    ((Intent)localObject).putExtras(paramString1);
    paramContext.startActivity((Intent)localObject);
  }
  
  protected native void onCreate(Bundle paramBundle);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/mailbox/MailboxActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */