package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.a.g;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

final class o
  implements Runnable
{
  private f bM = null;
  private Map<String, Integer> bO = null;
  private Context e = null;
  
  public o(Context paramContext)
  {
    this.e = paramContext;
    this.bM = null;
  }
  
  private static b a(String paramString, int paramInt)
  {
    b localb = new b();
    Socket localSocket = new Socket();
    int i = 0;
    for (;;)
    {
      try
      {
        localb.setDomain(paramString);
        localb.setPort(paramInt);
        long l = System.currentTimeMillis();
        InetSocketAddress localInetSocketAddress = new java/net/InetSocketAddress;
        localInetSocketAddress.<init>(paramString, paramInt);
        localSocket.connect(localInetSocketAddress, 30000);
        localb.a(System.currentTimeMillis() - l);
        localb.k(localInetSocketAddress.getAddress().getHostAddress());
        localSocket.close();
      }
      catch (IOException paramString)
      {
        paramString = paramString;
        paramInt = -1;
        e.K().b(paramString);
        try
        {
          localSocket.close();
        }
        catch (Throwable paramString)
        {
          e.K().b(paramString);
        }
        continue;
      }
      finally {}
      try
      {
        localSocket.close();
        paramInt = i;
      }
      catch (Throwable paramString)
      {
        e.K().b(paramString);
        paramInt = i;
      }
    }
    localb.setStatusCode(paramInt);
    return localb;
    try
    {
      localSocket.close();
      throw paramString;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        e.K().b(localThrowable);
      }
    }
  }
  
  private static Map<String, Integer> ag()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = c.l("__MTA_TEST_SPEED__");
    if ((localObject == null) || (((String)localObject).trim().length() == 0)) {}
    for (;;)
    {
      return localHashMap;
      localObject = ((String)localObject).split(";");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = localObject[i].split(",");
        String str;
        if ((arrayOfString != null) && (arrayOfString.length == 2))
        {
          str = arrayOfString[0];
          if ((str == null) || (str.trim().length() == 0)) {}
        }
        try
        {
          int k = Integer.valueOf(arrayOfString[1]).intValue();
          localHashMap.put(str, Integer.valueOf(k));
          i++;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            e.K().b(localNumberFormatException);
          }
        }
      }
    }
  }
  
  public final void run()
  {
    try
    {
      if (this.bO == null) {
        this.bO = ag();
      }
      if ((this.bO == null) || (this.bO.size() == 0))
      {
        e.K().b("empty domain list.");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        JSONArray localJSONArray;
        Iterator localIterator;
        Object localObject2;
        Object localObject1;
        e.K().b(localThrowable);
        continue;
        if ((Integer)((Map.Entry)localObject2).getValue() == null)
        {
          com.tencent.wxop.stat.b.b localb = e.K();
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>("port is null for ");
          localb.c((String)localObject1);
        }
        else
        {
          localThrowable.put(a((String)((Map.Entry)localObject2).getKey(), ((Integer)((Map.Entry)localObject2).getValue()).intValue()).i());
          continue;
          label213:
          if (localThrowable.length() != 0)
          {
            localObject1 = new com/tencent/wxop/stat/a/g;
            ((g)localObject1).<init>(this.e, e.a(this.e, false, this.bM), this.bM);
            ((g)localObject1).b(localThrowable.toString());
            p localp = new com/tencent/wxop/stat/p;
            localp.<init>((d)localObject1);
            localp.ah();
          }
        }
      }
    }
    localJSONArray = new org/json/JSONArray;
    localJSONArray.<init>();
    localIterator = this.bO.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label213;
      }
      localObject2 = (Map.Entry)localIterator.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
        break;
      }
      e.K().c("empty domain name.");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */