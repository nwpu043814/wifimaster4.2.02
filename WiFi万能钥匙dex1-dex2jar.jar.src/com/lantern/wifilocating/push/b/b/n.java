package com.lantern.wifilocating.push.b.b;

import com.lantern.wifilocating.push.b.a.b;
import com.lantern.wifilocating.push.util.h;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public final class n
{
  private Object a = new Object();
  private ExecutorService b;
  
  public n()
  {
    synchronized (this.a)
    {
      this.b = Executors.newSingleThreadExecutor();
      return;
    }
  }
  
  public final void a(String paramString)
  {
    synchronized (this.a)
    {
      try
      {
        if ((this.b != null) && (!this.b.isShutdown()))
        {
          ExecutorService localExecutorService = this.b;
          a locala = new com/lantern/wifilocating/push/b/b/n$a;
          locala.<init>(paramString);
          localExecutorService.submit(locala);
        }
        return;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          h.a(paramString);
        }
      }
    }
  }
  
  private static final class a
    implements Runnable
  {
    private String a;
    
    public a(String paramString)
    {
      this.a = paramString;
    }
    
    public final void run()
    {
      Object localObject1;
      if (this.a != null)
      {
        localObject1 = this.a.trim();
        this.a = ((String)localObject1);
      }
      for (;;)
      {
        try
        {
          localObject1 = new org/json/JSONObject;
          ((JSONObject)localObject1).<init>(this.a);
          localObject2 = e.a(((JSONObject)localObject1).optString("cmd"));
          if (localObject2 != null) {
            continue;
          }
          return;
        }
        catch (Exception localException)
        {
          Object localObject2;
          continue;
        }
        localObject1 = this.a;
        break;
        localObject2 = b.a().b((e)localObject2);
        if (localObject2 != null) {
          ((f)localObject2).b((JSONObject)localObject1);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */