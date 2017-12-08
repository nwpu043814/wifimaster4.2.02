package com.lantern.launcher.ui;

import android.os.Message;
import com.bluefay.d.b;
import org.json.JSONObject;

final class g
  extends b
{
  g(MainActivityICS paramMainActivityICS, int[] paramArrayOfInt)
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
      MainActivityICS.a(this.a, paramMessage);
      continue;
      paramMessage = (String)paramMessage.obj;
      this.a.c(paramMessage);
      continue;
      paramMessage = (JSONObject)paramMessage.obj;
      MainActivityICS.a(this.a, paramMessage);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */