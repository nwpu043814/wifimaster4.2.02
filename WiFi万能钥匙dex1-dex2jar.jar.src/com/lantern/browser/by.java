package com.lantern.browser;

import android.os.Bundle;
import android.os.Message;
import com.bluefay.b.h;
import com.bluefay.d.b;

final class by
  extends b
{
  by(WkBrowserWebView paramWkBrowserWebView, int[] paramArrayOfInt)
  {
    super(paramArrayOfInt);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      Object localObject = (Bundle)paramMessage.obj;
      paramMessage = ((Bundle)localObject).getString("data");
      localObject = ((Bundle)localObject).getString("callback");
      h.a("payResP data=" + paramMessage + " callback =" + (String)localObject, new Object[0]);
      this.a.a((String)localObject, new String[] { paramMessage });
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */