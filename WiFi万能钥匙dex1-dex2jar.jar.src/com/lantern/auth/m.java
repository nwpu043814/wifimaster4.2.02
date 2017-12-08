package com.lantern.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import com.bluefay.d.b;
import com.lantern.core.c;
import com.lantern.core.p;

final class m
  extends b
{
  m(WkRegisterInterface paramWkRegisterInterface, int[] paramArrayOfInt)
  {
    super(paramArrayOfInt);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (paramMessage.arg1 == 1)
    {
      WkRegisterInterface.access$002(this.a, "1");
      if (WkRegisterInterface.access$100(this.a))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("uhid", p.c(""));
        localIntent.putExtra("userToken", p.f(WkRegisterInterface.access$200(this.a)));
        WkRegisterInterface.access$200(this.a).setResult(-1, localIntent);
      }
    }
    for (;;)
    {
      WkRegisterInterface.access$400(this.a, paramMessage.arg1, (String)paramMessage.obj);
      c.removeListener(WkRegisterInterface.access$500(this.a));
      break;
      WkRegisterInterface.access$384(this.a, "6");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */