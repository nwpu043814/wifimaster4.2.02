package com.wifi.connect.d;

import android.os.AsyncTask;
import com.bluefay.b.a;
import com.bluefay.b.d;
import com.lantern.core.c;
import com.lantern.core.o;
import org.json.JSONException;

public final class j
  extends AsyncTask<String, Integer, Integer>
{
  private a a;
  private com.wifi.connect.model.h b;
  
  public j(a parama)
  {
    this.a = parama;
  }
  
  private Integer a()
  {
    com.bluefay.b.h.a("-----request start-----", new Object[0]);
    Object localObject = c.getServer();
    ((o)localObject).f("00900601");
    localObject = d.a("http://news.51y5.net/news/fa.sec", ((o)localObject).b("00900601", ((o)localObject).s()));
    if (localObject == null) {
      localObject = Integer.valueOf(10);
    }
    for (;;)
    {
      return (Integer)localObject;
      com.bluefay.b.h.a("response json:%s", new Object[] { localObject });
      try
      {
        this.b = com.wifi.connect.model.h.c((String)localObject);
        localObject = Integer.valueOf(1);
      }
      catch (JSONException localJSONException)
      {
        com.bluefay.b.h.a(localJSONException);
        Integer localInteger = Integer.valueOf(30);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/d/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */