package com.lantern.bindapp;

import android.os.Handler;
import android.os.Message;
import com.bluefay.b.h;
import com.bluefay.d.b;
import com.lantern.core.p;
import java.util.ArrayList;
import org.json.JSONObject;

final class c
  extends b
{
  c(int[] paramArrayOfInt)
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
    com.lantern.analytics.a.e().onEvent("dgtpapp");
    for (;;)
    {
      try
      {
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>((String)paramMessage.obj);
      }
      catch (Exception localException1)
      {
        try
        {
          paramMessage = com.lantern.bindapp.c.a.a((JSONObject)localObject1, false);
          Object localObject2 = localObject1;
          localObject1 = paramMessage;
          if (localObject2 != null)
          {
            p.b("bind_app_show_interval", ((JSONObject)localObject2).optLong("si", 0L));
            p.a("bind_app_cfg_type", ((JSONObject)localObject2).optInt("cfgType", 0));
          }
          paramMessage = (Message)localObject1;
          if (localObject1 == null) {
            paramMessage = new ArrayList();
          }
          if (a.c() == null) {
            break label160;
          }
          a.a(com.lantern.bindapp.c.a.a(a.c(), paramMessage));
          a.d().sendEmptyMessage(2);
          a.d().sendEmptyMessage(3);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject1;
            Message localMessage;
            paramMessage = (Message)localObject1;
          }
        }
        localException1 = localException1;
        paramMessage = null;
      }
      h.a(localException1);
      com.lantern.analytics.a.e().onEvent("dgtpapp0");
      localObject1 = null;
      localMessage = paramMessage;
      continue;
      label160:
      a.a(paramMessage);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/bindapp/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */