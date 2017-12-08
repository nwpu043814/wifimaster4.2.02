package com.lantern.wifilocating.push.b.c;

import com.lantern.wifilocating.push.f.a.a.a;
import com.lantern.wifilocating.push.f.f;
import com.lantern.wifilocating.push.util.h;
import java.io.IOException;
import java.io.OutputStream;
import org.json.JSONObject;

final class b
  extends Thread
{
  b(a parama, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    synchronized (a.a(this.b))
    {
      Object localObject2 = a.b(this.b);
      if (localObject2 != null) {}
      try
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject2 = this.a.toString() + "@$";
        a.b(this.b).write(((String)localObject2).getBytes("UTF-8"));
        a.b(this.b).flush();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("send:");
        com.lantern.wifilocating.push.util.b.a((String)localObject2);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.a(localException);
          if ((localException instanceof IOException))
          {
            com.lantern.wifilocating.push.f.a.a locala = new com/lantern/wifilocating/push/f/a/a;
            locala.<init>(a.a.h);
            f.a(locala);
          }
          a.c(this.b);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */