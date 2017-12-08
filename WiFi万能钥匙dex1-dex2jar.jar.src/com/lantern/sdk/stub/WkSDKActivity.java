package com.lantern.sdk.stub;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.qihoo.util.StubApp1053578832;

public class WkSDKActivity
  extends Activity
{
  static
  {
    StubApp1053578832.interface11(46);
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject1 = paramIntent.getScheme();
    h.a("schem=" + (String)localObject1);
    if ((localObject1 != null) && (((String)localObject1).equals("wkc")))
    {
      localObject1 = getIntent().getData();
      if (localObject1 != null) {}
    }
    for (;;)
    {
      return;
      Object localObject2 = ((Uri)localObject1).getHost();
      paramIntent = ((Uri)localObject1).getPath();
      h.a("host=" + (String)localObject2, new Object[0]);
      h.a("path=" + paramIntent, new Object[0]);
      localObject1 = ((Uri)localObject1).getQueryParameter("key");
      h.a("parameter=" + (String)localObject1, new Object[0]);
      try
      {
        if (!"com.lantern.launcher.ui.MainActivityICS".equals(localObject2)) {
          continue;
        }
        localObject2 = Class.forName((String)localObject2);
        if (localObject2 == null) {
          continue;
        }
        try
        {
          Intent localIntent = new android/content/Intent;
          localIntent.<init>(this, (Class)localObject2);
          localIntent.putExtra("path", paramIntent);
          localIntent.putExtra("parameter", (String)localObject1);
          startActivity(localIntent);
        }
        catch (Exception paramIntent)
        {
          h.a(paramIntent);
        }
      }
      catch (ClassNotFoundException paramIntent)
      {
        h.a(paramIntent);
      }
      continue;
      localObject1 = a.a(paramIntent);
      if ((localObject1 == null) || (!((a)localObject1).a()))
      {
        h.c("Invalid intent:" + paramIntent);
      }
      else
      {
        h.a(((a)localObject1).toString());
        if (("queryKey".equals(((a)localObject1).a)) || ("connect".equals(((a)localObject1).a)) || ("cancelConnect".equals(((a)localObject1).a)))
        {
          try
          {
            localObject1 = new android/content/Intent;
            ((Intent)localObject1).<init>("wifi.intent.action.SDK_CALL");
            ((Intent)localObject1).setPackage(getPackageName());
            ((Intent)localObject1).putExtras(paramIntent.getExtras());
            startService((Intent)localObject1);
          }
          catch (Throwable paramIntent)
          {
            h.c(String.valueOf(paramIntent));
          }
        }
        else if (("pay".equals(((a)localObject1).a)) || ("login".equals(((a)localObject1).a)))
        {
          localObject1 = new Intent("wifi.intent.action.AUTH_PAY");
          ((Intent)localObject1).setFlags(268435456);
          ((Intent)localObject1).setPackage(getPackageName());
          ((Intent)localObject1).putExtras(paramIntent.getExtras());
          e.a(this, (Intent)localObject1);
        }
      }
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onNewIntent(Intent paramIntent)
  {
    h.a("WkSDKActivity onNewIntent");
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/sdk/stub/WkSDKActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */