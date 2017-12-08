package com.lantern.wifilocating.push.g.c;

import com.lantern.wifilocating.push.util.h;
import com.lantern.wifilocating.push.util.j;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends c
{
  public final void a(JSONObject paramJSONObject)
  {
    try
    {
      b.a().a(paramJSONObject);
      return;
    }
    finally
    {
      paramJSONObject = finally;
      throw paramJSONObject;
    }
  }
  
  public final void b(JSONObject paramJSONObject) {}
  
  private static final class a
    implements Runnable
  {
    private JSONObject a;
    
    public a(JSONObject paramJSONObject)
    {
      this.a = paramJSONObject;
    }
    
    public final void run()
    {
      long l = this.a.optLong("sendTime");
      JSONObject localJSONObject1 = j.a(j.a(this.a.optString("content", null), "UTF-8"));
      if (localJSONObject1 == null) {}
      for (;;)
      {
        return;
        Iterator localIterator = localJSONObject1.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          JSONObject localJSONObject2 = j.a(localJSONObject1.optString(str));
          if (localJSONObject2.optLong("cv", -1L) == -1L) {
            try
            {
              localJSONObject2.put("cv", l);
              localJSONObject1.put(str, localJSONObject2.toString());
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
            }
          }
        }
        com.lantern.wifilocating.push.c.b.a.a().a(localJSONObject1);
      }
    }
  }
  
  private static class b
  {
    private static b c;
    private Object a = new Object();
    private ExecutorService b;
    
    private b()
    {
      synchronized (this.a)
      {
        this.b = Executors.newSingleThreadExecutor();
        return;
      }
    }
    
    public static b a()
    {
      if (c == null) {}
      try
      {
        if (c == null)
        {
          b localb = new com/lantern/wifilocating/push/g/c/a$b;
          localb.<init>();
          c = localb;
        }
        return c;
      }
      finally {}
    }
    
    public final void a(JSONObject paramJSONObject)
    {
      synchronized (this.a)
      {
        try
        {
          if ((this.b != null) && (!this.b.isShutdown()))
          {
            ExecutorService localExecutorService = this.b;
            a.a locala = new com/lantern/wifilocating/push/g/c/a$a;
            locala.<init>(paramJSONObject);
            localExecutorService.submit(locala);
          }
          return;
        }
        catch (Throwable paramJSONObject)
        {
          for (;;)
          {
            h.a(paramJSONObject);
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/g/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */