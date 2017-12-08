package com.lantern.browser;

import android.os.Handler;
import android.os.Message;
import com.bluefay.a.e;
import com.bluefay.b.b;
import java.io.File;
import java.util.HashMap;

final class bq
  extends Handler
{
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      Object localObject = (HashMap)paramMessage.obj;
      paramMessage = e.b((String)((HashMap)localObject).get("url"));
      localObject = (String)((HashMap)localObject).get("cache");
      b.a(new File(bp.c(), paramMessage + ".wkfeed").getAbsolutePath(), ((String)localObject).getBytes());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */