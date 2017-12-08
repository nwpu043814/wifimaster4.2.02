package com.wifipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.wifipay.sdk.c.a.d;

class b
  implements a.d
{
  b(a parama, String paramString) {}
  
  public void a()
  {
    try
    {
      Intent localIntent = new android/content/Intent;
      localIntent.<init>("android.intent.action.DIAL");
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("tel:");
      localIntent.setData(Uri.parse(this.a));
      this.b.a.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/app/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */