package com.lantern.wifilocating.push.b.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.lantern.wifilocating.push.f.a.a.a;
import com.lantern.wifilocating.push.util.h;
import org.json.JSONObject;

public final class j
  extends d
{
  public j()
  {
    super(e.d);
  }
  
  public final void b()
  {
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = (com.lantern.wifilocating.push.c.b)com.lantern.wifilocating.push.c.b.a.a().a(com.lantern.wifilocating.push.c.b.class);
    if (l - com.lantern.wifilocating.push.util.d.e() < ((com.lantern.wifilocating.push.c.b)localObject1).b()) {}
    for (;;)
    {
      return;
      Object localObject2 = com.lantern.wifilocating.push.util.d.a().b();
      if (localObject2 != null)
      {
        String str = ((com.lantern.wifilocating.push.d.f)localObject2).k;
        localObject1 = ((com.lantern.wifilocating.push.d.f)localObject2).l;
        localObject2 = ((com.lantern.wifilocating.push.d.f)localObject2).m;
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
          try
          {
            JSONObject localJSONObject = o.a(e());
            localJSONObject.put("mapSP", str);
            localJSONObject.put("longi", localObject1);
            localJSONObject.put("lati", localObject2);
            com.lantern.wifilocating.push.b.a.b.a().b().a(localJSONObject);
            com.lantern.wifilocating.push.util.d.c(str);
            com.lantern.wifilocating.push.util.d.b((String)localObject1);
            com.lantern.wifilocating.push.util.d.a((String)localObject2);
            com.lantern.wifilocating.push.util.d.a(l);
          }
          catch (Exception localException)
          {
            h.a(localException);
            com.lantern.wifilocating.push.f.f.a(new com.lantern.wifilocating.push.f.a.a(a.a.f, new p(e(), null)));
          }
        }
      }
    }
  }
  
  public final void b(JSONObject paramJSONObject) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */