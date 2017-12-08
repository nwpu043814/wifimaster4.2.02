package com.lantern.bindapp;

import android.os.Handler.Callback;
import android.os.Message;
import com.bluefay.b.h;
import com.lantern.core.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;

final class d
  implements Handler.Callback
{
  public final boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a.e();
      continue;
      if (paramMessage.arg1 == 1) {}
      for (;;)
      {
        a.a(bool);
        break;
        bool = false;
      }
      Object localObject = a.c();
      if (localObject != null)
      {
        try
        {
          paramMessage = new java/util/ArrayList;
          paramMessage.<init>((Collection)localObject);
          localObject = new org/json/JSONArray;
          ((JSONArray)localObject).<init>();
          paramMessage = paramMessage.iterator();
          while (paramMessage.hasNext()) {
            ((JSONArray)localObject).put(com.lantern.bindapp.c.a.a((com.lantern.bindapp.a.a)paramMessage.next()));
          }
        }
        catch (Exception paramMessage)
        {
          h.a("save as json error!", new Object[0]);
        }
        p.b("bind_app", "item_list", ((JSONArray)localObject).toString());
      }
      else
      {
        p.b("bind_app", "item_list", "");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/bindapp/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */