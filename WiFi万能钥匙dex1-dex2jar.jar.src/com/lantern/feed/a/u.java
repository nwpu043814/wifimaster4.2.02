package com.lantern.feed.a;

import android.os.Handler.Callback;
import android.os.Message;
import com.lantern.analytics.a;
import com.lantern.feed.b.o;
import com.lantern.feed.d.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

final class u
  implements Handler.Callback
{
  u(m paramm) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = ((String)paramMessage.obj).split(";");
      if (paramMessage.length == 2)
      {
        m.a(paramMessage[0], paramMessage[1]);
        continue;
        paramMessage = ((String)paramMessage.obj).split(";");
        if (paramMessage.length == 2)
        {
          m.b(paramMessage[0], paramMessage[1]);
          continue;
          m.b((String)paramMessage.obj);
          continue;
          m.a(this.a, paramMessage.arg1, paramMessage.arg2, (List)paramMessage.obj);
          continue;
          int i = paramMessage.arg1;
          Object localObject2 = new ArrayList((List)paramMessage.obj);
          Object localObject1;
          if (i == 1)
          {
            paramMessage = d.d();
            localObject1 = d.c();
            localObject2 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              o localo = (o)((Iterator)localObject2).next();
              HashMap localHashMap = new HashMap();
              localHashMap.put("tabId", localo.a());
              localHashMap.put("longi", paramMessage);
              localHashMap.put("lati", localObject1);
              a.e().onEvent("dtbld", new JSONObject(localHashMap).toString());
            }
          }
          else if (i == 2)
          {
            paramMessage = ((ArrayList)localObject2).iterator();
            while (paramMessage.hasNext())
            {
              localObject2 = (o)paramMessage.next();
              localObject1 = new HashMap();
              ((HashMap)localObject1).put("tabId", ((o)localObject2).a());
              a.e().onEvent("dtshow", new JSONObject((Map)localObject1).toString());
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */