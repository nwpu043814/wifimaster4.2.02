package com.lantern.wifilocating.push.b.d;

import android.text.TextUtils;
import com.lantern.wifilocating.push.c;
import com.lantern.wifilocating.push.util.h;
import com.lantern.wifilocating.push.util.i;
import com.lantern.wifilocating.push.util.j;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static List<com.lantern.wifilocating.push.b.c.a.a> a()
  {
    localObject3 = null;
    try
    {
      localObject1 = i.d(c.a(), com.lantern.wifilocating.push.util.d.c());
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>((String)localObject1);
      localObject1 = localObject3;
      if (localJSONObject.optLong("ept") > System.currentTimeMillis())
      {
        localObject1 = localJSONObject.optString("tk");
        com.lantern.wifilocating.push.util.d.a().b().n = ((String)localObject1);
        localObject1 = a(localJSONObject);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        h.a(localException);
        Object localObject2 = localObject3;
      }
    }
    return (List<com.lantern.wifilocating.push.b.c.a.a>)localObject1;
  }
  
  private static List<com.lantern.wifilocating.push.b.c.a.a> a(JSONObject paramJSONObject)
  {
    int i = 0;
    Object localObject1 = com.lantern.wifilocating.push.util.g.d();
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = ((String)localObject1).split(":");
      if ((localObject2 != null) && (localObject2.length == 2))
      {
        localObject1 = new ArrayList();
        ((List)localObject1).add(new com.lantern.wifilocating.push.b.c.a.a(localObject2[0], Integer.parseInt(localObject2[1])));
        if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
          break label95;
        }
      }
    }
    label95:
    do
    {
      return (List<com.lantern.wifilocating.push.b.c.a.a>)localObject1;
      localObject1 = null;
      break;
      localObject2 = paramJSONObject.optJSONArray("sp");
    } while (localObject2 == null);
    int j = ((JSONArray)localObject2).length();
    paramJSONObject = new ArrayList();
    for (;;)
    {
      localObject1 = paramJSONObject;
      if (i >= j) {
        break;
      }
      localObject1 = ((JSONArray)localObject2).getJSONObject(i);
      String str = ((JSONObject)localObject1).optString("ip");
      int k = ((JSONObject)localObject1).optInt("pt");
      if ((!TextUtils.isEmpty(str)) && (k > 0)) {
        paramJSONObject.add(new com.lantern.wifilocating.push.b.c.a.a(str, k));
      }
      i++;
    }
  }
  
  private static boolean a(String paramString, int paramInt)
  {
    boolean bool2 = false;
    Socket localSocket = new Socket();
    for (;;)
    {
      try
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>("connect:");
        com.lantern.wifilocating.push.util.b.a(paramString + ":" + paramInt);
        localObject = new java/net/InetSocketAddress;
        ((InetSocketAddress)localObject).<init>(paramString, paramInt);
        localSocket.connect((SocketAddress)localObject, 15000);
        localObject = new com/lantern/wifilocating/push/b/c/a;
        ((com.lantern.wifilocating.push.b.c.a)localObject).<init>(localSocket);
        h.a(paramString);
      }
      catch (Throwable paramString)
      {
        try
        {
          com.lantern.wifilocating.push.b.a.b.a().a((com.lantern.wifilocating.push.b.c.a)localObject);
          bool1 = true;
          return bool1;
        }
        catch (Throwable paramString)
        {
          Object localObject;
          boolean bool1;
          for (;;) {}
        }
        paramString = paramString;
        localObject = null;
      }
      j.a(localSocket);
      bool1 = bool2;
      if (localObject != null)
      {
        ((com.lantern.wifilocating.push.b.c.a)localObject).a();
        bool1 = bool2;
      }
    }
  }
  
  public static boolean a(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    label22:
    Object localObject;
    label61:
    com.lantern.wifilocating.push.b.c.a.a locala;
    if (!j.c(c.a()))
    {
      com.lantern.wifilocating.push.util.b.a("network disable, connect socket error");
      paramBoolean = bool1;
      break label165;
      return paramBoolean;
    }
    else
    {
      localObject = null;
      bool1 = bool3;
      if (paramBoolean)
      {
        com.lantern.wifilocating.push.util.b.a("ready to get host from cache");
        localObject = a();
        bool1 = bool2;
        if (localObject != null)
        {
          Iterator localIterator = ((List)localObject).iterator();
          paramBoolean = false;
          for (;;)
          {
            if (localIterator.hasNext())
            {
              locala = (com.lantern.wifilocating.push.b.c.a.a)localIterator.next();
              if (!com.lantern.wifilocating.push.util.d.a().a(locala))
              {
                paramBoolean = a(locala.a, locala.b);
                if (!paramBoolean) {
                  break;
                }
              }
            }
          }
        }
      }
    }
    for (bool1 = paramBoolean;; bool1 = paramBoolean)
    {
      if (localObject != null)
      {
        paramBoolean = bool1;
        if (!((List)localObject).isEmpty()) {
          break label22;
        }
      }
      com.lantern.wifilocating.push.util.b.a("ready to get host from API");
      localObject = b();
      paramBoolean = bool1;
      if (localObject == null) {
        break label22;
      }
      com.lantern.wifilocating.push.util.d.a().d();
      localObject = ((List)localObject).iterator();
      paramBoolean = bool1;
      label165:
      if (!((Iterator)localObject).hasNext()) {
        break label22;
      }
      locala = (com.lantern.wifilocating.push.b.c.a.a)((Iterator)localObject).next();
      bool1 = a(locala.a, locala.b);
      paramBoolean = bool1;
      if (!bool1) {
        break;
      }
      paramBoolean = bool1;
      break label22;
      break label61;
    }
  }
  
  private static List<com.lantern.wifilocating.push.b.c.a.a> b()
  {
    Object localObject5 = null;
    Object localObject6 = null;
    localObject1 = localObject5;
    for (;;)
    {
      try
      {
        localObject4 = com.lantern.wifilocating.push.d.g.b();
        localObject1 = localObject5;
        localObject2 = new java/lang/StringBuilder;
        localObject1 = localObject5;
        ((StringBuilder)localObject2).<init>("login-url:");
        localObject1 = localObject5;
        com.lantern.wifilocating.push.util.b.a((String)localObject4);
        localObject1 = localObject5;
        localObject2 = com.lantern.wifilocating.push.d.g.d().e();
        if (localObject2 != null)
        {
          localObject1 = localObject5;
          if (((HashMap)localObject2).size() != 0) {
            continue;
          }
        }
        localObject2 = null;
        if (localObject2 == null) {
          continue;
        }
        localObject1 = localObject5;
        localObject4 = com.lantern.wifilocating.push.d.d.a((String)localObject4, (Map)localObject2);
        localObject1 = localObject5;
        localObject2 = new java/lang/StringBuilder;
        localObject1 = localObject5;
        ((StringBuilder)localObject2).<init>("login-result:");
        localObject1 = localObject5;
        com.lantern.wifilocating.push.util.b.a((String)localObject4);
        localObject2 = localObject6;
        localObject1 = localObject5;
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject1 = localObject5;
          JSONObject localJSONObject = new org/json/JSONObject;
          localObject1 = localObject5;
          localJSONObject.<init>((String)localObject4);
          localObject1 = localObject5;
          int i = localJSONObject.optInt("retCd");
          localObject1 = localObject5;
          long l2 = localJSONObject.optLong("ept");
          localObject2 = localObject6;
          if (i == 0)
          {
            localObject2 = localObject6;
            if (l2 > 0L)
            {
              localObject1 = localObject5;
              long l1 = System.currentTimeMillis();
              localObject1 = localObject5;
              localObject2 = localJSONObject.optString("tk");
              localObject1 = localObject5;
              com.lantern.wifilocating.push.util.d.a().b().n = ((String)localObject2);
              localObject1 = localObject5;
              localObject4 = a(localJSONObject);
              localObject2 = localObject4;
              if (localObject4 != null)
              {
                localObject2 = localObject4;
                localObject1 = localObject4;
                if (!((List)localObject4).isEmpty())
                {
                  localObject1 = localObject4;
                  localJSONObject.remove("ept");
                  localObject1 = localObject4;
                  localJSONObject.put("ept", l2 + l1);
                  localObject1 = localObject4;
                  i.a(c.a(), com.lantern.wifilocating.push.util.d.c(), localJSONObject.toString());
                  localObject2 = localObject4;
                }
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject4;
        Object localObject2;
        h.a(localException);
        Object localObject3 = localObject1;
        continue;
      }
      return (List<com.lantern.wifilocating.push.b.c.a.a>)localObject2;
      localObject1 = localObject5;
      ((HashMap)localObject2).put("pid", "01700101");
      localObject1 = localObject5;
      ((HashMap)localObject2).put("sdkVersion", "2.0");
      localObject1 = localObject5;
      ((HashMap)localObject2).put("version", "1.0");
      localObject1 = localObject5;
      com.lantern.wifilocating.push.d.g.d();
      localObject1 = localObject5;
      localObject2 = com.lantern.wifilocating.push.d.g.a("01700101", (HashMap)localObject2);
      continue;
      localObject1 = localObject5;
      com.lantern.wifilocating.push.util.b.a("login-result:params error!");
      localObject4 = null;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */