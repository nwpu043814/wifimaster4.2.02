package com.lantern.wifilocating.push.f;

import com.lantern.wifilocating.push.b.b.e;
import com.lantern.wifilocating.push.c.d;
import com.lantern.wifilocating.push.f.a.a.a;
import com.lantern.wifilocating.push.f.a.b;
import com.lantern.wifilocating.push.f.a.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

final class h
  implements c
{
  h(f paramf) {}
  
  public final void onEvent(com.lantern.wifilocating.push.f.a.a parama)
  {
    int i = parama.a();
    if (i == a.a.a) {
      com.lantern.wifilocating.push.g.b.a.a().a((List)parama.b());
    }
    for (;;)
    {
      return;
      if (i == a.a.b)
      {
        parama = parama.b();
        if ((parama instanceof JSONObject))
        {
          JSONObject localJSONObject = (JSONObject)parama;
          parama = com.lantern.wifilocating.push.g.b.a.a();
          if (localJSONObject != null)
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(localJSONObject);
            parama.a(localArrayList);
          }
        }
      }
      else if (i == a.a.i)
      {
        f.a(this.a).a();
        f.b(this.a);
      }
      else if (i == a.a.d)
      {
        f.c(this.a);
      }
      else if ((com.lantern.wifilocating.push.b.e.a.a(e.a, parama)) && (((d)com.lantern.wifilocating.push.c.b.a.a().a(d.class)).d()))
      {
        f.d(this.a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/f/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */