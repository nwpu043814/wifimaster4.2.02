package com.wifi.connect.d;

import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.c.a.a.a.f.a.a.a;
import com.c.a.a.a.f.a.a.a.a;
import com.lantern.core.c;
import com.lantern.core.config.StandbyIPConf;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  extends AsyncTask<String, Integer, Integer>
{
  private com.bluefay.b.a a;
  private WkAccessPoint b;
  private com.lantern.core.model.e c;
  
  public h(WkAccessPoint paramWkAccessPoint, com.bluefay.b.a parama)
  {
    this.b = paramWkAccessPoint;
    this.a = parama;
  }
  
  private int a()
  {
    c.getServer().f("00301301");
    Object localObject3 = com.wifi.connect.a.a();
    com.bluefay.d.a.getAppContext();
    Object localObject2 = this.b;
    Object localObject1 = c.getServer().s();
    ((HashMap)localObject1).put("ssid", ((WkAccessPoint)localObject2).a);
    ((HashMap)localObject1).put("bssid", ((WkAccessPoint)localObject2).b);
    com.bluefay.b.h.a(((HashMap)localObject1).toString(), new Object[0]);
    HashMap localHashMap = c.getServer().c("00301301", (HashMap)localObject1);
    localObject2 = new com.bluefay.b.d((String)localObject3).b(localHashMap);
    localObject1 = localObject2;
    String str;
    if (!com.lantern.core.e.a((String)localObject2))
    {
      str = Uri.parse((String)localObject3).getHost();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = ((StandbyIPConf)com.lantern.core.config.d.a(c.getAppContext()).a(StandbyIPConf.class)).a(str);
        if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
          break label174;
        }
        com.bluefay.b.h.a("ip try list is empty");
        localObject1 = localObject2;
      }
    }
    int i;
    if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
      i = 10;
    }
    for (;;)
    {
      return i;
      label174:
      Iterator localIterator = ((List)localObject1).iterator();
      localObject1 = localObject2;
      while (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        com.bluefay.b.h.a("try ip:" + (String)localObject1);
        localObject2 = new com.bluefay.b.d(((String)localObject3).replaceFirst(str, (String)localObject1)).b(localHashMap);
        localObject1 = localObject2;
        if (com.lantern.core.e.a((String)localObject2)) {
          localObject1 = localObject2;
        }
      }
      break;
      com.bluefay.b.h.a("JSON:" + (String)localObject1, new Object[0]);
      i = 1;
      try
      {
        localObject3 = new com/lantern/core/model/e;
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>((String)localObject1);
        ((com.lantern.core.model.e)localObject3).<init>((JSONObject)localObject2);
        this.c = ((com.lantern.core.model.e)localObject3);
      }
      catch (JSONException localJSONException)
      {
        com.bluefay.b.h.a(localJSONException);
        i = 30;
        this.c = null;
      }
    }
  }
  
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (!c.getServer().a("00302011", paramBoolean1)) {
      i = 0;
    }
    for (;;)
    {
      return i;
      Object localObject1 = c.getServer().v();//apurl
      com.bluefay.d.a.getAppContext();
      Object localObject2 = this.b;
      a.a.a locala = a.a.l();
      locala.a(((WkAccessPoint)localObject2).a());
      locala.b(((WkAccessPoint)localObject2).b());
      localObject2 = ((a.a)locala.c()).b();
      c.getServer();
      localObject1 = com.lantern.core.e.a((String)localObject1, o.a("00302011", (byte[])localObject2));
      if ((localObject1 == null) || (localObject1.length == 0)) {
        i = 10;
      } else {
        try
        {
          c.getServer();
          localObject2 = o.b("00302011", (byte[])localObject1);
          if (((com.lantern.core.h.a)localObject2).c())
          {
            localObject1 = new com/lantern/core/model/e;
            ((com.lantern.core.model.e)localObject1).<init>();
            this.c = ((com.lantern.core.model.e)localObject1);
            this.c.a("0");
            this.c.b(((com.lantern.core.h.a)localObject2).b());
            i = 1;
          }
          else
          {
            this.c = null;
            if ((paramBoolean1) && (!paramBoolean2) && ((((com.lantern.core.h.a)localObject2).d()) || (((com.lantern.core.h.a)localObject2).e())))
            {
              c.getServer().b("00302011", ((com.lantern.core.h.a)localObject2).b());
              i = a(true, true);
            }
            else
            {
              i = 30;
            }
          }
        }
        catch (Exception localException)
        {
          com.bluefay.b.h.a(localException);
          this.c = null;
          i = 30;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */