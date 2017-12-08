package com.lantern.wifilocating.push.b.d;

import android.text.TextUtils;
import com.lantern.wifilocating.push.d.g;
import com.lantern.wifilocating.push.util.b;
import com.lantern.wifilocating.push.util.h;
import com.lantern.wifilocating.push.util.i;
import com.lantern.wifilocating.push.util.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements Runnable
{
  private static long b = 0L;
  private static final Object d = new Object();
  private com.lantern.wifilocating.push.a<List<JSONObject>> a;
  private long c = 60000L;
  private int e;
  private String f;
  private ArrayList<JSONObject> g;
  private int h;
  private int i;
  private boolean j = false;
  private boolean k;
  private int l = 0;
  
  public c(com.lantern.wifilocating.push.a<List<JSONObject>> parama, boolean paramBoolean, int paramInt)
  {
    this.a = parama;
    this.k = paramBoolean;
    this.g = new ArrayList();
    this.c = ((com.lantern.wifilocating.push.c.d)com.lantern.wifilocating.push.c.b.a.a().a(com.lantern.wifilocating.push.c.d.class)).a();
    if (this.c < 10000L) {
      this.c = 10000L;
    }
    this.l = paramInt;
  }
  
  private static HashMap<String, String> a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = g.d().e();
    if ((localHashMap == null) || (localHashMap.size() == 0)) {
      localHashMap = null;
    }
    for (;;)
    {
      return localHashMap;
      localHashMap.put("pid", "01500101");
      localHashMap.put("sdkVersion", "2.0");
      localHashMap.put("version", "1.0");
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>();
        localJSONObject.put("0", paramInt1);
        localJSONObject.put("1", paramInt2);
        localHashMap.put("tys", localJSONObject.toString());
        b.b("before : " + String.valueOf(localHashMap) + ", threadId:" + Thread.currentThread().getId());
        g.d();
        localHashMap = g.a("01500101", localHashMap);
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  private List<JSONObject> a(JSONObject paramJSONObject, com.lantern.wifilocating.push.h.d paramd, int paramInt)
  {
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = paramJSONObject.optJSONArray(paramd.a());
        if (localJSONArray != null)
        {
          int i3 = localJSONArray.length();
          if (i3 > 0)
          {
            ArrayList localArrayList = new java/util/ArrayList;
            localArrayList.<init>();
            int n = 0;
            int m = 0;
            paramJSONObject = localArrayList;
            i1 = m;
            if (n >= i3) {
              continue;
            }
            localObject1 = localArrayList;
            try
            {
              Object localObject2 = localJSONArray.getJSONObject(n);
              localObject1 = localArrayList;
              ((JSONObject)localObject2).put("sequenceType", paramd.a());
              localObject1 = localArrayList;
              int i2 = ((JSONObject)localObject2).optInt("sequence", 0);
              localObject1 = localArrayList;
              paramJSONObject = ((JSONObject)localObject2).optString("requestId");
              i1 = m;
              if (i2 > m) {
                i1 = i2;
              }
              localObject1 = localArrayList;
              if (!TextUtils.isEmpty(paramJSONObject))
              {
                localObject1 = localArrayList;
                m = ((JSONObject)localObject2).optInt("status");
                if (m == 1)
                {
                  localObject1 = localArrayList;
                  if (((JSONObject)localObject2).has("remainingTime"))
                  {
                    localObject1 = localArrayList;
                    long l1 = ((JSONObject)localObject2).optLong("remainingTime");
                    localObject1 = localArrayList;
                    ((JSONObject)localObject2).remove("remainingTime");
                    localObject1 = localArrayList;
                    ((JSONObject)localObject2).put("exp", l1 + System.currentTimeMillis());
                  }
                  localObject1 = localArrayList;
                  ((JSONObject)localObject2).put("syt", 0);
                  localObject1 = localArrayList;
                  localArrayList.add(localObject2);
                }
                localObject1 = localArrayList;
                localObject2 = new com/lantern/wifilocating/push/a/b/a;
                localObject1 = localArrayList;
                ((com.lantern.wifilocating.push.a.b.a)localObject2).<init>();
                localObject1 = localArrayList;
                ((com.lantern.wifilocating.push.a.b.a)localObject2).b(i2);
                localObject1 = localArrayList;
                ((com.lantern.wifilocating.push.a.b.a)localObject2).a(paramd.a());
                localObject1 = localArrayList;
                ((com.lantern.wifilocating.push.a.b.a)localObject2).c(paramJSONObject);
                localObject1 = localArrayList;
                ((com.lantern.wifilocating.push.a.b.a)localObject2).c(m);
                localObject1 = localArrayList;
                ((com.lantern.wifilocating.push.a.b.a)localObject2).d(1);
                localObject1 = localArrayList;
                ((com.lantern.wifilocating.push.a.b.a)localObject2).f(0);
                if (m == 1)
                {
                  localObject1 = localArrayList;
                  ((com.lantern.wifilocating.push.a.b.a)localObject2).e(1);
                  localObject1 = localArrayList;
                  com.lantern.wifilocating.push.a.a.c().a("012003", ((com.lantern.wifilocating.push.a.b.a)localObject2).b());
                  localObject1 = localArrayList;
                  this.j = true;
                }
              }
              else
              {
                n++;
                m = i1;
                continue;
              }
              localObject1 = localArrayList;
              ((com.lantern.wifilocating.push.a.b.a)localObject2).e(2);
              continue;
              return (List<JSONObject>)localObject1;
            }
            catch (JSONException paramJSONObject) {}
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        int i1;
        Object localObject1 = null;
        continue;
      }
      paramJSONObject = null;
      i1 = 0;
      localObject1 = paramJSONObject;
      if (i1 >= 0)
      {
        localObject1 = paramJSONObject;
        if (i1 > paramInt)
        {
          localObject1 = paramJSONObject;
          i.a(com.lantern.wifilocating.push.c.a(), com.lantern.wifilocating.push.util.d.c(), paramd, i1);
          localObject1 = paramJSONObject;
        }
      }
    }
  }
  
  public final void run()
  {
    int n = Integer.MIN_VALUE;
    synchronized (d)
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("sync type : ");
      b.b(this.l + ", threadId:" + Thread.currentThread().getId());
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("ready sync~, threadId:");
      b.b(Thread.currentThread().getId());
      if ((!this.k) && (System.currentTimeMillis() - b < this.c))
      {
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("sync too often, threadId:");
        b.b(Thread.currentThread().getId());
        return;
      }
      if (!j.c(com.lantern.wifilocating.push.c.a()))
      {
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("network disconnect, threadId:");
        b.b(Thread.currentThread().getId());
        this.e = 10;
      }
    }
    Object localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>("start sync, threadId:");
    b.b(Thread.currentThread().getId());
    String str = g.a();
    int m = Integer.MIN_VALUE;
    this.h = i.a(com.lantern.wifilocating.push.c.a(), com.lantern.wifilocating.push.util.d.c(), com.lantern.wifilocating.push.h.d.a);
    this.i = i.a(com.lantern.wifilocating.push.c.a(), com.lantern.wifilocating.push.util.d.c(), com.lantern.wifilocating.push.h.d.b);
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>("userMsg:");
    b.b(this.h + ", globalMsg:" + this.i + ", lastRequestUserMsg:" + m + ", lastRequestGlobalMsg:" + n + ", threadId:" + Thread.currentThread().getId());
    Object localObject5;
    if (((this.h != m) || (this.i != n)) && (this.h >= m) && (this.i >= n))
    {
      localObject2 = a(this.h, this.i);
      this.e = 0;
      localObject5 = new java/lang/StringBuilder;
      ((StringBuilder)localObject5).<init>("sync url:");
      b.b(str + ", threadId:" + Thread.currentThread().getId());
      if (localObject2 == null) {
        break label593;
      }
      localObject2 = com.lantern.wifilocating.push.d.c.a(str, (Map)localObject2);
      localObject5 = new java/lang/StringBuilder;
      ((StringBuilder)localObject5).<init>("sync result:");
      b.b((String)localObject2 + ", threadId:" + Thread.currentThread().getId());
      if ((localObject2 != null) && (((String)localObject2).length() != 0)) {
        break label626;
      }
      h.a("very important log");
      this.e = 10;
    }
    for (;;)
    {
      label511:
      if (this.j) {
        com.lantern.wifilocating.push.f.a.a().b();
      }
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>("sync end, threadId:");
      b.b(Thread.currentThread().getId());
      if (this.e == 1) {
        b = System.currentTimeMillis();
      }
      if (this.a == null) {
        break;
      }
      this.a.a(this.e, this.g);
      break;
      label593:
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>("sync result:params error, threadId:");
      b.b(Thread.currentThread().getId());
    }
    label626:
    m = this.h;
    n = this.i;
    for (;;)
    {
      try
      {
        localObject5 = new org/json/JSONObject;
        ((JSONObject)localObject5).<init>((String)localObject2);
        if (!"0".equals(((JSONObject)localObject5).getString("retCd")))
        {
          this.e = 0;
          if (((JSONObject)localObject5).has("retMsg")) {
            this.f = ((JSONObject)localObject5).getString("retMsg");
          }
          localObject6 = ((JSONObject)localObject5).optString("msgMap");
          boolean bool = TextUtils.isEmpty((CharSequence)localObject6);
          if (bool) {
            break label891;
          }
        }
      }
      catch (Exception localException1)
      {
        Object localObject6;
        h.a(localException1);
        this.e = 30;
      }
      try
      {
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>((String)localObject6);
        if (localObject2 != null)
        {
          localObject6 = a((JSONObject)localObject2, com.lantern.wifilocating.push.h.d.a, this.h);
          if ((localObject6 != null) && (!((List)localObject6).isEmpty())) {
            this.g.addAll((Collection)localObject6);
          }
          localObject2 = a((JSONObject)localObject2, com.lantern.wifilocating.push.h.d.b, this.i);
          if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
            this.g.addAll((Collection)localObject2);
          }
        }
        h.a("retcode=%s,retmsg=%s", new Object[] { Integer.valueOf(this.e), this.f });
        localObject2 = ((JSONObject)localObject5).optString("more");
        if ((localObject2 == null) || (!"Y".equals(localObject2))) {
          break label511;
        }
      }
      catch (Exception localException2) {}
      this.e = 1;
      continue;
      break label511;
      label891:
      Object localObject3 = null;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */