package com.lantern.analytics.d;

import android.text.TextUtils;
import com.bluefay.b.h;
import com.c.b.a.a.a.a.a.a;
import com.c.b.a.a.a.a.a.a.a;
import com.lantern.analytics.a.d;
import com.lantern.core.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements Runnable
{
  private boolean a;
  private boolean b;
  private String c;
  private JSONObject d;
  private JSONArray e;
  
  public c()
  {
    this.a = false;
    this.b = false;
  }
  
  public c(String paramString, JSONArray paramJSONArray)
  {
    this.a = true;
    this.b = true;
    this.c = paramString;
    this.e = paramJSONArray;
  }
  
  public c(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    this.a = true;
    this.b = paramBoolean;
    this.c = paramString;
    this.d = paramJSONObject;
  }
  
  private static int a(String paramString)
  {
    List localList = com.lantern.analytics.a.e().a().a(paramString);
    int j;
    if ((localList == null) || (localList.size() == 0))
    {
      h.b("dctype:%s EventItem count is 0", new Object[] { paramString });
      j = 1;
      return j;
    }
    int m = (localList.size() + 20 - 1) / 20;
    int k = 0;
    Object localObject1;
    Object localObject2;
    for (i = 0;; i = j)
    {
      j = i;
      if (k >= m) {
        break;
      }
      j = localList.size();
      localObject1 = new ArrayList();
      int n = Math.min(j, (k + 1) * 20);
      for (j = k * 20; j < n; j++) {
        ((ArrayList)localObject1).add(localList.get(j));
      }
      h.b("page:%s count:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(((ArrayList)localObject1).size()) });
      Object localObject3 = a((List)localObject1).toString();
      j = i;
      if (localObject3 != null)
      {
        j = i;
        if (((String)localObject3).length() != 0)
        {
          localObject2 = com.lantern.core.c.getServer().w();
          localObject3 = a(paramString, (String)localObject3);
          com.lantern.core.c.getServer();
          localObject2 = com.lantern.core.e.a((String)localObject2, o.a("00500104", (byte[])localObject3, true));
          if ((localObject2 != null) && (localObject2.length != 0)) {
            break label244;
          }
          j = 10;
        }
      }
      k++;
    }
    for (;;)
    {
      try
      {
        label244:
        com.lantern.core.c.getServer();
        localObject2 = o.b("00500104", (byte[])localObject2, true);
        h.a(String.valueOf(localObject2), new Object[0]);
        boolean bool = ((com.lantern.core.h.a)localObject2).c();
        if (!bool) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        h.a(localException);
        i = 30;
        continue;
      }
      h.b("pages:%s, retcode=%s", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      j = i;
      if (i != 1) {
        break;
      }
      localObject2 = ((ArrayList)localObject1).iterator();
      j = i;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (com.lantern.analytics.c.e)((Iterator)localObject2).next();
      com.lantern.analytics.a.e().a().a(paramString, ((com.lantern.analytics.c.e)localObject1).a);
      continue;
      i = 0;
    }
  }
  
  private static JSONArray a(List<com.lantern.analytics.c.e> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.lantern.analytics.c.e locale = (com.lantern.analytics.c.e)paramList.next();
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(locale.c);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONArray;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    h.a("upload one start");
    if (!com.lantern.core.c.getServer().i()) {}
    label81:
    label105:
    label292:
    label325:
    label372:
    label400:
    label405:
    label409:
    for (;;)
    {
      return;
      if (!com.lantern.core.c.getServer().a("00500104", paramBoolean1))
      {
        h.a("initdev failed:" + paramBoolean1 + " " + paramBoolean2);
      }
      else
      {
        if (this.d != null) {}
        Object localObject2;
        for (Object localObject1 = a(this.c, this.d.toString());; localObject2 = null)
        {
          if (localObject1 == null) {
            break label409;
          }
          String str = com.lantern.core.c.getServer().w();
          com.lantern.core.c.getServer();
          boolean bool;
          if (!paramBoolean1)
          {
            bool = true;
            localObject1 = com.lantern.core.e.a(str, o.a("00500104", (byte[])localObject1, bool));
            if ((localObject1 != null) && (localObject1.length != 0)) {
              break label400;
            }
          }
          for (int i = 10;; i = 0)
          {
            try
            {
              com.lantern.core.c.getServer();
              if (!paramBoolean1)
              {
                bool = true;
                localObject1 = o.b("00500104", (byte[])localObject1, bool);
                h.a(String.valueOf(localObject1), new Object[0]);
                bool = ((com.lantern.core.h.a)localObject1).c();
                if (!bool) {
                  break label292;
                }
                j = 1;
                h.b("retcode=%s", new Object[] { Integer.valueOf(j) });
                if ((j == 1) || (!this.b)) {
                  break;
                }
                if (this.d == null) {
                  break label372;
                }
              }
            }
            catch (Exception localException)
            {
              try
              {
                do
                {
                  do
                  {
                    do
                    {
                      for (;;)
                      {
                        this.d.put("offline", "true");
                        com.lantern.analytics.a.e().a().a(this.c, this.d);
                        break;
                        if (this.e == null) {
                          break label405;
                        }
                        localObject1 = a(this.c, this.e.toString());
                        break label81;
                        bool = false;
                        break label105;
                        bool = false;
                      }
                      j = i;
                    } while (!paramBoolean1);
                    j = i;
                  } while (paramBoolean2);
                  if (((com.lantern.core.h.a)localObject1).d()) {
                    break label325;
                  }
                  j = i;
                } while (!((com.lantern.core.h.a)localObject1).e());
                com.lantern.core.c.getServer().b("00500104", ((com.lantern.core.h.a)localObject1).b());
                a(true, true);
                break;
                localException = localException;
                h.a(localException);
                int j = 30;
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  h.a(localJSONException);
                }
              }
            }
            if (this.e == null) {
              break;
            }
            com.lantern.analytics.a.e().a().a(this.c, this.e);
            break;
          }
        }
      }
    }
  }
  
  private static byte[] a(String paramString1, String paramString2)
  {
    a.a.a locala = a.a.l();
    if (paramString1 != null)
    {
      locala.a(paramString1);
      if (paramString2 == null) {
        break label41;
      }
    }
    for (;;)
    {
      locala.b(paramString2);
      return ((a.a)locala.c()).b();
      paramString1 = "";
      break;
      label41:
      paramString2 = "";
    }
  }
  
  private static int b(String paramString)
  {
    List localList = com.lantern.analytics.a.e().a().a(paramString);
    if ((localList == null) || (localList.size() == 0))
    {
      h.b("dctype:%s EventItem count is 0", new Object[] { paramString });
      i = 1;
      return i;
    }
    int m = localList.size();
    int k = 0;
    int j = 0;
    com.lantern.analytics.c.e locale;
    Object localObject1;
    for (;;)
    {
      i = j;
      if (k >= m) {
        break;
      }
      locale = (com.lantern.analytics.c.e)localList.get(k);
      Object localObject2 = locale.c;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = com.lantern.core.c.getServer().w();
        localObject2 = a(paramString, (String)localObject2);
        com.lantern.core.c.getServer();
        localObject1 = com.lantern.core.e.a((String)localObject1, o.a("00500104", (byte[])localObject2, true));
        if ((localObject1 != null) && (localObject1.length != 0)) {
          break label148;
        }
        j = 10;
      }
      k++;
    }
    for (;;)
    {
      try
      {
        label148:
        com.lantern.core.c.getServer();
        localObject1 = o.b("00500104", (byte[])localObject1, true);
        h.a(String.valueOf(localObject1), new Object[0]);
        boolean bool = ((com.lantern.core.h.a)localObject1).c();
        if (!bool) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        h.a(localException);
        i = 30;
        continue;
      }
      h.b("retcode=%s", new Object[] { Integer.valueOf(i) });
      j = i;
      if (i != 1) {
        break;
      }
      com.lantern.analytics.a.e().a().a(paramString, locale.a);
      j = i;
      break;
      i = 0;
    }
  }
  
  private static int c(String paramString)
  {
    List localList = com.lantern.analytics.a.e().a().a(paramString);
    int j;
    if ((localList == null) || (localList.size() == 0))
    {
      h.b("dctype:%s EventItem count is 0", new Object[] { paramString });
      j = 1;
      return j;
    }
    int m = localList.size();
    int k = 0;
    com.lantern.analytics.c.e locale;
    Object localObject1;
    for (i = 0;; i = j)
    {
      j = i;
      if (k >= m) {
        break;
      }
      locale = (com.lantern.analytics.c.e)localList.get(k);
      Object localObject2 = locale.c;
      j = i;
      if (localObject2 != null)
      {
        j = i;
        if (((String)localObject2).length() != 0)
        {
          localObject1 = com.lantern.core.c.getServer().w();
          localObject2 = a(paramString, (String)localObject2);
          com.lantern.core.c.getServer();
          localObject1 = com.lantern.core.e.a((String)localObject1, o.a("00500104", (byte[])localObject2, true));
          if ((localObject1 != null) && (localObject1.length != 0)) {
            break label159;
          }
          j = 10;
        }
      }
      k++;
    }
    for (;;)
    {
      try
      {
        label159:
        com.lantern.core.c.getServer();
        localObject1 = o.b("00500104", (byte[])localObject1, true);
        h.a(String.valueOf(localObject1), new Object[0]);
        boolean bool = ((com.lantern.core.h.a)localObject1).c();
        if (!bool) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        h.a(localException);
        i = 30;
        continue;
      }
      h.b("retcode=%s", new Object[] { Integer.valueOf(i) });
      j = i;
      if (i != 1) {
        break;
      }
      com.lantern.analytics.a.e().a().a(paramString, locale.a);
      j = i;
      break;
      i = 0;
    }
  }
  
  public final void run()
  {
    if (this.a) {
      a(false, false);
    }
    for (;;)
    {
      return;
      h.a("upload all start");
      if (com.lantern.core.c.getServer().i())
      {
        Object localObject = com.lantern.analytics.a.e().a().a();
        if ((localObject == null) || (((List)localObject).size() == 0))
        {
          h.c("dc files count is 0");
        }
        else if (!com.lantern.core.c.getServer().a("00500104", false))
        {
          h.a("initdev failed:false false");
        }
        else
        {
          Iterator localIterator = ((List)localObject).iterator();
          while (localIterator.hasNext())
          {
            localObject = (String)localIterator.next();
            if ("005001".equals(localObject)) {
              c((String)localObject);
            } else if ("005022".equals(localObject)) {
              b((String)localObject);
            } else {
              a((String)localObject);
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/analytics/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */