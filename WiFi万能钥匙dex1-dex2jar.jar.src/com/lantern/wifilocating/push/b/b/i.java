package com.lantern.wifilocating.push.b.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.lantern.wifilocating.push.d.f;
import com.lantern.wifilocating.push.f.a.a.a;
import com.lantern.wifilocating.push.util.d;
import com.lantern.wifilocating.push.util.h;
import org.json.JSONObject;

public final class i
  extends a
{
  private int d = 0;
  
  public i()
  {
    super(e.b);
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    try
    {
      if (((com.lantern.wifilocating.push.c.b)com.lantern.wifilocating.push.c.b.a.a().a(com.lantern.wifilocating.push.c.b.class)).d())
      {
        f localf = d.a().b();
        if (localf != null)
        {
          long l = SystemClock.elapsedRealtime();
          if ((!TextUtils.isEmpty(localf.k)) && (!TextUtils.isEmpty(localf.l)) && (!TextUtils.isEmpty(localf.m)))
          {
            paramJSONObject.put("mapSP", localf.k);
            paramJSONObject.put("longi", localf.l);
            paramJSONObject.put("lati", localf.m);
            d.c(localf.k);
            d.b(localf.l);
            d.a(localf.m);
            d.a(l);
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        h.a(localThrowable);
      }
    }
    super.a(paramJSONObject);
  }
  
  public final void onEvent(com.lantern.wifilocating.push.f.a.a parama)
  {
    super.onEvent(parama);
    if (parama.a() == a.a.c) {
      if (com.lantern.wifilocating.push.b.a.b.a().d()) {
        b();
      }
    }
    for (;;)
    {
      return;
      com.lantern.wifilocating.push.b.a.b.a().a(true, null);
      continue;
      if (com.lantern.wifilocating.push.b.e.a.a(e.b, parama))
      {
        this.d = 0;
      }
      else if (com.lantern.wifilocating.push.b.e.a.b(e.b, parama))
      {
        this.d += 1;
        if (this.d > 0)
        {
          this.d = 0;
          com.lantern.wifilocating.push.b.a.b.a().a(true, null);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */