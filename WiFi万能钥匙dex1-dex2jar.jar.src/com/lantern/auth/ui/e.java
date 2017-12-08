package com.lantern.auth.ui;

import android.content.Intent;
import android.os.Bundle;
import com.lantern.sdk.stub.b;

final class e
  implements com.bluefay.b.a
{
  e(AuthActivity paramAuthActivity) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    AuthActivity.a(this.a);
    boolean bool = ((Boolean)paramObject).booleanValue();
    if ((AuthActivity.i(this.a) != null) && ("login".equals(AuthActivity.i(this.a).a)))
    {
      paramObject = new b("login");
      ((b)paramObject).b = paramInt;
      ((b)paramObject).d = paramString;
      ((b)paramObject).c = paramString;
      b.a(this.a, AuthActivity.i(this.a).c, (b)paramObject);
      if (bool) {
        this.a.finish();
      }
    }
    for (;;)
    {
      return;
      try
      {
        Intent localIntent = new android/content/Intent;
        localIntent.<init>("wifi.intent.action.AUTHSDK_MESSAGE");
        paramObject = new android/os/Bundle;
        ((Bundle)paramObject).<init>();
        ((Bundle)paramObject).putSerializable("auth_sdk_code", paramString);
        localIntent.putExtras((Bundle)paramObject);
        this.a.sendBroadcast(localIntent);
        if (bool) {
          this.a.finish();
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */